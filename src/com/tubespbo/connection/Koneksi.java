package com.tubespbo.connection;

import java.sql.*;
public class Koneksi {
    private static Connection connection;

    private Koneksi() {
    }

    public static Connection getConnection() {
        if (connection == null) {
            String url = "jdbc:mysql://localhost:3306/dbgudang";
            String username = "root";
            String password = "";

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url, username, password);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean isConnected() {
        try {
            if (connection != null && !connection.isClosed()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}