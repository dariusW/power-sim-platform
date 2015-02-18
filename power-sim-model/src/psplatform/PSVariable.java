/**
 */
package psplatform;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PS Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link psplatform.PSVariable#getType <em>Type</em>}</li>
 *   <li>{@link psplatform.PSVariable#getScope <em>Scope</em>}</li>
 *   <li>{@link psplatform.PSVariable#getKey <em>Key</em>}</li>
 *   <li>{@link psplatform.PSVariable#getValue <em>Value</em>}</li>
 *   <li>{@link psplatform.PSVariable#getDefault <em>Default</em>}</li>
 * </ul>
 * </p>
 *
 * @see psplatform.PsplatformPackage#getPSVariable()
 * @model
 * @generated
 */
public interface PSVariable extends EObject {
    /**
     * Returns the value of the '<em><b>Type</b></em>' attribute.
     * The literals are from the enumeration {@link psplatform.PSVariableType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Type</em>' attribute.
     * @see psplatform.PSVariableType
     * @see #setType(PSVariableType)
     * @see psplatform.PsplatformPackage#getPSVariable_Type()
     * @model required="true"
     * @generated
     */
    PSVariableType getType();

    /**
     * Sets the value of the '{@link psplatform.PSVariable#getType <em>Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type</em>' attribute.
     * @see psplatform.PSVariableType
     * @see #getType()
     * @generated
     */
    void setType(PSVariableType value);

    /**
     * Returns the value of the '<em><b>Scope</b></em>' attribute.
     * The literals are from the enumeration {@link psplatform.PSVariableScope}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Scope</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Scope</em>' attribute.
     * @see psplatform.PSVariableScope
     * @see #setScope(PSVariableScope)
     * @see psplatform.PsplatformPackage#getPSVariable_Scope()
     * @model required="true"
     * @generated
     */
    PSVariableScope getScope();

    /**
     * Sets the value of the '{@link psplatform.PSVariable#getScope <em>Scope</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Scope</em>' attribute.
     * @see psplatform.PSVariableScope
     * @see #getScope()
     * @generated
     */
    void setScope(PSVariableScope value);

    /**
     * Returns the value of the '<em><b>Key</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Key</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Key</em>' attribute.
     * @see #setKey(String)
     * @see psplatform.PsplatformPackage#getPSVariable_Key()
     * @model
     * @generated
     */
    String getKey();

    /**
     * Sets the value of the '{@link psplatform.PSVariable#getKey <em>Key</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Key</em>' attribute.
     * @see #getKey()
     * @generated
     */
    void setKey(String value);

    /**
     * Returns the value of the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Value</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Value</em>' attribute.
     * @see #setValue(Object)
     * @see psplatform.PsplatformPackage#getPSVariable_Value()
     * @model
     * @generated
     */
    Object getValue();

    /**
     * Sets the value of the '{@link psplatform.PSVariable#getValue <em>Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Value</em>' attribute.
     * @see #getValue()
     * @generated
     */
    void setValue(Object value);

    /**
     * Returns the value of the '<em><b>Default</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Default</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Default</em>' attribute.
     * @see #setDefault(Object)
     * @see psplatform.PsplatformPackage#getPSVariable_Default()
     * @model
     * @generated
     */
    Object getDefault();

    /**
     * Sets the value of the '{@link psplatform.PSVariable#getDefault <em>Default</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Default</em>' attribute.
     * @see #getDefault()
     * @generated
     */
    void setDefault(Object value);

} // PSVariable
