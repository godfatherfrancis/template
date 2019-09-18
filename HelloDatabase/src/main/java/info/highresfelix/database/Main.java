package main.java.info.highresfelix.database;

import org.h2.tools.Server;

import java.sql.*;

/**
 * created by @highresfelix on 9/18/19
 */

public class Main {
    public static void main(String[] args) throws SQLException {
        // http://localhost:8082
        Server.createWebServer().start();

        Connection connection = DriverManager.getConnection("jdbc:h2:./main");
        // execute SQL strings
        Statement statement = connection.createStatement();
        statement.execute("CREATE TABLE IF NOT EXISTS players (id IDENTITY, name VARCHAR, is_alive BOOLEAN, score INT, health DOUBLE)");
//        statement.execute("INSERT INTO players VALUES (NULL, 'Alice', true, 0, 100.0)");

//        statement.execute("UPDATE players SET is_alive = FALSE WHERE name = 'Alice'");
//        statement.execute("DELETE FROM players WHERE name = 'Alice'");

        // BAD: Statement can cause SQL injection attack
//        String name = "Charlie";
//        statement.execute(String.format("INSERT INTO players VALUES (NULL, '%s', true, 0, 100.0)", name));

        // PreparedStatement when you need to inject values
        /*PreparedStatement statement2 = connection.prepareStatement("INSERT INTO players VALUES (NULL, ?, ?, ?, ?)");
        statement2.setString(1, "David");
        statement2.setBoolean(2, true);
        statement2.setInt(3, 0);
        statement2.setDouble(4, 100.0);
        statement2.execute();*/


        // read all players from database and print
        PreparedStatement statement3 = connection.prepareStatement("SELECT * FROM players");
        ResultSet results = statement3.executeQuery();
        while (results.next()) {
            String playerName = results.getString("name");
            double health = results.getDouble("health");
            int score = results.getInt("score");
            System.out.printf("%s %s %s\n", playerName, health, score);
        }
    }
}
