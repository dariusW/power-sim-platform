/**
 */
package pssimulation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PS Simulation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link pssimulation.PSSimulation#getId <em>Id</em>}</li>
 *   <li>{@link pssimulation.PSSimulation#getElement <em>Element</em>}</li>
 *   <li>{@link pssimulation.PSSimulation#getConnections <em>Connections</em>}</li>
 *   <li>{@link pssimulation.PSSimulation#getDescription <em>Description</em>}</li>
 *   <li>{@link pssimulation.PSSimulation#getRelations <em>Relations</em>}</li>
 *   <li>{@link pssimulation.PSSimulation#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see pssimulation.PssimulationPackage#getPSSimulation()
 * @model
 * @generated
 */
public interface PSSimulation extends EObject {
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
     * @see pssimulation.PssimulationPackage#getPSSimulation_Name()
     * @model
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link pssimulation.PSSimulation#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Element</b></em>' containment reference list.
     * The list contents are of type {@link pssimulation.PSInstance}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Element</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Element</em>' containment reference list.
     * @see pssimulation.PssimulationPackage#getPSSimulation_Element()
     * @model containment="true" required="true"
     * @generated
     */
    EList<PSInstance> getElement();

    /**
     * Returns the value of the '<em><b>Connections</b></em>' containment reference list.
     * The list contents are of type {@link pssimulation.PSHierarchy}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Connections</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Connections</em>' containment reference list.
     * @see pssimulation.PssimulationPackage#getPSSimulation_Connections()
     * @model containment="true"
     * @generated
     */
    EList<PSHierarchy> getConnections();

    /**
     * Returns the value of the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Description</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Description</em>' attribute.
     * @see #setDescription(String)
     * @see pssimulation.PssimulationPackage#getPSSimulation_Description()
     * @model
     * @generated
     */
    String getDescription();

    /**
     * Sets the value of the '{@link pssimulation.PSSimulation#getDescription <em>Description</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Description</em>' attribute.
     * @see #getDescription()
     * @generated
     */
    void setDescription(String value);

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
     * @see pssimulation.PssimulationPackage#getPSSimulation_Id()
     * @model
     * @generated
     */
    String getId();

    /**
     * Sets the value of the '{@link pssimulation.PSSimulation#getId <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Id</em>' attribute.
     * @see #getId()
     * @generated
     */
    void setId(String value);

    /**
     * Returns the value of the '<em><b>Relations</b></em>' containment reference list.
     * The list contents are of type {@link pssimulation.PSComunication}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Relations</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Relations</em>' containment reference list.
     * @see pssimulation.PssimulationPackage#getPSSimulation_Relations()
     * @model containment="true"
     * @generated
     */
    EList<PSComunication> getRelations();

} // PSSimulation
