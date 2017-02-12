package it.naturtalent.technik.parts;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.di.extensions.Preference;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.di.Persist;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.e4.ui.model.application.ui.MDirtyable;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecp.core.ECPProject;
import org.eclipse.emf.ecp.core.util.ECPUtil;
import org.eclipse.emf.ecp.core.util.observer.ECPProjectContentChangedObserver;
import org.eclipse.emf.ecp.core.util.observer.ECPProjectContentTouchedObserver;
import org.eclipse.emf.ecp.internal.core.ECPProjectImpl;
import org.eclipse.emf.ecp.spi.ui.util.ECPHandlerHelper;
import org.eclipse.emf.ecp.ui.common.ECPViewerFactory;
import org.eclipse.emf.ecp.ui.view.ECPRendererException;
import org.eclipse.emf.ecp.ui.view.swt.ECPSWTViewRenderer;
import org.eclipse.emf.ecp.view.spi.context.ViewModelContext;
import org.eclipse.emf.ecp.view.spi.context.ViewModelContextFactory;
import org.eclipse.emf.ecp.view.spi.model.VView;
import org.eclipse.emf.ecp.view.spi.model.VViewFactory;
import org.eclipse.emf.ecp.view.spi.model.VViewModelProperties;
import org.eclipse.emf.ecp.view.spi.provider.ViewProviderHelper;
import org.eclipse.emfforms.spi.core.services.controlmapper.EMFFormsSettingToControlMapper;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.osgi.service.prefs.BackingStoreException;

import com.tinkerforge.BrickletRemoteSwitch;
import com.tinkerforge.IPConnection;
import com.tinkerforge.IPConnectionBase;
import com.tinkerforge.NotConnectedException;
import com.tinkerforge.TimeoutException;

import it.naturtalent.emf.model.ModelEventKey;
import it.naturtalent.icons.core.Icon;
import it.naturtalent.icons.core.IconSize;
import it.naturtalent.technik.Activator;
import it.naturtalent.technik.Messages;
import it.naturtalent.technik.RemoteSocketData;
import it.naturtalent.technik.TechnikPreferences;
import it.naturtalent.technik.actions.AddSocketAction;
import it.naturtalent.technik.actions.ExportSocketAction;
import it.naturtalent.technik.actions.ImportSocketAction;
import it.naturtalent.technik.actions.SaveAction;
import it.naturtalent.technik.actions.SocketsHackerAction;
import it.naturtalent.technik.actions.UndoModelAction;
import it.naturtalent.technik.dialogs.OnOffDialog;
import wifi.RemoteSocket;
import wifi.WifiPackage;

public class RemoteSocketView
{
	
	/*
	 * 'ECPProjectContentChangedObserver' Überwacht Aenderungen im Modell
	 */
	private class RemoteSocketChangeObserver
			implements ECPProjectContentChangedObserver
	{
		@Override
		public Collection<Object> objectsChanged(ECPProject project,Collection<Object> objects)
		{
			// Aenderungen am Modell werden vie Broker weitergemeldet
			eventBroker.send(REMOTESOCKET_MODELEVENT, "Modeldata changed");
			return null;
		}

	}

	public static final String REMOTESOCKET_MODELEVENT = "remotesocketmodelevent"; //$NON-NLS-N$
	
	//public static final String REMOTESOCKET_DEFAULTVIEW_KEY = "it.naturtalent.technik.viewmodel.key1";
	//public static final String REMOTESOCKET_DEFAULTVIEW_VALUE = "it.naturtalent.technik.viewmodel.value1";
	
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	
	private IEclipseContext context;
	
	// Preferences
	private IEclipsePreferences prefs;
	
	protected @Inject MDirtyable dirtyable;	
	
	private  @Inject @Named (IServiceConstants.ACTIVE_SHELL) Shell shell;
	
	private ECPProject ecpProject = Activator.getECPProject();
	private RemoteSocketChangeObserver projectChangeObserver;
	
	private StructuredViewer viewer;
	
	private String Host = null;
	private String Port = null;
	
	// 
	private SubMonitor subMonitor;
	
	public static IPConnection ipcon = null;
	
	@Optional @Inject IStatusLineManager statuslinemanager;
	
	public enum ViewActionID
	{
		IMPORT_SOCKETS,
		EXPORT_SOCKETS,
		SOCKET_SWITCHER,
		RECONNECT_TASK,
		SOCKETHACKER_TASK,
		UNDO_ACTION,
		SAVE_ACTION,
	}
	private Map<ViewActionID, Action>actionRegistry = new HashMap<ViewActionID, Action>();
	
	// KontextMenues
	private Map<ViewActionID, MenuItem> menuRegistry = new HashMap<ViewActionID, MenuItem>();
	
	
	
	
	@Inject
	private IEventBroker eventBroker;

