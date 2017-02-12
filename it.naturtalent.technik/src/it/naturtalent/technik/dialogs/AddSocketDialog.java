package it.naturtalent.technik.dialogs;

import javax.annotation.PostConstruct;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.e4.core.di.extensions.Preference;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecp.ui.view.ECPRendererException;
import org.eclipse.emf.ecp.ui.view.swt.ECPSWTViewRenderer;
import org.eclipse.emf.ecp.view.spi.context.ViewModelContext;
import org.eclipse.emf.ecp.view.spi.context.ViewModelContextFactory;
import org.eclipse.emf.ecp.view.spi.model.VView;
import org.eclipse.emf.ecp.view.spi.model.VViewFactory;
import org.eclipse.emf.ecp.view.spi.model.VViewModelProperties;
import org.eclipse.emf.ecp.view.spi.provider.ViewProviderHelper;
import org.eclipse.emfforms.spi.swt.table.TableViewerFactory;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import wifi.RemoteSocket;
import wifi.WifiPackage;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;


public class AddSocketDialog extends TitleAreaDialog
{

	public static final String REMOTESOCKET_DEFAULTVIEW_KEY = "it.naturtalent.technik.viewmodel.key1";
	public static final String REMOTESOCKET_DEFAULTVIEW_VALUE = "it.naturtalent.technik.viewmodel.value1";
	
	
	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public AddSocketDialog(Shell parentShell)
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
		Composite area = (Composite) super.createDialogArea(parent);
		GridLayout gridLayout = (GridLayout) area.getLayout();
		Composite container = new Composite(area, SWT.NONE);
		container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		// neuen Datensatz generieren
		EClass remoteSocketClass = WifiPackage.eINSTANCE.getRemoteSocket();
		EObject remoteSocketObject = EcoreUtil.create(remoteSocketClass);
		
		// Dummydaten 
		RemoteSocket remoteSocket = (RemoteSocket) remoteSocketObject;
		remoteSocket.setName("Pumpe");
		remoteSocket.setHouseCode((short) 8);
		
		
		VViewModelProperties properties = VViewFactory.eINSTANCE.createViewModelLoadingProperties();	
		
		properties.addNonInheritableProperty(REMOTESOCKET_DEFAULTVIEW_KEY, REMOTESOCKET_DEFAULTVIEW_VALUE);	
		
		VView view = ViewProviderHelper.getView(remoteSocketObject, properties);			
		ViewModelContext vmc = ViewModelContextFactory.INSTANCE.createViewModelContext(view, remoteSocketObject);
		
		
		
		try
		{
			ECPSWTViewRenderer.INSTANCE.render(container, vmc);
			container.setLayout(new GridLayout(1, false));
		} catch (ECPRendererException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//ECPSWTViewRenderer.INSTANCE.render(container,vmc);
		
		System.out.println("IEST");

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
		createButton(parent, IDialogConstants.CANCEL_ID,
				IDialogConstants.CANCEL_LABEL, false);
	}
	
	@PostConstruct
	public void postConstruct(@Preference(nodePath = "it.naturtalent.technik") IEclipsePreferences prefs)
	{
		
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize()
	{
		return new Point(450, 358);
	}

}
