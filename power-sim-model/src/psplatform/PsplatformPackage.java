/**
 */
package psplatform;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see psplatform.PsplatformFactory
 * @model kind="package"
 * @generated
 */
public interface PsplatformPackage extends EPackage {
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "psplatform";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "powerSim";

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
    PsplatformPackage eINSTANCE = psplatform.impl.PsplatformPackageImpl.init();

    /**
     * The meta object id for the '{@link psplatform.impl.PSAgentImpl <em>PS Agent</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see psplatform.impl.PSAgentImpl
     * @see psplatform.impl.PsplatformPackageImpl#getPSAgent()
     * @generated
     */
    int PS_AGENT = 0;

    /**
     * The feature id for the '<em><b>Start</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_AGENT__START = 0;

    /**
     * The feature id for the '<em><b>States</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_AGENT__STATES = 1;

    /**
     * The feature id for the '<em><b>Transactions</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_AGENT__TRANSACTIONS = 2;

    /**
     * The feature id for the '<em><b>Package</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_AGENT__PACKAGE = 3;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_AGENT__ID = 4;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_AGENT__NAME = 5;

    /**
     * The feature id for the '<em><b>Variables</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_AGENT__VARIABLES = 6;

    /**
     * The number of structural features of the '<em>PS Agent</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_AGENT_FEATURE_COUNT = 7;

    /**
     * The number of operations of the '<em>PS Agent</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_AGENT_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link psplatform.impl.PSStateImpl <em>PS State</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see psplatform.impl.PSStateImpl
     * @see psplatform.impl.PsplatformPackageImpl#getPSState()
     * @generated
     */
    int PS_STATE = 2;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_STATE__NAME = 0;

    /**
     * The feature id for the '<em><b>Transitions</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_STATE__TRANSITIONS = 1;

    /**
     * The feature id for the '<em><b>On Step</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_STATE__ON_STEP = 2;

    /**
     * The feature id for the '<em><b>On Entry</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_STATE__ON_ENTRY = 3;

    /**
     * The feature id for the '<em><b>On Exit</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_STATE__ON_EXIT = 4;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_STATE__ID = 5;

    /**
     * The number of structural features of the '<em>PS State</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_STATE_FEATURE_COUNT = 6;

    /**
     * The number of operations of the '<em>PS State</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_STATE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link psplatform.impl.PSStartImpl <em>PS Start</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see psplatform.impl.PSStartImpl
     * @see psplatform.impl.PsplatformPackageImpl#getPSStart()
     * @generated
     */
    int PS_START = 1;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_START__NAME = PS_STATE__NAME;

    /**
     * The feature id for the '<em><b>Transitions</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_START__TRANSITIONS = PS_STATE__TRANSITIONS;

    /**
     * The feature id for the '<em><b>On Step</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_START__ON_STEP = PS_STATE__ON_STEP;

    /**
     * The feature id for the '<em><b>On Entry</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_START__ON_ENTRY = PS_STATE__ON_ENTRY;

    /**
     * The feature id for the '<em><b>On Exit</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_START__ON_EXIT = PS_STATE__ON_EXIT;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_START__ID = PS_STATE__ID;

    /**
     * The feature id for the '<em><b>On Init</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_START__ON_INIT = PS_STATE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>PS Start</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_START_FEATURE_COUNT = PS_STATE_FEATURE_COUNT + 1;

    /**
     * The number of operations of the '<em>PS Start</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_START_OPERATION_COUNT = PS_STATE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link psplatform.impl.PSTransitionImpl <em>PS Transition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see psplatform.impl.PSTransitionImpl
     * @see psplatform.impl.PsplatformPackageImpl#getPSTransition()
     * @generated
     */
    int PS_TRANSITION = 3;

