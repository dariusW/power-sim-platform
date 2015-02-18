/**
 */
package pssimulation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PS Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link pssimulation.PSInstance#getId <em>Id</em>}</li>
 *   <li>{@link pssimulation.PSInstance#getInitBehaviour <em>Init Behaviour</em>}</li>
 *   <li>{@link pssimulation.PSInstance#getModelClass <em>Model Class</em>}</li>
 *   <li>{@link pssimulation.PSInstance#getParent <em>Parent</em>}</li>
 *   <li>{@link pssimulation.PSInstance#getChildren <em>Children</em>}</li>
 *   <li>{@link pssimulation.PSInstance#getModelPath <em>Model Path</em>}</li>
 *   <li>{@link pssimulation.PSInstance#getName <em>Name</em>}</li>
 *   <li>{@link pssimulation.PSInstance#getIncomingConnections <em>Incoming Connections</em>}</li>
 *   <li>{@link pssimulation.PSInstance#getOutgoingConnections <em>Outgoing Connections</em>}</li>
 *   <li>{@link pssimulation.PSInstance#getSuperinstance <em>Superinstance</em>}</li>
 *   <li>{@link pssimulation.PSInstance#getSubinstance <em>Subinstance</em>}</li>
 * </ul>
 * </p>
 *
 * @see pssimulation.PssimulationPackage#getPSInstance()
 * @model
 * @generated
 */
public interface PSInstance extends EObject {
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
     * @see pssimulation.PssimulationPackage#getPSInstance_Id()
     * @model
     * @generated
     */
    String getId();

    /**
     * Sets the value of the '{@link pssimulation.PSInstance#getId <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Id</em>' attribute.
     * @see #getId()
     * @generated
     */
    void setId(String value);

    /**
     * Returns the value of the '<em><b>Init Behaviour</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Init Behaviour</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Init Behaviour</em>' attribute.
     * @see #setInitBehaviour(String)
     * @see pssimulation.PssimulationPackage#getPSInstance_InitBehaviour()
     * @model
     * @generated
     */
    String getInitBehaviour();

    /**
     * Sets the value of the '{@link pssimulation.PSInstance#getInitBehaviour <em>Init Behaviour</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Init Behaviour</em>' attribute.
     * @see #getInitBehaviour()
     * @generated
     */
    void setInitBehaviour(String value);

    /**
     * Returns the value of the '<em><b>Model Class</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Model Class</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Model Class</em>' attribute.
     * @see #setModelClass(String)
     * @see pssimulation.PssimulationPackage#getPSInstance_ModelClass()
     * @model
     * @generated
     */
    String getModelClass();

    /**
     * Sets the value of the '{@link pssimulation.PSInstance#getModelClass <em>Model Class</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Model Class</em>' attribute.
     * @see #getModelClass()
     * @generated
     */
    void setModelClass(String value);

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
     * @see pssimulation.PssimulationPackage#getPSInstance_Name()
     * @model
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link pssimulation.PSInstance#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Incoming Connections</b></em>' reference list.
     * The list contents are of type {@link pssimulation.PSComunication}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Incoming Connections</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Incoming Connections</em>' reference list.
     * @see pssimulation.PssimulationPackage#getPSInstance_IncomingConnections()
     * @model
     * @generated
     */
    EList<PSComunication> getIncomingConnections();

    /**
     * Returns the value of the '<em><b>Outgoing Connections</b></em>' reference list.
     * The list contents are of type {@link pssimulation.PSComunication}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Outgoing Connections</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Outgoing Connections</em>' reference list.
     * @see pssimulation.PssimulationPackage#getPSInstance_OutgoingConnections()
     * @model
     * @generated
     */
    EList<PSComunication> getOutgoingConnections();

    /**
     * Returns the value of the '<em><b>Superinstance</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Superinstance</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Superinstance</em>' reference.
     * @see #setSuperinstance(PSInstance)
     * @see pssimulation.PssimulationPackage#getPSInstance_Superinstance()
     * @model
     * @generated
     */
    PSInstance getSuperinstance();

    /**
     * Sets the value of the '{@link pssimulation.PSInstance#getSuperinstance <em>Superinstance</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Superinstance</em>' reference.
     * @see #getSuperinstance()
     * @generated
     */
    void setSuperinstance(PSInstance value);

    /**
     * Returns the value of the '<em><b>Subinstance</b></em>' reference list.
     * The list contents are of type {@link pssimulation.PSInstance}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Subinstance</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Subinstance</em>' reference list.
     * @see pssimulation.PssimulationPackage#getPSInstance_Subinstance()
     * @model
     * @generated
     */
    EList<PSInstance> getSubinstance();

    /**
     * Returns the value of the '<em><b>Parent</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Parent</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Parent</em>' reference.
     * @see #setParent(PSHierarchy)
     * @see pssimulation.PssimulationPackage#getPSInstance_Parent()
     * @model
     * @generated
     */
    PSHierarchy getParent();

    /**
     * Sets the value of the '{@link pssimulation.PSInstance#getParent <em>Parent</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Parent</em>' reference.
     * @see #getParent()
     * @generated
     */
    void setParent(PSHierarchy value);

    /**
     * Returns the value of the '<em><b>Children</b></em>' reference list.
     * The list contents are of type {@link pssimulation.PSHierarchy}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Children</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Children</em>' reference list.
     * @see pssimulation.PssimulationPackage#getPSInstance_Children()
     * @model
     * @generated
     */
    EList<PSHierarchy> getChildren();

    /**
     * Returns the value of the '<em><b>Model Path</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Model Path</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Model Path</em>' attribute.
     * @see #setModelPath(String)
     * @see pssimulation.PssimulationPackage#getPSInstance_ModelPath()
     * @model
     * @generated
     */
    String getModelPath();

    /**
     * Sets the value of the '{@link pssimulation.PSInstance#getModelPath <em>Model Path</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Model Path</em>' attribute.
     * @see #getModelPath()
     * @generated
     */
    void setModelPath(String value);

} // PSInstance
