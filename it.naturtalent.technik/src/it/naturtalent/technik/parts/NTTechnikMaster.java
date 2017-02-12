
package it.naturtalent.technik.parts;

import javax.inject.Inject;

import java.net.Socket;

import javax.annotation.PostConstruct;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;

import it.naturtalent.technik.dialogs.SocketRemoteControl;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class NTTechnikMaster
{
	@Inject
	public NTTechnikMaster()
	{

	}

	@PostConstruct
	public void postConstruct(Composite parent)
	{
		parent.setLayout(new GridLayout(2, false));
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		
		Button btnRemoteSocket = new Button(parent, SWT.NONE);
		btnRemoteSocket.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				Dialog dialog = new SocketRemoteControl(parent.getShell());
				dialog.open();
				
			}
		});
		btnRemoteSocket.setText("Funksteckdosen");

	}

}