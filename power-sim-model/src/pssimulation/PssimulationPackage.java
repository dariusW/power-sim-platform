/**
 */
package pssimulation;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see pssimulation.PssimulationFactory
 * @model kind="package"
 * @generated
 */
public interface PssimulationPackage extends EPackage {
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "pssimulation";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "pssimulation";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "pl.agh";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    PssimulationPackage eINSTANCE = pssimulation.impl.PssimulationPackageImpl.init();

    /**
     * The meta object id for the '{@link pssimulation.impl.PSSimulationImpl <em>PS Simulation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see pssimulation.impl.PSSimulationImpl
     * @see pssimulation.impl.PssimulationPackageImpl#getPSSimulation()
     * @generated
     */
    int PS_SIMULATION = 0;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_SIMULATION__ID = 0;

    /**
     * The feature id for the '<em><b>Element</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_SIMULATION__ELEMENT = 1;

    /**
     * The feature id for the '<em><b>Connections</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_SIMULATION__CONNECTIONS = 2;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_SIMULATION__DESCRIPTION = 3;

    /**
     * The feature id for the '<em><b>Relations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_SIMULATION__RELATIONS = 4;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_SIMULATION__NAME = 5;

    /**
     * The number of structural features of the '<em>PS Simulation</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_SIMULATION_FEATURE_COUNT = 6;

    /**
     * The number of operations of the '<em>PS Simulation</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_SIMULATION_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link pssimulation.impl.PSInstanceImpl <em>PS Instance</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see pssimulation.impl.PSInstanceImpl
     * @see pssimulation.impl.PssimulationPackageImpl#getPSInstance()
     * @generated
     */
    int PS_INSTANCE = 1;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_INSTANCE__ID = 0;

    /**
     * The feature id for the '<em><b>Init Behaviour</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_INSTANCE__INIT_BEHAVIOUR = 1;

    /**
     * The feature id for the '<em><b>Model Class</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_INSTANCE__MODEL_CLASS = 2;

    /**
     * The feature id for the '<em><b>Parent</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_INSTANCE__PARENT = 3;

    /**
     * The feature id for the '<em><b>Children</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_INSTANCE__CHILDREN = 4;

    /**
     * The feature id for the '<em><b>Model Path</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_INSTANCE__MODEL_PATH = 5;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_INSTANCE__NAME = 6;

    /**
     * The feature id for the '<em><b>Incoming Connections</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_INSTANCE__INCOMING_CONNECTIONS = 7;

    /**
     * The feature id for the '<em><b>Outgoing Connections</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_INSTANCE__OUTGOING_CONNECTIONS = 8;

    /**
     * The feature id for the '<em><b>Superinstance</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_INSTANCE__SUPERINSTANCE = 9;

    /**
     * The feature id for the '<em><b>Subinstance</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_INSTANCE__SUBINSTANCE = 10;

    /**
     * The number of structural features of the '<em>PS Instance</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_INSTANCE_FEATURE_COUNT = 11;

    /**
     * The number of operations of the '<em>PS Instance</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_INSTANCE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link pssimulation.impl.PSHierarchyImpl <em>PS Hierarchy</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see pssimulation.impl.PSHierarchyImpl
     * @see pssimulation.impl.PssimulationPackageImpl#getPSHierarchy()
     * @generated
     */
    int PS_HIERARCHY = 2;

    /**
     * The feature id for the '<em><b>Parent</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_HIERARCHY__PARENT = 0;

    /**
     * The feature id for the '<em><b>Child</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_HIERARCHY__CHILD = 1;

    /**
     * The number of structural features of the '<em>PS Hierarchy</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_HIERARCHY_FEATURE_COUNT = 2;

    /**
     * The number of operations of the '<em>PS Hierarchy</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_HIERARCHY_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link pssimulation.impl.PSComunicationImpl <em>PS Comunication</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see pssimulation.impl.PSComunicationImpl
     * @see pssimulation.impl.PssimulationPackageImpl#getPSComunication()
     * @generated
     */
    int PS_COMUNICATION = 3;

