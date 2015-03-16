package pl.agh.dariuszw;

import jade.core.Agent;
import org.apache.logging.log4j.Logger;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.logging.LogManager;

/**
 * Created by dariuszw on 2015-03-01.
 */
public abstract class ExtendedAgent extends Agent {

    public Logger log = org.apache.logging.log4j.LogManager.getLogger(ExtendedAgent.class);

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

    public Set<String> states = new HashSet<String>();

    void addState(String s){
        states.add(s);
    }

    void removeState(String s){
        states.remove(s);
    }

    public DateTime toDate(String date){
        return Utils.DEFAULT_TIME_FORMATTER.parseDateTime(date);
    }

    public DateTime toTime(String date){
        return Utils.DEFAULT_TIME2_FORMATTER.parseDateTime(date);
    }

    Random localRandomGenerator = new Random();

    public int randomInteger(int min, int max) {

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = localRandomGenerator.nextInt((max - min) + 1) + min;

        return randomNum;
    }

    public float randomFloat(float min, float max) {

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        float randomNum = localRandomGenerator.nextFloat() * (max - min) + min;

        return randomNum;
    }

    public boolean probabilityCheck(float probability){
        float random = localRandomGenerator.nextFloat();
        return probability > random;
    }

    public void log(String... logs){
        StringBuilder sb = new StringBuilder(getAID().toString());
        sb.append(": ");
        for(String s: logs){
            sb.append(s);
            sb.append(", ");
        }
        sb.deleteCharAt(sb.length()-1);
        log.info(sb.toString());

    }
}
