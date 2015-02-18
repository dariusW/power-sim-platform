/**
 */
package pssimulation.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import pssimulation.PSComunication;
import pssimulation.PSHierarchy;
import pssimulation.PSInstance;
import pssimulation.PssimulationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PS Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link pssimulation.impl.PSInstanceImpl#getId <em>Id</em>}</li>
 *   <li>{@link pssimulation.impl.PSInstanceImpl#getInitBehaviour <em>Init Behaviour</em>}</li>
 *   <li>{@link pssimulation.impl.PSInstanceImpl#getModelClass <em>Model Class</em>}</li>
 *   <li>{@link pssimulation.impl.PSInstanceImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link pssimulation.impl.PSInstanceImpl#getChildren <em>Children</em>}</li>
 *   <li>{@link pssimulation.impl.PSInstanceImpl#getModelPath <em>Model Path</em>}</li>
 *   <li>{@link pssimulation.impl.PSInstanceImpl#getName <em>Name</em>}</li>
 *   <li>{@link pssimulation.impl.PSInstanceImpl#getIncomingConnections <em>Incoming Connections</em>}</li>
 *   <li>{@link pssimulation.impl.PSInstanceImpl#getOutgoingConnections <em>Outgoing Connections</em>}</li>
 *   <li>{@link pssimulation.impl.PSInstanceImpl#getSuperinstance <em>Superinstance</em>}</li>
 *   <li>{@link pssimulation.impl.PSInstanceImpl#getSubinstance <em>Subinstance</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PSInstanceImpl extends MinimalEObjectImpl.Container implements PSInstance {
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
     * The default value of the '{@link #getInitBehaviour() <em>Init Behaviour</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInitBehaviour()
     * @generated
     * @ordered
     */
    protected static final String INIT_BEHAVIOUR_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getInitBehaviour() <em>Init Behaviour</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInitBehaviour()
     * @generated
     * @ordered
     */
    protected String initBehaviour = INIT_BEHAVIOUR_EDEFAULT;

    /**
     * The default value of the '{@link #getModelClass() <em>Model Class</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getModelClass()
     * @generated
     * @ordered
     */
    protected static final String MODEL_CLASS_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getModelClass() <em>Model Class</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getModelClass()
     * @generated
     * @ordered
     */
    protected String modelClass = MODEL_CLASS_EDEFAULT;

    /**
     * The cached value of the '{@link #getParent() <em>Parent</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getParent()
     * @generated
     * @ordered
     */
    protected PSHierarchy parent;

    /**
     * The cached value of the '{@link #getChildren() <em>Children</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getChildren()
     * @generated
     * @ordered
     */
    protected EList<PSHierarchy> children;

    /**
     * The default value of the '{@link #getModelPath() <em>Model Path</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getModelPath()
     * @generated
     * @ordered
     */
    protected static final String MODEL_PATH_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getModelPath() <em>Model Path</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getModelPath()
     * @generated
     * @ordered
     */
    protected String modelPath = MODEL_PATH_EDEFAULT;

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
     * The cached value of the '{@link #getIncomingConnections() <em>Incoming Connections</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getIncomingConnections()
     * @generated
     * @ordered
     */
    protected EList<PSComunication> incomingConnections;

    /**
     * The cached value of the '{@link #getOutgoingConnections() <em>Outgoing Connections</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOutgoingConnections()
     * @generated
     * @ordered
     */
    protected EList<PSComunication> outgoingConnections;

    /**
     * The cached value of the '{@link #getSuperinstance() <em>Superinstance</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSuperinstance()
     * @generated
     * @ordered
     */
    protected PSInstance superinstance;

    /**
     * The cached value of the '{@link #getSubinstance() <em>Subinstance</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSubinstance()
     * @generated
     * @ordered
     */
    protected EList<PSInstance> subinstance;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected PSInstanceImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return PssimulationPackage.Literals.PS_INSTANCE;
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
            eNotify(new ENotificationImpl(this, Notification.SET, PssimulationPackage.PS_INSTANCE__ID, oldId, id));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getInitBehaviour() {
        return initBehaviour;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setInitBehaviour(String newInitBehaviour) {
        String oldInitBehaviour = initBehaviour;
        initBehaviour = newInitBehaviour;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PssimulationPackage.PS_INSTANCE__INIT_BEHAVIOUR, oldInitBehaviour, initBehaviour));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getModelClass() {
        return modelClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setModelClass(String newModelClass) {
        String oldModelClass = modelClass;
        modelClass = newModelClass;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PssimulationPackage.PS_INSTANCE__MODEL_CLASS, oldModelClass, modelClass));
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
            eNotify(new ENotificationImpl(this, Notification.SET, PssimulationPackage.PS_INSTANCE__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<PSComunication> getIncomingConnections() {
        if (incomingConnections == null) {
            incomingConnections = new EObjectResolvingEList<PSComunication>(PSComunication.class, this, PssimulationPackage.PS_INSTANCE__INCOMING_CONNECTIONS);
        }
        return incomingConnections;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<PSComunication> getOutgoingConnections() {
        if (outgoingConnections == null) {
            outgoingConnections = new EObjectResolvingEList<PSComunication>(PSComunication.class, this, PssimulationPackage.PS_INSTANCE__OUTGOING_CONNECTIONS);
        }
        return outgoingConnections;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PSInstance getSuperinstance() {
        if (superinstance != null && superinstance.eIsProxy()) {
            InternalEObject oldSuperinstance = (InternalEObject)superinstance;
            superinstance = (PSInstance)eResolveProxy(oldSuperinstance);
            if (superinstance != oldSuperinstance) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, PssimulationPackage.PS_INSTANCE__SUPERINSTANCE, oldSuperinstance, superinstance));
            }
        }
        return superinstance;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PSInstance basicGetSuperinstance() {
        return superinstance;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSuperinstance(PSInstance newSuperinstance) {
        PSInstance oldSuperinstance = superinstance;
        superinstance = newSuperinstance;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PssimulationPackage.PS_INSTANCE__SUPERINSTANCE, oldSuperinstance, superinstance));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<PSInstance> getSubinstance() {
        if (subinstance == null) {
            subinstance = new EObjectResolvingEList<PSInstance>(PSInstance.class, this, PssimulationPackage.PS_INSTANCE__SUBINSTANCE);
        }
        return subinstance;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PSHierarchy getParent() {
        if (parent != null && parent.eIsProxy()) {
            InternalEObject oldParent = (InternalEObject)parent;
            parent = (PSHierarchy)eResolveProxy(oldParent);
            if (parent != oldParent) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, PssimulationPackage.PS_INSTANCE__PARENT, oldParent, parent));
            }
        }
        return parent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PSHierarchy basicGetParent() {
        return parent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setParent(PSHierarchy newParent) {
        PSHierarchy oldParent = parent;
        parent = newParent;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PssimulationPackage.PS_INSTANCE__PARENT, oldParent, parent));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<PSHierarchy> getChildren() {
        if (children == null) {
            children = new EObjectResolvingEList<PSHierarchy>(PSHierarchy.class, this, PssimulationPackage.PS_INSTANCE__CHILDREN);
        }
        return children;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getModelPath() {
        return modelPath;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setModelPath(String newModelPath) {
        String oldModelPath = modelPath;
        modelPath = newModelPath;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PssimulationPackage.PS_INSTANCE__MODEL_PATH, oldModelPath, modelPath));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case PssimulationPackage.PS_INSTANCE__ID:
                return getId();
            case PssimulationPackage.PS_INSTANCE__INIT_BEHAVIOUR:
                return getInitBehaviour();
            case PssimulationPackage.PS_INSTANCE__MODEL_CLASS:
                return getModelClass();
            case PssimulationPackage.PS_INSTANCE__PARENT:
                if (resolve) return getParent();
                return basicGetParent();
            case PssimulationPackage.PS_INSTANCE__CHILDREN:
                return getChildren();
            case PssimulationPackage.PS_INSTANCE__MODEL_PATH:
                return getModelPath();
            case PssimulationPackage.PS_INSTANCE__NAME:
                return getName();
            case PssimulationPackage.PS_INSTANCE__INCOMING_CONNECTIONS:
                return getIncomingConnections();
            case PssimulationPackage.PS_INSTANCE__OUTGOING_CONNECTIONS:
                return getOutgoingConnections();
            case PssimulationPackage.PS_INSTANCE__SUPERINSTANCE:
                if (resolve) return getSuperinstance();
                return basicGetSuperinstance();
            case PssimulationPackage.PS_INSTANCE__SUBINSTANCE:
                return getSubinstance();
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
            case PssimulationPackage.PS_INSTANCE__ID:
                setId((String)newValue);
                return;
            case PssimulationPackage.PS_INSTANCE__INIT_BEHAVIOUR:
                setInitBehaviour((String)newValue);
                return;
            case PssimulationPackage.PS_INSTANCE__MODEL_CLASS:
                setModelClass((String)newValue);
                return;
            case PssimulationPackage.PS_INSTANCE__PARENT:
                setParent((PSHierarchy)newValue);
                return;
            case PssimulationPackage.PS_INSTANCE__CHILDREN:
                getChildren().clear();
                getChildren().addAll((Collection<? extends PSHierarchy>)newValue);
                return;
            case PssimulationPackage.PS_INSTANCE__MODEL_PATH:
                setModelPath((String)newValue);
                return;
            case PssimulationPackage.PS_INSTANCE__NAME:
                setName((String)newValue);
                return;
            case PssimulationPackage.PS_INSTANCE__INCOMING_CONNECTIONS:
                getIncomingConnections().clear();
                getIncomingConnections().addAll((Collection<? extends PSComunication>)newValue);
                return;
            case PssimulationPackage.PS_INSTANCE__OUTGOING_CONNECTIONS:
                getOutgoingConnections().clear();
                getOutgoingConnections().addAll((Collection<? extends PSComunication>)newValue);
                return;
            case PssimulationPackage.PS_INSTANCE__SUPERINSTANCE:
                setSuperinstance((PSInstance)newValue);
                return;
            case PssimulationPackage.PS_INSTANCE__SUBINSTANCE:
                getSubinstance().clear();
                getSubinstance().addAll((Collection<? extends PSInstance>)newValue);
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
            case PssimulationPackage.PS_INSTANCE__ID:
                setId(ID_EDEFAULT);
                return;
            case PssimulationPackage.PS_INSTANCE__INIT_BEHAVIOUR:
                setInitBehaviour(INIT_BEHAVIOUR_EDEFAULT);
                return;
            case PssimulationPackage.PS_INSTANCE__MODEL_CLASS:
                setModelClass(MODEL_CLASS_EDEFAULT);
                return;
            case PssimulationPackage.PS_INSTANCE__PARENT:
                setParent((PSHierarchy)null);
                return;
            case PssimulationPackage.PS_INSTANCE__CHILDREN:
                getChildren().clear();
                return;
            case PssimulationPackage.PS_INSTANCE__MODEL_PATH:
                setModelPath(MODEL_PATH_EDEFAULT);
                return;
            case PssimulationPackage.PS_INSTANCE__NAME:
                setName(NAME_EDEFAULT);
                return;
            case PssimulationPackage.PS_INSTANCE__INCOMING_CONNECTIONS:
                getIncomingConnections().clear();
                return;
            case PssimulationPackage.PS_INSTANCE__OUTGOING_CONNECTIONS:
                getOutgoingConnections().clear();
                return;
            case PssimulationPackage.PS_INSTANCE__SUPERINSTANCE:
                setSuperinstance((PSInstance)null);
                return;
            case PssimulationPackage.PS_INSTANCE__SUBINSTANCE:
                getSubinstance().clear();
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
            case PssimulationPackage.PS_INSTANCE__ID:
                return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
            case PssimulationPackage.PS_INSTANCE__INIT_BEHAVIOUR:
                return INIT_BEHAVIOUR_EDEFAULT == null ? initBehaviour != null : !INIT_BEHAVIOUR_EDEFAULT.equals(initBehaviour);
            case PssimulationPackage.PS_INSTANCE__MODEL_CLASS:
                return MODEL_CLASS_EDEFAULT == null ? modelClass != null : !MODEL_CLASS_EDEFAULT.equals(modelClass);
            case PssimulationPackage.PS_INSTANCE__PARENT:
                return parent != null;
            case PssimulationPackage.PS_INSTANCE__CHILDREN:
                return children != null && !children.isEmpty();
            case PssimulationPackage.PS_INSTANCE__MODEL_PATH:
                return MODEL_PATH_EDEFAULT == null ? modelPath != null : !MODEL_PATH_EDEFAULT.equals(modelPath);
            case PssimulationPackage.PS_INSTANCE__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case PssimulationPackage.PS_INSTANCE__INCOMING_CONNECTIONS:
                return incomingConnections != null && !incomingConnections.isEmpty();
            case PssimulationPackage.PS_INSTANCE__OUTGOING_CONNECTIONS:
                return outgoingConnections != null && !outgoingConnections.isEmpty();
            case PssimulationPackage.PS_INSTANCE__SUPERINSTANCE:
                return superinstance != null;
            case PssimulationPackage.PS_INSTANCE__SUBINSTANCE:
                return subinstance != null && !subinstance.isEmpty();
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
        result.append(", initBehaviour: ");
        result.append(initBehaviour);
        result.append(", modelClass: ");
        result.append(modelClass);
        result.append(", modelPath: ");
        result.append(modelPath);
        result.append(", name: ");
        result.append(name);
        result.append(')');
        return result.toString();
    }

} //PSInstanceImpl