    /**
     * The feature id for the '<em><b>Condition</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_TRANSITION__CONDITION = 0;

    /**
     * The feature id for the '<em><b>Source</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_TRANSITION__SOURCE = 1;

    /**
     * The feature id for the '<em><b>Target</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_TRANSITION__TARGET = 2;

    /**
     * The number of structural features of the '<em>PS Transition</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_TRANSITION_FEATURE_COUNT = 3;

    /**
     * The number of operations of the '<em>PS Transition</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_TRANSITION_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link psplatform.impl.PSBehaviourImpl <em>PS Behaviour</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see psplatform.impl.PSBehaviourImpl
     * @see psplatform.impl.PsplatformPackageImpl#getPSBehaviour()
     * @generated
     */
    int PS_BEHAVIOUR = 4;

    /**
     * The feature id for the '<em><b>On Action</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_BEHAVIOUR__ON_ACTION = 0;

    /**
     * The number of structural features of the '<em>PS Behaviour</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_BEHAVIOUR_FEATURE_COUNT = 1;

    /**
     * The number of operations of the '<em>PS Behaviour</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_BEHAVIOUR_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link psplatform.impl.PSVariableImpl <em>PS Variable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see psplatform.impl.PSVariableImpl
     * @see psplatform.impl.PsplatformPackageImpl#getPSVariable()
     * @generated
     */
    int PS_VARIABLE = 5;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_VARIABLE__TYPE = 0;

    /**
     * The feature id for the '<em><b>Scope</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_VARIABLE__SCOPE = 1;

    /**
     * The feature id for the '<em><b>Key</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_VARIABLE__KEY = 2;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_VARIABLE__VALUE = 3;

    /**
     * The feature id for the '<em><b>Default</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_VARIABLE__DEFAULT = 4;

    /**
     * The number of structural features of the '<em>PS Variable</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_VARIABLE_FEATURE_COUNT = 5;

    /**
     * The number of operations of the '<em>PS Variable</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_VARIABLE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link psplatform.impl.PSSingleBehaviourImpl <em>PS Single Behaviour</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see psplatform.impl.PSSingleBehaviourImpl
     * @see psplatform.impl.PsplatformPackageImpl#getPSSingleBehaviour()
     * @generated
     */
    int PS_SINGLE_BEHAVIOUR = 6;

    /**
     * The feature id for the '<em><b>On Action</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_SINGLE_BEHAVIOUR__ON_ACTION = PS_BEHAVIOUR__ON_ACTION;

    /**
     * The number of structural features of the '<em>PS Single Behaviour</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_SINGLE_BEHAVIOUR_FEATURE_COUNT = PS_BEHAVIOUR_FEATURE_COUNT + 0;

    /**
     * The number of operations of the '<em>PS Single Behaviour</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_SINGLE_BEHAVIOUR_OPERATION_COUNT = PS_BEHAVIOUR_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link psplatform.impl.PSContinuousBehaviourImpl <em>PS Continuous Behaviour</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see psplatform.impl.PSContinuousBehaviourImpl
     * @see psplatform.impl.PsplatformPackageImpl#getPSContinuousBehaviour()
     * @generated
     */
    int PS_CONTINUOUS_BEHAVIOUR = 7;

    /**
     * The feature id for the '<em><b>On Action</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_CONTINUOUS_BEHAVIOUR__ON_ACTION = PS_BEHAVIOUR__ON_ACTION;

    /**
     * The number of structural features of the '<em>PS Continuous Behaviour</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_CONTINUOUS_BEHAVIOUR_FEATURE_COUNT = PS_BEHAVIOUR_FEATURE_COUNT + 0;

    /**
     * The number of operations of the '<em>PS Continuous Behaviour</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PS_CONTINUOUS_BEHAVIOUR_OPERATION_COUNT = PS_BEHAVIOUR_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link psplatform.PSVariableType <em>PS Variable Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see psplatform.PSVariableType
     * @see psplatform.impl.PsplatformPackageImpl#getPSVariableType()
     * @generated
     */
    int PS_VARIABLE_TYPE = 8;

