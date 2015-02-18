/**
 */
package psplatform.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import psplatform.PSBehaviour;
import psplatform.PsplatformPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PS Behaviour</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link psplatform.impl.PSBehaviourImpl#getOnAction <em>On Action</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PSBehaviourImpl extends MinimalEObjectImpl.Container implements PSBehaviour {
    /**
     * The default value of the '{@link #getOnAction() <em>On Action</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOnAction()
     * @generated
     * @ordered
     */
    protected static final String ON_ACTION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getOnAction() <em>On Action</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOnAction()
     * @generated
     * @ordered
     */
    protected String onAction = ON_ACTION_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected PSBehaviourImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return PsplatformPackage.Literals.PS_BEHAVIOUR;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getOnAction() {
        return onAction;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOnAction(String newOnAction) {
        String oldOnAction = onAction;
        onAction = newOnAction;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PsplatformPackage.PS_BEHAVIOUR__ON_ACTION, oldOnAction, onAction));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case PsplatformPackage.PS_BEHAVIOUR__ON_ACTION:
                return getOnAction();
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
            case PsplatformPackage.PS_BEHAVIOUR__ON_ACTION:
                setOnAction((String)newValue);
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
            case PsplatformPackage.PS_BEHAVIOUR__ON_ACTION:
                setOnAction(ON_ACTION_EDEFAULT);
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
            case PsplatformPackage.PS_BEHAVIOUR__ON_ACTION:
                return ON_ACTION_EDEFAULT == null ? onAction != null : !ON_ACTION_EDEFAULT.equals(onAction);
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
        result.append(" (onAction: ");
        result.append(onAction);
        result.append(')');
        return result.toString();
    }

} //PSBehaviourImpl
