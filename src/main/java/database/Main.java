package database;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");
            String dbURL = "jdbc:sqlite:bookstore.db";
            Connection connection = DriverManager.getConnection(dbURL);

            assert connection != null;
            System.out.println("Connected to the database....");

            // display database information
            DatabaseMetaData dm = connection.getMetaData();
            System.out.println("Driver name: " + dm.getDriverName());
            System.out.println("Product name: " + dm.getDatabaseProductName());

            // execute SQL statements
            System.out.println("----- Data in Book table -----");

            String query = "SELECT * FROM book";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String type = resultSet.getString(3);
                double price = resultSet.getDouble(4);

                String out = String.format("| id: %-2d | name: %-20s | type: %-10s | price: %-7.2f |", id, name, type, price);
                System.out.println(out);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
