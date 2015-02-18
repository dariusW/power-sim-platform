/**
 */
package psplatform;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PS Agent</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link psplatform.PSAgent#getStart <em>Start</em>}</li>
 *   <li>{@link psplatform.PSAgent#getStates <em>States</em>}</li>
 *   <li>{@link psplatform.PSAgent#getTransactions <em>Transactions</em>}</li>
 *   <li>{@link psplatform.PSAgent#getPackage <em>Package</em>}</li>
 *   <li>{@link psplatform.PSAgent#getId <em>Id</em>}</li>
 *   <li>{@link psplatform.PSAgent#getName <em>Name</em>}</li>
 *   <li>{@link psplatform.PSAgent#getVariables <em>Variables</em>}</li>
 * </ul>
 * </p>
 *
 * @see psplatform.PsplatformPackage#getPSAgent()
 * @model
 * @generated
 */
public interface PSAgent extends EObject {
    /**
     * Returns the value of the '<em><b>Start</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Start</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Start</em>' containment reference.
     * @see #setStart(PSStart)
     * @see psplatform.PsplatformPackage#getPSAgent_Start()
     * @model containment="true" required="true"
     * @generated
     */
    PSStart getStart();

    /**
     * Sets the value of the '{@link psplatform.PSAgent#getStart <em>Start</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Start</em>' containment reference.
     * @see #getStart()
     * @generated
     */
    void setStart(PSStart value);

    /**
     * Returns the value of the '<em><b>States</b></em>' containment reference list.
     * The list contents are of type {@link psplatform.PSState}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>States</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>States</em>' containment reference list.
     * @see psplatform.PsplatformPackage#getPSAgent_States()
     * @model containment="true" required="true"
     * @generated
     */
    EList<PSState> getStates();

    /**
     * Returns the value of the '<em><b>Transactions</b></em>' containment reference list.
     * The list contents are of type {@link psplatform.PSTransition}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transactions</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transactions</em>' containment reference list.
     * @see psplatform.PsplatformPackage#getPSAgent_Transactions()
     * @model containment="true" required="true"
     * @generated
     */
    EList<PSTransition> getTransactions();

    /**
     * Returns the value of the '<em><b>Package</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Package</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Package</em>' attribute.
     * @see #setPackage(String)
     * @see psplatform.PsplatformPackage#getPSAgent_Package()
     * @model
     * @generated
     */
    String getPackage();

    /**
     * Sets the value of the '{@link psplatform.PSAgent#getPackage <em>Package</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Package</em>' attribute.
     * @see #getPackage()
     * @generated
     */
    void setPackage(String value);

    /**
     * Returns the value of the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Id</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Id</em>' attribute.
     * @see #setId(String)
     * @see psplatform.PsplatformPackage#getPSAgent_Id()
     * @model
     * @generated
     */
    String getId();

    /**
     * Sets the value of the '{@link psplatform.PSAgent#getId <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Id</em>' attribute.
     * @see #getId()
     * @generated
     */
    void setId(String value);

    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see psplatform.PsplatformPackage#getPSAgent_Name()
     * @model
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link psplatform.PSAgent#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Variables</b></em>' containment reference list.
     * The list contents are of type {@link psplatform.PSVariable}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Variables</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Variables</em>' containment reference list.
     * @see psplatform.PsplatformPackage#getPSAgent_Variables()
     * @model containment="true"
     * @generated
     */
    EList<PSVariable> getVariables();

} // PSAgent