	private TableViewer tableViewer; 
	private Table table;
	
	
	private static final String STATUSBAR ="statusbar";
	private Text txtStatus;
	
	private EObject masterDetailSelection;
	
	/*
	 * meldet, dass eine erfolgreiche Verbindung hergestellt wurde
	 * - Statuszeile und Toolbar aktualisieren
	 */
	@Inject @Optional
	public void  getEvent(@UIEventTopic(STATUSBAR) String message) 
	{
	    updateStatusLine(message); 
	    updateWidgetStatus();
	}
	
	// aktualisiert die Statuszeile
	public void updateStatusLine(String message)
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
						txtStatus.setText(message);
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

	//public static final String MODELCHANGE ="modelchange";
	
	/*
	@Inject @Optional
	public void  getModelChangeEvent(@UIEventTopic(REMOTESOCKET_MODELEVENT) String message) 
	{
		System.out.println("Modelländerung");
	}
	*/
	
	

	@Inject
	public RemoteSocketView(
			@Preference(nodePath = "it.naturtalent.technik") IEclipsePreferences prefs,
			IEclipseContext context)
	{
		this.prefs = prefs;
		this.context = context;

		try
		{
			String[] names = prefs.keys();
			if (ArrayUtils.isEmpty(names))
			{
				prefs.put(TechnikPreferences.WIFI_HOST, TechnikPreferences.WIFI_DEFAULT_HOST);
				prefs.put(TechnikPreferences.WIFI_PORT, TechnikPreferences.WIFI_DEFAULT_PORT);
				prefs.flush();
			}
		} catch (BackingStoreException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// String host = prefs.get(WIFI_HOST, WIFI_DEFAULT_HOST);
		// String port = prefs.get(WIFI_PORT, WIFI_DEFAULT_PORT);

	}
	


	/**
	 * Create contents of the view part.
	 */
	@PostConstruct
	public void createControls(Composite parent)
	{
		parent.setLayout(new GridLayout(1, false));
		
		Section sctnRemoteSockets = formToolkit.createSection(parent, Section.TITLE_BAR);
		GridData gd_sctnRemoteSockets = new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1);
		gd_sctnRemoteSockets.heightHint = 340;
		sctnRemoteSockets.setLayoutData(gd_sctnRemoteSockets);
		formToolkit.paintBordersFor(sctnRemoteSockets);
		sctnRemoteSockets.setText(Messages.RemoteSocketsView_sctnRemoteSockets_text);
		
		Composite compositeClient = formToolkit.createComposite(sctnRemoteSockets, SWT.NONE);
		formToolkit.paintBordersFor(compositeClient);
		sctnRemoteSockets.setClient(compositeClient);
		compositeClient.setLayout(new GridLayout(1, false));
		
		Composite composite = new Composite(compositeClient, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));
		GridData gd_composite = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
		gd_composite.heightHint = 441;
		composite.setLayoutData(gd_composite);
		formToolkit.adapt(composite);
		formToolkit.paintBordersFor(composite);
		
		Composite compositeMasterDetail = formToolkit.createComposite(composite, SWT.NONE);
		compositeMasterDetail.setLayout(new GridLayout(1, false));
		GridData gd_compositeMasterDetail = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_compositeMasterDetail.heightHint = 423;
		compositeMasterDetail.setLayoutData(gd_compositeMasterDetail);
		formToolkit.paintBordersFor(compositeMasterDetail);
		
		// root Element 'RemoteSockets' anlegen
		EClass socketsClass = WifiPackage.eINSTANCE.getRemoteSockets();
		EObject socketsObject = EcoreUtil.create(socketsClass);

		// gespeicherte Daten laden
		ECPProject ecpProject = Activator.getECPProject();
		EList<Object> childs = ecpProject.getContents();
		if(!childs.isEmpty())
			socketsObject = (EObject) childs.get(0);
		
		//ecpProject.getProvider().

		// Daten im MasterDetail-View anzeigen
		// im Viewmodel wurde fuer das 'RemoteSockets' - Element ein MasterDetail View definiert 
		VViewModelProperties properties = VViewFactory.eINSTANCE.createViewModelLoadingProperties();	
		VView view = ViewProviderHelper.getView(socketsObject, properties);
		ViewModelContext vmc = ViewModelContextFactory.INSTANCE.createViewModelContext(view, socketsObject);
		
		
		//vmc.
		//EMFFormsSettingToControlMapper.class.
		//vmc.getService(EMFFormsSettingToControlMapper.class).getControlsFor(null);
		
