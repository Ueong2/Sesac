package dev.spring.core.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
    static final String DB_URL = "jdbc:mysql://localhost:3306/";
    static final String DATABASE_NAME = "springaop";
    static final String USER = "root";
    static final String PASSWORD = "ekseh123";

    // JDBC4.0 이후로 모든 드라이버들은 클래스패스에서 자동으로 로딩됨. https://www.baeldung.com/java-jdbc
    // static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";

    // Java와 MySQL Database 연결
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        // Class.forName(DRIVER_NAME);
        connection = DriverManager.getConnection(DB_URL + DATABASE_NAME, USER, PASSWORD);
        return connection;
    }


}