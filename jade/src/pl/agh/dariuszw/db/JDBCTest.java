package pl.agh.dariuszw.db;

import java.sql.Connection;

/**
 * Created by dariuszw on 2015-02-26.
 */
public class JDBCTest {

    public static void main(String[] args){

        DatabaseManager databaseManager = DatabaseManager.getInstance();
        System.out.println(databaseManager.toString());

    }
}
