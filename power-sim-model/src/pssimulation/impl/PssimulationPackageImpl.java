/**
 */
package pssimulation.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import pssimulation.PSComunication;
import pssimulation.PSInstance;
import pssimulation.PSSimulation;
import pssimulation.PssimulationFactory;
import pssimulation.PssimulationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PssimulationPackageImpl extends EPackageImpl implements PssimulationPackage {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass psSimulationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass psInstanceEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass psComunicationEClass = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
     * package URI value.
     * <p>Note: the correct way to create the package is via the static
     * factory method {@link #init init()}, which also performs
     * initialization of the package, or returns the registered package,
     * if one already exists.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see pssimulation.PssimulationPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private PssimulationPackageImpl() {
        super(eNS_URI, PssimulationFactory.eINSTANCE);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
     * 
     * <p>This method is used to initialize {@link PssimulationPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static PssimulationPackage init() {
        if (isInited) return (PssimulationPackage)EPackage.Registry.INSTANCE.getEPackage(PssimulationPackage.eNS_URI);

        // Obtain or create and register package
        PssimulationPackageImpl thePssimulationPackage = (PssimulationPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof PssimulationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new PssimulationPackageImpl());

        isInited = true;

        // Create package meta-data objects
        thePssimulationPackage.createPackageContents();

        // Initialize created meta-data
        thePssimulationPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        thePssimulationPackage.freeze();

  
        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(PssimulationPackage.eNS_URI, thePssimulationPackage);
        return thePssimulationPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getPSSimulation() {
        return psSimulationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPSSimulation_Name() {
        return (EAttribute)psSimulationEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPSSimulation_SimulationStep() {
        return (EAttribute)psSimulationEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPSSimulation_SimulationStartDate() {
        return (EAttribute)psSimulationEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPSSimulation_SimulationEndDate() {
        return (EAttribute)psSimulationEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getPSSimulation_Element() {
        return (EReference)psSimulationEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPSSimulation_Description() {
        return (EAttribute)psSimulationEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPSSimulation_Id() {
        return (EAttribute)psSimulationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getPSSimulation_Relations() {
        return (EReference)psSimulationEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getPSInstance() {
        return psInstanceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPSInstance_Id() {
        return (EAttribute)psInstanceEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPSInstance_InitBehaviour() {
        return (EAttribute)psInstanceEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPSInstance_ModelClass() {
        return (EAttribute)psInstanceEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPSInstance_Name() {
        return (EAttribute)psInstanceEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getPSInstance_IncomingConnections() {
        return (EReference)psInstanceEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getPSInstance_OutgoingConnections() {
        return (EReference)psInstanceEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getPSInstance_Superinstance() {
        return (EReference)psInstanceEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getPSInstance_Subinstance() {
        return (EReference)psInstanceEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPSInstance_ModelPath() {
        return (EAttribute)psInstanceEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getPSComunication() {
        return psComunicationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getPSComunication_Begin() {
        return (EReference)psComunicationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getPSComunication_End() {
        return (EReference)psComunicationEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPSComunication_PublicVariable() {
        return (EAttribute)psComunicationEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPSComunication_ExernalVariable() {
        return (EAttribute)psComunicationEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PssimulationFactory getPssimulationFactory() {
        return (PssimulationFactory)getEFactoryInstance();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package.  This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void createPackageContents() {
        if (isCreated) return;
        isCreated = true;

        // Create classes and their features
        psSimulationEClass = createEClass(PS_SIMULATION);
        createEAttribute(psSimulationEClass, PS_SIMULATION__ID);
        createEReference(psSimulationEClass, PS_SIMULATION__ELEMENT);
        createEAttribute(psSimulationEClass, PS_SIMULATION__DESCRIPTION);
        createEReference(psSimulationEClass, PS_SIMULATION__RELATIONS);
        createEAttribute(psSimulationEClass, PS_SIMULATION__NAME);
        createEAttribute(psSimulationEClass, PS_SIMULATION__SIMULATION_STEP);
        createEAttribute(psSimulationEClass, PS_SIMULATION__SIMULATION_START_DATE);
        createEAttribute(psSimulationEClass, PS_SIMULATION__SIMULATION_END_DATE);

        psInstanceEClass = createEClass(PS_INSTANCE);
        createEAttribute(psInstanceEClass, PS_INSTANCE__ID);
        createEAttribute(psInstanceEClass, PS_INSTANCE__INIT_BEHAVIOUR);
        createEAttribute(psInstanceEClass, PS_INSTANCE__MODEL_CLASS);
        createEAttribute(psInstanceEClass, PS_INSTANCE__MODEL_PATH);
        createEAttribute(psInstanceEClass, PS_INSTANCE__NAME);
        createEReference(psInstanceEClass, PS_INSTANCE__INCOMING_CONNECTIONS);
        createEReference(psInstanceEClass, PS_INSTANCE__OUTGOING_CONNECTIONS);
        createEReference(psInstanceEClass, PS_INSTANCE__SUPERINSTANCE);
        createEReference(psInstanceEClass, PS_INSTANCE__SUBINSTANCE);

        psComunicationEClass = createEClass(PS_COMUNICATION);
        createEReference(psComunicationEClass, PS_COMUNICATION__BEGIN);
        createEReference(psComunicationEClass, PS_COMUNICATION__END);
        createEAttribute(psComunicationEClass, PS_COMUNICATION__PUBLIC_VARIABLE);
        createEAttribute(psComunicationEClass, PS_COMUNICATION__EXERNAL_VARIABLE);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model.  This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void initializePackageContents() {
        if (isInitialized) return;
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes

        // Initialize classes, features, and operations; add parameters
        initEClass(psSimulationEClass, PSSimulation.class, "PSSimulation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getPSSimulation_Id(), ecorePackage.getEString(), "id", null, 0, 1, PSSimulation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getPSSimulation_Element(), this.getPSInstance(), null, "element", null, 1, -1, PSSimulation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPSSimulation_Description(), ecorePackage.getEString(), "description", null, 0, 1, PSSimulation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getPSSimulation_Relations(), this.getPSComunication(), null, "relations", null, 0, -1, PSSimulation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPSSimulation_Name(), ecorePackage.getEString(), "name", null, 0, 1, PSSimulation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPSSimulation_SimulationStep(), ecorePackage.getEString(), "simulationStep", "PT1M", 0, 1, PSSimulation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPSSimulation_SimulationStartDate(), ecorePackage.getEString(), "simulationStartDate", null, 0, 1, PSSimulation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPSSimulation_SimulationEndDate(), ecorePackage.getEString(), "simulationEndDate", null, 0, 1, PSSimulation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(psInstanceEClass, PSInstance.class, "PSInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getPSInstance_Id(), ecorePackage.getEString(), "id", null, 0, 1, PSInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPSInstance_InitBehaviour(), ecorePackage.getEString(), "initBehaviour", null, 0, 1, PSInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPSInstance_ModelClass(), ecorePackage.getEString(), "modelClass", null, 0, 1, PSInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPSInstance_ModelPath(), ecorePackage.getEString(), "modelPath", null, 0, 1, PSInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPSInstance_Name(), ecorePackage.getEString(), "name", null, 0, 1, PSInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getPSInstance_IncomingConnections(), this.getPSComunication(), null, "incomingConnections", null, 0, -1, PSInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getPSInstance_OutgoingConnections(), this.getPSComunication(), null, "outgoingConnections", null, 0, -1, PSInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getPSInstance_Superinstance(), this.getPSInstance(), null, "superinstance", null, 0, 1, PSInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getPSInstance_Subinstance(), this.getPSInstance(), null, "subinstance", null, 0, -1, PSInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(psComunicationEClass, PSComunication.class, "PSComunication", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getPSComunication_Begin(), this.getPSInstance(), null, "begin", null, 1, 1, PSComunication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getPSComunication_End(), this.getPSInstance(), null, "end", null, 1, 1, PSComunication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPSComunication_PublicVariable(), ecorePackage.getEString(), "publicVariable", null, 0, 1, PSComunication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPSComunication_ExernalVariable(), ecorePackage.getEString(), "exernalVariable", null, 0, 1, PSComunication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Create resource
        createResource(eNS_URI);
    }

} //PssimulationPackageImpl
