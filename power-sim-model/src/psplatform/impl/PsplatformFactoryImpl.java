/**
 */
package psplatform.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import psplatform.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PsplatformFactoryImpl extends EFactoryImpl implements PsplatformFactory {
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static PsplatformFactory init() {
        try {
            PsplatformFactory thePsplatformFactory = (PsplatformFactory)EPackage.Registry.INSTANCE.getEFactory(PsplatformPackage.eNS_URI);
            if (thePsplatformFactory != null) {
                return thePsplatformFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new PsplatformFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PsplatformFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
            case PsplatformPackage.PS_AGENT: return createPSAgent();
            case PsplatformPackage.PS_START: return createPSStart();
            case PsplatformPackage.PS_STATE: return createPSState();
            case PsplatformPackage.PS_TRANSITION: return createPSTransition();
            case PsplatformPackage.PS_BEHAVIOUR: return createPSBehaviour();
            case PsplatformPackage.PS_VARIABLE: return createPSVariable();
            case PsplatformPackage.PS_SINGLE_BEHAVIOUR: return createPSSingleBehaviour();
            case PsplatformPackage.PS_CONTINUOUS_BEHAVIOUR: return createPSContinuousBehaviour();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object createFromString(EDataType eDataType, String initialValue) {
        switch (eDataType.getClassifierID()) {
            case PsplatformPackage.PS_VARIABLE_TYPE:
                return createPSVariableTypeFromString(eDataType, initialValue);
            case PsplatformPackage.PS_VARIABLE_SCOPE:
                return createPSVariableScopeFromString(eDataType, initialValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String convertToString(EDataType eDataType, Object instanceValue) {
        switch (eDataType.getClassifierID()) {
            case PsplatformPackage.PS_VARIABLE_TYPE:
                return convertPSVariableTypeToString(eDataType, instanceValue);
            case PsplatformPackage.PS_VARIABLE_SCOPE:
                return convertPSVariableScopeToString(eDataType, instanceValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PSAgent createPSAgent() {
        PSAgentImpl psAgent = new PSAgentImpl();
        return psAgent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PSStart createPSStart() {
        PSStartImpl psStart = new PSStartImpl();
        return psStart;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PSState createPSState() {
        PSStateImpl psState = new PSStateImpl();
        return psState;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PSTransition createPSTransition() {
        PSTransitionImpl psTransition = new PSTransitionImpl();
        return psTransition;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PSBehaviour createPSBehaviour() {
        PSBehaviourImpl psBehaviour = new PSBehaviourImpl();
        return psBehaviour;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PSVariable createPSVariable() {
        PSVariableImpl psVariable = new PSVariableImpl();
        return psVariable;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PSSingleBehaviour createPSSingleBehaviour() {
        PSSingleBehaviourImpl psSingleBehaviour = new PSSingleBehaviourImpl();
        return psSingleBehaviour;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PSContinuousBehaviour createPSContinuousBehaviour() {
        PSContinuousBehaviourImpl psContinuousBehaviour = new PSContinuousBehaviourImpl();
        return psContinuousBehaviour;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PSVariableType createPSVariableTypeFromString(EDataType eDataType, String initialValue) {
        PSVariableType result = PSVariableType.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertPSVariableTypeToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PSVariableScope createPSVariableScopeFromString(EDataType eDataType, String initialValue) {
        PSVariableScope result = PSVariableScope.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertPSVariableScopeToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PsplatformPackage getPsplatformPackage() {
        return (PsplatformPackage)getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static PsplatformPackage getPackage() {
        return PsplatformPackage.eINSTANCE;
    }

} //PsplatformFactoryImpl
