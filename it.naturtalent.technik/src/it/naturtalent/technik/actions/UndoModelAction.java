package it.naturtalent.technik.actions;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecp.core.ECPProject;
import org.eclipse.emf.ecp.spi.ui.util.ECPHandlerHelper;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.action.Action;

import it.naturtalent.icons.core.Icon;
import it.naturtalent.icons.core.IconSize;
import it.naturtalent.technik.Activator;
import it.naturtalent.technik.parts.RemoteSocketView;

public class UndoModelAction extends Action
{
	@Inject
	private IEventBroker eventBroker;
	
	private static EditingDomain domain = Activator.getECPProject().getEditingDomain();
	private static ECPProject ecpProject = Activator.getECPProject();
	
	@Inject
	public UndoModelAction()
	{
		setImageDescriptor(Icon.COMMAND_UNDO.getImageDescriptor(IconSize._16x16_DefaultIconSize));
		setToolTipText("undo");	
		setEnabled(false);
	}

	@Override
	public void run()
	{	
		if (domain != null)
		{
			// undo 
			domain.getCommandStack().undo();
			setEnabled(domain.getCommandStack().canUndo());		
					
			if(!domain.getCommandStack().canUndo())
			{
				ECPHandlerHelper.saveProject(ecpProject);
				eventBroker.send(RemoteSocketView.REMOTESOCKET_MODELEVENT, "Model last undo");
			}
		
		}
	}
	
	@Inject @Optional
	public void  getModelChangeEvent(@UIEventTopic(RemoteSocketView.REMOTESOCKET_MODELEVENT) String message) 
	{
		setEnabled(ecpProject.hasDirtyContents());		
	}
	

}
