package it.naturtalent.technik.actions;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.emf.ecp.core.ECPProject;
import org.eclipse.emf.ecp.spi.ui.util.ECPHandlerHelper;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.action.Action;

import it.naturtalent.icons.core.Icon;
import it.naturtalent.icons.core.IconSize;
import it.naturtalent.technik.Activator;
import it.naturtalent.technik.parts.RemoteSocketView;

public class SaveAction extends Action
{
	
	private static EditingDomain domain = Activator.getECPProject().getEditingDomain();
	private static ECPProject ecpProject = Activator.getECPProject();


	@Inject
	private IEventBroker eventBroker;
	
	@Inject
	public SaveAction()
	{
		setImageDescriptor(Icon.COMMAND_SAVE.getImageDescriptor(IconSize._16x16_DefaultIconSize));
		setToolTipText("speichern");
		setEnabled(false);
	}
	
	//@Override
	public void run()
	{		
		ECPHandlerHelper.saveProject(ecpProject);
		eventBroker.send(RemoteSocketView.REMOTESOCKET_MODELEVENT, "Model saved");
		
/*
		EObject eObject = geteObject();
		if(eObject != null)
			eventBroker.send(ModelEventKey.DEFAULT_UNDO_MODELEVENT, eObject);
			*/
		
	}
	
	@Inject @Optional
	public void  getModelChangeEvent(@UIEventTopic(RemoteSocketView.REMOTESOCKET_MODELEVENT) String message) 
	{
		setEnabled(ecpProject.hasDirtyContents());		
	}
	

}
