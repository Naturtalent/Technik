/**
 */
package wifi.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectValidator;
import wifi.RemoteSocket;
import wifi.RemoteType;
import wifi.WifiPackage;
import wifi.util.WifiValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Remote Socket</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link wifi.impl.RemoteSocketImpl#getName <em>Name</em>}</li>
 *   <li>{@link wifi.impl.RemoteSocketImpl#getType <em>Type</em>}</li>
 *   <li>{@link wifi.impl.RemoteSocketImpl#getHouseCode <em>House Code</em>}</li>
 *   <li>{@link wifi.impl.RemoteSocketImpl#getReceiverCode <em>Receiver Code</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RemoteSocketImpl extends MinimalEObjectImpl.Container implements RemoteSocket
{
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final RemoteType TYPE_EDEFAULT = RemoteType.HOUSE_CODE_SOCKET;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected RemoteType type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getHouseCode() <em>House Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHouseCode()
	 * @generated
	 * @ordered
	 */
	protected static final short HOUSE_CODE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getHouseCode() <em>House Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHouseCode()
	 * @generated
	 * @ordered
	 */
	protected short houseCode = HOUSE_CODE_EDEFAULT;

	/**
	 * The default value of the '{@link #getReceiverCode() <em>Receiver Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReceiverCode()
	 * @generated
	 * @ordered
	 */
	protected static final short RECEIVER_CODE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getReceiverCode() <em>Receiver Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReceiverCode()
	 * @generated
	 * @ordered
	 */
	protected short receiverCode = RECEIVER_CODE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RemoteSocketImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return WifiPackage.Literals.REMOTE_SOCKET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName)
	{
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WifiPackage.REMOTE_SOCKET__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RemoteType getType()
	{
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(RemoteType newType)
	{
		RemoteType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WifiPackage.REMOTE_SOCKET__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public short getHouseCode()
	{
		return houseCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHouseCode(short newHouseCode)
	{
		short oldHouseCode = houseCode;
		houseCode = newHouseCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WifiPackage.REMOTE_SOCKET__HOUSE_CODE, oldHouseCode, houseCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public short getReceiverCode()
	{
		return receiverCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReceiverCode(short newReceiverCode)
	{
		short oldReceiverCode = receiverCode;
		receiverCode = newReceiverCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WifiPackage.REMOTE_SOCKET__RECEIVER_CODE, oldReceiverCode, receiverCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean hasName(DiagnosticChain chain, Map<?, ?> context)
	{		
		if (StringUtils.isEmpty(getName()))
		{
			if (chain != null)
			{
				chain.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 WifiValidator.DIAGNOSTIC_SOURCE,
						 WifiValidator.REMOTE_SOCKET__HAS_NAME,
						 "Name der Funksteckdose sollte definiert sein",
						 new Object [] { this, WifiPackage.eINSTANCE.getRemoteSocket_Name() }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case WifiPackage.REMOTE_SOCKET__NAME:
				return getName();
			case WifiPackage.REMOTE_SOCKET__TYPE:
				return getType();
			case WifiPackage.REMOTE_SOCKET__HOUSE_CODE:
				return getHouseCode();
			case WifiPackage.REMOTE_SOCKET__RECEIVER_CODE:
				return getReceiverCode();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case WifiPackage.REMOTE_SOCKET__NAME:
				setName((String)newValue);
				return;
			case WifiPackage.REMOTE_SOCKET__TYPE:
				setType((RemoteType)newValue);
				return;
			case WifiPackage.REMOTE_SOCKET__HOUSE_CODE:
				setHouseCode((Short)newValue);
				return;
			case WifiPackage.REMOTE_SOCKET__RECEIVER_CODE:
				setReceiverCode((Short)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
			case WifiPackage.REMOTE_SOCKET__NAME:
				setName(NAME_EDEFAULT);
				return;
			case WifiPackage.REMOTE_SOCKET__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case WifiPackage.REMOTE_SOCKET__HOUSE_CODE:
				setHouseCode(HOUSE_CODE_EDEFAULT);
				return;
			case WifiPackage.REMOTE_SOCKET__RECEIVER_CODE:
				setReceiverCode(RECEIVER_CODE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
			case WifiPackage.REMOTE_SOCKET__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case WifiPackage.REMOTE_SOCKET__TYPE:
				return type != TYPE_EDEFAULT;
			case WifiPackage.REMOTE_SOCKET__HOUSE_CODE:
				return houseCode != HOUSE_CODE_EDEFAULT;
			case WifiPackage.REMOTE_SOCKET__RECEIVER_CODE:
				return receiverCode != RECEIVER_CODE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException
	{
		switch (operationID)
		{
			case WifiPackage.REMOTE_SOCKET___HAS_NAME__DIAGNOSTICCHAIN_MAP:
				return hasName((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", type: ");
		result.append(type);
		result.append(", houseCode: ");
		result.append(houseCode);
		result.append(", receiverCode: ");
		result.append(receiverCode);
		result.append(')');
		return result.toString();
	}

} //RemoteSocketImpl
