package pl.agh.dariuszw.db;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.MutablePeriod;

import pl.agh.dariuszw.StorageAgent;

/**
 * Created by dariuszw on 2015-02-26.
 */
public final class DatabaseManager {

    private static final String SIMULATION_TABLE = "SIMULATION";

    private String dbSchemaUrl = "/default_schema.sql";

    private boolean dropAll = false;

    private static Logger log = LogManager.getLogger(DatabaseManager.class);

    private DatabaseManager() {
    }

    private Connection connection = JDBCConnectionFactory.getInstance();

    public static DatabaseManager getInstance() {
        DatabaseManager instance = new DatabaseManager();

        instance.populateSchema();

        return instance;
    }

    private void populateSchema() {
        Properties properties = new Properties();
        try {
            properties.load(JDBCConnectionFactory.class.getClassLoader().getResourceAsStream("jdbc.properties"));
            dbSchemaUrl = properties.getProperty("jdbc.db.schema");
            dropAll = Boolean.parseBoolean(properties.getProperty("jdbc.db.drop"));
        } catch (IOException e1) {
            System.err.println(e1.getMessage());
        }

        if ( dropAll ) {
            Statement statement = null;
            InputStreamReader sqlFileReader = null;
            LineNumberReader lineReader = null;
            String line = null;
            StringBuffer buffer = new StringBuffer();
            sqlFileReader = new InputStreamReader(getClass().getResourceAsStream("/drop_schema.sql"));
            lineReader = new LineNumberReader(sqlFileReader);
            try {
                while ((line = lineReader.readLine()) != null) {
                    if ( StringUtils.trim(line).endsWith(";") ) {
                        buffer.append(line);
                        statement = connection.createStatement();
                        System.out.println(buffer.toString());
                        statement.execute(buffer.toString());

                        buffer.delete(0, buffer.length());
                    } else {
                        buffer.append(line);
                    }

                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        Statement schemaTestStatement = null;
        ResultSet r = null;
        try {
            schemaTestStatement = connection.createStatement();
            r = schemaTestStatement.executeQuery("SELECT * FROM " + SIMULATION_TABLE);
        } catch (SQLException e) {
            Statement statement = null;
            InputStreamReader sqlFileReader = null;
            LineNumberReader lineReader = null;
            String line = null;
            StringBuffer buffer = new StringBuffer();
            try {
                System.err.println("Assume schema is empty! Populate data. Thrown error: " + e.getMessage());

                sqlFileReader = new InputStreamReader(getClass().getResourceAsStream(dbSchemaUrl));
                lineReader = new LineNumberReader(sqlFileReader);
                while ((line = lineReader.readLine()) != null) {
                    if ( StringUtils.trim(line).endsWith(";") ) {
                        buffer.append(line);
                        statement = connection.createStatement();
                        System.out.println(buffer.toString());
                        statement.execute(buffer.toString());

                        buffer.delete(0, buffer.length());
                    } else {
                        buffer.append(line);
                    }

                }

            } catch (IOException e1) {
                System.err.println(e1.getMessage());
            } catch (SQLException e1) {
                System.err.println(e1.getMessage());
            } finally {
                try {
                    if ( sqlFileReader != null ) {
                        sqlFileReader.close();
                    }
                    if ( lineReader != null ) {
                        lineReader.close();
                    }

                    if ( statement != null ) {
                        statement.close();
                    }
                } catch (Exception e1) {
                    System.err.println(e1.getMessage());
                    throw new RuntimeException(e1);
                }
            }

        } finally {
            try {
                schemaTestStatement.close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
                e.printStackTrace();
            }
        }

    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    private static final String SIMULATION_INSERT = "INSERT INTO SIMULATION (simulation_id, execution_date, simulation_step, simulation_start, simulation_end, configuration_url) VALUES (?,?,?,?,?,?);";

    private static final String TIME_INSERT = "INSERT INTO TIME_POINT (simulation_id, execution_date, time_id) VALUES (?,?,?);";

    public void executeSimulationInitialization(String simulationID, Date executionDate, String step, Date simulationStart, Date simulationEnd, String url) {
        PreparedStatement insert = null;
        try {
            insert = connection.prepareStatement(SIMULATION_INSERT);
            insert.setString(1, simulationID);
            insert.setTimestamp(2, new Timestamp(executionDate.getTime()));
            insert.setString(3, step);
            insert.setTimestamp(4, new Timestamp(simulationStart.getTime()));
            insert.setTimestamp(5, new Timestamp(simulationEnd.getTime()));
            insert.setString(6, url);
            insert.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if ( insert != null ) {
                try {
                    insert.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        DateTime endTime = new DateTime(simulationEnd);
        DateTime currentTime = new DateTime(simulationStart);
        MutablePeriod stepPeriod = MutablePeriod.parse(step);
        PreparedStatement insertTime = null;
        try {
            // populate time rows!
            insertTime = connection.prepareStatement(TIME_INSERT);
            insertTime.setString(1, simulationID);
            insertTime.setTimestamp(2, new Timestamp(executionDate.getTime()));
            while ( !currentTime.isAfter(endTime)) {
                insertTime.setTimestamp(3, new Timestamp(currentTime.toDate().getTime()));
                insertTime.executeUpdate();
                currentTime = currentTime.plus(stepPeriod);
            }
        } catch (SQLException e) {
            if ( insertTime != null ) {
                try {
                    insertTime.close();
                } catch (SQLException e1) {
                    throw new RuntimeException(e1);
                }
            }
        }

    }

    private static final String STATE_INSERT = "INSERT INTO STATE_LOG (simulation_id, execution_date, time_id, instance_id, state) VALUES (?,?,?,?,?);";

    public void executeStateInsert(String simulationID, Date executionDate, String instance, Date currentTime, String state) {
        PreparedStatement insert = null;
        try {
            insert = connection.prepareStatement(STATE_INSERT);
            insert.setString(1, simulationID);
            insert.setTimestamp(2, new Timestamp(executionDate.getTime()));
            insert.setString(4, instance);
            insert.setTimestamp(3, new Timestamp(currentTime.getTime()));
            insert.setString(5, state);
            insert.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if ( insert != null ) {
                try {
                    insert.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private static final String INSTANCE_INSERT = "INSERT INTO AGENT_INSTANCE (simulation_id, execution_date, instance_id, agent_class) VALUES (?,?,?,?);";

    public void executeInstanceInsert(String simulationID, Date executionDate, String instanceID, String instanceClass) {
        PreparedStatement insert = null;
        try {
            insert = connection.prepareStatement(INSTANCE_INSERT);
            insert.setString(1, simulationID);
            insert.setTimestamp(2, new Timestamp(executionDate.getTime()));
            insert.setString(3, instanceID);
            insert.setString(4, instanceClass);
            insert.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if ( insert != null ) {
                try {
                    insert.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private static final String VARIABLE_INSERT = "INSERT INTO VARIABLE_LOG (simulation_id, execution_date, instance_id, time_id, variable_id, prev_value, new_value, increment) VALUES (?,?,?,?,?,?,?,?);";

    public void executeVariableInsert(String simulationID, Date executionDate, String instance, Date currentTime, String key, String oldValue, String newValue,
            Long increment) {
        PreparedStatement insert = null;
        try {
            insert = connection.prepareStatement(VARIABLE_INSERT);
            insert.setString(1, simulationID);
            insert.setTimestamp(2, new Timestamp(executionDate.getTime()));
            insert.setString(3, instance);
            insert.setTimestamp(4, new Timestamp(currentTime.getTime()));
            insert.setString(5, key);
            insert.setString(6, oldValue);
            insert.setString(7, newValue);
            insert.setLong(8, increment);
            insert.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if ( insert != null ) {
                try {
                    insert.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void dispose() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static final String POWER_INSERT = "INSERT INTO POWER_LOG (simulation_id, execution_date, instance_id, time_id, power, delta, consumption) VALUES (?,?,?,?,?,?,?);";

    public void executePowerInsert(String simulationID, Date executionDate, String instance, Date currentTime, Integer power, String delta, Double consumption) {
        PreparedStatement insert = null;
        try {
            insert = connection.prepareStatement(POWER_INSERT);
            insert.setString(1, simulationID);
            insert.setTimestamp(2, new Timestamp(executionDate.getTime()));
            insert.setString(3, instance);
            insert.setTimestamp(4, new Timestamp(currentTime.getTime()));
            insert.setInt(5, power);
            insert.setString(6, delta);
            insert.setDouble(7, consumption);
            insert.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if ( insert != null ) {
                try {
                    insert.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

    private static final String POWER_SELECT = "SELECT time_id, power, consumption FROM power_log WHERE simulation_id = ? AND execution_date = ? AND instance_id = ?";

    public Map<DateTime, StorageAgent.PowerStamp> collectPowerData(String simulationID, Date executionDate, String instanceID) {
        Map<DateTime, StorageAgent.PowerStamp> transferMap = new TreeMap<DateTime, StorageAgent.PowerStamp>();
        PreparedStatement select = null;
        try {
            select = connection.prepareStatement(POWER_SELECT);
            select.setString(1, simulationID);
            select.setString(3, instanceID);
            select.setTimestamp(2, new Timestamp(executionDate.getTime()));

            ResultSet result = select.executeQuery();
            while (result.next()) {
                Timestamp time = result.getTimestamp(1);
                Integer power = result.getInt(2);
                Double work = result.getDouble(3);

                DateTime dateTime = new DateTime(time.getTime());
                log.info("POWER_LOG: " + dateTime + " | " + power + " | " + work);

                transferMap.put(dateTime, new StorageAgent.PowerStamp(power, work));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if ( select != null ) {
                try {
                    select.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return transferMap;
    }
}