		try
		{			
			ECPSWTViewRenderer.INSTANCE.render(compositeMasterDetail, vmc);			
		} catch (ECPRendererException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		// Statusanzeige 
		txtStatus = formToolkit.createText(compositeClient, "", SWT.NONE);
		txtStatus.setEditable(false);
		txtStatus.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		// als ChangeModelObserver registrieren
		projectChangeObserver = new RemoteSocketChangeObserver();
		ECPUtil.getECPObserverBus().register(projectChangeObserver);
				
		// Toolbar erzeugen
		createSectionToolbar(sctnRemoteSockets);
		//createContextMenu();
		
		connectJob();
		
		updateWidgetStatus();
		
	}
	
	private void createSectionToolbar(Section section)
	{
		ToolBarManager toolBarManager = new ToolBarManager(SWT.FLAT);
		ToolBar toolbar = toolBarManager.createControl(section);		
		section.setTextClient(toolbar);
		
		final Cursor handCursor = new Cursor(Display.getCurrent(),SWT.CURSOR_HAND);
		toolbar.setCursor(handCursor);
		// Cursor needs to be explicitly disposed
		toolbar.addDisposeListener(new DisposeListener()
		{
			public void widgetDisposed(DisposeEvent e)
			{
				if (handCursor.isDisposed() == false)				
					handCursor.dispose();				
			}
		});
	
		Action action;
		if (context != null) // Reminiszenz an windowsbuilder
		{
			// Export
			action = ContextInjectionFactory.make(ExportSocketAction.class,context);			
			toolBarManager.add(action);
			actionRegistry.put(ViewActionID.EXPORT_SOCKETS, action);

			// Import
			action = ContextInjectionFactory.make(ImportSocketAction.class,context);
			toolBarManager.add(action);
			actionRegistry.put(ViewActionID.IMPORT_SOCKETS, action);

			// UNDO
			action = ContextInjectionFactory.make(UndoModelAction.class,context);
			toolBarManager.add(action);
			actionRegistry.put(ViewActionID.UNDO_ACTION, action);
			
			// SAVE
			action = ContextInjectionFactory.make(SaveAction.class,context);
			toolBarManager.add(action);
			actionRegistry.put(ViewActionID.SAVE_ACTION, action);
			
			// Switch
			action = new Action()
			{
				@Override
				public void run()
				{
					if(masterDetailSelection instanceof RemoteSocket)
					{
						RemoteSocket [] remoteSockets = new RemoteSocket []{(RemoteSocket) masterDetailSelection}; 					
						switchSocket(remoteSockets);
					}
				}
			};
			action.setImageDescriptor(Icon.ICON_SPOT.getImageDescriptor(IconSize._16x16_DefaultIconSize));
			toolBarManager.add(action);
			actionRegistry.put(ViewActionID.SOCKET_SWITCHER, action);

			// Reconnect 
			action = new Action()
			{
				@Override
				public void run()
				{
					subMonitor.setCanceled(true);
					connectJob();
				}
			};
			action.setImageDescriptor(Icon.COMMAND_CONNECT.getImageDescriptor(IconSize._16x16_DefaultIconSize));
			toolBarManager.add(action);
			actionRegistry.put(ViewActionID.RECONNECT_TASK, action);
			
			// SocketHacker
			if (context != null) // Reminiszenz an windowsbuilder
			{
				action = ContextInjectionFactory.make(SocketsHackerAction.class,context);
				action.setEnabled(false);
				toolBarManager.add(action);
				actionRegistry.put(ViewActionID.SOCKETHACKER_TASK, action);
			}		

		}	

		toolBarManager.update(true);		
	}
	
	@Inject
	public void setSelection(@Named(IServiceConstants.ACTIVE_SELECTION)@Optional EObject eObject)
	{
		masterDetailSelection = eObject;
		updateWidgetStatus();
	}

	
	/*
	 * Enable-/Disablestatus der Aktion-und Menueeintraege aktualisieren
	 */
	private void updateWidgetStatus()
	{	
		// zunaechst alle disablen
		Set<ViewActionID>keySet = actionRegistry.keySet();
		for(ViewActionID id : keySet)
		{
			switch (id)
				{
					case SOCKET_SWITCHER:
					case SOCKETHACKER_TASK:
					case RECONNECT_TASK:
					case EXPORT_SOCKETS:
						actionRegistry.get(id).setEnabled(false);										
						break;
				}
		}
				
		// Enable Logik
		keySet = actionRegistry.keySet();
		for(ViewActionID id : keySet)
		{
			switch (id)
			{
				case SOCKET_SWITCHER:
					if(masterDetailSelection instanceof RemoteSocket)
						if((ipcon != null) && (ipcon.getConnectionState() == IPConnectionBase.CONNECTION_STATE_CONNECTED))
							actionRegistry.get(id).setEnabled(true);					
					break;
					
				case SOCKETHACKER_TASK:
				case RECONNECT_TASK:
					if(ipcon != null)
					{
						actionRegistry.get(id).setEnabled(true);																		
					}
					break;
					
				case EXPORT_SOCKETS:
					if(masterDetailSelection != null)
					{
						actionRegistry.get(id).setEnabled(true);																					
					}
					break;
			}

		}
	}

