/**
 */
package pssimulation.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import pssimulation.PSComunication;
import pssimulation.PSInstance;
import pssimulation.PssimulationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PS Comunication</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link pssimulation.impl.PSComunicationImpl#getBegin <em>Begin</em>}</li>
 *   <li>{@link pssimulation.impl.PSComunicationImpl#getEnd <em>End</em>}</li>
 *   <li>{@link pssimulation.impl.PSComunicationImpl#getPublicVariable <em>Public Variable</em>}</li>
 *   <li>{@link pssimulation.impl.PSComunicationImpl#getExernalVariable <em>Exernal Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PSComunicationImpl extends MinimalEObjectImpl.Container implements PSComunication {
    /**
     * The cached value of the '{@link #getBegin() <em>Begin</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBegin()
     * @generated
     * @ordered
     */
    protected PSInstance begin;

    /**
     * The cached value of the '{@link #getEnd() <em>End</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEnd()
     * @generated
     * @ordered
     */
    protected PSInstance end;

    /**
     * The default value of the '{@link #getPublicVariable() <em>Public Variable</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPublicVariable()
     * @generated
     * @ordered
     */
    protected static final String PUBLIC_VARIABLE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getPublicVariable() <em>Public Variable</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPublicVariable()
     * @generated
     * @ordered
     */
    protected String publicVariable = PUBLIC_VARIABLE_EDEFAULT;

    /**
     * The default value of the '{@link #getExernalVariable() <em>Exernal Variable</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getExernalVariable()
     * @generated
     * @ordered
     */
    protected static final String EXERNAL_VARIABLE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getExernalVariable() <em>Exernal Variable</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getExernalVariable()
     * @generated
     * @ordered
     */
    protected String exernalVariable = EXERNAL_VARIABLE_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected PSComunicationImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return PssimulationPackage.Literals.PS_COMUNICATION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PSInstance getBegin() {
        if (begin != null && begin.eIsProxy()) {
            InternalEObject oldBegin = (InternalEObject)begin;
            begin = (PSInstance)eResolveProxy(oldBegin);
            if (begin != oldBegin) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, PssimulationPackage.PS_COMUNICATION__BEGIN, oldBegin, begin));
            }
        }
        return begin;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PSInstance basicGetBegin() {
        return begin;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setBegin(PSInstance newBegin) {
        PSInstance oldBegin = begin;
        begin = newBegin;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PssimulationPackage.PS_COMUNICATION__BEGIN, oldBegin, begin));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PSInstance getEnd() {
        if (end != null && end.eIsProxy()) {
            InternalEObject oldEnd = (InternalEObject)end;
            end = (PSInstance)eResolveProxy(oldEnd);
            if (end != oldEnd) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, PssimulationPackage.PS_COMUNICATION__END, oldEnd, end));
            }
        }
        return end;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PSInstance basicGetEnd() {
        return end;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setEnd(PSInstance newEnd) {
        PSInstance oldEnd = end;
        end = newEnd;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PssimulationPackage.PS_COMUNICATION__END, oldEnd, end));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getPublicVariable() {
        return publicVariable;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPublicVariable(String newPublicVariable) {
        String oldPublicVariable = publicVariable;
        publicVariable = newPublicVariable;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PssimulationPackage.PS_COMUNICATION__PUBLIC_VARIABLE, oldPublicVariable, publicVariable));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getExernalVariable() {
        return exernalVariable;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setExernalVariable(String newExernalVariable) {
        String oldExernalVariable = exernalVariable;
        exernalVariable = newExernalVariable;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PssimulationPackage.PS_COMUNICATION__EXERNAL_VARIABLE, oldExernalVariable, exernalVariable));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case PssimulationPackage.PS_COMUNICATION__BEGIN:
                if (resolve) return getBegin();
                return basicGetBegin();
            case PssimulationPackage.PS_COMUNICATION__END:
                if (resolve) return getEnd();
                return basicGetEnd();
            case PssimulationPackage.PS_COMUNICATION__PUBLIC_VARIABLE:
                return getPublicVariable();
            case PssimulationPackage.PS_COMUNICATION__EXERNAL_VARIABLE:
                return getExernalVariable();
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
            case PssimulationPackage.PS_COMUNICATION__BEGIN:
                setBegin((PSInstance)newValue);
                return;
            case PssimulationPackage.PS_COMUNICATION__END:
                setEnd((PSInstance)newValue);
                return;
            case PssimulationPackage.PS_COMUNICATION__PUBLIC_VARIABLE:
                setPublicVariable((String)newValue);
                return;
            case PssimulationPackage.PS_COMUNICATION__EXERNAL_VARIABLE:
                setExernalVariable((String)newValue);
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
            case PssimulationPackage.PS_COMUNICATION__BEGIN:
                setBegin((PSInstance)null);
                return;
            case PssimulationPackage.PS_COMUNICATION__END:
                setEnd((PSInstance)null);
                return;
            case PssimulationPackage.PS_COMUNICATION__PUBLIC_VARIABLE:
                setPublicVariable(PUBLIC_VARIABLE_EDEFAULT);
                return;
            case PssimulationPackage.PS_COMUNICATION__EXERNAL_VARIABLE:
                setExernalVariable(EXERNAL_VARIABLE_EDEFAULT);
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
            case PssimulationPackage.PS_COMUNICATION__BEGIN:
                return begin != null;
            case PssimulationPackage.PS_COMUNICATION__END:
                return end != null;
            case PssimulationPackage.PS_COMUNICATION__PUBLIC_VARIABLE:
                return PUBLIC_VARIABLE_EDEFAULT == null ? publicVariable != null : !PUBLIC_VARIABLE_EDEFAULT.equals(publicVariable);
            case PssimulationPackage.PS_COMUNICATION__EXERNAL_VARIABLE:
                return EXERNAL_VARIABLE_EDEFAULT == null ? exernalVariable != null : !EXERNAL_VARIABLE_EDEFAULT.equals(exernalVariable);
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
        result.append(" (publicVariable: ");
        result.append(publicVariable);
        result.append(", exernalVariable: ");
        result.append(exernalVariable);
        result.append(')');
        return result.toString();
    }

} //PSComunicationImpl