    /**
     * The feature id for the '<em><b>Begin</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_COMUNICATION__BEGIN = 0;

    /**
     * The feature id for the '<em><b>End</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_COMUNICATION__END = 1;

    /**
     * The feature id for the '<em><b>Public Variable</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_COMUNICATION__PUBLIC_VARIABLE = 2;

    /**
     * The feature id for the '<em><b>Exernal Variable</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_COMUNICATION__EXERNAL_VARIABLE = 3;

    /**
     * The number of structural features of the '<em>PS Comunication</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_COMUNICATION_FEATURE_COUNT = 4;

    /**
     * The number of operations of the '<em>PS Comunication</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_COMUNICATION_OPERATION_COUNT = 0;

    /**
     * Returns the meta object for class '{@link pssimulation.PSSimulation <em>PS Simulation</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>PS Simulation</em>'.
     * @see pssimulation.PSSimulation
     * @generated
     */
    EClass getPSSimulation();

    /**
     * Returns the meta object for the attribute '{@link pssimulation.PSSimulation#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see pssimulation.PSSimulation#getName()
     * @see #getPSSimulation()
     * @generated
     */
    EAttribute getPSSimulation_Name();

    /**
     * Returns the meta object for the containment reference list '{@link pssimulation.PSSimulation#getElement <em>Element</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Element</em>'.
     * @see pssimulation.PSSimulation#getElement()
     * @see #getPSSimulation()
     * @generated
     */
    EReference getPSSimulation_Element();

    /**
     * Returns the meta object for the containment reference list '{@link pssimulation.PSSimulation#getConnections <em>Connections</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Connections</em>'.
     * @see pssimulation.PSSimulation#getConnections()
     * @see #getPSSimulation()
     * @generated
     */
    EReference getPSSimulation_Connections();

    /**
     * Returns the meta object for the attribute '{@link pssimulation.PSSimulation#getDescription <em>Description</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Description</em>'.
     * @see pssimulation.PSSimulation#getDescription()
     * @see #getPSSimulation()
     * @generated
     */
    EAttribute getPSSimulation_Description();

    /**
     * Returns the meta object for the attribute '{@link pssimulation.PSSimulation#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see pssimulation.PSSimulation#getId()
     * @see #getPSSimulation()
     * @generated
     */
    EAttribute getPSSimulation_Id();

    /**
     * Returns the meta object for the containment reference list '{@link pssimulation.PSSimulation#getRelations <em>Relations</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Relations</em>'.
     * @see pssimulation.PSSimulation#getRelations()
     * @see #getPSSimulation()
     * @generated
     */
    EReference getPSSimulation_Relations();

    /**
     * Returns the meta object for class '{@link pssimulation.PSInstance <em>PS Instance</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>PS Instance</em>'.
     * @see pssimulation.PSInstance
     * @generated
     */
    EClass getPSInstance();

    /**
     * Returns the meta object for the attribute '{@link pssimulation.PSInstance#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see pssimulation.PSInstance#getId()
     * @see #getPSInstance()
     * @generated
     */
    EAttribute getPSInstance_Id();

    /**
     * Returns the meta object for the attribute '{@link pssimulation.PSInstance#getInitBehaviour <em>Init Behaviour</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Init Behaviour</em>'.
     * @see pssimulation.PSInstance#getInitBehaviour()
     * @see #getPSInstance()
     * @generated
     */
    EAttribute getPSInstance_InitBehaviour();

    /**
     * Returns the meta object for the attribute '{@link pssimulation.PSInstance#getModelClass <em>Model Class</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Model Class</em>'.
     * @see pssimulation.PSInstance#getModelClass()
     * @see #getPSInstance()
     * @generated
     */
    EAttribute getPSInstance_ModelClass();

    /**
     * Returns the meta object for the attribute '{@link pssimulation.PSInstance#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see pssimulation.PSInstance#getName()
     * @see #getPSInstance()
     * @generated
     */
    EAttribute getPSInstance_Name();

    /**
     * Returns the meta object for the reference list '{@link pssimulation.PSInstance#getIncomingConnections <em>Incoming Connections</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Incoming Connections</em>'.
     * @see pssimulation.PSInstance#getIncomingConnections()
     * @see #getPSInstance()
     * @generated
     */
    EReference getPSInstance_IncomingConnections();

    /**
     * Returns the meta object for the reference list '{@link pssimulation.PSInstance#getOutgoingConnections <em>Outgoing Connections</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Outgoing Connections</em>'.
     * @see pssimulation.PSInstance#getOutgoingConnections()
     * @see #getPSInstance()
     * @generated
     */
    EReference getPSInstance_OutgoingConnections();

    /**
     * Returns the meta object for the reference '{@link pssimulation.PSInstance#getSuperinstance <em>Superinstance</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Superinstance</em>'.
     * @see pssimulation.PSInstance#getSuperinstance()
     * @see #getPSInstance()
     * @generated
     */
    EReference getPSInstance_Superinstance();

