import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;
import java.text.RuleBasedCollator;

public class CreacionTablas {
    public static void main(String[] args) {
        Path rutafich = null;
        try {
            rutafich = Path.of(args[0]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("No se encuentra nada en la posicion 0 del argumento pasado");
        }
        if (Files.notExists(rutafich)){
            System.out.println("no existe o no esta creado este fichero "+rutafich);
            return;
        }
        String url="jdbc:sqlite:"+rutafich.toAbsolutePath();
        try (Connection conexion = DriverManager.getConnection(url)) {
            try (Statement comando=conexion.createStatement()){
                comando.execute("PRAGMA FOREIGN_KEYS =ON");

                String creacionTClientes= """
                        CREATE TABLE IF NOT EXISTS CLIENTES (
                             id INTEGER primary key NOT NULL  CHECK(id>0),
                            nombre TEXT NOT NULL CHECK(length(trim(nombre))>0),
                            matricula TEXT unique NOT NULL CHECK(length(trim(matricula))>0),
                            telefono TEXT  NOT NULL CHECK(length(trim(telefono))>0)
                        );
                        """;
               comando.execute(creacionTClientes);
                String creacionTPagos = """
                        create table if not exists pagos (
                            id INTEGER primary key NOT NULL  CHECK(id>0),
                            idCliente INTEGER  CHECK(idCliente>0),
                            fechaRepostajes TEXT NOT NULL CHECK(length(trim(fechaRepostajes))>0),
                            importe REAL NOT NULL  CHECK(importe>0),
                            litros REAL NOT NULL CHECK(litros>0),
                            combustible TEXT NOT NULL CHECK(length(trim(combustible))>0),
                            foreign key (idCliente)REFERENCES CLIENTES(id)
                        );
                        """;
                comando.execute(creacionTPagos);
               DatabaseMetaData resultado= conexion.getMetaData();
               boolean existe;
               try (ResultSet resultset=resultado.getTables(null,null,"clientes",null)){
                  existe=resultset.next();
                  System.out.println("Ha encontrado la tabla clientes:"+existe);
               }
               try (ResultSet resultSet=resultado.getTables(null,null,"Pagos",null)){
                   existe=resultSet.next();
                   System.out.println("has encontrado la tabla pagos:"+existe);
               }

            }
        } catch (SQLException e) {
            System.out.println("No se podido establecer una conexion con la base de datos");
        }

    }
}