    /**
     * The meta object id for the '{@link psplatform.PSVariableScope <em>PS Variable Scope</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see psplatform.PSVariableScope
     * @see psplatform.impl.PsplatformPackageImpl#getPSVariableScope()
     * @generated
     */
    int PS_VARIABLE_SCOPE = 9;


    /**
     * Returns the meta object for class '{@link psplatform.PSAgent <em>PS Agent</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>PS Agent</em>'.
     * @see psplatform.PSAgent
     * @generated
     */
    EClass getPSAgent();

    /**
     * Returns the meta object for the containment reference '{@link psplatform.PSAgent#getStart <em>Start</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Start</em>'.
     * @see psplatform.PSAgent#getStart()
     * @see #getPSAgent()
     * @generated
     */
    EReference getPSAgent_Start();

    /**
     * Returns the meta object for the containment reference list '{@link psplatform.PSAgent#getStates <em>States</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>States</em>'.
     * @see psplatform.PSAgent#getStates()
     * @see #getPSAgent()
     * @generated
     */
    EReference getPSAgent_States();

    /**
     * Returns the meta object for the containment reference list '{@link psplatform.PSAgent#getTransactions <em>Transactions</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Transactions</em>'.
     * @see psplatform.PSAgent#getTransactions()
     * @see #getPSAgent()
     * @generated
     */
    EReference getPSAgent_Transactions();

    /**
     * Returns the meta object for the attribute '{@link psplatform.PSAgent#getPackage <em>Package</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Package</em>'.
     * @see psplatform.PSAgent#getPackage()
     * @see #getPSAgent()
     * @generated
     */
    EAttribute getPSAgent_Package();

    /**
     * Returns the meta object for the attribute '{@link psplatform.PSAgent#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see psplatform.PSAgent#getId()
     * @see #getPSAgent()
     * @generated
     */
    EAttribute getPSAgent_Id();

    /**
     * Returns the meta object for the attribute '{@link psplatform.PSAgent#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see psplatform.PSAgent#getName()
     * @see #getPSAgent()
     * @generated
     */
    EAttribute getPSAgent_Name();

    /**
     * Returns the meta object for the containment reference list '{@link psplatform.PSAgent#getVariables <em>Variables</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Variables</em>'.
     * @see psplatform.PSAgent#getVariables()
     * @see #getPSAgent()
     * @generated
     */
    EReference getPSAgent_Variables();

    /**
     * Returns the meta object for class '{@link psplatform.PSStart <em>PS Start</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>PS Start</em>'.
     * @see psplatform.PSStart
     * @generated
     */
    EClass getPSStart();

    /**
     * Returns the meta object for the containment reference '{@link psplatform.PSStart#getOnInit <em>On Init</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>On Init</em>'.
     * @see psplatform.PSStart#getOnInit()
     * @see #getPSStart()
     * @generated
     */
    EReference getPSStart_OnInit();

    /**
     * Returns the meta object for class '{@link psplatform.PSState <em>PS State</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>PS State</em>'.
     * @see psplatform.PSState
     * @generated
     */
    EClass getPSState();

    /**
     * Returns the meta object for the attribute '{@link psplatform.PSState#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see psplatform.PSState#getName()
     * @see #getPSState()
     * @generated
     */
    EAttribute getPSState_Name();

    /**
     * Returns the meta object for the reference list '{@link psplatform.PSState#getTransitions <em>Transitions</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Transitions</em>'.
     * @see psplatform.PSState#getTransitions()
     * @see #getPSState()
     * @generated
     */
    EReference getPSState_Transitions();

    /**
     * Returns the meta object for the containment reference '{@link psplatform.PSState#getOnStep <em>On Step</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>On Step</em>'.
     * @see psplatform.PSState#getOnStep()
     * @see #getPSState()
     * @generated
     */
    EReference getPSState_OnStep();

