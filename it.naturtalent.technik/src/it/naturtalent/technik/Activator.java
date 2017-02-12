package it.naturtalent.technik;

import java.util.Collection;

import org.eclipse.emf.ecp.core.ECPProject;
import org.eclipse.emf.ecp.core.util.ECPUtil;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import it.naturtalent.emf.model.EMFModelUtils;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin
{
	// The plug-in ID
	public static final String PLUGIN_ID = "it.naturtalent.technik"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;
	
	// Name des ECP Projekts indem alle Sockets gespeichert werden
	public final static String REMOTESOCKETPROJECTNAME = "RemoteSocket";
	
	// Projekt, in dem alle Archive abgelegt sind
	private static ECPProject remoteSocketProject = null;
	
	


	/**
	 * The constructor
	 */
	public Activator()
	{
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.
	 * BundleContext)
	 */
	public void start(BundleContext context) throws Exception
	{
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.
	 * BundleContext)
	 */
	public void stop(BundleContext context) throws Exception
	{
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault()
	{
		return plugin;
	}
	

	public static  ECPProject getECPProject()
	{
		if(remoteSocketProject == null)
		{
			remoteSocketProject = ECPUtil.getECPProjectManager().getProject(REMOTESOCKETPROJECTNAME);			
			if(remoteSocketProject == null)
			{
				// Projekt 'ARCHIVPROJECT' erzeugen
				remoteSocketProject = new EMFModelUtils().createProject(REMOTESOCKETPROJECTNAME);
			}
			
			// provoziert die Addition 'ECPModelContextAdapter' zum root Notifiers des Providers
			ECPUtil.getECPProjectManager().getProjects();
		}
		return remoteSocketProject;
	}


}
