/**
 */
package psplatform;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see psplatform.PsplatformPackage
 * @generated
 */
public interface PsplatformFactory extends EFactory {
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    PsplatformFactory eINSTANCE = psplatform.impl.PsplatformFactoryImpl.init();

    /**
     * Returns a new object of class '<em>PS Agent</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>PS Agent</em>'.
     * @generated
     */
    PSAgent createPSAgent();

    /**
     * Returns a new object of class '<em>PS Start</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>PS Start</em>'.
     * @generated
     */
    PSStart createPSStart();

    /**
     * Returns a new object of class '<em>PS State</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>PS State</em>'.
     * @generated
     */
    PSState createPSState();

    /**
     * Returns a new object of class '<em>PS Transition</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>PS Transition</em>'.
     * @generated
     */
    PSTransition createPSTransition();

    /**
     * Returns a new object of class '<em>PS Behaviour</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>PS Behaviour</em>'.
     * @generated
     */
    PSBehaviour createPSBehaviour();

    /**
     * Returns a new object of class '<em>PS Variable</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>PS Variable</em>'.
     * @generated
     */
    PSVariable createPSVariable();

    /**
     * Returns a new object of class '<em>PS Single Behaviour</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>PS Single Behaviour</em>'.
     * @generated
     */
    PSSingleBehaviour createPSSingleBehaviour();

    /**
     * Returns a new object of class '<em>PS Continuous Behaviour</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>PS Continuous Behaviour</em>'.
     * @generated
     */
    PSContinuousBehaviour createPSContinuousBehaviour();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    PsplatformPackage getPsplatformPackage();

} //PsplatformFactory