    /**
     * Returns the meta object for the containment reference '{@link psplatform.PSState#getOnEntry <em>On Entry</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>On Entry</em>'.
     * @see psplatform.PSState#getOnEntry()
     * @see #getPSState()
     * @generated
     */
    EReference getPSState_OnEntry();

    /**
     * Returns the meta object for the containment reference '{@link psplatform.PSState#getOnExit <em>On Exit</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>On Exit</em>'.
     * @see psplatform.PSState#getOnExit()
     * @see #getPSState()
     * @generated
     */
    EReference getPSState_OnExit();

    /**
     * Returns the meta object for the attribute '{@link psplatform.PSState#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see psplatform.PSState#getId()
     * @see #getPSState()
     * @generated
     */
    EAttribute getPSState_Id();

    /**
     * Returns the meta object for class '{@link psplatform.PSTransition <em>PS Transition</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>PS Transition</em>'.
     * @see psplatform.PSTransition
     * @generated
     */
    EClass getPSTransition();

    /**
     * Returns the meta object for the attribute '{@link psplatform.PSTransition#getCondition <em>Condition</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Condition</em>'.
     * @see psplatform.PSTransition#getCondition()
     * @see #getPSTransition()
     * @generated
     */
    EAttribute getPSTransition_Condition();

    /**
     * Returns the meta object for the reference '{@link psplatform.PSTransition#getSource <em>Source</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Source</em>'.
     * @see psplatform.PSTransition#getSource()
     * @see #getPSTransition()
     * @generated
     */
    EReference getPSTransition_Source();

    /**
     * Returns the meta object for the reference '{@link psplatform.PSTransition#getTarget <em>Target</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Target</em>'.
     * @see psplatform.PSTransition#getTarget()
     * @see #getPSTransition()
     * @generated
     */
    EReference getPSTransition_Target();

    /**
     * Returns the meta object for class '{@link psplatform.PSBehaviour <em>PS Behaviour</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>PS Behaviour</em>'.
     * @see psplatform.PSBehaviour
     * @generated
     */
    EClass getPSBehaviour();

    /**
     * Returns the meta object for the attribute '{@link psplatform.PSBehaviour#getOnAction <em>On Action</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>On Action</em>'.
     * @see psplatform.PSBehaviour#getOnAction()
     * @see #getPSBehaviour()
     * @generated
     */
    EAttribute getPSBehaviour_OnAction();

    /**
     * Returns the meta object for class '{@link psplatform.PSVariable <em>PS Variable</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>PS Variable</em>'.
     * @see psplatform.PSVariable
     * @generated
     */
    EClass getPSVariable();

    /**
     * Returns the meta object for the attribute '{@link psplatform.PSVariable#getType <em>Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Type</em>'.
     * @see psplatform.PSVariable#getType()
     * @see #getPSVariable()
     * @generated
     */
    EAttribute getPSVariable_Type();

    /**
     * Returns the meta object for the attribute '{@link psplatform.PSVariable#getScope <em>Scope</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Scope</em>'.
     * @see psplatform.PSVariable#getScope()
     * @see #getPSVariable()
     * @generated
     */
    EAttribute getPSVariable_Scope();

    /**
     * Returns the meta object for the attribute '{@link psplatform.PSVariable#getKey <em>Key</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Key</em>'.
     * @see psplatform.PSVariable#getKey()
     * @see #getPSVariable()
     * @generated
     */
    EAttribute getPSVariable_Key();

    /**
     * Returns the meta object for the attribute '{@link psplatform.PSVariable#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see psplatform.PSVariable#getValue()
     * @see #getPSVariable()
     * @generated
     */
    EAttribute getPSVariable_Value();

    /**
     * Returns the meta object for the attribute '{@link psplatform.PSVariable#getDefault <em>Default</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Default</em>'.
     * @see psplatform.PSVariable#getDefault()
     * @see #getPSVariable()
     * @generated
     */
    EAttribute getPSVariable_Default();

