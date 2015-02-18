/**
 */
package psplatform.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import psplatform.PSSingleBehaviour;
import psplatform.PSStart;
import psplatform.PsplatformPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PS Start</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link psplatform.impl.PSStartImpl#getOnInit <em>On Init</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PSStartImpl extends PSStateImpl implements PSStart {
    /**
     * The cached value of the '{@link #getOnInit() <em>On Init</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOnInit()
     * @generated
     * @ordered
     */
    protected PSSingleBehaviour onInit;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected PSStartImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return PsplatformPackage.Literals.PS_START;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PSSingleBehaviour getOnInit() {
        return onInit;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetOnInit(PSSingleBehaviour newOnInit, NotificationChain msgs) {
        PSSingleBehaviour oldOnInit = onInit;
        onInit = newOnInit;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PsplatformPackage.PS_START__ON_INIT, oldOnInit, newOnInit);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOnInit(PSSingleBehaviour newOnInit) {
        if (newOnInit != onInit) {
            NotificationChain msgs = null;
            if (onInit != null)
                msgs = ((InternalEObject)onInit).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PsplatformPackage.PS_START__ON_INIT, null, msgs);
            if (newOnInit != null)
                msgs = ((InternalEObject)newOnInit).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PsplatformPackage.PS_START__ON_INIT, null, msgs);
            msgs = basicSetOnInit(newOnInit, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PsplatformPackage.PS_START__ON_INIT, newOnInit, newOnInit));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case PsplatformPackage.PS_START__ON_INIT:
                return basicSetOnInit(null, msgs);
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
            case PsplatformPackage.PS_START__ON_INIT:
                return getOnInit();
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
            case PsplatformPackage.PS_START__ON_INIT:
                setOnInit((PSSingleBehaviour)newValue);
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
            case PsplatformPackage.PS_START__ON_INIT:
                setOnInit((PSSingleBehaviour)null);
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
            case PsplatformPackage.PS_START__ON_INIT:
                return onInit != null;
        }
        return super.eIsSet(featureID);
    }

} //PSStartImpl
