/**
 */
package wifi;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Remote Socket</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link wifi.RemoteSocket#getName <em>Name</em>}</li>
 *   <li>{@link wifi.RemoteSocket#getType <em>Type</em>}</li>
 *   <li>{@link wifi.RemoteSocket#getHouseCode <em>House Code</em>}</li>
 *   <li>{@link wifi.RemoteSocket#getReceiverCode <em>Receiver Code</em>}</li>
 * </ul>
 *
 * @see wifi.WifiPackage#getRemoteSocket()
 * @model
 * @generated
 */
public interface RemoteSocket extends EObject
{
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see wifi.WifiPackage#getRemoteSocket_Name()
	 * @model default=""
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link wifi.RemoteSocket#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link wifi.RemoteType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see wifi.RemoteType
	 * @see #setType(RemoteType)
	 * @see wifi.WifiPackage#getRemoteSocket_Type()
	 * @model
	 * @generated
	 */
	RemoteType getType();

	/**
	 * Sets the value of the '{@link wifi.RemoteSocket#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see wifi.RemoteType
	 * @see #getType()
	 * @generated
	 */
	void setType(RemoteType value);

	/**
	 * Returns the value of the '<em><b>House Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>House Code</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>House Code</em>' attribute.
	 * @see #setHouseCode(short)
	 * @see wifi.WifiPackage#getRemoteSocket_HouseCode()
	 * @model
	 * @generated
	 */
	short getHouseCode();

	/**
	 * Sets the value of the '{@link wifi.RemoteSocket#getHouseCode <em>House Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>House Code</em>' attribute.
	 * @see #getHouseCode()
	 * @generated
	 */
	void setHouseCode(short value);

	/**
	 * Returns the value of the '<em><b>Receiver Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Receiver Code</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Receiver Code</em>' attribute.
	 * @see #setReceiverCode(short)
	 * @see wifi.WifiPackage#getRemoteSocket_ReceiverCode()
	 * @model
	 * @generated
	 */
	short getReceiverCode();

	/**
	 * Sets the value of the '{@link wifi.RemoteSocket#getReceiverCode <em>Receiver Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Receiver Code</em>' attribute.
	 * @see #getReceiverCode()
	 * @generated
	 */
	void setReceiverCode(short value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean hasName(DiagnosticChain chain, Map<?, ?> context);

} // RemoteSocket