    /**
     * Returns the meta object for class '{@link psplatform.PSSingleBehaviour <em>PS Single Behaviour</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>PS Single Behaviour</em>'.
     * @see psplatform.PSSingleBehaviour
     * @generated
     */
    EClass getPSSingleBehaviour();

    /**
     * Returns the meta object for class '{@link psplatform.PSContinuousBehaviour <em>PS Continuous Behaviour</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>PS Continuous Behaviour</em>'.
     * @see psplatform.PSContinuousBehaviour
     * @generated
     */
    EClass getPSContinuousBehaviour();

    /**
     * Returns the meta object for enum '{@link psplatform.PSVariableType <em>PS Variable Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for enum '<em>PS Variable Type</em>'.
     * @see psplatform.PSVariableType
     * @generated
     */
    EEnum getPSVariableType();

    /**
     * Returns the meta object for enum '{@link psplatform.PSVariableScope <em>PS Variable Scope</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for enum '<em>PS Variable Scope</em>'.
     * @see psplatform.PSVariableScope
     * @generated
     */
    EEnum getPSVariableScope();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    PsplatformFactory getPsplatformFactory();

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
         * The meta object literal for the '{@link psplatform.impl.PSAgentImpl <em>PS Agent</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see psplatform.impl.PSAgentImpl
         * @see psplatform.impl.PsplatformPackageImpl#getPSAgent()
         * @generated
         */
        EClass PS_AGENT = eINSTANCE.getPSAgent();

        /**
         * The meta object literal for the '<em><b>Start</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PS_AGENT__START = eINSTANCE.getPSAgent_Start();

        /**
         * The meta object literal for the '<em><b>States</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PS_AGENT__STATES = eINSTANCE.getPSAgent_States();

        /**
         * The meta object literal for the '<em><b>Transactions</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PS_AGENT__TRANSACTIONS = eINSTANCE.getPSAgent_Transactions();

        /**
         * The meta object literal for the '<em><b>Package</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PS_AGENT__PACKAGE = eINSTANCE.getPSAgent_Package();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PS_AGENT__ID = eINSTANCE.getPSAgent_Id();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PS_AGENT__NAME = eINSTANCE.getPSAgent_Name();

        /**
         * The meta object literal for the '<em><b>Variables</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PS_AGENT__VARIABLES = eINSTANCE.getPSAgent_Variables();

        /**
         * The meta object literal for the '{@link psplatform.impl.PSStartImpl <em>PS Start</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see psplatform.impl.PSStartImpl
         * @see psplatform.impl.PsplatformPackageImpl#getPSStart()
         * @generated
         */
        EClass PS_START = eINSTANCE.getPSStart();

        /**
         * The meta object literal for the '<em><b>On Init</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PS_START__ON_INIT = eINSTANCE.getPSStart_OnInit();

        /**
         * The meta object literal for the '{@link psplatform.impl.PSStateImpl <em>PS State</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see psplatform.impl.PSStateImpl
         * @see psplatform.impl.PsplatformPackageImpl#getPSState()
         * @generated
         */
        EClass PS_STATE = eINSTANCE.getPSState();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PS_STATE__NAME = eINSTANCE.getPSState_Name();

        /**
         * The meta object literal for the '<em><b>Transitions</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PS_STATE__TRANSITIONS = eINSTANCE.getPSState_Transitions();

        /**
         * The meta object literal for the '<em><b>On Step</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PS_STATE__ON_STEP = eINSTANCE.getPSState_OnStep();

        /**
         * The meta object literal for the '<em><b>On Entry</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PS_STATE__ON_ENTRY = eINSTANCE.getPSState_OnEntry();

        /**
         * The meta object literal for the '<em><b>On Exit</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PS_STATE__ON_EXIT = eINSTANCE.getPSState_OnExit();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PS_STATE__ID = eINSTANCE.getPSState_Id();

        /**
         * The meta object literal for the '{@link psplatform.impl.PSTransitionImpl <em>PS Transition</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see psplatform.impl.PSTransitionImpl
         * @see psplatform.impl.PsplatformPackageImpl#getPSTransition()
         * @generated
         */
        EClass PS_TRANSITION = eINSTANCE.getPSTransition();

