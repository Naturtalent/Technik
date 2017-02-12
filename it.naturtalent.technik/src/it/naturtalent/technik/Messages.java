package it.naturtalent.technik;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "it.naturtalent.technik.messages"; //$NON-NLS-1$
	public static String SocketRemoteControl_this_title;
	public static String SocketRemoteControl_this_message;
	public static String SocketRemoteControl_btnNewButton_text;
	public static String SocketRemoteControl_btnNewButton_text_1;
	public static String RemoteSocketsView_sctnRemoteSockets_text;
	public static String RemoteSocketsView_lblNewLabel_text;
	public static String SocketHackerDialog_this_title;
	public static String SocketHackerDialog_this_message;
	public static String OnOffDialog_container_toolTipText;
	public static String OnOffDialog_btnOffButton_text;
	public static String OnOffDialog_btnNewButton_text;
	public static String OnOffDialog_btnRadioButton_text;
	public static String OnOffDialog_text_text;
	
	////////////////////////////////////////////////////////////////////////////
	//
	// Constructor
	//
	////////////////////////////////////////////////////////////////////////////
	private Messages() {
		// do not instantiate
	}
	////////////////////////////////////////////////////////////////////////////
	//
	// Class initialization
	//
	////////////////////////////////////////////////////////////////////////////
	static {
		// load message values from bundle file
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}
}
