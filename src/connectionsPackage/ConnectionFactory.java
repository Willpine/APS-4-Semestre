package connectionsPackage;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import org.apache.log4j.Logger;
import sun.util.logging.PlatformLogger;

public class ConnectionFactory {

    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/testeschema";
    private final String USER = "root";
    private final String PASSWORD = "SOU@esperto10";

    public Connection getConnection() {

        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Erro na conexão.", e);
        }
    }

    public static void closeConnection(Connection con) {
        try {
            if(con != null)
            con.close();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void closeConnection(Connection con, PreparedStatement ppstmt) {
        closeConnection(con);
        try {
            if(ppstmt != null)
                ppstmt.close();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void closeConnection(Connection con, PreparedStatement ppstmt, ResultSet rs) {
        closeConnection(con);
        try {
            if(rs != null)
                rs.close();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
