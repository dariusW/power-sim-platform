/**
 */
package psplatform;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PS Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link psplatform.PSTransition#getCondition <em>Condition</em>}</li>
 *   <li>{@link psplatform.PSTransition#getSource <em>Source</em>}</li>
 *   <li>{@link psplatform.PSTransition#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see psplatform.PsplatformPackage#getPSTransition()
 * @model
 * @generated
 */
public interface PSTransition extends EObject {
    /**
     * Returns the value of the '<em><b>Condition</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Condition</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Condition</em>' attribute.
     * @see #setCondition(String)
     * @see psplatform.PsplatformPackage#getPSTransition_Condition()
     * @model ordered="false"
     * @generated
     */
    String getCondition();

    /**
     * Sets the value of the '{@link psplatform.PSTransition#getCondition <em>Condition</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Condition</em>' attribute.
     * @see #getCondition()
     * @generated
     */
    void setCondition(String value);

    /**
     * Returns the value of the '<em><b>Source</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Source</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Source</em>' reference.
     * @see #setSource(PSState)
     * @see psplatform.PsplatformPackage#getPSTransition_Source()
     * @model required="true"
     * @generated
     */
    PSState getSource();

    /**
     * Sets the value of the '{@link psplatform.PSTransition#getSource <em>Source</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Source</em>' reference.
     * @see #getSource()
     * @generated
     */
    void setSource(PSState value);

    /**
     * Returns the value of the '<em><b>Target</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Target</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Target</em>' reference.
     * @see #setTarget(PSState)
     * @see psplatform.PsplatformPackage#getPSTransition_Target()
     * @model required="true"
     * @generated
     */
    PSState getTarget();

    /**
     * Sets the value of the '{@link psplatform.PSTransition#getTarget <em>Target</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Target</em>' reference.
     * @see #getTarget()
     * @generated
     */
    void setTarget(PSState value);

} // PSTransition
