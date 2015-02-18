/**
 */
package psplatform.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import psplatform.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see psplatform.PsplatformPackage
 * @generated
 */
public class PsplatformSwitch<T> extends Switch<T> {
    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static PsplatformPackage modelPackage;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PsplatformSwitch() {
        if (modelPackage == null) {
            modelPackage = PsplatformPackage.eINSTANCE;
        }
    }

    /**
     * Checks whether this is a switch for the given package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @parameter ePackage the package in question.
     * @return whether this is a switch for the given package.
     * @generated
     */
    @Override
    protected boolean isSwitchFor(EPackage ePackage) {
        return ePackage == modelPackage;
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    @Override
    protected T doSwitch(int classifierID, EObject theEObject) {
        switch (classifierID) {
            case PsplatformPackage.PS_AGENT: {
                PSAgent psAgent = (PSAgent)theEObject;
                T result = casePSAgent(psAgent);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case PsplatformPackage.PS_START: {
                PSStart psStart = (PSStart)theEObject;
                T result = casePSStart(psStart);
                if (result == null) result = casePSState(psStart);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case PsplatformPackage.PS_STATE: {
                PSState psState = (PSState)theEObject;
                T result = casePSState(psState);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case PsplatformPackage.PS_TRANSITION: {
                PSTransition psTransition = (PSTransition)theEObject;
                T result = casePSTransition(psTransition);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case PsplatformPackage.PS_BEHAVIOUR: {
                PSBehaviour psBehaviour = (PSBehaviour)theEObject;
                T result = casePSBehaviour(psBehaviour);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case PsplatformPackage.PS_VARIABLE: {
                PSVariable psVariable = (PSVariable)theEObject;
                T result = casePSVariable(psVariable);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case PsplatformPackage.PS_SINGLE_BEHAVIOUR: {
                PSSingleBehaviour psSingleBehaviour = (PSSingleBehaviour)theEObject;
                T result = casePSSingleBehaviour(psSingleBehaviour);
                if (result == null) result = casePSBehaviour(psSingleBehaviour);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case PsplatformPackage.PS_CONTINUOUS_BEHAVIOUR: {
                PSContinuousBehaviour psContinuousBehaviour = (PSContinuousBehaviour)theEObject;
                T result = casePSContinuousBehaviour(psContinuousBehaviour);
                if (result == null) result = casePSBehaviour(psContinuousBehaviour);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            default: return defaultCase(theEObject);
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>PS Agent</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PS Agent</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePSAgent(PSAgent object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>PS Start</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PS Start</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePSStart(PSStart object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>PS State</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PS State</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePSState(PSState object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>PS Transition</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PS Transition</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePSTransition(PSTransition object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>PS Behaviour</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PS Behaviour</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePSBehaviour(PSBehaviour object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>PS Variable</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PS Variable</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePSVariable(PSVariable object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>PS Single Behaviour</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PS Single Behaviour</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePSSingleBehaviour(PSSingleBehaviour object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>PS Continuous Behaviour</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PS Continuous Behaviour</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePSContinuousBehaviour(PSContinuousBehaviour object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch, but this is the last case anyway.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
    @Override
    public T defaultCase(EObject object) {
        return null;
    }

} //PsplatformSwitch
