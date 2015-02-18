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

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import psplatform.PSAgent;
import psplatform.PSStart;
import psplatform.PSState;
import psplatform.PSTransition;
import psplatform.PSVariable;
import psplatform.PsplatformPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PS Agent</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link psplatform.impl.PSAgentImpl#getStart <em>Start</em>}</li>
 *   <li>{@link psplatform.impl.PSAgentImpl#getStates <em>States</em>}</li>
 *   <li>{@link psplatform.impl.PSAgentImpl#getTransactions <em>Transactions</em>}</li>
 *   <li>{@link psplatform.impl.PSAgentImpl#getPackage <em>Package</em>}</li>
 *   <li>{@link psplatform.impl.PSAgentImpl#getId <em>Id</em>}</li>
 *   <li>{@link psplatform.impl.PSAgentImpl#getName <em>Name</em>}</li>
 *   <li>{@link psplatform.impl.PSAgentImpl#getVariables <em>Variables</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PSAgentImpl extends MinimalEObjectImpl.Container implements PSAgent {
    /**
     * The cached value of the '{@link #getStart() <em>Start</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getStart()
     * @generated
     * @ordered
     */
    protected PSStart start;

    /**
     * The cached value of the '{@link #getStates() <em>States</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getStates()
     * @generated
     * @ordered
     */
    protected EList<PSState> states;

    /**
     * The cached value of the '{@link #getTransactions() <em>Transactions</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTransactions()
     * @generated
     * @ordered
     */
    protected EList<PSTransition> transactions;

    /**
     * The default value of the '{@link #getPackage() <em>Package</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPackage()
     * @generated
     * @ordered
     */
    protected static final String PACKAGE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getPackage() <em>Package</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPackage()
     * @generated
     * @ordered
     */
    protected String package_ = PACKAGE_EDEFAULT;

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
     * The cached value of the '{@link #getVariables() <em>Variables</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getVariables()
     * @generated
     * @ordered
     */
    protected EList<PSVariable> variables;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected PSAgentImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return PsplatformPackage.Literals.PS_AGENT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PSStart getStart() {
        return start;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetStart(PSStart newStart, NotificationChain msgs) {
        PSStart oldStart = start;
        start = newStart;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PsplatformPackage.PS_AGENT__START, oldStart, newStart);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setStart(PSStart newStart) {
        if (newStart != start) {
            NotificationChain msgs = null;
            if (start != null)
                msgs = ((InternalEObject)start).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PsplatformPackage.PS_AGENT__START, null, msgs);
            if (newStart != null)
                msgs = ((InternalEObject)newStart).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PsplatformPackage.PS_AGENT__START, null, msgs);
            msgs = basicSetStart(newStart, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PsplatformPackage.PS_AGENT__START, newStart, newStart));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<PSState> getStates() {
        if (states == null) {
            states = new EObjectContainmentEList<PSState>(PSState.class, this, PsplatformPackage.PS_AGENT__STATES);
        }
        return states;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<PSTransition> getTransactions() {
        if (transactions == null) {
            transactions = new EObjectContainmentEList<PSTransition>(PSTransition.class, this, PsplatformPackage.PS_AGENT__TRANSACTIONS);
        }
        return transactions;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getPackage() {
        return package_;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPackage(String newPackage) {
        String oldPackage = package_;
        package_ = newPackage;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PsplatformPackage.PS_AGENT__PACKAGE, oldPackage, package_));
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
            eNotify(new ENotificationImpl(this, Notification.SET, PsplatformPackage.PS_AGENT__ID, oldId, id));
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
            eNotify(new ENotificationImpl(this, Notification.SET, PsplatformPackage.PS_AGENT__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<PSVariable> getVariables() {
        if (variables == null) {
            variables = new EObjectContainmentEList<PSVariable>(PSVariable.class, this, PsplatformPackage.PS_AGENT__VARIABLES);
        }
        return variables;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case PsplatformPackage.PS_AGENT__START:
                return basicSetStart(null, msgs);
            case PsplatformPackage.PS_AGENT__STATES:
                return ((InternalEList<?>)getStates()).basicRemove(otherEnd, msgs);
            case PsplatformPackage.PS_AGENT__TRANSACTIONS:
                return ((InternalEList<?>)getTransactions()).basicRemove(otherEnd, msgs);
            case PsplatformPackage.PS_AGENT__VARIABLES:
                return ((InternalEList<?>)getVariables()).basicRemove(otherEnd, msgs);
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
            case PsplatformPackage.PS_AGENT__START:
                return getStart();
            case PsplatformPackage.PS_AGENT__STATES:
                return getStates();
            case PsplatformPackage.PS_AGENT__TRANSACTIONS:
                return getTransactions();
            case PsplatformPackage.PS_AGENT__PACKAGE:
                return getPackage();
            case PsplatformPackage.PS_AGENT__ID:
                return getId();
            case PsplatformPackage.PS_AGENT__NAME:
                return getName();
            case PsplatformPackage.PS_AGENT__VARIABLES:
                return getVariables();
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
            case PsplatformPackage.PS_AGENT__START:
                setStart((PSStart)newValue);
                return;
            case PsplatformPackage.PS_AGENT__STATES:
                getStates().clear();
                getStates().addAll((Collection<? extends PSState>)newValue);
                return;
            case PsplatformPackage.PS_AGENT__TRANSACTIONS:
                getTransactions().clear();
                getTransactions().addAll((Collection<? extends PSTransition>)newValue);
                return;
            case PsplatformPackage.PS_AGENT__PACKAGE:
                setPackage((String)newValue);
                return;
            case PsplatformPackage.PS_AGENT__ID:
                setId((String)newValue);
                return;
            case PsplatformPackage.PS_AGENT__NAME:
                setName((String)newValue);
                return;
            case PsplatformPackage.PS_AGENT__VARIABLES:
                getVariables().clear();
                getVariables().addAll((Collection<? extends PSVariable>)newValue);
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
            case PsplatformPackage.PS_AGENT__START:
                setStart((PSStart)null);
                return;
            case PsplatformPackage.PS_AGENT__STATES:
                getStates().clear();
                return;
            case PsplatformPackage.PS_AGENT__TRANSACTIONS:
                getTransactions().clear();
                return;
            case PsplatformPackage.PS_AGENT__PACKAGE:
                setPackage(PACKAGE_EDEFAULT);
                return;
            case PsplatformPackage.PS_AGENT__ID:
                setId(ID_EDEFAULT);
                return;
            case PsplatformPackage.PS_AGENT__NAME:
                setName(NAME_EDEFAULT);
                return;
            case PsplatformPackage.PS_AGENT__VARIABLES:
                getVariables().clear();
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
            case PsplatformPackage.PS_AGENT__START:
                return start != null;
            case PsplatformPackage.PS_AGENT__STATES:
                return states != null && !states.isEmpty();
            case PsplatformPackage.PS_AGENT__TRANSACTIONS:
                return transactions != null && !transactions.isEmpty();
            case PsplatformPackage.PS_AGENT__PACKAGE:
                return PACKAGE_EDEFAULT == null ? package_ != null : !PACKAGE_EDEFAULT.equals(package_);
            case PsplatformPackage.PS_AGENT__ID:
                return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
            case PsplatformPackage.PS_AGENT__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case PsplatformPackage.PS_AGENT__VARIABLES:
                return variables != null && !variables.isEmpty();
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
        result.append(" (package: ");
        result.append(package_);
        result.append(", id: ");
        result.append(id);
        result.append(", name: ");
        result.append(name);
        result.append(')');
        return result.toString();
    }

} //PSAgentImpl
