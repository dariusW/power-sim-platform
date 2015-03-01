/**
 */
package pssimulation.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import pssimulation.PSComunication;
import pssimulation.PSInstance;
import pssimulation.PSSimulation;
import pssimulation.PssimulationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PS Simulation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link pssimulation.impl.PSSimulationImpl#getId <em>Id</em>}</li>
 *   <li>{@link pssimulation.impl.PSSimulationImpl#getElement <em>Element</em>}</li>
 *   <li>{@link pssimulation.impl.PSSimulationImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link pssimulation.impl.PSSimulationImpl#getRelations <em>Relations</em>}</li>
 *   <li>{@link pssimulation.impl.PSSimulationImpl#getName <em>Name</em>}</li>
 *   <li>{@link pssimulation.impl.PSSimulationImpl#getSimulationStep <em>Simulation Step</em>}</li>
 *   <li>{@link pssimulation.impl.PSSimulationImpl#getSimulationStartDate <em>Simulation Start Date</em>}</li>
 *   <li>{@link pssimulation.impl.PSSimulationImpl#getSimulationEndDate <em>Simulation End Date</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PSSimulationImpl extends MinimalEObjectImpl.Container implements PSSimulation {
    /**
     * The default value of the '{@link #getId() <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getId()
     * @generated
     * @ordered
     */
    protected static final String ID_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getId()
     * @generated
     * @ordered
     */
    protected String id = ID_EDEFAULT;

    /**
     * The cached value of the '{@link #getElement() <em>Element</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getElement()
     * @generated
     * @ordered
     */
    protected EList<PSInstance> element;

    /**
     * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDescription()
     * @generated
     * @ordered
     */
    protected static final String DESCRIPTION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDescription()
     * @generated
     * @ordered
     */
    protected String description = DESCRIPTION_EDEFAULT;

    /**
     * The cached value of the '{@link #getRelations() <em>Relations</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRelations()
     * @generated
     * @ordered
     */
    protected EList<PSComunication> relations;

    /**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected static final String NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected String name = NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getSimulationStep() <em>Simulation Step</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSimulationStep()
     * @generated
     * @ordered
     */
    protected static final String SIMULATION_STEP_EDEFAULT = "PT1M";

    /**
     * The cached value of the '{@link #getSimulationStep() <em>Simulation Step</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSimulationStep()
     * @generated
     * @ordered
     */
    protected String simulationStep = SIMULATION_STEP_EDEFAULT;

    /**
     * The default value of the '{@link #getSimulationStartDate() <em>Simulation Start Date</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSimulationStartDate()
     * @generated
     * @ordered
     */
    protected static final String SIMULATION_START_DATE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getSimulationStartDate() <em>Simulation Start Date</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSimulationStartDate()
     * @generated
     * @ordered
     */
    protected String simulationStartDate = SIMULATION_START_DATE_EDEFAULT;

    /**
     * The default value of the '{@link #getSimulationEndDate() <em>Simulation End Date</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSimulationEndDate()
     * @generated
     * @ordered
     */
    protected static final String SIMULATION_END_DATE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getSimulationEndDate() <em>Simulation End Date</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSimulationEndDate()
     * @generated
     * @ordered
     */
    protected String simulationEndDate = SIMULATION_END_DATE_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected PSSimulationImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return PssimulationPackage.Literals.PS_SIMULATION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getName() {
        return name;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setName(String newName) {
        String oldName = name;
        name = newName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PssimulationPackage.PS_SIMULATION__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getSimulationStep() {
        return simulationStep;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSimulationStep(String newSimulationStep) {
        String oldSimulationStep = simulationStep;
        simulationStep = newSimulationStep;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PssimulationPackage.PS_SIMULATION__SIMULATION_STEP, oldSimulationStep, simulationStep));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getSimulationStartDate() {
        return simulationStartDate;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSimulationStartDate(String newSimulationStartDate) {
        String oldSimulationStartDate = simulationStartDate;
        simulationStartDate = newSimulationStartDate;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PssimulationPackage.PS_SIMULATION__SIMULATION_START_DATE, oldSimulationStartDate, simulationStartDate));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getSimulationEndDate() {
        return simulationEndDate;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSimulationEndDate(String newSimulationEndDate) {
        String oldSimulationEndDate = simulationEndDate;
        simulationEndDate = newSimulationEndDate;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PssimulationPackage.PS_SIMULATION__SIMULATION_END_DATE, oldSimulationEndDate, simulationEndDate));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<PSInstance> getElement() {
        if (element == null) {
            element = new EObjectContainmentEList<PSInstance>(PSInstance.class, this, PssimulationPackage.PS_SIMULATION__ELEMENT);
        }
        return element;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getDescription() {
        return description;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDescription(String newDescription) {
        String oldDescription = description;
        description = newDescription;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PssimulationPackage.PS_SIMULATION__DESCRIPTION, oldDescription, description));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getId() {
        return id;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setId(String newId) {
        String oldId = id;
        id = newId;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PssimulationPackage.PS_SIMULATION__ID, oldId, id));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<PSComunication> getRelations() {
        if (relations == null) {
            relations = new EObjectContainmentEList<PSComunication>(PSComunication.class, this, PssimulationPackage.PS_SIMULATION__RELATIONS);
        }
        return relations;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case PssimulationPackage.PS_SIMULATION__ELEMENT:
                return ((InternalEList<?>)getElement()).basicRemove(otherEnd, msgs);
            case PssimulationPackage.PS_SIMULATION__RELATIONS:
                return ((InternalEList<?>)getRelations()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case PssimulationPackage.PS_SIMULATION__ID:
                return getId();
            case PssimulationPackage.PS_SIMULATION__ELEMENT:
                return getElement();
            case PssimulationPackage.PS_SIMULATION__DESCRIPTION:
                return getDescription();
            case PssimulationPackage.PS_SIMULATION__RELATIONS:
                return getRelations();
            case PssimulationPackage.PS_SIMULATION__NAME:
                return getName();
            case PssimulationPackage.PS_SIMULATION__SIMULATION_STEP:
                return getSimulationStep();
            case PssimulationPackage.PS_SIMULATION__SIMULATION_START_DATE:
                return getSimulationStartDate();
            case PssimulationPackage.PS_SIMULATION__SIMULATION_END_DATE:
                return getSimulationEndDate();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case PssimulationPackage.PS_SIMULATION__ID:
                setId((String)newValue);
                return;
            case PssimulationPackage.PS_SIMULATION__ELEMENT:
                getElement().clear();
                getElement().addAll((Collection<? extends PSInstance>)newValue);
                return;
            case PssimulationPackage.PS_SIMULATION__DESCRIPTION:
                setDescription((String)newValue);
                return;
            case PssimulationPackage.PS_SIMULATION__RELATIONS:
                getRelations().clear();
                getRelations().addAll((Collection<? extends PSComunication>)newValue);
                return;
            case PssimulationPackage.PS_SIMULATION__NAME:
                setName((String)newValue);
                return;
            case PssimulationPackage.PS_SIMULATION__SIMULATION_STEP:
                setSimulationStep((String)newValue);
                return;
            case PssimulationPackage.PS_SIMULATION__SIMULATION_START_DATE:
                setSimulationStartDate((String)newValue);
                return;
            case PssimulationPackage.PS_SIMULATION__SIMULATION_END_DATE:
                setSimulationEndDate((String)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case PssimulationPackage.PS_SIMULATION__ID:
                setId(ID_EDEFAULT);
                return;
            case PssimulationPackage.PS_SIMULATION__ELEMENT:
                getElement().clear();
                return;
            case PssimulationPackage.PS_SIMULATION__DESCRIPTION:
                setDescription(DESCRIPTION_EDEFAULT);
                return;
            case PssimulationPackage.PS_SIMULATION__RELATIONS:
                getRelations().clear();
                return;
            case PssimulationPackage.PS_SIMULATION__NAME:
                setName(NAME_EDEFAULT);
                return;
            case PssimulationPackage.PS_SIMULATION__SIMULATION_STEP:
                setSimulationStep(SIMULATION_STEP_EDEFAULT);
                return;
            case PssimulationPackage.PS_SIMULATION__SIMULATION_START_DATE:
                setSimulationStartDate(SIMULATION_START_DATE_EDEFAULT);
                return;
            case PssimulationPackage.PS_SIMULATION__SIMULATION_END_DATE:
                setSimulationEndDate(SIMULATION_END_DATE_EDEFAULT);
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case PssimulationPackage.PS_SIMULATION__ID:
                return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
            case PssimulationPackage.PS_SIMULATION__ELEMENT:
                return element != null && !element.isEmpty();
            case PssimulationPackage.PS_SIMULATION__DESCRIPTION:
                return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
            case PssimulationPackage.PS_SIMULATION__RELATIONS:
                return relations != null && !relations.isEmpty();
            case PssimulationPackage.PS_SIMULATION__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case PssimulationPackage.PS_SIMULATION__SIMULATION_STEP:
                return SIMULATION_STEP_EDEFAULT == null ? simulationStep != null : !SIMULATION_STEP_EDEFAULT.equals(simulationStep);
            case PssimulationPackage.PS_SIMULATION__SIMULATION_START_DATE:
                return SIMULATION_START_DATE_EDEFAULT == null ? simulationStartDate != null : !SIMULATION_START_DATE_EDEFAULT.equals(simulationStartDate);
            case PssimulationPackage.PS_SIMULATION__SIMULATION_END_DATE:
                return SIMULATION_END_DATE_EDEFAULT == null ? simulationEndDate != null : !SIMULATION_END_DATE_EDEFAULT.equals(simulationEndDate);
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (id: ");
        result.append(id);
        result.append(", description: ");
        result.append(description);
        result.append(", name: ");
        result.append(name);
        result.append(", simulationStep: ");
        result.append(simulationStep);
        result.append(", simulationStartDate: ");
        result.append(simulationStartDate);
        result.append(", simulationEndDate: ");
        result.append(simulationEndDate);
        result.append(')');
        return result.toString();
    }

} //PSSimulationImpl
