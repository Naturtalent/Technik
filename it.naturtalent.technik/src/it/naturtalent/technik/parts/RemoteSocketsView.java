package it.naturtalent.technik.parts;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecp.spi.ui.ECPReferenceServiceImpl;
import org.eclipse.emf.ecp.ui.view.ECPRendererException;
import org.eclipse.emf.ecp.ui.view.swt.ECPSWTViewRenderer;
import org.eclipse.emf.ecp.view.spi.context.ViewModelContext;
import org.eclipse.emf.ecp.view.spi.context.ViewModelContextFactory;
import org.eclipse.emf.ecp.view.spi.model.VView;
import org.eclipse.emf.ecp.view.spi.model.VViewFactory;
import org.eclipse.emf.ecp.view.spi.model.VViewModelProperties;
import org.eclipse.emf.ecp.view.spi.provider.ViewProviderHelper;
import org.eclipse.emfforms.spi.localization.LocalizationServiceHelper;
import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.widgets.Composite;

import wifi.SocketGroup;
import wifi.WifiPackage;

public class RemoteSocketsView
{

	public RemoteSocketsView()
	{
	}

	/**
	 * Create contents of the view part.
	 */
	@PostConstruct
	public void createControls(Composite parent)
	{
		/*
		final ECPProject ecpProject = it.naturtalent.technik.Activator.getECPProject();
		EClass socketsClass = WifiPackage.eINSTANCE.getRemoteSockets();
		EPackage ePackage = socketsClass.getEPackage();
		final EObject eObject = ePackage.getEFactoryInstance().create(socketsClass);
		ecpProject.getContents().add(eObject);
		*/
		
		
		// neuen Datensatz generieren
		EClass socketsClass = WifiPackage.eINSTANCE.getRemoteSockets();
		EObject socketsObject = EcoreUtil.create(socketsClass);
		
		/*
		SocketGroup socketGroup = (SocketGroup) groupObject;
		socketGroup.setName("Garten");
		*/		
		
		//TreeMasterDetailSWTFactory.createTreeMasterDetail(parent, SWT.NONE, socketsObject);
		
		

		
		
		VViewModelProperties properties = VViewFactory.eINSTANCE.createViewModelLoadingProperties();	
		VView view = ViewProviderHelper.getView(socketsObject, properties);
		//ViewModelContext vmc = ViewModelContextFactory.INSTANCE.createViewModelContext(view, socketsObject, new ECPReferenceServiceImpl());
		ViewModelContext vmc = ViewModelContextFactory.INSTANCE.createViewModelContext(view, socketsObject);
		
		try
		{			
			ECPSWTViewRenderer.INSTANCE.render(parent, vmc);
			//container.setLayout(new GridLayout(1, false));
		} catch (ECPRendererException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@PreDestroy
	public void dispose()
	{
	}

	@Focus
	public void setFocus()
	{
		// TODO	Set the focus to control
	}

}
