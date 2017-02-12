/**
 */
package wifi.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import wifi.RemoteSocket;
import wifi.RemoteSockets;
import wifi.RemoteType;
import wifi.SocketGroup;
import wifi.WifiFactory;
import wifi.WifiPackage;
import wifi.util.WifiValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class WifiPackageImpl extends EPackageImpl implements WifiPackage
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass remoteSocketEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass socketGroupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass remoteSocketsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum remoteTypeEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see wifi.WifiPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private WifiPackageImpl()
	{
		super(eNS_URI, WifiFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link WifiPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static WifiPackage init()
	{
		if (isInited) return (WifiPackage)EPackage.Registry.INSTANCE.getEPackage(WifiPackage.eNS_URI);

		// Obtain or create and register package
		WifiPackageImpl theWifiPackage = (WifiPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof WifiPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new WifiPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theWifiPackage.createPackageContents();

		// Initialize created meta-data
		theWifiPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theWifiPackage, 
			 new EValidator.Descriptor()
			 {
				 public EValidator getEValidator()
				 {
					 return WifiValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theWifiPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(WifiPackage.eNS_URI, theWifiPackage);
		return theWifiPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRemoteSocket()
	{
		return remoteSocketEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRemoteSocket_Name()
	{
		return (EAttribute)remoteSocketEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRemoteSocket_Type()
	{
		return (EAttribute)remoteSocketEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRemoteSocket_HouseCode()
	{
		return (EAttribute)remoteSocketEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRemoteSocket_ReceiverCode()
	{
		return (EAttribute)remoteSocketEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRemoteSocket__HasName__DiagnosticChain_Map()
	{
		return remoteSocketEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSocketGroup()
	{
		return socketGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSocketGroup_Name()
	{
		return (EAttribute)socketGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSocketGroup_Members()
	{
		return (EReference)socketGroupEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRemoteSockets()
	{
		return remoteSocketsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRemoteSockets_SocketGroups()
	{
		return (EReference)remoteSocketsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getRemoteType()
	{
		return remoteTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WifiFactory getWifiFactory()
	{
		return (WifiFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents()
	{
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		remoteSocketEClass = createEClass(REMOTE_SOCKET);
		createEAttribute(remoteSocketEClass, REMOTE_SOCKET__NAME);
		createEAttribute(remoteSocketEClass, REMOTE_SOCKET__TYPE);
		createEAttribute(remoteSocketEClass, REMOTE_SOCKET__HOUSE_CODE);
		createEAttribute(remoteSocketEClass, REMOTE_SOCKET__RECEIVER_CODE);
		createEOperation(remoteSocketEClass, REMOTE_SOCKET___HAS_NAME__DIAGNOSTICCHAIN_MAP);

		socketGroupEClass = createEClass(SOCKET_GROUP);
		createEAttribute(socketGroupEClass, SOCKET_GROUP__NAME);
		createEReference(socketGroupEClass, SOCKET_GROUP__MEMBERS);

		remoteSocketsEClass = createEClass(REMOTE_SOCKETS);
		createEReference(remoteSocketsEClass, REMOTE_SOCKETS__SOCKET_GROUPS);

		// Create enums
		remoteTypeEEnum = createEEnum(REMOTE_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents()
	{
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(remoteSocketEClass, RemoteSocket.class, "RemoteSocket", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRemoteSocket_Name(), ecorePackage.getEString(), "name", "", 0, 1, RemoteSocket.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRemoteSocket_Type(), this.getRemoteType(), "type", null, 0, 1, RemoteSocket.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRemoteSocket_HouseCode(), ecorePackage.getEShort(), "houseCode", null, 0, 1, RemoteSocket.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRemoteSocket_ReceiverCode(), ecorePackage.getEShort(), "receiverCode", null, 0, 1, RemoteSocket.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getRemoteSocket__HasName__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "hasName", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "chain", 0, 1, IS_UNIQUE, IS_ORDERED);
		EGenericType g1 = createEGenericType(ecorePackage.getEMap());
		EGenericType g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(socketGroupEClass, SocketGroup.class, "SocketGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSocketGroup_Name(), ecorePackage.getEString(), "name", null, 0, 1, SocketGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSocketGroup_Members(), this.getRemoteSocket(), null, "Members", null, 0, -1, SocketGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(remoteSocketsEClass, RemoteSockets.class, "RemoteSockets", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRemoteSockets_SocketGroups(), this.getSocketGroup(), null, "SocketGroups", null, 0, -1, RemoteSockets.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(remoteTypeEEnum, RemoteType.class, "RemoteType");
		addEEnumLiteral(remoteTypeEEnum, RemoteType.HOUSE_CODE_SOCKET);
		addEEnumLiteral(remoteTypeEEnum, RemoteType.ADDRESS_CODE_SOCKET);

		// Create resource
		createResource(eNS_URI);
	}

} //WifiPackageImpl
