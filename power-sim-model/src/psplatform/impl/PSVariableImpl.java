/**
 */
package psplatform.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import psplatform.PSVariable;
import psplatform.PSVariableScope;
import psplatform.PSVariableType;
import psplatform.PsplatformPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PS Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link psplatform.impl.PSVariableImpl#getType <em>Type</em>}</li>
 *   <li>{@link psplatform.impl.PSVariableImpl#getScope <em>Scope</em>}</li>
 *   <li>{@link psplatform.impl.PSVariableImpl#getKey <em>Key</em>}</li>
 *   <li>{@link psplatform.impl.PSVariableImpl#getValue <em>Value</em>}</li>
 *   <li>{@link psplatform.impl.PSVariableImpl#getDefault <em>Default</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PSVariableImpl extends MinimalEObjectImpl.Container implements PSVariable {
    /**
     * The default value of the '{@link #getType() <em>Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getType()
     * @generated
     * @ordered
     */
    protected static final PSVariableType TYPE_EDEFAULT = PSVariableType.DATE;

    /**
     * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getType()
     * @generated
     * @ordered
     */
    protected PSVariableType type = TYPE_EDEFAULT;

    /**
     * The default value of the '{@link #getScope() <em>Scope</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getScope()
     * @generated
     * @ordered
     */
    protected static final PSVariableScope SCOPE_EDEFAULT = PSVariableScope.EXTERNAL;

    /**
     * The cached value of the '{@link #getScope() <em>Scope</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getScope()
     * @generated
     * @ordered
     */
    protected PSVariableScope scope = SCOPE_EDEFAULT;

    /**
     * The default value of the '{@link #getKey() <em>Key</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getKey()
     * @generated
     * @ordered
     */
    protected static final String KEY_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getKey() <em>Key</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getKey()
     * @generated
     * @ordered
     */
    protected String key = KEY_EDEFAULT;

    /**
     * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getValue()
     * @generated
     * @ordered
     */
    protected static final Object VALUE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getValue()
     * @generated
     * @ordered
     */
    protected Object value = VALUE_EDEFAULT;

    /**
     * The default value of the '{@link #getDefault() <em>Default</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDefault()
     * @generated
     * @ordered
     */
    protected static final Object DEFAULT_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDefault() <em>Default</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDefault()
     * @generated
     * @ordered
     */
    protected Object default_ = DEFAULT_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected PSVariableImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return PsplatformPackage.Literals.PS_VARIABLE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PSVariableType getType() {
        return type;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setType(PSVariableType newType) {
        PSVariableType oldType = type;
        type = newType == null ? TYPE_EDEFAULT : newType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PsplatformPackage.PS_VARIABLE__TYPE, oldType, type));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PSVariableScope getScope() {
        return scope;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setScope(PSVariableScope newScope) {
        PSVariableScope oldScope = scope;
        scope = newScope == null ? SCOPE_EDEFAULT : newScope;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PsplatformPackage.PS_VARIABLE__SCOPE, oldScope, scope));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getKey() {
        return key;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setKey(String newKey) {
        String oldKey = key;
        key = newKey;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PsplatformPackage.PS_VARIABLE__KEY, oldKey, key));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Object getValue() {
        return value;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setValue(Object newValue) {
        Object oldValue = value;
        value = newValue;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PsplatformPackage.PS_VARIABLE__VALUE, oldValue, value));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Object getDefault() {
        return default_;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDefault(Object newDefault) {
        Object oldDefault = default_;
        default_ = newDefault;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PsplatformPackage.PS_VARIABLE__DEFAULT, oldDefault, default_));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case PsplatformPackage.PS_VARIABLE__TYPE:
                return getType();
            case PsplatformPackage.PS_VARIABLE__SCOPE:
                return getScope();
            case PsplatformPackage.PS_VARIABLE__KEY:
                return getKey();
            case PsplatformPackage.PS_VARIABLE__VALUE:
                return getValue();
            case PsplatformPackage.PS_VARIABLE__DEFAULT:
                return getDefault();
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
            case PsplatformPackage.PS_VARIABLE__TYPE:
                setType((PSVariableType)newValue);
                return;
            case PsplatformPackage.PS_VARIABLE__SCOPE:
                setScope((PSVariableScope)newValue);
                return;
            case PsplatformPackage.PS_VARIABLE__KEY:
                setKey((String)newValue);
                return;
            case PsplatformPackage.PS_VARIABLE__VALUE:
                setValue(newValue);
                return;
            case PsplatformPackage.PS_VARIABLE__DEFAULT:
                setDefault(newValue);
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
            case PsplatformPackage.PS_VARIABLE__TYPE:
                setType(TYPE_EDEFAULT);
                return;
            case PsplatformPackage.PS_VARIABLE__SCOPE:
                setScope(SCOPE_EDEFAULT);
                return;
            case PsplatformPackage.PS_VARIABLE__KEY:
                setKey(KEY_EDEFAULT);
                return;
            case PsplatformPackage.PS_VARIABLE__VALUE:
                setValue(VALUE_EDEFAULT);
                return;
            case PsplatformPackage.PS_VARIABLE__DEFAULT:
                setDefault(DEFAULT_EDEFAULT);
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
            case PsplatformPackage.PS_VARIABLE__TYPE:
                return type != TYPE_EDEFAULT;
            case PsplatformPackage.PS_VARIABLE__SCOPE:
                return scope != SCOPE_EDEFAULT;
            case PsplatformPackage.PS_VARIABLE__KEY:
                return KEY_EDEFAULT == null ? key != null : !KEY_EDEFAULT.equals(key);
            case PsplatformPackage.PS_VARIABLE__VALUE:
                return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
            case PsplatformPackage.PS_VARIABLE__DEFAULT:
                return DEFAULT_EDEFAULT == null ? default_ != null : !DEFAULT_EDEFAULT.equals(default_);
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
        result.append(" (type: ");
        result.append(type);
        result.append(", scope: ");
        result.append(scope);
        result.append(", key: ");
        result.append(key);
        result.append(", value: ");
        result.append(value);
        result.append(", default: ");
        result.append(default_);
        result.append(')');
        return result.toString();
    }

} //PSVariableImpl
