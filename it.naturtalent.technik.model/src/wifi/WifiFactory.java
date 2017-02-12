/**
 */
package wifi;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see wifi.WifiPackage
 * @generated
 */
public interface WifiFactory extends EFactory
{
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	WifiFactory eINSTANCE = wifi.impl.WifiFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Remote Socket</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Remote Socket</em>'.
	 * @generated
	 */
	RemoteSocket createRemoteSocket();

	/**
	 * Returns a new object of class '<em>Socket Group</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Socket Group</em>'.
	 * @generated
	 */
	SocketGroup createSocketGroup();

	/**
	 * Returns a new object of class '<em>Remote Sockets</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Remote Sockets</em>'.
	 * @generated
	 */
	RemoteSockets createRemoteSockets();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	WifiPackage getWifiPackage();

} //WifiFactory
