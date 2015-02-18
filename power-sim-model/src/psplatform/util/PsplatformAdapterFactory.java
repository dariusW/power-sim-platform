/**
 */
package psplatform.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import psplatform.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see psplatform.PsplatformPackage
 * @generated
 */
public class PsplatformAdapterFactory extends AdapterFactoryImpl {
    /**
     * The cached model package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static PsplatformPackage modelPackage;

    /**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PsplatformAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = PsplatformPackage.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc -->
     * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
     * <!-- end-user-doc -->
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
    @Override
    public boolean isFactoryForType(Object object) {
        if (object == modelPackage) {
            return true;
        }
        if (object instanceof EObject) {
            return ((EObject)object).eClass().getEPackage() == modelPackage;
        }
        return false;
    }

    /**
     * The switch that delegates to the <code>createXXX</code> methods.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected PsplatformSwitch<Adapter> modelSwitch =
        new PsplatformSwitch<Adapter>() {
            @Override
            public Adapter casePSAgent(PSAgent object) {
                return createPSAgentAdapter();
            }
            @Override
            public Adapter casePSStart(PSStart object) {
                return createPSStartAdapter();
            }
            @Override
            public Adapter casePSState(PSState object) {
                return createPSStateAdapter();
            }
            @Override
            public Adapter casePSTransition(PSTransition object) {
                return createPSTransitionAdapter();
            }
            @Override
            public Adapter casePSBehaviour(PSBehaviour object) {
                return createPSBehaviourAdapter();
            }
            @Override
            public Adapter casePSVariable(PSVariable object) {
                return createPSVariableAdapter();
            }
            @Override
            public Adapter casePSSingleBehaviour(PSSingleBehaviour object) {
                return createPSSingleBehaviourAdapter();
            }
            @Override
            public Adapter casePSContinuousBehaviour(PSContinuousBehaviour object) {
                return createPSContinuousBehaviourAdapter();
            }
            @Override
            public Adapter defaultCase(EObject object) {
                return createEObjectAdapter();
            }
        };

    /**
     * Creates an adapter for the <code>target</code>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param target the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
    @Override
    public Adapter createAdapter(Notifier target) {
        return modelSwitch.doSwitch((EObject)target);
    }


    /**
     * Creates a new adapter for an object of class '{@link psplatform.PSAgent <em>PS Agent</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see psplatform.PSAgent
     * @generated
     */
    public Adapter createPSAgentAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link psplatform.PSStart <em>PS Start</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see psplatform.PSStart
     * @generated
     */
    public Adapter createPSStartAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link psplatform.PSState <em>PS State</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see psplatform.PSState
     * @generated
     */
    public Adapter createPSStateAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link psplatform.PSTransition <em>PS Transition</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see psplatform.PSTransition
     * @generated
     */
    public Adapter createPSTransitionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link psplatform.PSBehaviour <em>PS Behaviour</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see psplatform.PSBehaviour
     * @generated
     */
    public Adapter createPSBehaviourAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link psplatform.PSVariable <em>PS Variable</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see psplatform.PSVariable
     * @generated
     */
    public Adapter createPSVariableAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link psplatform.PSSingleBehaviour <em>PS Single Behaviour</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see psplatform.PSSingleBehaviour
     * @generated
     */
    public Adapter createPSSingleBehaviourAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link psplatform.PSContinuousBehaviour <em>PS Continuous Behaviour</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see psplatform.PSContinuousBehaviour
     * @generated
     */
    public Adapter createPSContinuousBehaviourAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for the default case.
     * <!-- begin-user-doc -->
     * This default implementation returns null.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter() {
        return null;
    }

} //PsplatformAdapterFactory
