import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLOutput;
import java.util.*;
public class MigrarCSVToJson {
    static Scanner sc=new Scanner(System.in);
    Path directorioCSV;
    Path clienteCSV;
    Path pagosCSV;
    Path directorioJSON;
    Path clientsJSON;
    Path pagosJSON;

    public MigrarCSVToJson() {
        this.directorioJSON = Path.of("datosJSON");
        this.clientsJSON = directorioJSON.resolve("clientes.json");
        this.pagosJSON = directorioJSON.resolve("pagos.json");
    }

    public void  migrar(){
        if(!Files.exists(directorioJSON)&&!Files.exists(clientsJSON)&&!Files.exists(pagosJSON)){
            System.out.println("Quieres migrar ficheros CSV a JSON?");
            String op = sc.nextLine().toLowerCase();

            while(!op.equals("si")&&!op.equals("no")){
                System.out.println("Quieres migrar ficheros CSV a JSON?");
                op = sc.nextLine().toLowerCase();
            }

            if(op.equals("si")){
                System.out.println("Indica el nombre del directorio CSV: ");
                String ruta = sc.nextLine();
                this.directorioCSV = Path.of(ruta);

                System.out.println("Indica el nombre del fichero clientes CSV: ");
                ruta = sc.nextLine();
                this.clienteCSV = directorioCSV.resolve(ruta);

                System.out.println("Indica el nombre del fichero pagos CSV: ");
                ruta = sc.nextLine();
                this.pagosCSV = directorioCSV.resolve(ruta);

                if(Files.exists(directorioCSV) && Files.exists(clienteCSV) && Files.exists(pagosCSV)){
                    try {
                        GestionFicherosCSV csv = new GestionFicherosCSV(directorioCSV, clienteCSV, pagosCSV);
                        GestionFicherosJSON json = new GestionFicherosJSON();

                        LinkedList<Clientes> listaClientes = csv.leerClientes();
                        LinkedList<PagosRepostaje> listaPagos = csv.leerPagos();

                        json.escribirClientes(listaClientes);
                        json.escribirPagos(listaPagos);

                        int numClientes = json.leerClientes().size();
                        int numPagos = json.leerPagos().size();

                        System.out.println("Se han migrado "+numClientes+" clientes y "+numPagos+" pagos a los ficheros: ");
                        System.out.println();

                    } catch (IOException e) {
                        System.out.println("Error al migrar, JSON inexistente o no tienes permisos.");
                    }

                } else {
                    System.out.println("No existen los ficheros CSV origen.");
                }
            } else {
                System.out.println("Has elegeido no migrar datos.");
            }
        } else {
            System.out.println("Ya existen ficheros JSON.");
        }
    }
}