    /**
     * Returns the meta object for the reference list '{@link pssimulation.PSInstance#getSubinstance <em>Subinstance</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Subinstance</em>'.
     * @see pssimulation.PSInstance#getSubinstance()
     * @see #getPSInstance()
     * @generated
     */
    EReference getPSInstance_Subinstance();

    /**
     * Returns the meta object for the reference '{@link pssimulation.PSInstance#getParent <em>Parent</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Parent</em>'.
     * @see pssimulation.PSInstance#getParent()
     * @see #getPSInstance()
     * @generated
     */
    EReference getPSInstance_Parent();

    /**
     * Returns the meta object for the reference list '{@link pssimulation.PSInstance#getChildren <em>Children</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Children</em>'.
     * @see pssimulation.PSInstance#getChildren()
     * @see #getPSInstance()
     * @generated
     */
    EReference getPSInstance_Children();

    /**
     * Returns the meta object for the attribute '{@link pssimulation.PSInstance#getModelPath <em>Model Path</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Model Path</em>'.
     * @see pssimulation.PSInstance#getModelPath()
     * @see #getPSInstance()
     * @generated
     */
    EAttribute getPSInstance_ModelPath();

    /**
     * Returns the meta object for class '{@link pssimulation.PSHierarchy <em>PS Hierarchy</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>PS Hierarchy</em>'.
     * @see pssimulation.PSHierarchy
     * @generated
     */
    EClass getPSHierarchy();

    /**
     * Returns the meta object for the reference '{@link pssimulation.PSHierarchy#getParent <em>Parent</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Parent</em>'.
     * @see pssimulation.PSHierarchy#getParent()
     * @see #getPSHierarchy()
     * @generated
     */
    EReference getPSHierarchy_Parent();

    /**
     * Returns the meta object for the reference '{@link pssimulation.PSHierarchy#getChild <em>Child</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Child</em>'.
     * @see pssimulation.PSHierarchy#getChild()
     * @see #getPSHierarchy()
     * @generated
     */
    EReference getPSHierarchy_Child();

    /**
     * Returns the meta object for class '{@link pssimulation.PSComunication <em>PS Comunication</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>PS Comunication</em>'.
     * @see pssimulation.PSComunication
     * @generated
     */
    EClass getPSComunication();

    /**
     * Returns the meta object for the reference '{@link pssimulation.PSComunication#getBegin <em>Begin</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Begin</em>'.
     * @see pssimulation.PSComunication#getBegin()
     * @see #getPSComunication()
     * @generated
     */
    EReference getPSComunication_Begin();

    /**
     * Returns the meta object for the reference '{@link pssimulation.PSComunication#getEnd <em>End</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>End</em>'.
     * @see pssimulation.PSComunication#getEnd()
     * @see #getPSComunication()
     * @generated
     */
    EReference getPSComunication_End();

    /**
     * Returns the meta object for the attribute '{@link pssimulation.PSComunication#getPublicVariable <em>Public Variable</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Public Variable</em>'.
     * @see pssimulation.PSComunication#getPublicVariable()
     * @see #getPSComunication()
     * @generated
     */
    EAttribute getPSComunication_PublicVariable();

    /**
     * Returns the meta object for the attribute '{@link pssimulation.PSComunication#getExernalVariable <em>Exernal Variable</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Exernal Variable</em>'.
     * @see pssimulation.PSComunication#getExernalVariable()
     * @see #getPSComunication()
     * @generated
     */
    EAttribute getPSComunication_ExernalVariable();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    PssimulationFactory getPssimulationFactory();

    /**
     * <!-- begin-user-doc -->
     * Defines literals for the meta objects that represent
     * <ul>
     *   <li>each class,</li>
     *   <li>each feature of each class,</li>
     *   <li>each operation of each class,</li>
     *   <li>each enum,</li>
     *   <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * @generated
     */
    interface Literals {
        /**
         * The meta object literal for the '{@link pssimulation.impl.PSSimulationImpl <em>PS Simulation</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see pssimulation.impl.PSSimulationImpl
         * @see pssimulation.impl.PssimulationPackageImpl#getPSSimulation()
         * @generated
         */
        EClass PS_SIMULATION = eINSTANCE.getPSSimulation();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PS_SIMULATION__NAME = eINSTANCE.getPSSimulation_Name();

