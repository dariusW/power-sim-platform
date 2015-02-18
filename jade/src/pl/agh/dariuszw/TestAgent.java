package pl.agh.dariuszw;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;

/**
 * Created by dariuszw on 2015-02-09.
 */
public class TestAgent extends Agent {

    int counter;

    boolean allReady = false;

    @Override
    protected void setup() {
        addBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {
                checkKill();
                System.out.println("Behaviour A");
            }
        });

        addBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {
                checkKill();
                System.out.println("Behaviour B");

                if ( !allReady ) {
                    addBehaviour(new CyclicBehaviour() {
                        @Override
                        public void action() {
                            checkKill();
                            System.out.println("Behaviour C");
                        }
                    });
                    allReady = true;
                }

            }
        });
    }

    private void checkKill() {
        counter++;
        if ( counter > 100 ) {
            doDelete();
        }
    }
}
