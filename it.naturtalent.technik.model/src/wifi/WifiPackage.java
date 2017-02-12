/**
 */
package wifi;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see wifi.WifiFactory
 * @model kind="package"
 * @generated
 */
public interface WifiPackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "wifi";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/wifi";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "wifi";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	WifiPackage eINSTANCE = wifi.impl.WifiPackageImpl.init();

	/**
	 * The meta object id for the '{@link wifi.impl.RemoteSocketImpl <em>Remote Socket</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see wifi.impl.RemoteSocketImpl
	 * @see wifi.impl.WifiPackageImpl#getRemoteSocket()
	 * @generated
	 */
	int REMOTE_SOCKET = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_SOCKET__NAME = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_SOCKET__TYPE = 1;

	/**
	 * The feature id for the '<em><b>House Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_SOCKET__HOUSE_CODE = 2;

	/**
	 * The feature id for the '<em><b>Receiver Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_SOCKET__RECEIVER_CODE = 3;

	/**
	 * The number of structural features of the '<em>Remote Socket</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_SOCKET_FEATURE_COUNT = 4;

	/**
	 * The operation id for the '<em>Has Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_SOCKET___HAS_NAME__DIAGNOSTICCHAIN_MAP = 0;

	/**
	 * The number of operations of the '<em>Remote Socket</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_SOCKET_OPERATION_COUNT = 1;


	/**
	 * The meta object id for the '{@link wifi.impl.SocketGroupImpl <em>Socket Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see wifi.impl.SocketGroupImpl
	 * @see wifi.impl.WifiPackageImpl#getSocketGroup()
	 * @generated
	 */
	int SOCKET_GROUP = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOCKET_GROUP__NAME = 0;

	/**
	 * The feature id for the '<em><b>Members</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOCKET_GROUP__MEMBERS = 1;

	/**
	 * The number of structural features of the '<em>Socket Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOCKET_GROUP_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Socket Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOCKET_GROUP_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link wifi.impl.RemoteSocketsImpl <em>Remote Sockets</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see wifi.impl.RemoteSocketsImpl
	 * @see wifi.impl.WifiPackageImpl#getRemoteSockets()
	 * @generated
	 */
	int REMOTE_SOCKETS = 2;

	/**
	 * The feature id for the '<em><b>Socket Groups</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_SOCKETS__SOCKET_GROUPS = 0;

	/**
	 * The number of structural features of the '<em>Remote Sockets</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_SOCKETS_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Remote Sockets</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_SOCKETS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link wifi.RemoteType <em>Remote Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see wifi.RemoteType
	 * @see wifi.impl.WifiPackageImpl#getRemoteType()
	 * @generated
	 */
	int REMOTE_TYPE = 3;


	/**
	 * Returns the meta object for class '{@link wifi.RemoteSocket <em>Remote Socket</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Remote Socket</em>'.
	 * @see wifi.RemoteSocket
	 * @generated
	 */
	EClass getRemoteSocket();

	/**
	 * Returns the meta object for the attribute '{@link wifi.RemoteSocket#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see wifi.RemoteSocket#getName()
	 * @see #getRemoteSocket()
	 * @generated
	 */
	EAttribute getRemoteSocket_Name();

	/**
	 * Returns the meta object for the attribute '{@link wifi.RemoteSocket#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see wifi.RemoteSocket#getType()
	 * @see #getRemoteSocket()
	 * @generated
	 */
	EAttribute getRemoteSocket_Type();

	/**
	 * Returns the meta object for the attribute '{@link wifi.RemoteSocket#getHouseCode <em>House Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>House Code</em>'.
	 * @see wifi.RemoteSocket#getHouseCode()
	 * @see #getRemoteSocket()
	 * @generated
	 */
	EAttribute getRemoteSocket_HouseCode();

	/**
	 * Returns the meta object for the attribute '{@link wifi.RemoteSocket#getReceiverCode <em>Receiver Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Receiver Code</em>'.
	 * @see wifi.RemoteSocket#getReceiverCode()
	 * @see #getRemoteSocket()
	 * @generated
	 */
	EAttribute getRemoteSocket_ReceiverCode();

	/**
	 * Returns the meta object for the '{@link wifi.RemoteSocket#hasName(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Has Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Has Name</em>' operation.
	 * @see wifi.RemoteSocket#hasName(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getRemoteSocket__HasName__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link wifi.SocketGroup <em>Socket Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Socket Group</em>'.
	 * @see wifi.SocketGroup
	 * @generated
	 */
	EClass getSocketGroup();

	/**
	 * Returns the meta object for the attribute '{@link wifi.SocketGroup#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see wifi.SocketGroup#getName()
	 * @see #getSocketGroup()
	 * @generated
	 */
	EAttribute getSocketGroup_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link wifi.SocketGroup#getMembers <em>Members</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Members</em>'.
	 * @see wifi.SocketGroup#getMembers()
	 * @see #getSocketGroup()
	 * @generated
	 */
	EReference getSocketGroup_Members();

	/**
	 * Returns the meta object for class '{@link wifi.RemoteSockets <em>Remote Sockets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Remote Sockets</em>'.
	 * @see wifi.RemoteSockets
	 * @generated
	 */
	EClass getRemoteSockets();

	/**
	 * Returns the meta object for the containment reference list '{@link wifi.RemoteSockets#getSocketGroups <em>Socket Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Socket Groups</em>'.
	 * @see wifi.RemoteSockets#getSocketGroups()
	 * @see #getRemoteSockets()
	 * @generated
	 */
	EReference getRemoteSockets_SocketGroups();

	/**
	 * Returns the meta object for enum '{@link wifi.RemoteType <em>Remote Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Remote Type</em>'.
	 * @see wifi.RemoteType
	 * @generated
	 */
	EEnum getRemoteType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	WifiFactory getWifiFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals
	{
		/**
		 * The meta object literal for the '{@link wifi.impl.RemoteSocketImpl <em>Remote Socket</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see wifi.impl.RemoteSocketImpl
		 * @see wifi.impl.WifiPackageImpl#getRemoteSocket()
		 * @generated
		 */
		EClass REMOTE_SOCKET = eINSTANCE.getRemoteSocket();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REMOTE_SOCKET__NAME = eINSTANCE.getRemoteSocket_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REMOTE_SOCKET__TYPE = eINSTANCE.getRemoteSocket_Type();

		/**
		 * The meta object literal for the '<em><b>House Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REMOTE_SOCKET__HOUSE_CODE = eINSTANCE.getRemoteSocket_HouseCode();

		/**
		 * The meta object literal for the '<em><b>Receiver Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REMOTE_SOCKET__RECEIVER_CODE = eINSTANCE.getRemoteSocket_ReceiverCode();

		/**
		 * The meta object literal for the '<em><b>Has Name</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation REMOTE_SOCKET___HAS_NAME__DIAGNOSTICCHAIN_MAP = eINSTANCE.getRemoteSocket__HasName__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link wifi.impl.SocketGroupImpl <em>Socket Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see wifi.impl.SocketGroupImpl
		 * @see wifi.impl.WifiPackageImpl#getSocketGroup()
		 * @generated
		 */
		EClass SOCKET_GROUP = eINSTANCE.getSocketGroup();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOCKET_GROUP__NAME = eINSTANCE.getSocketGroup_Name();

		/**
		 * The meta object literal for the '<em><b>Members</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOCKET_GROUP__MEMBERS = eINSTANCE.getSocketGroup_Members();

		/**
		 * The meta object literal for the '{@link wifi.impl.RemoteSocketsImpl <em>Remote Sockets</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see wifi.impl.RemoteSocketsImpl
		 * @see wifi.impl.WifiPackageImpl#getRemoteSockets()
		 * @generated
		 */
		EClass REMOTE_SOCKETS = eINSTANCE.getRemoteSockets();

		/**
		 * The meta object literal for the '<em><b>Socket Groups</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REMOTE_SOCKETS__SOCKET_GROUPS = eINSTANCE.getRemoteSockets_SocketGroups();

		/**
		 * The meta object literal for the '{@link wifi.RemoteType <em>Remote Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see wifi.RemoteType
		 * @see wifi.impl.WifiPackageImpl#getRemoteType()
		 * @generated
		 */
		EEnum REMOTE_TYPE = eINSTANCE.getRemoteType();

	}

} //WifiPackage