        /**
         * The meta object literal for the '<em><b>Element</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PS_SIMULATION__ELEMENT = eINSTANCE.getPSSimulation_Element();

        /**
         * The meta object literal for the '<em><b>Connections</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PS_SIMULATION__CONNECTIONS = eINSTANCE.getPSSimulation_Connections();

        /**
         * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PS_SIMULATION__DESCRIPTION = eINSTANCE.getPSSimulation_Description();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PS_SIMULATION__ID = eINSTANCE.getPSSimulation_Id();

        /**
         * The meta object literal for the '<em><b>Relations</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PS_SIMULATION__RELATIONS = eINSTANCE.getPSSimulation_Relations();

        /**
         * The meta object literal for the '{@link pssimulation.impl.PSInstanceImpl <em>PS Instance</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see pssimulation.impl.PSInstanceImpl
         * @see pssimulation.impl.PssimulationPackageImpl#getPSInstance()
         * @generated
         */
        EClass PS_INSTANCE = eINSTANCE.getPSInstance();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PS_INSTANCE__ID = eINSTANCE.getPSInstance_Id();

        /**
         * The meta object literal for the '<em><b>Init Behaviour</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PS_INSTANCE__INIT_BEHAVIOUR = eINSTANCE.getPSInstance_InitBehaviour();

        /**
         * The meta object literal for the '<em><b>Model Class</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PS_INSTANCE__MODEL_CLASS = eINSTANCE.getPSInstance_ModelClass();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PS_INSTANCE__NAME = eINSTANCE.getPSInstance_Name();

        /**
         * The meta object literal for the '<em><b>Incoming Connections</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PS_INSTANCE__INCOMING_CONNECTIONS = eINSTANCE.getPSInstance_IncomingConnections();

        /**
         * The meta object literal for the '<em><b>Outgoing Connections</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PS_INSTANCE__OUTGOING_CONNECTIONS = eINSTANCE.getPSInstance_OutgoingConnections();

        /**
         * The meta object literal for the '<em><b>Superinstance</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PS_INSTANCE__SUPERINSTANCE = eINSTANCE.getPSInstance_Superinstance();

        /**
         * The meta object literal for the '<em><b>Subinstance</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PS_INSTANCE__SUBINSTANCE = eINSTANCE.getPSInstance_Subinstance();

        /**
         * The meta object literal for the '<em><b>Parent</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PS_INSTANCE__PARENT = eINSTANCE.getPSInstance_Parent();

        /**
         * The meta object literal for the '<em><b>Children</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PS_INSTANCE__CHILDREN = eINSTANCE.getPSInstance_Children();

        /**
         * The meta object literal for the '<em><b>Model Path</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PS_INSTANCE__MODEL_PATH = eINSTANCE.getPSInstance_ModelPath();

        /**
         * The meta object literal for the '{@link pssimulation.impl.PSHierarchyImpl <em>PS Hierarchy</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see pssimulation.impl.PSHierarchyImpl
         * @see pssimulation.impl.PssimulationPackageImpl#getPSHierarchy()
         * @generated
         */
        EClass PS_HIERARCHY = eINSTANCE.getPSHierarchy();

        /**
         * The meta object literal for the '<em><b>Parent</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PS_HIERARCHY__PARENT = eINSTANCE.getPSHierarchy_Parent();

        /**
         * The meta object literal for the '<em><b>Child</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PS_HIERARCHY__CHILD = eINSTANCE.getPSHierarchy_Child();

        /**
         * The meta object literal for the '{@link pssimulation.impl.PSComunicationImpl <em>PS Comunication</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see pssimulation.impl.PSComunicationImpl
         * @see pssimulation.impl.PssimulationPackageImpl#getPSComunication()
         * @generated
         */
        EClass PS_COMUNICATION = eINSTANCE.getPSComunication();

        /**
         * The meta object literal for the '<em><b>Begin</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PS_COMUNICATION__BEGIN = eINSTANCE.getPSComunication_Begin();

        /**
         * The meta object literal for the '<em><b>End</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PS_COMUNICATION__END = eINSTANCE.getPSComunication_End();

        /**
         * The meta object literal for the '<em><b>Public Variable</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PS_COMUNICATION__PUBLIC_VARIABLE = eINSTANCE.getPSComunication_PublicVariable();

        /**
         * The meta object literal for the '<em><b>Exernal Variable</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PS_COMUNICATION__EXERNAL_VARIABLE = eINSTANCE.getPSComunication_ExernalVariable();

    }

} //PssimulationPackage
