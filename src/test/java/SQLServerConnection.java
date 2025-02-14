import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLServerConnection {
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=proj_information;encrypt=true;trustServerCertificate=true";
    private static final String USER = "sa";
    private static final String PASSWORD = "kpPvpiQNhsf62X2";

    public static Connection conectar() {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa a SQL Server.");
            return connection;
        } catch (SQLException e) {
            System.out.println("Error en la conexión: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        conectar();
    }
}
