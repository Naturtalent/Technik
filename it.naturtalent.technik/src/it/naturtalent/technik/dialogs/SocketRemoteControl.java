package it.naturtalent.technik.dialogs;

import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;

import it.naturtalent.technik.RemoteSocketData;
import it.naturtalent.technik.RemoteSocketDefinitions;
import it.naturtalent.technik.TinkerforgeUtils;
import it.naturtalent.technik.Messages;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import swing2swt.layout.FlowLayout;

public class SocketRemoteControl extends TitleAreaDialog
{
	private class TableLabelProvider extends LabelProvider implements ITableLabelProvider {
		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}
		public String getColumnText(Object element, int columnIndex) 
		{
			if(element instanceof RemoteSocketData)
			{
				return (((RemoteSocketData)element).getName());
			}
			
			return element.toString();
		}
	}
	private Table table;
	
	private Button btnSwitchOn;
	private Button btnSwitchOff;
	
	private CheckboxTableViewer checkboxTableViewer;
	
	private RemoteSocketDefinitions remoteSockets = new RemoteSocketDefinitions ();
	private Composite composite;
	private Button btnSelectAll;
	private Button btnDeselectAll;

	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public SocketRemoteControl(Shell parentShell)
	{
		super(parentShell);
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent)
	{
		setMessage(Messages.SocketRemoteControl_this_message);
		setTitle(Messages.SocketRemoteControl_this_title);
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayout(new GridLayout(3, false));
		container.setLayoutData(new GridData(GridData.FILL_BOTH));
		new Label(container, SWT.NONE);
		
		checkboxTableViewer = CheckboxTableViewer.newCheckList(container, SWT.BORDER | SWT.FULL_SELECTION);
		checkboxTableViewer.addCheckStateListener(new ICheckStateListener() {
			public void checkStateChanged(CheckStateChangedEvent event) 
			{
				updateWidgets();
			}
		});
		table = checkboxTableViewer.getTable();
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1));
		checkboxTableViewer.setLabelProvider(new TableLabelProvider());
		checkboxTableViewer.setContentProvider(new ArrayContentProvider());
		
		composite = new Composite(container, SWT.NONE);
		composite.setLayout(new FillLayout(SWT.VERTICAL));
		
		btnSelectAll = new Button(composite, SWT.NONE);
		btnSelectAll.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				checkboxTableViewer.setAllChecked(true);
				updateWidgets();
			}
		});
		btnSelectAll.setText(Messages.SocketRemoteControl_btnNewButton_text);
		
		btnDeselectAll = new Button(composite, SWT.NONE);
		btnDeselectAll.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				checkboxTableViewer.setAllChecked(false);
				updateWidgets();
			}
		});
		btnDeselectAll.setText(Messages.SocketRemoteControl_btnNewButton_text_1);
		new Label(container, SWT.NONE);
		
		Composite compOnOffSwitches = new Composite(container, SWT.NONE);
		compOnOffSwitches.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		btnSwitchOn = new Button(compOnOffSwitches, SWT.NONE);
		btnSwitchOn.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				try {
					TinkerforgeUtils.switchSocket(getCheckedSockets(), true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSwitchOn.setText("einschalten");
		
		btnSwitchOff = new Button(compOnOffSwitches, SWT.NONE);
		btnSwitchOff.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) 
			{
				try {
					TinkerforgeUtils.switchSocket(getCheckedSockets(), false);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnSwitchOff.setText("ausschalten");
		new Label(container, SWT.NONE);
		
		checkboxTableViewer.setInput(remoteSockets.getRemoteSockets());
		updateWidgets();
		return area;
	}

	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent)
	{
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
				true);
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize()
	{
		return new Point(450, 588);
	}
	
	private void updateWidgets() 
	{
		boolean flag = false;
			
		flag = (getCheckedSockets() != null) && ArrayUtils.isNotEmpty(getCheckedSockets());
		btnSwitchOn.setEnabled(flag);
		btnSwitchOff.setEnabled(flag);				
	}
	
	private RemoteSocketData [] getCheckedSockets() 
	{
		Object [] result = checkboxTableViewer.getCheckedElements();
		RemoteSocketData [] remoteData = new RemoteSocketData[result.length];
		System.arraycopy(result, 0, remoteData, 0, result.length);		
		return remoteData;
	}

}