	private void createContextMenu()
	{
		Table table = ((TableViewer)viewer).getTable();
		Menu menu = new Menu(table);
		table.setMenu(menu);
		
		MenuItem menuItem;
		
		// Reconnect
		menuItem = new MenuItem(menu, SWT.NONE);
		menuItem.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				actionRegistry.get(ViewActionID.RECONNECT_TASK).run();
			}
		});
		menuItem.setText("hinzufügen");
		menuItem.setImage(Icon.COMMAND_CONNECT.getImage(IconSize._16x16_DefaultIconSize));
		menuRegistry.put(ViewActionID.RECONNECT_TASK, menuItem);
	}
	
	// eine Aenderung am Modell wird gemeldet
	@Inject @Optional
	public void  getModelChangeEvent(@UIEventTopic(RemoteSocketView.REMOTESOCKET_MODELEVENT) String message) 
	{
		dirtyable.setDirty(ecpProject.hasDirtyContents());		
	}
	
	// die dirtyable-Speicherfunktion ausfuehren
	@Persist
	public void persist()
	{
		ECPHandlerHelper.saveProject(ecpProject);
		dirtyable.setDirty(false);
	}

	@PreDestroy
	public void dispose()
	{		
		formToolkit.dispose();
		ECPUtil.getECPObserverBus().unregister(projectChangeObserver);
		
		if(subMonitor != null)
			subMonitor.setCanceled(true);
	}

	@Focus
	public void setFocus()
	{
		// TODO	Set the focus to control
	}
	
	/*
	 * Verbindung zum Brick (Bricklet-Extension) aufbauen
	 */
	private void connectJob()
	{		
		Host = prefs.get(TechnikPreferences.WIFI_HOST, TechnikPreferences.WIFI_DEFAULT_HOST);
		Port = prefs.get(TechnikPreferences.WIFI_PORT, TechnikPreferences.WIFI_DEFAULT_PORT);
		ipcon = new IPConnection();
		eventBroker.send(STATUSBAR,"Verbindungsaufbau mit Host: "+Host+"  Port: "+Port);	
		
		Job job = Job.create("CancelAbleJob", monitor -> {
			subMonitor = SubMonitor.convert(monitor,1);

			int i = 0;
			while(i == 0)
			{
				if(subMonitor.isCanceled()) 
                    return Status.CANCEL_STATUS;
				
				if(doConnect())
					break;
			}
			
			eventBroker.send(STATUSBAR,"Verbunden mit Host: "+Host+"  Port: "+Port);
			return Status.OK_STATUS;
		});
		
		job.schedule();
	}

	private boolean doConnect()
	{
			try
			{
				ipcon.connect(Host, new Integer(Port).intValue());
				return true;
				
			} catch (Exception e)
			{
				System.out.println("exception Connect");					
			}
			
			try
			{
				Thread.sleep(500);
			} catch (InterruptedException e)
			{
			}
			
			return false;
	}
	
	
	private void switchSocket(RemoteSocket [] remoteSockets)
	{
		if (ipcon != null)
		{
			String UID = prefs.get(TechnikPreferences.BRICKLET_UID, TechnikPreferences.BRICKLET_DEFAULT_UID);			
			BrickletRemoteSwitch rs = new BrickletRemoteSwitch(UID, ipcon);

			short state = ipcon.getConnectionState();
			if (state == IPConnectionBase.CONNECTION_STATE_CONNECTED)
			{
				
				OnOffDialog dialog = new OnOffDialog(shell);
				dialog.open();
				int switchstatus = dialog.getSwitchState();
				if ((switchstatus >= 0) && (remoteSockets != null) && (!ArrayUtils.isEmpty(remoteSockets)))
				{
					for (RemoteSocket remoteSocket : remoteSockets)
					{
						switch (remoteSocket.getType())
							{
								case HOUSE_CODE_SOCKET:

									try
									{
										rs.switchSocketA(
												remoteSocket.getHouseCode(),
												remoteSocket.getReceiverCode(),
												(switchstatus > 0)
														? BrickletRemoteSwitch.SWITCH_TO_ON
														: BrickletRemoteSwitch.SWITCH_TO_OFF);
									} catch (TimeoutException
											| NotConnectedException e)
									{
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									break;

								default:
									break;
							}
					}
				}

			}
		}
	}
	

}
