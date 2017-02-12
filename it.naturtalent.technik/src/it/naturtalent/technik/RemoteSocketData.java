package it.naturtalent.technik;

public class RemoteSocketData 
{
	static public final Character SOCKET_TYPE_A = 'A';
	static public final Character SOCKET_TYPE_B = 'B';
	
	private String id;
	private String name;
	private char type;
	private short houseCode;
	private short remoteCode;
	
	
	
	
	public RemoteSocketData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RemoteSocketData(String id, String name, char type, short houseCode, short remoteCode) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.houseCode = houseCode;
		this.remoteCode = remoteCode;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}

	public short getHouseCode() {
		return houseCode;
	}

	public void setHouseCode(short houseCode) {
		this.houseCode = houseCode;
	}

	public short getRemoteCode() {
		return remoteCode;
	}

	public void setRemoteCode(short remoteCode) {
		this.remoteCode = remoteCode;
	}	
	
}
