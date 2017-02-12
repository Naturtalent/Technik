 
package it.naturtalent.technik;

import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.di.extensions.EventTopic;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.osgi.service.event.Event;

import it.naturtalent.e4.application.IPreferenceRegistry;


public class TechnikAddon 
{

	@Inject IEclipseContext context;
	@Inject @Optional IPreferenceRegistry preferenceRegistry;
	static @Inject @Optional ESelectionService selectionService;
	
	
	
	@Inject
	@Optional
	public void applicationStarted(
			@EventTopic(UIEvents.UILifeCycle.APP_STARTUP_COMPLETE) Event event)
	{
		preferenceRegistry.getPreferenceAdapters().add(new SocketsPreferencesAdapter());
		
	}
	
	public static ESelectionService getSelectionService()
	{
		return selectionService;
	}

}
