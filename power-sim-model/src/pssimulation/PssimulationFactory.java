/**
 */
package pssimulation;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see pssimulation.PssimulationPackage
 * @generated
 */
public interface PssimulationFactory extends EFactory {
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    PssimulationFactory eINSTANCE = pssimulation.impl.PssimulationFactoryImpl.init();

    /**
     * Returns a new object of class '<em>PS Simulation</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>PS Simulation</em>'.
     * @generated
     */
    PSSimulation createPSSimulation();

    /**
     * Returns a new object of class '<em>PS Instance</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>PS Instance</em>'.
     * @generated
     */
    PSInstance createPSInstance();

    /**
     * Returns a new object of class '<em>PS Hierarchy</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>PS Hierarchy</em>'.
     * @generated
     */
    PSHierarchy createPSHierarchy();

    /**
     * Returns a new object of class '<em>PS Comunication</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>PS Comunication</em>'.
     * @generated
     */
    PSComunication createPSComunication();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    PssimulationPackage getPssimulationPackage();

} //PssimulationFactory
