/**
 */
package pssimulation.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import pssimulation.PSHierarchy;
import pssimulation.PSInstance;
import pssimulation.PssimulationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PS Hierarchy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link pssimulation.impl.PSHierarchyImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link pssimulation.impl.PSHierarchyImpl#getChild <em>Child</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PSHierarchyImpl extends MinimalEObjectImpl.Container implements PSHierarchy {
    /**
     * The cached value of the '{@link #getParent() <em>Parent</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getParent()
     * @generated
     * @ordered
     */
    protected PSInstance parent;

    /**
     * The cached value of the '{@link #getChild() <em>Child</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getChild()
     * @generated
     * @ordered
     */
    protected PSInstance child;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected PSHierarchyImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return PssimulationPackage.Literals.PS_HIERARCHY;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PSInstance getParent() {
        if (parent != null && parent.eIsProxy()) {
            InternalEObject oldParent = (InternalEObject)parent;
            parent = (PSInstance)eResolveProxy(oldParent);
            if (parent != oldParent) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, PssimulationPackage.PS_HIERARCHY__PARENT, oldParent, parent));
            }
        }
        return parent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PSInstance basicGetParent() {
        return parent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setParent(PSInstance newParent) {
        PSInstance oldParent = parent;
        parent = newParent;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PssimulationPackage.PS_HIERARCHY__PARENT, oldParent, parent));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PSInstance getChild() {
        if (child != null && child.eIsProxy()) {
            InternalEObject oldChild = (InternalEObject)child;
            child = (PSInstance)eResolveProxy(oldChild);
            if (child != oldChild) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, PssimulationPackage.PS_HIERARCHY__CHILD, oldChild, child));
            }
        }
        return child;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PSInstance basicGetChild() {
        return child;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setChild(PSInstance newChild) {
        PSInstance oldChild = child;
        child = newChild;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PssimulationPackage.PS_HIERARCHY__CHILD, oldChild, child));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case PssimulationPackage.PS_HIERARCHY__PARENT:
                if (resolve) return getParent();
                return basicGetParent();
            case PssimulationPackage.PS_HIERARCHY__CHILD:
                if (resolve) return getChild();
                return basicGetChild();
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
            case PssimulationPackage.PS_HIERARCHY__PARENT:
                setParent((PSInstance)newValue);
                return;
            case PssimulationPackage.PS_HIERARCHY__CHILD:
                setChild((PSInstance)newValue);
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
            case PssimulationPackage.PS_HIERARCHY__PARENT:
                setParent((PSInstance)null);
                return;
            case PssimulationPackage.PS_HIERARCHY__CHILD:
                setChild((PSInstance)null);
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
            case PssimulationPackage.PS_HIERARCHY__PARENT:
                return parent != null;
            case PssimulationPackage.PS_HIERARCHY__CHILD:
                return child != null;
        }
        return super.eIsSet(featureID);
    }

} //PSHierarchyImpl
