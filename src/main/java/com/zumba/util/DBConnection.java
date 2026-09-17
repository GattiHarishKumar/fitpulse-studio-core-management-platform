package com.zumba.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DBConnection {
    private static final String URL =
        "jdbc:mysql://localhost:3306/zumba_db?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    // Set these environment variables before starting Tomcat:
    // ZUMBA_DB_USER and ZUMBA_DB_PASSWORD
    private static final String USER =
        System.getenv().getOrDefault("ZUMBA_DB_USER", "root");
    private static final String PASSWORD =
        System.getenv().getOrDefault("ZUMBA_DB_PASSWORD", "root123");

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    private DBConnection() {}

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
