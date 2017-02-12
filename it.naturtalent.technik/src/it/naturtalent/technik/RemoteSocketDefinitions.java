package it.naturtalent.technik;

import java.util.ArrayList;
import java.util.List;

public class RemoteSocketDefinitions 
{
	private List<RemoteSocketData>remoteSockets = new ArrayList<RemoteSocketData>();
	
	public List<RemoteSocketData> getRemoteSockets() 
	{
		if(remoteSockets.isEmpty())
		{
			remoteSockets.clear();
						
			RemoteSocketData remoteSocketsData = 
					new RemoteSocketData("socket1",
							"Pumpe Quellbecken",
							(char) RemoteSocketData.SOCKET_TYPE_A,
							(short) 1,
							(short) 1);			
			remoteSockets.add(remoteSocketsData);
			
			remoteSocketsData = 
					new RemoteSocketData("socket2",
							"Skimmer",
							(char) RemoteSocketData.SOCKET_TYPE_A,
							(short) 1,
							(short) 2);			
			remoteSockets.add(remoteSocketsData);
			
			remoteSocketsData = 
					new RemoteSocketData("socket3",
							"Spot Amhore",
							(char) RemoteSocketData.SOCKET_TYPE_A,
							(short) 1,
							(short) 3);			
			remoteSockets.add(remoteSocketsData);

			remoteSocketsData = 
					new RemoteSocketData("socket4",
							"Spot Teich ",
							(char) RemoteSocketData.SOCKET_TYPE_A,
							(short) 1,
							(short) 4);			
			remoteSockets.add(remoteSocketsData);
			
		}
		
		return remoteSockets;
	}

}
