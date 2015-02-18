/**
 */
package psplatform;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PS State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link psplatform.PSState#getName <em>Name</em>}</li>
 *   <li>{@link psplatform.PSState#getTransitions <em>Transitions</em>}</li>
 *   <li>{@link psplatform.PSState#getOnStep <em>On Step</em>}</li>
 *   <li>{@link psplatform.PSState#getOnEntry <em>On Entry</em>}</li>
 *   <li>{@link psplatform.PSState#getOnExit <em>On Exit</em>}</li>
 *   <li>{@link psplatform.PSState#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see psplatform.PsplatformPackage#getPSState()
 * @model
 * @generated
 */
public interface PSState extends EObject {
    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * The default value is <code>"New State"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see psplatform.PsplatformPackage#getPSState_Name()
     * @model default="New State"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link psplatform.PSState#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Transitions</b></em>' reference list.
     * The list contents are of type {@link psplatform.PSTransition}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transitions</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transitions</em>' reference list.
     * @see psplatform.PsplatformPackage#getPSState_Transitions()
     * @model required="true"
     * @generated
     */
    EList<PSTransition> getTransitions();

    /**
     * Returns the value of the '<em><b>On Step</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>On Step</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>On Step</em>' containment reference.
     * @see #setOnStep(PSContinuousBehaviour)
     * @see psplatform.PsplatformPackage#getPSState_OnStep()
     * @model containment="true" required="true"
     * @generated
     */
    PSContinuousBehaviour getOnStep();

    /**
     * Sets the value of the '{@link psplatform.PSState#getOnStep <em>On Step</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>On Step</em>' containment reference.
     * @see #getOnStep()
     * @generated
     */
    void setOnStep(PSContinuousBehaviour value);

    /**
     * Returns the value of the '<em><b>On Entry</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>On Entry</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>On Entry</em>' containment reference.
     * @see #setOnEntry(PSSingleBehaviour)
     * @see psplatform.PsplatformPackage#getPSState_OnEntry()
     * @model containment="true" required="true"
     * @generated
     */
    PSSingleBehaviour getOnEntry();

    /**
     * Sets the value of the '{@link psplatform.PSState#getOnEntry <em>On Entry</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>On Entry</em>' containment reference.
     * @see #getOnEntry()
     * @generated
     */
    void setOnEntry(PSSingleBehaviour value);

    /**
     * Returns the value of the '<em><b>On Exit</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>On Exit</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>On Exit</em>' containment reference.
     * @see #setOnExit(PSSingleBehaviour)
     * @see psplatform.PsplatformPackage#getPSState_OnExit()
     * @model containment="true" required="true"
     * @generated
     */
    PSSingleBehaviour getOnExit();

    /**
     * Sets the value of the '{@link psplatform.PSState#getOnExit <em>On Exit</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>On Exit</em>' containment reference.
     * @see #getOnExit()
     * @generated
     */
    void setOnExit(PSSingleBehaviour value);

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
     * @see psplatform.PsplatformPackage#getPSState_Id()
     * @model required="true"
     * @generated
     */
    String getId();

    /**
     * Sets the value of the '{@link psplatform.PSState#getId <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Id</em>' attribute.
     * @see #getId()
     * @generated
     */
    void setId(String value);

} // PSState
