package util;
import com.sun.rowset.CachedRowSetImpl;

import java.sql.*;

public class DBUtil {
    // JDBC driver
    private static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static Connection conn = null;

    // connection String (user and password hidden for the sake of security)
    private static final String connStr = "jdbc:oracle:thin:****/****@oracle.scs.ryerson.ca:1521:orcl";

    // connect to DB
    public static void dbConnect() throws SQLException, ClassNotFoundException {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("Oracle JDBC Driver Not Found");
            e.printStackTrace();
            throw e;
        }
        System.out.println("Oracle JDBC Driver Registered");
        // establish the oracle connection
        try {
            conn = DriverManager.getConnection(connStr);
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console" + e);
            e.printStackTrace();
            throw e;
        }
    }

    // close connection
    public static void dbDisconnect() throws SQLException {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (Exception e){
            throw e;
        }
    }

    // execute Query Operation
    public static ResultSet dbExecuteQuery(String queryStmt) throws SQLException, ClassNotFoundException {
        Statement stmt = null;
        ResultSet resultSet = null;
        CachedRowSetImpl crs = null;
        try {
            dbConnect();
            System.out.println("Select statement: " + queryStmt);
            stmt = conn.createStatement();

            resultSet = stmt.executeQuery(queryStmt);

            // using CachedRowSetIn in order to prevent "java.sql.SQLRecoverableException: Closed Connection: next" error
            crs = new CachedRowSetImpl();
            crs.populate(resultSet);
        } catch (SQLException e) {
            System.out.println("Problem occurred at executeQuery operation : " + e);
            throw e;
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            dbDisconnect();
        }
        return crs;
    }

    // update/insert/delete operation
    public static void dbExecuteUpdate(String sqlStmt) throws SQLException, ClassNotFoundException {
        Statement stmt = null;
        try {
            dbConnect();
            stmt = conn.createStatement();
            stmt.executeUpdate(sqlStmt);
        } catch (SQLException e) {
            System.out.println("Problem occurred at executeUpdate operation : " + e);
            throw e;
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            dbDisconnect();
        }
    }
}