package it.naturtalent.technik;

import com.tinkerforge.AlreadyConnectedException;
import com.tinkerforge.BrickletRemoteSwitch;
import com.tinkerforge.IPConnection;
import com.tinkerforge.IPConnectionBase;

import wifi.RemoteSocket;
import wifi.SocketGroup;
import wifi.WifiPackage;

import java.io.IOException;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.TableViewer;

/**
 * Created by dieter on 23.08.16.
 */
public class TinkerforgeUtils
{
	// private static final String HOST = "localhost";
	private static final String HOST = "wifi-extension-v2";

	private static final int PORT = 4223;

	// UID des Remote Switch Bricklet
	private static final String UID = "v1T";
	
	/**
	 * Generiert eine neue Gruppe mit RemoteSockets
	 * @param n  Anzahl der zugeordneten neuen Schalter
	 * @return
	 */
	/*
	public static SocketGroup getNewRemoteGroup(int max)
	{
		// neuen Datensatz generieren
		EClass socketGroupClass = WifiPackage.eINSTANCE.getSocketGroup();
		EObject groupObject = EcoreUtil.create(socketGroupClass);
		
		SocketGroup socketGroup = (SocketGroup) groupObject;
		socketGroup.setName("SocketGroup");		
		
		EList<RemoteSocket>sockets = socketGroup.getSockets();
		for(int i = 0;i < max;i++)
			sockets.add(getNewRemote(i));
		
		return socketGroup;
	}
	*/
	
	/**
	 * Generiert einen neuen Datensatz
	 * @param i  Zusatz zum Namen des Schalters
	 * @return
	 */
	/*
	public static RemoteSocket getNewRemote(int i)
	{
		// neuen Datensatz generieren
		EClass remoteSocketClass = WifiPackage.eINSTANCE.getRemoteSocket();
		EObject remoteSocketObject = EcoreUtil.create(remoteSocketClass);
		
		RemoteSocket remoteSocket = (RemoteSocket) remoteSocketObject;
		remoteSocket.setName("Socket "+i);
		remoteSocket.setHouseCode((short) 8);
		
		return remoteSocket;
	}
	*/
	
	
	
	private void connectJob()
	{
		Job job = new Job("Connect Job")
		{
			@Override
			protected IStatus run(IProgressMonitor monitor)
			{
				//doConnect();

				//syncWithUi();
				// use this to open a Shell in the UI thread
				return Status.OK_STATUS;
			}

		};
     
     job.setUser(true);
     job.schedule();

	}
	
	/*
	private void doConnect()
	{
		eventBroker.send(STATUSBAR,"Verbindungsaufbau mit Host: "+Host+"  Port: "+Port);
		//System.out.println("  Verbindungsaufbau mit Host: "+Host+"  Port: "+Port);
		
		ipcon = new IPConnection();
		while (true)
		{
			try
			{
				ipcon.connect(Host, new Integer(Port).intValue());
				break;

			} catch (Exception e)
			{
				System.out.println("exception Connect");
				//e.printStackTrace();
			}

			try
			{
				Thread.sleep(500);
			} catch (InterruptedException e)
			{
			}
		}
		
		eventBroker.send(STATUSBAR,"Verbunden mit Host: "+Host+"  Port: "+Port);
		//System.out.println(" verbunden mit Host: "+Host+"  Port: "+Port);
	}
	*/
	
	
	
	

	public static void switchSocket(RemoteSocketData[] remoteSockets,
			boolean switchFlag) throws Exception
	{
		IPConnection ipcon = getConnection();
		if (ipcon != null)
		{
			BrickletRemoteSwitch rs = new BrickletRemoteSwitch(UID, ipcon);

			short state = ipcon.getConnectionState();
			if (state == IPConnectionBase.CONNECTION_STATE_CONNECTED)
				System.out.println("connected");

			if ((remoteSockets != null) && (remoteSockets != null))
			{
				for (RemoteSocketData remoteSocket : remoteSockets)
				{
					rs.switchSocketA(remoteSocket.getHouseCode(),
							remoteSocket.getRemoteCode(),
							(switchFlag) ? BrickletRemoteSwitch.SWITCH_TO_ON
									: BrickletRemoteSwitch.SWITCH_TO_OFF);
				}
			}

			// rs.switchSocketA((short)1, (short)1, (switchFlag) ?
			// BrickletRemoteSwitch.SWITCH_TO_ON :
			// BrickletRemoteSwitch.SWITCH_TO_OFF);

			/*
			 * switch (view.getId()) { case R.id.checkBox:
			 * rs.switchSocketA((short)17, (short)1, (switchFlag) ?
			 * BrickletRemoteSwitch.SWITCH_TO_ON :
			 * BrickletRemoteSwitch.SWITCH_TO_OFF); break; }
			 */

			ipcon.disconnect();
		}

	}
	


	public static IPConnection getConnection()
	{
		IPConnection ipcon = new IPConnection();

		try
		{
			ipcon.connect(HOST, PORT);
			return ipcon;
		} catch (IOException e)
		{
			e.printStackTrace();
		} catch (AlreadyConnectedException e)
		{
			e.printStackTrace();
		}

		return null;
	}

}