        /**
         * The meta object literal for the '<em><b>Condition</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PS_TRANSITION__CONDITION = eINSTANCE.getPSTransition_Condition();

        /**
         * The meta object literal for the '<em><b>Source</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PS_TRANSITION__SOURCE = eINSTANCE.getPSTransition_Source();

        /**
         * The meta object literal for the '<em><b>Target</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PS_TRANSITION__TARGET = eINSTANCE.getPSTransition_Target();

        /**
         * The meta object literal for the '{@link psplatform.impl.PSBehaviourImpl <em>PS Behaviour</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see psplatform.impl.PSBehaviourImpl
         * @see psplatform.impl.PsplatformPackageImpl#getPSBehaviour()
         * @generated
         */
        EClass PS_BEHAVIOUR = eINSTANCE.getPSBehaviour();

        /**
         * The meta object literal for the '<em><b>On Action</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PS_BEHAVIOUR__ON_ACTION = eINSTANCE.getPSBehaviour_OnAction();

        /**
         * The meta object literal for the '{@link psplatform.impl.PSVariableImpl <em>PS Variable</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see psplatform.impl.PSVariableImpl
         * @see psplatform.impl.PsplatformPackageImpl#getPSVariable()
         * @generated
         */
        EClass PS_VARIABLE = eINSTANCE.getPSVariable();

        /**
         * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PS_VARIABLE__TYPE = eINSTANCE.getPSVariable_Type();

        /**
         * The meta object literal for the '<em><b>Scope</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PS_VARIABLE__SCOPE = eINSTANCE.getPSVariable_Scope();

        /**
         * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PS_VARIABLE__KEY = eINSTANCE.getPSVariable_Key();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PS_VARIABLE__VALUE = eINSTANCE.getPSVariable_Value();

        /**
         * The meta object literal for the '<em><b>Default</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PS_VARIABLE__DEFAULT = eINSTANCE.getPSVariable_Default();

        /**
         * The meta object literal for the '{@link psplatform.impl.PSSingleBehaviourImpl <em>PS Single Behaviour</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see psplatform.impl.PSSingleBehaviourImpl
         * @see psplatform.impl.PsplatformPackageImpl#getPSSingleBehaviour()
         * @generated
         */
        EClass PS_SINGLE_BEHAVIOUR = eINSTANCE.getPSSingleBehaviour();

        /**
         * The meta object literal for the '{@link psplatform.impl.PSContinuousBehaviourImpl <em>PS Continuous Behaviour</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see psplatform.impl.PSContinuousBehaviourImpl
         * @see psplatform.impl.PsplatformPackageImpl#getPSContinuousBehaviour()
         * @generated
         */
        EClass PS_CONTINUOUS_BEHAVIOUR = eINSTANCE.getPSContinuousBehaviour();

        /**
         * The meta object literal for the '{@link psplatform.PSVariableType <em>PS Variable Type</em>}' enum.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see psplatform.PSVariableType
         * @see psplatform.impl.PsplatformPackageImpl#getPSVariableType()
         * @generated
         */
        EEnum PS_VARIABLE_TYPE = eINSTANCE.getPSVariableType();

        /**
         * The meta object literal for the '{@link psplatform.PSVariableScope <em>PS Variable Scope</em>}' enum.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see psplatform.PSVariableScope
         * @see psplatform.impl.PsplatformPackageImpl#getPSVariableScope()
         * @generated
         */
        EEnum PS_VARIABLE_SCOPE = eINSTANCE.getPSVariableScope();

    }

} //PsplatformPackage
