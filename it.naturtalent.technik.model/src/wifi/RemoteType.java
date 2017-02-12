/**
 */
package wifi;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Remote Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see wifi.WifiPackage#getRemoteType()
 * @model
 * @generated
 */
public enum RemoteType implements Enumerator
{
	/**
	 * The '<em><b>House Code Socket</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HOUSE_CODE_SOCKET_VALUE
	 * @generated
	 * @ordered
	 */
	HOUSE_CODE_SOCKET(0, "HouseCodeSocket", "ATypeSocketA"),

	/**
	 * The '<em><b>Address Code Socket</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ADDRESS_CODE_SOCKET_VALUE
	 * @generated
	 * @ordered
	 */
	ADDRESS_CODE_SOCKET(1, "AddressCodeSocket", "BTypeSocket");

	/**
	 * The '<em><b>House Code Socket</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>House Code Socket</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HOUSE_CODE_SOCKET
	 * @model name="HouseCodeSocket" literal="ATypeSocketA"
	 * @generated
	 * @ordered
	 */
	public static final int HOUSE_CODE_SOCKET_VALUE = 0;

	/**
	 * The '<em><b>Address Code Socket</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Address Code Socket</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ADDRESS_CODE_SOCKET
	 * @model name="AddressCodeSocket" literal="BTypeSocket"
	 * @generated
	 * @ordered
	 */
	public static final int ADDRESS_CODE_SOCKET_VALUE = 1;

	/**
	 * An array of all the '<em><b>Remote Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final RemoteType[] VALUES_ARRAY =
		new RemoteType[]
		{
			HOUSE_CODE_SOCKET,
			ADDRESS_CODE_SOCKET,
		};

	/**
	 * A public read-only list of all the '<em><b>Remote Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<RemoteType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Remote Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static RemoteType get(String literal)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			RemoteType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Remote Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static RemoteType getByName(String name)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			RemoteType result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Remote Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static RemoteType get(int value)
	{
		switch (value)
		{
			case HOUSE_CODE_SOCKET_VALUE: return HOUSE_CODE_SOCKET;
			case ADDRESS_CODE_SOCKET_VALUE: return ADDRESS_CODE_SOCKET;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private RemoteType(int value, String name, String literal)
	{
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue()
	{
	  return value;
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
	public String getLiteral()
	{
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		return literal;
	}
	
} //RemoteType
