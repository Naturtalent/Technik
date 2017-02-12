package it.naturtalent.technik.actions;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.extensions.Preference;
import org.eclipse.e4.ui.workbench.lifecycle.ProcessAdditions;
import org.eclipse.jface.action.Action;
import org.eclipse.swt.widgets.Shell;

import it.naturtalent.icons.core.Icon;
import it.naturtalent.icons.core.IconSize;
import it.naturtalent.technik.TechnikPreferences;
import it.naturtalent.technik.dialogs.SocketHackerDialog;
import it.naturtalent.technik.dialogs.SocketRemoteControl;

public class SocketsHackerAction extends Action
{
	private IEclipsePreferences prefs;
	
	@Inject Shell shell;
	
	@Inject IEclipseContext context;
	
	@Inject
	public SocketsHackerAction(@Preference(nodePath = "it.naturtalent.technik") IEclipsePreferences prefs)
	{
		super();
		setImageDescriptor(Icon.ICON_SOCKET.getImageDescriptor(IconSize._16x16_DefaultIconSize));
		
		this.prefs = prefs;
	}

	@Override
	public void run()
	{
		
		String host = prefs.get(TechnikPreferences.WIFI_HOST, "");
		String port = prefs.get(TechnikPreferences.WIFI_PORT, "");
		
		SocketHackerDialog dialog = new SocketHackerDialog(shell);
		ContextInjectionFactory.inject(dialog, context);
		ContextInjectionFactory.invoke(dialog, PostConstruct.class, context);
		
		dialog.open();
		
		System.out.println("Aktion:"+host+"  :   "+port);
	}

	/*
	 @ProcessAdditions
	 void processAdditions(IEclipseContext workbenchContext) 
	 {		 
		 SocketHackerDialog dialog = new SocketHackerDialog(shell);
	     ContextInjectionFactory.inject(dialog, workbenchContext);
	     dialog.open(); 
	 }
	 */
	
	
}
