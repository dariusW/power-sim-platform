/**
 */
package psplatform.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import psplatform.PSContinuousBehaviour;
import psplatform.PSSingleBehaviour;
import psplatform.PSState;
import psplatform.PSTransition;
import psplatform.PsplatformPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PS State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link psplatform.impl.PSStateImpl#getName <em>Name</em>}</li>
 *   <li>{@link psplatform.impl.PSStateImpl#getTransitions <em>Transitions</em>}</li>
 *   <li>{@link psplatform.impl.PSStateImpl#getOnStep <em>On Step</em>}</li>
 *   <li>{@link psplatform.impl.PSStateImpl#getOnEntry <em>On Entry</em>}</li>
 *   <li>{@link psplatform.impl.PSStateImpl#getOnExit <em>On Exit</em>}</li>
 *   <li>{@link psplatform.impl.PSStateImpl#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PSStateImpl extends MinimalEObjectImpl.Container implements PSState {
    /**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected static final String NAME_EDEFAULT = "New State";

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
     * The cached value of the '{@link #getTransitions() <em>Transitions</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTransitions()
     * @generated
     * @ordered
     */
    protected EList<PSTransition> transitions;

    /**
     * The cached value of the '{@link #getOnStep() <em>On Step</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOnStep()
     * @generated
     * @ordered
     */
    protected PSContinuousBehaviour onStep;

    /**
     * The cached value of the '{@link #getOnEntry() <em>On Entry</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOnEntry()
     * @generated
     * @ordered
     */
    protected PSSingleBehaviour onEntry;

    /**
     * The cached value of the '{@link #getOnExit() <em>On Exit</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOnExit()
     * @generated
     * @ordered
     */
    protected PSSingleBehaviour onExit;

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
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected PSStateImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return PsplatformPackage.Literals.PS_STATE;
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
            eNotify(new ENotificationImpl(this, Notification.SET, PsplatformPackage.PS_STATE__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<PSTransition> getTransitions() {
        if (transitions == null) {
            transitions = new EObjectResolvingEList<PSTransition>(PSTransition.class, this, PsplatformPackage.PS_STATE__TRANSITIONS);
        }
        return transitions;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PSContinuousBehaviour getOnStep() {
        return onStep;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetOnStep(PSContinuousBehaviour newOnStep, NotificationChain msgs) {
        PSContinuousBehaviour oldOnStep = onStep;
        onStep = newOnStep;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PsplatformPackage.PS_STATE__ON_STEP, oldOnStep, newOnStep);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOnStep(PSContinuousBehaviour newOnStep) {
        if (newOnStep != onStep) {
            NotificationChain msgs = null;
            if (onStep != null)
                msgs = ((InternalEObject)onStep).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PsplatformPackage.PS_STATE__ON_STEP, null, msgs);
            if (newOnStep != null)
                msgs = ((InternalEObject)newOnStep).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PsplatformPackage.PS_STATE__ON_STEP, null, msgs);
            msgs = basicSetOnStep(newOnStep, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PsplatformPackage.PS_STATE__ON_STEP, newOnStep, newOnStep));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PSSingleBehaviour getOnEntry() {
        return onEntry;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetOnEntry(PSSingleBehaviour newOnEntry, NotificationChain msgs) {
        PSSingleBehaviour oldOnEntry = onEntry;
        onEntry = newOnEntry;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PsplatformPackage.PS_STATE__ON_ENTRY, oldOnEntry, newOnEntry);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOnEntry(PSSingleBehaviour newOnEntry) {
        if (newOnEntry != onEntry) {
            NotificationChain msgs = null;
            if (onEntry != null)
                msgs = ((InternalEObject)onEntry).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PsplatformPackage.PS_STATE__ON_ENTRY, null, msgs);
            if (newOnEntry != null)
                msgs = ((InternalEObject)newOnEntry).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PsplatformPackage.PS_STATE__ON_ENTRY, null, msgs);
            msgs = basicSetOnEntry(newOnEntry, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PsplatformPackage.PS_STATE__ON_ENTRY, newOnEntry, newOnEntry));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PSSingleBehaviour getOnExit() {
        return onExit;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetOnExit(PSSingleBehaviour newOnExit, NotificationChain msgs) {
        PSSingleBehaviour oldOnExit = onExit;
        onExit = newOnExit;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PsplatformPackage.PS_STATE__ON_EXIT, oldOnExit, newOnExit);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOnExit(PSSingleBehaviour newOnExit) {
        if (newOnExit != onExit) {
            NotificationChain msgs = null;
            if (onExit != null)
                msgs = ((InternalEObject)onExit).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PsplatformPackage.PS_STATE__ON_EXIT, null, msgs);
            if (newOnExit != null)
                msgs = ((InternalEObject)newOnExit).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PsplatformPackage.PS_STATE__ON_EXIT, null, msgs);
            msgs = basicSetOnExit(newOnExit, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PsplatformPackage.PS_STATE__ON_EXIT, newOnExit, newOnExit));
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
            eNotify(new ENotificationImpl(this, Notification.SET, PsplatformPackage.PS_STATE__ID, oldId, id));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case PsplatformPackage.PS_STATE__ON_STEP:
                return basicSetOnStep(null, msgs);
            case PsplatformPackage.PS_STATE__ON_ENTRY:
                return basicSetOnEntry(null, msgs);
            case PsplatformPackage.PS_STATE__ON_EXIT:
                return basicSetOnExit(null, msgs);
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
            case PsplatformPackage.PS_STATE__NAME:
                return getName();
            case PsplatformPackage.PS_STATE__TRANSITIONS:
                return getTransitions();
            case PsplatformPackage.PS_STATE__ON_STEP:
                return getOnStep();
            case PsplatformPackage.PS_STATE__ON_ENTRY:
                return getOnEntry();
            case PsplatformPackage.PS_STATE__ON_EXIT:
                return getOnExit();
            case PsplatformPackage.PS_STATE__ID:
                return getId();
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
            case PsplatformPackage.PS_STATE__NAME:
                setName((String)newValue);
                return;
            case PsplatformPackage.PS_STATE__TRANSITIONS:
                getTransitions().clear();
                getTransitions().addAll((Collection<? extends PSTransition>)newValue);
                return;
            case PsplatformPackage.PS_STATE__ON_STEP:
                setOnStep((PSContinuousBehaviour)newValue);
                return;
            case PsplatformPackage.PS_STATE__ON_ENTRY:
                setOnEntry((PSSingleBehaviour)newValue);
                return;
            case PsplatformPackage.PS_STATE__ON_EXIT:
                setOnExit((PSSingleBehaviour)newValue);
                return;
            case PsplatformPackage.PS_STATE__ID:
                setId((String)newValue);
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
            case PsplatformPackage.PS_STATE__NAME:
                setName(NAME_EDEFAULT);
                return;
            case PsplatformPackage.PS_STATE__TRANSITIONS:
                getTransitions().clear();
                return;
            case PsplatformPackage.PS_STATE__ON_STEP:
                setOnStep((PSContinuousBehaviour)null);
                return;
            case PsplatformPackage.PS_STATE__ON_ENTRY:
                setOnEntry((PSSingleBehaviour)null);
                return;
            case PsplatformPackage.PS_STATE__ON_EXIT:
                setOnExit((PSSingleBehaviour)null);
                return;
            case PsplatformPackage.PS_STATE__ID:
                setId(ID_EDEFAULT);
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
            case PsplatformPackage.PS_STATE__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case PsplatformPackage.PS_STATE__TRANSITIONS:
                return transitions != null && !transitions.isEmpty();
            case PsplatformPackage.PS_STATE__ON_STEP:
                return onStep != null;
            case PsplatformPackage.PS_STATE__ON_ENTRY:
                return onEntry != null;
            case PsplatformPackage.PS_STATE__ON_EXIT:
                return onExit != null;
            case PsplatformPackage.PS_STATE__ID:
                return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
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
        result.append(" (name: ");
        result.append(name);
        result.append(", id: ");
        result.append(id);
        result.append(')');
        return result.toString();
    }

} //PSStateImpl
