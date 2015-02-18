package pl.agh.dariuszw;

import jade.core.behaviours.Behaviour;

/**
 * Created by dariuszw on 2015-02-16.
 */
public abstract class SimBehaviour extends Behaviour{

    protected final String id;
    protected final String localName;
    private boolean init = true;

    protected SimBehaviour(String localName, String name){
        this.id = name;
        this.localName = localName;
    }


    @Override
    public final void action() {
        if(init){
            init = false;
            onEntry();
        }
        onStep();


        System.out.println(localName + ": " + id);
    }

    @Override
    public final boolean done() {
        boolean isDone = isDone();
        if(isDone()){
            onExit();
        }
        return isDone;
    }

    protected abstract boolean isDone();

    protected abstract void onStep();

    protected abstract void onEntry();

    protected abstract void onExit();
}
