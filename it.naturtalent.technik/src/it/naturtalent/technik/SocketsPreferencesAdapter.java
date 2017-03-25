package it.naturtalent.technik;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.core.runtime.preferences.DefaultScope;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.osgi.service.prefs.BackingStoreException;

import it.naturtalent.application.AbstractPreferenceAdapter;
import it.naturtalent.application.IPreferenceNode;

public class SocketsPreferencesAdapter extends AbstractPreferenceAdapter
{
	
	//private Log log = LogFactory.getLog(this.getClass());
	
	private Text textHost;
	private Text textPort;
	private Text textBrickUID;
	
	public SocketsPreferencesAdapter()
	{
		instancePreferenceNode = InstanceScope.INSTANCE.getNode(TechnikPreferences.ROOT_NATURTALENTTECHNIK_PREFERENCES_NODE);
		defaultPreferenceNode = DefaultScope.INSTANCE.getNode(TechnikPreferences.ROOT_NATURTALENTTECHNIK_PREFERENCES_NODE);
	}

	@Override
	public String getLabel()
	{	
		return "Funksteckdosen";
	}

	@Override
	public String getNodePath()
	{
		return "Naturtalent Technik";
	}

	@Override
	public void restoreDefaultPressed()
	{
		String value = defaultPreferenceNode.get(TechnikPreferences.WIFI_HOST, TechnikPreferences.WIFI_DEFAULT_HOST);
		if(StringUtils.isNotEmpty(value))
			textHost.setText(value);
		
		value = defaultPreferenceNode.get(TechnikPreferences.WIFI_PORT, TechnikPreferences.WIFI_DEFAULT_PORT);
		if(StringUtils.isNotEmpty(value))
			textPort.setText(value);

		value = defaultPreferenceNode.get(TechnikPreferences.BRICKLET_UID, TechnikPreferences.BRICKLET_DEFAULT_UID);
		if(StringUtils.isNotEmpty(value))
			textBrickUID.setText(value);

	}

	@Override
	public void appliedPressed()
	{
		String value = textHost.getText();
		if(StringUtils.isNotEmpty(value))
			instancePreferenceNode.put(TechnikPreferences.WIFI_HOST, value);
		
		value = textPort.getText();
		if(StringUtils.isNotEmpty(value))
			instancePreferenceNode.put(TechnikPreferences.WIFI_PORT, value);
		
		value = textBrickUID.getText();
		if(StringUtils.isNotEmpty(value))
			instancePreferenceNode.put(TechnikPreferences.BRICKLET_UID, value);
		
		try
		{
			instancePreferenceNode.flush();
		} catch (BackingStoreException e)
		{
			e.printStackTrace();
			//log.error(e);	
		}
	}

	@Override
	public void okPressed()
	{
		appliedPressed();
	}

	@Override
	public Composite createNodeComposite(IPreferenceNode parentNodeComposite)
	{
		// Titel
		parentNodeComposite.setTitle(getLabel());
		
		SocketPreferencesComposite comp = new SocketPreferencesComposite(
				parentNodeComposite.getParentNode(), SWT.NONE);	
		
		textHost = comp.getTextHost();
		textPort = comp.getTextPort();
		textBrickUID = comp.getTextBrickID();
		
		String value = instancePreferenceNode.get(TechnikPreferences.WIFI_HOST, TechnikPreferences.WIFI_DEFAULT_HOST);
		textHost.setText(value);

		value = instancePreferenceNode.get(TechnikPreferences.WIFI_PORT, TechnikPreferences.WIFI_DEFAULT_PORT);
		textPort.setText(value);

		value = instancePreferenceNode.get(TechnikPreferences.BRICKLET_UID, TechnikPreferences.BRICKLET_DEFAULT_UID);
		textBrickUID.setText(value);

		return comp;
	}

}
