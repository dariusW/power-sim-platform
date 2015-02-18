/**
 */
package pssimulation;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PS Comunication</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link pssimulation.PSComunication#getBegin <em>Begin</em>}</li>
 *   <li>{@link pssimulation.PSComunication#getEnd <em>End</em>}</li>
 *   <li>{@link pssimulation.PSComunication#getPublicVariable <em>Public Variable</em>}</li>
 *   <li>{@link pssimulation.PSComunication#getExernalVariable <em>Exernal Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @see pssimulation.PssimulationPackage#getPSComunication()
 * @model
 * @generated
 */
public interface PSComunication extends EObject {
    /**
     * Returns the value of the '<em><b>Begin</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Begin</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Begin</em>' reference.
     * @see #setBegin(PSInstance)
     * @see pssimulation.PssimulationPackage#getPSComunication_Begin()
     * @model required="true"
     * @generated
     */
    PSInstance getBegin();

    /**
     * Sets the value of the '{@link pssimulation.PSComunication#getBegin <em>Begin</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Begin</em>' reference.
     * @see #getBegin()
     * @generated
     */
    void setBegin(PSInstance value);

    /**
     * Returns the value of the '<em><b>End</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>End</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>End</em>' reference.
     * @see #setEnd(PSInstance)
     * @see pssimulation.PssimulationPackage#getPSComunication_End()
     * @model required="true"
     * @generated
     */
    PSInstance getEnd();

    /**
     * Sets the value of the '{@link pssimulation.PSComunication#getEnd <em>End</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>End</em>' reference.
     * @see #getEnd()
     * @generated
     */
    void setEnd(PSInstance value);

    /**
     * Returns the value of the '<em><b>Public Variable</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Public Variable</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Public Variable</em>' attribute.
     * @see #setPublicVariable(String)
     * @see pssimulation.PssimulationPackage#getPSComunication_PublicVariable()
     * @model
     * @generated
     */
    String getPublicVariable();

    /**
     * Sets the value of the '{@link pssimulation.PSComunication#getPublicVariable <em>Public Variable</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Public Variable</em>' attribute.
     * @see #getPublicVariable()
     * @generated
     */
    void setPublicVariable(String value);

    /**
     * Returns the value of the '<em><b>Exernal Variable</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Exernal Variable</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Exernal Variable</em>' attribute.
     * @see #setExernalVariable(String)
     * @see pssimulation.PssimulationPackage#getPSComunication_ExernalVariable()
     * @model
     * @generated
     */
    String getExernalVariable();

    /**
     * Sets the value of the '{@link pssimulation.PSComunication#getExernalVariable <em>Exernal Variable</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Exernal Variable</em>' attribute.
     * @see #getExernalVariable()
     * @generated
     */
    void setExernalVariable(String value);

} // PSComunication
