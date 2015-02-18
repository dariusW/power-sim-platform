/**
 */
package psplatform;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PS Behaviour</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link psplatform.PSBehaviour#getOnAction <em>On Action</em>}</li>
 * </ul>
 * </p>
 *
 * @see psplatform.PsplatformPackage#getPSBehaviour()
 * @model
 * @generated
 */
public interface PSBehaviour extends EObject {
    /**
     * Returns the value of the '<em><b>On Action</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>On Action</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>On Action</em>' attribute.
     * @see #setOnAction(String)
     * @see psplatform.PsplatformPackage#getPSBehaviour_OnAction()
     * @model
     * @generated
     */
    String getOnAction();

    /**
     * Sets the value of the '{@link psplatform.PSBehaviour#getOnAction <em>On Action</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>On Action</em>' attribute.
     * @see #getOnAction()
     * @generated
     */
    void setOnAction(String value);

} // PSBehaviour
