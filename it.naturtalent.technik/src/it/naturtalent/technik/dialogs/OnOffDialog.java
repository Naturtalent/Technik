package it.naturtalent.technik.dialogs;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import it.naturtalent.technik.Messages;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;

public class OnOffDialog extends Dialog
{

	private int switchState = (-1);
	
	private Button btnOnButton;
	private Button btnOffButton;
	private Label text;
	
	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public OnOffDialog(Shell parentShell)
	{
		super(parentShell);
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent)
	{
		Composite container = (Composite) super.createDialogArea(parent);
		container.setToolTipText(Messages.OnOffDialog_container_toolTipText);
		container.setLayout(new GridLayout(3, false));
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		
		text = new Label(container, SWT.BORDER);
		text.setText(Messages.OnOffDialog_text_text);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		
		btnOnButton = new Button(container, SWT.RADIO);
		btnOnButton.setSelection(true);
		btnOnButton.setText(Messages.OnOffDialog_btnOffButton_text);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		
		btnOffButton = new Button(container, SWT.RADIO);
		btnOffButton.setText(Messages.OnOffDialog_btnRadioButton_text);

		return container;
	}

	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent)
	{
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
				true);
		createButton(parent, IDialogConstants.CANCEL_ID,
				IDialogConstants.CANCEL_LABEL, false);
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize()
	{
		return new Point(450, 240);
	}

	@Override
	protected void okPressed()
	{
		switchState = (btnOffButton.getSelection() ? 0 : 1);
		super.okPressed();
	}

	public int getSwitchState()
	{
		return switchState;
	}
	
	

}
