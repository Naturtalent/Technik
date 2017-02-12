/**
 */
package wifi.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import wifi.RemoteSockets;
import wifi.SocketGroup;
import wifi.WifiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Remote Sockets</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link wifi.impl.RemoteSocketsImpl#getSocketGroups <em>Socket Groups</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RemoteSocketsImpl extends MinimalEObjectImpl.Container implements RemoteSockets
{
	/**
	 * The cached value of the '{@link #getSocketGroups() <em>Socket Groups</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSocketGroups()
	 * @generated
	 * @ordered
	 */
	protected EList<SocketGroup> socketGroups;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RemoteSocketsImpl()
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
		return WifiPackage.Literals.REMOTE_SOCKETS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SocketGroup> getSocketGroups()
	{
		if (socketGroups == null)
		{
			socketGroups = new EObjectContainmentEList<SocketGroup>(SocketGroup.class, this, WifiPackage.REMOTE_SOCKETS__SOCKET_GROUPS);
		}
		return socketGroups;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case WifiPackage.REMOTE_SOCKETS__SOCKET_GROUPS:
				return ((InternalEList<?>)getSocketGroups()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
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
			case WifiPackage.REMOTE_SOCKETS__SOCKET_GROUPS:
				return getSocketGroups();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case WifiPackage.REMOTE_SOCKETS__SOCKET_GROUPS:
				getSocketGroups().clear();
				getSocketGroups().addAll((Collection<? extends SocketGroup>)newValue);
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
			case WifiPackage.REMOTE_SOCKETS__SOCKET_GROUPS:
				getSocketGroups().clear();
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
			case WifiPackage.REMOTE_SOCKETS__SOCKET_GROUPS:
				return socketGroups != null && !socketGroups.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //RemoteSocketsImpl
