/**
 */
package psplatform.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import psplatform.PSState;
import psplatform.PSTransition;
import psplatform.PsplatformPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PS Transition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link psplatform.impl.PSTransitionImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link psplatform.impl.PSTransitionImpl#getSource <em>Source</em>}</li>
 *   <li>{@link psplatform.impl.PSTransitionImpl#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PSTransitionImpl extends MinimalEObjectImpl.Container implements PSTransition {
    /**
     * The default value of the '{@link #getCondition() <em>Condition</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCondition()
     * @generated
     * @ordered
     */
    protected static final String CONDITION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getCondition() <em>Condition</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCondition()
     * @generated
     * @ordered
     */
    protected String condition = CONDITION_EDEFAULT;

    /**
     * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSource()
     * @generated
     * @ordered
     */
    protected PSState source;

    /**
     * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTarget()
     * @generated
     * @ordered
     */
    protected PSState target;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected PSTransitionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return PsplatformPackage.Literals.PS_TRANSITION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getCondition() {
        return condition;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCondition(String newCondition) {
        String oldCondition = condition;
        condition = newCondition;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PsplatformPackage.PS_TRANSITION__CONDITION, oldCondition, condition));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PSState getSource() {
        if (source != null && source.eIsProxy()) {
            InternalEObject oldSource = (InternalEObject)source;
            source = (PSState)eResolveProxy(oldSource);
            if (source != oldSource) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, PsplatformPackage.PS_TRANSITION__SOURCE, oldSource, source));
            }
        }
        return source;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PSState basicGetSource() {
        return source;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSource(PSState newSource) {
        PSState oldSource = source;
        source = newSource;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PsplatformPackage.PS_TRANSITION__SOURCE, oldSource, source));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PSState getTarget() {
        if (target != null && target.eIsProxy()) {
            InternalEObject oldTarget = (InternalEObject)target;
            target = (PSState)eResolveProxy(oldTarget);
            if (target != oldTarget) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, PsplatformPackage.PS_TRANSITION__TARGET, oldTarget, target));
            }
        }
        return target;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PSState basicGetTarget() {
        return target;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTarget(PSState newTarget) {
        PSState oldTarget = target;
        target = newTarget;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PsplatformPackage.PS_TRANSITION__TARGET, oldTarget, target));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case PsplatformPackage.PS_TRANSITION__CONDITION:
                return getCondition();
            case PsplatformPackage.PS_TRANSITION__SOURCE:
                if (resolve) return getSource();
                return basicGetSource();
            case PsplatformPackage.PS_TRANSITION__TARGET:
                if (resolve) return getTarget();
                return basicGetTarget();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case PsplatformPackage.PS_TRANSITION__CONDITION:
                setCondition((String)newValue);
                return;
            case PsplatformPackage.PS_TRANSITION__SOURCE:
                setSource((PSState)newValue);
                return;
            case PsplatformPackage.PS_TRANSITION__TARGET:
                setTarget((PSState)newValue);
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
            case PsplatformPackage.PS_TRANSITION__CONDITION:
                setCondition(CONDITION_EDEFAULT);
                return;
            case PsplatformPackage.PS_TRANSITION__SOURCE:
                setSource((PSState)null);
                return;
            case PsplatformPackage.PS_TRANSITION__TARGET:
                setTarget((PSState)null);
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
            case PsplatformPackage.PS_TRANSITION__CONDITION:
                return CONDITION_EDEFAULT == null ? condition != null : !CONDITION_EDEFAULT.equals(condition);
            case PsplatformPackage.PS_TRANSITION__SOURCE:
                return source != null;
            case PsplatformPackage.PS_TRANSITION__TARGET:
                return target != null;
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
        result.append(" (condition: ");
        result.append(condition);
        result.append(')');
        return result.toString();
    }

} //PSTransitionImpl
