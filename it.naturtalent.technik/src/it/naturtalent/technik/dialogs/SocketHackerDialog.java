package it.naturtalent.technik.dialogs;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.e4.core.di.extensions.Preference;
import org.eclipse.e4.ui.di.UISynchronize;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.tinkerforge.BrickletRemoteSwitch;
import com.tinkerforge.NotConnectedException;
import com.tinkerforge.TimeoutException;

import it.naturtalent.technik.TechnikPreferences;
import it.naturtalent.technik.parts.RemoteSocketView;
import it.naturtalent.technik.Messages;

public class SocketHackerDialog extends TitleAreaDialog
{
		
	@Inject
	private UISynchronize sync = null;
	
	private BrickletRemoteSwitch rs;
	
	private Job houseJob = null;
	private Job receiverJob = null;
	
	private SubMonitor houseMonitor;
	private SubMonitor receiverMonitor;
	
	private final static Short MIN_HOUSE_CODE = 0;
	private final static Short MAX_HOUSE_CODE = 32;
	
	private final static Short MIN_RECEIVER_CODE = 0;
	private final static Short MAX_RECEIVER_CODE = 32;
	
	private ProgressBar progressBarHouseCode;
	private ProgressBar progressBarReceiverCode;

	private Text textHC;
	private Text textRC;
	
	// synchronisiert die Jobs
	private static boolean semaphor = true;

	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public SocketHackerDialog(Shell parentShell)
	{
		super(parentShell);
	}
	

	public void updateHouseCode(String message)
	{
		try
		{
			Display.getDefault().asyncExec(new Runnable()
			{
				@Override
				public void run()
				{
					try
					{
						System.out.println("EVENT "+message);
						//textHC.setText(message);
					} catch (Exception exc)
					{
						System.out.println(exc);
					}
				}
			});
		} catch (Exception exception)
		{
			System.out.println(exception);
		}
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent)
	{
		setMessage(Messages.SocketHackerDialog_this_message);
		setTitle(Messages.SocketHackerDialog_this_title);
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayout(new GridLayout(3, false));
		container.setLayoutData(new GridData(GridData.FILL_BOTH));
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		
		Label lblHouseCode = new Label(container, SWT.NONE);
		lblHouseCode.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		lblHouseCode.setText("Housecode");
		
		textHC = new Text(container, SWT.BORDER);
		textHC.setEditable(false);
		GridData gd_textHC = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_textHC.widthHint = 50;
		textHC.setLayoutData(gd_textHC);
		new Label(container, SWT.NONE);
		
		progressBarHouseCode = new ProgressBar(container, SWT.NONE);
		progressBarHouseCode.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		progressBarHouseCode.setMaximum(MAX_HOUSE_CODE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		
		Label lblReceiverCode = new Label(container, SWT.NONE);
		lblReceiverCode.setText("Receivercode");
		
		textRC = new Text(container, SWT.BORDER);
		textRC.setEditable(false);
		GridData gd_textRC = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_textRC.widthHint = 50;
		textRC.setLayoutData(gd_textRC);
		new Label(container, SWT.NONE);
		
		progressBarReceiverCode = new ProgressBar(container, SWT.NONE);
		progressBarReceiverCode.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		progressBarReceiverCode.setMaximum(MAX_RECEIVER_CODE);
		new Label(container, SWT.NONE);
		
		doHackSocketJob();
				
		return area;
	}
	
	@PostConstruct
	public void postConstruct(@Preference(nodePath = "it.naturtalent.technik") IEclipsePreferences prefs)
	{
		String uid = prefs.get(TechnikPreferences.BRICKLET_UID, TechnikPreferences.BRICKLET_DEFAULT_UID);
		rs = new BrickletRemoteSwitch(uid, RemoteSocketView.ipcon);
	}

	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent)
	{
		createButton(parent, IDialogConstants.CANCEL_ID, "Stop",false);
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,false);		
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize()
	{
		return new Point(450, 300);
	}
	
	@Override
	public boolean close()
	{
		//subMonitor.setCanceled(true);
		return super.close();
	}
	
	short houseCode;
	private void doHackSocketJob()
	{
		houseJob = Job.create("houseCode", monitor -> {
			houseMonitor = SubMonitor.convert(monitor, MAX_HOUSE_CODE);
			
			for (houseCode = MIN_HOUSE_CODE; houseCode < MAX_HOUSE_CODE; houseCode++)
			{
				
				if(houseMonitor.isCanceled())
					break;

				try
				{
					sync.asyncExec(new Runnable()
					{
						@Override
						public void run()
						{
							progressBarHouseCode.setSelection(
									progressBarHouseCode.getSelection() + 1);
							
							textHC.setText(new Short(houseCode).toString());
							
						}
					});

					Thread.sleep(500);
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				
				semaphor = true;
				scanReceiverCode();
				while (true)
				{
					try
					{
						Thread.sleep(50);
					} catch (InterruptedException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					if (!semaphor)
						break;
				}
				
			}
			
			return Status.OK_STATUS;
		});	
	
		houseJob.schedule();
	}
	
	private short receiverCode;
	private void scanReceiverCode()
	{		
		receiverJob = Job.create("receiverCode", monitor -> {
			receiverMonitor = SubMonitor.convert(monitor, MAX_HOUSE_CODE);

			for (receiverCode = MIN_RECEIVER_CODE; receiverCode < MAX_RECEIVER_CODE; receiverCode++)
			{
				
				if(receiverMonitor.isCanceled())
					break;
				
				try
				{
					sync.asyncExec(new Runnable()
					{
						@Override
						public void run()
						{
							try
							{
								rs.switchSocketA(houseCode,receiverCode,BrickletRemoteSwitch.SWITCH_TO_ON);
							} catch (TimeoutException | NotConnectedException e)
							{
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							progressBarReceiverCode.setSelection(receiverCode+1);
							textRC.setText(new Short(receiverCode).toString());							
						}
					});

					Thread.sleep(500);
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}

			}
			
			semaphor = false;			
			return Status.OK_STATUS;
		});	
				
		receiverJob.schedule();
	}
	
	@Override
	protected void cancelPressed()
	{
		houseMonitor.setCanceled(true);
		receiverMonitor.setCanceled(true);		
	}

	@Override
	protected void okPressed()
	{
		houseMonitor.setCanceled(true);
		receiverMonitor.setCanceled(true);

		// warten bis Job beendet ist
		Display.getDefault().syncExec(new Runnable()
		{
			@Override
			public void run()
			{
				try
				{
					Thread.sleep(500);
				} catch (Exception exc)
				{
					System.out.println(exc);
				}
			}
		});

		super.okPressed();
	}	
	
	

}
