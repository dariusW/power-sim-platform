package pl.agh.dariuszw.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * Created by dariuszw on 2015-02-26.
 */
final class JDBCConnectionFactory {

    private JDBCConnectionFactory(){}


    public static Connection getInstance() {
        try {
            Properties properties = new Properties();
            properties.load(JDBCConnectionFactory.class.getClassLoader().getResourceAsStream("jdbc.properties"));

            String connectionUrl = properties.getProperty("jdbc.connection.url");
            String jdbcDriver = properties.getProperty("jdbc.driver");
            String dbUser = properties.getProperty("jdbc.db.user");
            String dbPass = properties.getProperty("jdbc.db.pass");

            Class.forName(jdbcDriver);
            return DriverManager.getConnection(connectionUrl, dbUser, dbPass);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
