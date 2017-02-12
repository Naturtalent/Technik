package it.naturtalent.technik;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

public class SocketPreferencesComposite extends Composite
{
	private Text textHost;
	private Text textPort;
	private Text textBrickID;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public SocketPreferencesComposite(Composite parent, int style)
	{
		super(parent, style);
		
		Label lblWifi = new Label(this, SWT.NONE);
		lblWifi.setBounds(10, 10, 147, 17);
		lblWifi.setText("WiFi Einstellungen");
		
		Label lblHost = new Label(this, SWT.NONE);
		lblHost.setBounds(10, 54, 45, 17);
		lblHost.setText("Host:");

		textHost = new Text(this, SWT.BORDER);
		textHost.setBounds(80, 53, 215, 27);
		textHost.setTextLimit(50);
		
		Label lblPort = new Label(this, SWT.NONE);
		lblPort.setBounds(10, 93, 45, 17);
		lblPort.setText("Port:");
		
		textPort = new Text(this, SWT.BORDER);
		textPort.setBounds(80, 93, 73, 27);		
		textPort.setTextLimit(4);
		
		Label lblBrickId = new Label(this, SWT.NONE);
		lblBrickId.setBounds(10, 138, 62, 17);
		lblBrickId.setText("Brick ID:");
		
		textBrickID = new Text(this, SWT.BORDER);
		textBrickID.setBounds(80, 133, 75, 27);
		textBrickID.setTextLimit(10);
		

	}

	@Override
	protected void checkSubclass()
	{
		// Disable the check that prevents subclassing of SWT components
	}

	public Text getTextHost()
	{
		return textHost;
	}

	public Text getTextPort()
	{
		return textPort;
	}

	public Text getTextBrickID()
	{
		return textBrickID;
	}
	
	
}
