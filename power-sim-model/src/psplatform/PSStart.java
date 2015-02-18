/**
 */
package psplatform;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PS Start</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link psplatform.PSStart#getOnInit <em>On Init</em>}</li>
 * </ul>
 * </p>
 *
 * @see psplatform.PsplatformPackage#getPSStart()
 * @model
 * @generated
 */
public interface PSStart extends PSState {

    /**
     * Returns the value of the '<em><b>On Init</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>On Init</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>On Init</em>' containment reference.
     * @see #setOnInit(PSSingleBehaviour)
     * @see psplatform.PsplatformPackage#getPSStart_OnInit()
     * @model containment="true" required="true"
     * @generated
     */
    PSSingleBehaviour getOnInit();

    /**
     * Sets the value of the '{@link psplatform.PSStart#getOnInit <em>On Init</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>On Init</em>' containment reference.
     * @see #getOnInit()
     * @generated
     */
    void setOnInit(PSSingleBehaviour value);
} // PSStart
