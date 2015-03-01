/**
 */
package pssimulation.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import pssimulation.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PssimulationFactoryImpl extends EFactoryImpl implements PssimulationFactory {
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static PssimulationFactory init() {
        try {
            PssimulationFactory thePssimulationFactory = (PssimulationFactory)EPackage.Registry.INSTANCE.getEFactory(PssimulationPackage.eNS_URI);
            if (thePssimulationFactory != null) {
                return thePssimulationFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new PssimulationFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PssimulationFactoryImpl() {
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
            case PssimulationPackage.PS_SIMULATION: return createPSSimulation();
            case PssimulationPackage.PS_INSTANCE: return createPSInstance();
            case PssimulationPackage.PS_COMUNICATION: return createPSComunication();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PSSimulation createPSSimulation() {
        PSSimulationImpl psSimulation = new PSSimulationImpl();
        return psSimulation;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PSInstance createPSInstance() {
        PSInstanceImpl psInstance = new PSInstanceImpl();
        return psInstance;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PSComunication createPSComunication() {
        PSComunicationImpl psComunication = new PSComunicationImpl();
        return psComunication;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PssimulationPackage getPssimulationPackage() {
        return (PssimulationPackage)getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static PssimulationPackage getPackage() {
        return PssimulationPackage.eINSTANCE;
    }

} //PssimulationFactoryImpl
