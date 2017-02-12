package it.naturtalent.technik.actions;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.di.extensions.Preference;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.lifecycle.ProcessAdditions;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecp.internal.ui.util.ECPExportHandlerHelper;
import org.eclipse.emf.ecp.internal.ui.util.ECPImportHandlerHelper;
import org.eclipse.jface.action.Action;
import org.eclipse.swt.widgets.Shell;

import it.naturtalent.icons.core.Icon;
import it.naturtalent.icons.core.IconSize;
import it.naturtalent.technik.Activator;
import it.naturtalent.technik.TechnikPreferences;
import it.naturtalent.technik.dialogs.AddSocketDialog;
import it.naturtalent.technik.dialogs.SocketHackerDialog;
import it.naturtalent.technik.dialogs.SocketRemoteControl;
import wifi.RemoteSocket;
import wifi.RemoteSockets;
import wifi.SocketGroup;

public class AddSocketAction extends Action
{
	private IEclipsePreferences prefs;
	
	@Inject Shell shell;
	
	@Inject IEclipseContext context;
	
	@Inject
	public AddSocketAction(@Preference(nodePath = "it.naturtalent.technik") IEclipsePreferences prefs)
	{
		super();
		setImageDescriptor(Icon.COMMAND_ADD.getImageDescriptor(IconSize._16x16_DefaultIconSize));
		
		this.prefs = prefs;
	}

	@Override
	public void run()
	{
		AddSocketDialog dialog = new AddSocketDialog(shell);
		ContextInjectionFactory.inject(dialog, context);
		ContextInjectionFactory.invoke(dialog, PostConstruct.class, context);
		
		dialog.open();
	}

/*
	@Inject
	public void setSelection(@Named(IServiceConstants.ACTIVE_SELECTION)@Optional EObject eObject)
	{
		System.out.println("Selection: "+eObject);
	}
	*/
	
}
