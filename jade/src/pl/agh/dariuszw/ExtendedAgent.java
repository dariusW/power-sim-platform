package pl.agh.dariuszw;

import jade.core.Agent;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dariuszw on 2015-03-01.
 */
public abstract class ExtendedAgent extends Agent {

    private static Map<String, List<String>> instancesStateMap = new HashMap<String, List<String>>();

    protected static void registerState(String instanceId, String state){
        List<String> list = instancesStateMap.get(instanceId);
        if(list == null){
            list = new ArrayList<String>();
            instancesStateMap.put(instanceId, list);
        }
        list.add(state);
    }

    protected static String[] getStates(String instanceId){
        List<String> list = instancesStateMap.get(instanceId);
        if(list == null || list.isEmpty()){
            return new String[]{};
        }
        return list.toArray(new String[list.size()]);
    }


    public abstract DateTime getCurrentDate();

    public abstract String getInstance();

}
