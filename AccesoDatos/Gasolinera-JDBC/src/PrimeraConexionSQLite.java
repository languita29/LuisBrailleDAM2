import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PrimeraConexionSQLite {
    public static void main(String[] args) {
        Path fichSQLite;
        try {
            fichSQLite = Path.of(args[0]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("No se le está pasando el fichero como argumento.");
            fichSQLite = Path.of("gasolinera.sqlite");
        }

        if(Files.notExists(fichSQLite)){
            System.out.println("No existe la BD");
            return;
        }

        String url = "jdbc:sqlite:/Users/luu/Documents/LuisBrailleDAM2/AccesoDatos/Gasolinera-JDBC/gasolinera.sqlite";

        try(Connection conexion = DriverManager.getConnection(url);){
            try(Statement comando = conexion.createStatement()) {
                comando.execute("PRAGMA FOREIGN_KEYS = ON");
            } catch (SQLException ex) {
                System.out.println("Error comando");
            }
            System.out.println("Conexión abierta: "+conexion.isValid(2));
        } catch (SQLException e) {
            System.out.println("No se ha podido conectar con la BD "+fichSQLite);
            System.out.println(e.getErrorCode() + " "+ e.getMessage());
        }

    }
}
