/**
 */
package psplatform.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import psplatform.PSAgent;
import psplatform.PSBehaviour;
import psplatform.PSContinuousBehaviour;
import psplatform.PSSingleBehaviour;
import psplatform.PSStart;
import psplatform.PSState;
import psplatform.PSTransition;
import psplatform.PSVariable;
import psplatform.PSVariableScope;
import psplatform.PSVariableType;
import psplatform.PsplatformFactory;
import psplatform.PsplatformPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PsplatformPackageImpl extends EPackageImpl implements PsplatformPackage {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass psAgentEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass psStartEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass psStateEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass psTransitionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass psBehaviourEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass psVariableEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass psSingleBehaviourEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass psContinuousBehaviourEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum psVariableTypeEEnum = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum psVariableScopeEEnum = null;

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
     * @see psplatform.PsplatformPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private PsplatformPackageImpl() {
        super(eNS_URI, PsplatformFactory.eINSTANCE);
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
     * <p>This method is used to initialize {@link PsplatformPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static PsplatformPackage init() {
        if (isInited) return (PsplatformPackage)EPackage.Registry.INSTANCE.getEPackage(PsplatformPackage.eNS_URI);

        // Obtain or create and register package
        PsplatformPackageImpl thePsplatformPackage = (PsplatformPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof PsplatformPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new PsplatformPackageImpl());

        isInited = true;

        // Create package meta-data objects
        thePsplatformPackage.createPackageContents();

        // Initialize created meta-data
        thePsplatformPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        thePsplatformPackage.freeze();

  
        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(PsplatformPackage.eNS_URI, thePsplatformPackage);
        return thePsplatformPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getPSAgent() {
        return psAgentEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getPSAgent_Start() {
        return (EReference)psAgentEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getPSAgent_States() {
        return (EReference)psAgentEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getPSAgent_Transactions() {
        return (EReference)psAgentEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPSAgent_Package() {
        return (EAttribute)psAgentEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPSAgent_Id() {
        return (EAttribute)psAgentEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPSAgent_Name() {
        return (EAttribute)psAgentEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getPSAgent_Variables() {
        return (EReference)psAgentEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getPSStart() {
        return psStartEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getPSStart_OnInit() {
        return (EReference)psStartEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getPSState() {
        return psStateEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPSState_Name() {
        return (EAttribute)psStateEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getPSState_Transitions() {
        return (EReference)psStateEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getPSState_OnStep() {
        return (EReference)psStateEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getPSState_OnEntry() {
        return (EReference)psStateEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getPSState_OnExit() {
        return (EReference)psStateEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPSState_Id() {
        return (EAttribute)psStateEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getPSTransition() {
        return psTransitionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPSTransition_Condition() {
        return (EAttribute)psTransitionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getPSTransition_Source() {
        return (EReference)psTransitionEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getPSTransition_Target() {
        return (EReference)psTransitionEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getPSBehaviour() {
        return psBehaviourEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPSBehaviour_OnAction() {
        return (EAttribute)psBehaviourEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getPSVariable() {
        return psVariableEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPSVariable_Type() {
        return (EAttribute)psVariableEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPSVariable_Scope() {
        return (EAttribute)psVariableEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPSVariable_Key() {
        return (EAttribute)psVariableEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPSVariable_Value() {
        return (EAttribute)psVariableEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPSVariable_Default() {
        return (EAttribute)psVariableEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getPSSingleBehaviour() {
        return psSingleBehaviourEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getPSContinuousBehaviour() {
        return psContinuousBehaviourEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EEnum getPSVariableType() {
        return psVariableTypeEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EEnum getPSVariableScope() {
        return psVariableScopeEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PsplatformFactory getPsplatformFactory() {
        return (PsplatformFactory)getEFactoryInstance();
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
        psAgentEClass = createEClass(PS_AGENT);
        createEReference(psAgentEClass, PS_AGENT__START);
        createEReference(psAgentEClass, PS_AGENT__STATES);
        createEReference(psAgentEClass, PS_AGENT__TRANSACTIONS);
        createEAttribute(psAgentEClass, PS_AGENT__PACKAGE);
        createEAttribute(psAgentEClass, PS_AGENT__ID);
        createEAttribute(psAgentEClass, PS_AGENT__NAME);
        createEReference(psAgentEClass, PS_AGENT__VARIABLES);

        psStartEClass = createEClass(PS_START);
        createEReference(psStartEClass, PS_START__ON_INIT);

        psStateEClass = createEClass(PS_STATE);
        createEAttribute(psStateEClass, PS_STATE__NAME);
        createEReference(psStateEClass, PS_STATE__TRANSITIONS);
        createEReference(psStateEClass, PS_STATE__ON_STEP);
        createEReference(psStateEClass, PS_STATE__ON_ENTRY);
        createEReference(psStateEClass, PS_STATE__ON_EXIT);
        createEAttribute(psStateEClass, PS_STATE__ID);

        psTransitionEClass = createEClass(PS_TRANSITION);
        createEAttribute(psTransitionEClass, PS_TRANSITION__CONDITION);
        createEReference(psTransitionEClass, PS_TRANSITION__SOURCE);
        createEReference(psTransitionEClass, PS_TRANSITION__TARGET);

        psBehaviourEClass = createEClass(PS_BEHAVIOUR);
        createEAttribute(psBehaviourEClass, PS_BEHAVIOUR__ON_ACTION);

        psVariableEClass = createEClass(PS_VARIABLE);
        createEAttribute(psVariableEClass, PS_VARIABLE__TYPE);
        createEAttribute(psVariableEClass, PS_VARIABLE__SCOPE);
        createEAttribute(psVariableEClass, PS_VARIABLE__KEY);
        createEAttribute(psVariableEClass, PS_VARIABLE__VALUE);
        createEAttribute(psVariableEClass, PS_VARIABLE__DEFAULT);

        psSingleBehaviourEClass = createEClass(PS_SINGLE_BEHAVIOUR);

        psContinuousBehaviourEClass = createEClass(PS_CONTINUOUS_BEHAVIOUR);

        // Create enums
        psVariableTypeEEnum = createEEnum(PS_VARIABLE_TYPE);
        psVariableScopeEEnum = createEEnum(PS_VARIABLE_SCOPE);
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
        psStartEClass.getESuperTypes().add(this.getPSState());
        psSingleBehaviourEClass.getESuperTypes().add(this.getPSBehaviour());
        psContinuousBehaviourEClass.getESuperTypes().add(this.getPSBehaviour());

        // Initialize classes, features, and operations; add parameters
        initEClass(psAgentEClass, PSAgent.class, "PSAgent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getPSAgent_Start(), this.getPSStart(), null, "start", null, 1, 1, PSAgent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getPSAgent_States(), this.getPSState(), null, "states", null, 1, -1, PSAgent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getPSAgent_Transactions(), this.getPSTransition(), null, "transactions", null, 1, -1, PSAgent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPSAgent_Package(), ecorePackage.getEString(), "package", null, 0, 1, PSAgent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPSAgent_Id(), ecorePackage.getEString(), "id", null, 0, 1, PSAgent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPSAgent_Name(), ecorePackage.getEString(), "name", null, 0, 1, PSAgent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getPSAgent_Variables(), this.getPSVariable(), null, "variables", null, 0, -1, PSAgent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(psStartEClass, PSStart.class, "PSStart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getPSStart_OnInit(), this.getPSSingleBehaviour(), null, "onInit", null, 1, 1, PSStart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(psStateEClass, PSState.class, "PSState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getPSState_Name(), ecorePackage.getEString(), "name", "New State", 0, 1, PSState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getPSState_Transitions(), this.getPSTransition(), null, "transitions", null, 1, -1, PSState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getPSState_OnStep(), this.getPSContinuousBehaviour(), null, "onStep", null, 1, 1, PSState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getPSState_OnEntry(), this.getPSSingleBehaviour(), null, "onEntry", null, 1, 1, PSState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getPSState_OnExit(), this.getPSSingleBehaviour(), null, "onExit", null, 1, 1, PSState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPSState_Id(), ecorePackage.getEString(), "id", null, 1, 1, PSState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(psTransitionEClass, PSTransition.class, "PSTransition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getPSTransition_Condition(), ecorePackage.getEString(), "condition", null, 0, 1, PSTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getPSTransition_Source(), this.getPSState(), null, "source", null, 1, 1, PSTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getPSTransition_Target(), this.getPSState(), null, "target", null, 1, 1, PSTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(psBehaviourEClass, PSBehaviour.class, "PSBehaviour", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getPSBehaviour_OnAction(), ecorePackage.getEString(), "onAction", null, 0, 1, PSBehaviour.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(psVariableEClass, PSVariable.class, "PSVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getPSVariable_Type(), this.getPSVariableType(), "type", null, 1, 1, PSVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPSVariable_Scope(), this.getPSVariableScope(), "scope", null, 1, 1, PSVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPSVariable_Key(), ecorePackage.getEString(), "key", null, 0, 1, PSVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPSVariable_Value(), ecorePackage.getEJavaObject(), "value", null, 0, 1, PSVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPSVariable_Default(), ecorePackage.getEJavaObject(), "default", null, 0, 1, PSVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(psSingleBehaviourEClass, PSSingleBehaviour.class, "PSSingleBehaviour", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(psContinuousBehaviourEClass, PSContinuousBehaviour.class, "PSContinuousBehaviour", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        // Initialize enums and add enum literals
        initEEnum(psVariableTypeEEnum, PSVariableType.class, "PSVariableType");
        addEEnumLiteral(psVariableTypeEEnum, PSVariableType.DATE);
        addEEnumLiteral(psVariableTypeEEnum, PSVariableType.INTEGER);
        addEEnumLiteral(psVariableTypeEEnum, PSVariableType.FLOAT);
        addEEnumLiteral(psVariableTypeEEnum, PSVariableType.TIME);
        addEEnumLiteral(psVariableTypeEEnum, PSVariableType.BOOLEAN);
        addEEnumLiteral(psVariableTypeEEnum, PSVariableType.STRING);

        initEEnum(psVariableScopeEEnum, PSVariableScope.class, "PSVariableScope");
        addEEnumLiteral(psVariableScopeEEnum, PSVariableScope.EXTERNAL);
        addEEnumLiteral(psVariableScopeEEnum, PSVariableScope.LOCAL);
        addEEnumLiteral(psVariableScopeEEnum, PSVariableScope.PUBLIC);

        // Create resource
        createResource(eNS_URI);
    }

} //PsplatformPackageImpl
