/**
 */
package wifi;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Remote Sockets</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link wifi.RemoteSockets#getSocketGroups <em>Socket Groups</em>}</li>
 * </ul>
 *
 * @see wifi.WifiPackage#getRemoteSockets()
 * @model
 * @generated
 */
public interface RemoteSockets extends EObject
{
	/**
	 * Returns the value of the '<em><b>Socket Groups</b></em>' containment reference list.
	 * The list contents are of type {@link wifi.SocketGroup}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Socket Groups</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Socket Groups</em>' containment reference list.
	 * @see wifi.WifiPackage#getRemoteSockets_SocketGroups()
	 * @model containment="true"
	 * @generated
	 */
	EList<SocketGroup> getSocketGroups();

} // RemoteSockets
