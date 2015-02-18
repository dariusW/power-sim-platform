/**
 */
package pssimulation;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PS Hierarchy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link pssimulation.PSHierarchy#getParent <em>Parent</em>}</li>
 *   <li>{@link pssimulation.PSHierarchy#getChild <em>Child</em>}</li>
 * </ul>
 * </p>
 *
 * @see pssimulation.PssimulationPackage#getPSHierarchy()
 * @model
 * @generated
 */
public interface PSHierarchy extends EObject {
    /**
     * Returns the value of the '<em><b>Parent</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Parent</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Parent</em>' reference.
     * @see #setParent(PSInstance)
     * @see pssimulation.PssimulationPackage#getPSHierarchy_Parent()
     * @model required="true"
     * @generated
     */
    PSInstance getParent();

    /**
     * Sets the value of the '{@link pssimulation.PSHierarchy#getParent <em>Parent</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Parent</em>' reference.
     * @see #getParent()
     * @generated
     */
    void setParent(PSInstance value);

    /**
     * Returns the value of the '<em><b>Child</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Child</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Child</em>' reference.
     * @see #setChild(PSInstance)
     * @see pssimulation.PssimulationPackage#getPSHierarchy_Child()
     * @model required="true"
     * @generated
     */
    PSInstance getChild();

    /**
     * Sets the value of the '{@link pssimulation.PSHierarchy#getChild <em>Child</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Child</em>' reference.
     * @see #getChild()
     * @generated
     */
    void setChild(PSInstance value);

} // PSHierarchy
