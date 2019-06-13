package util;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBUtil {
    private static Connection connection = null;

    public static Connection getConnection() {
        try {
            InputStream inputStream = DBUtil.class.getResourceAsStream("DBConfig.properties");
            Properties properties = new Properties();
            properties.load(inputStream);
            String DRIVER = properties.getProperty("DRIVER");
            String URL = properties.getProperty("URL");
            String USER = properties.getProperty("USER");
            String PASSWORD = properties.getProperty("PASSWORD");
            inputStream.close();
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void close() {
        try {
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
