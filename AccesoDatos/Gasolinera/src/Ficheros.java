import java.util.ArrayList;
import java.util.List;

public class Ficheros {
    public static List <PagosDeRepostajes> leerFicheroRepostaje(){
        System.out.println("Recuperamos los repostajes del fichero.");

        List<PagosDeRepostajes>  listaPagosRepostaje = new ArrayList<>();
        return listaPagosRepostaje;
    }

    public static List <Clientes> leerFicheroClientes(){
        System.out.println("Recuperamos los clientes del fichero.");
        List<Clientes>  listaClientes = new ArrayList<>();
        return listaClientes;
    }

    public static void guardarClientes(List Clientes){
        System.out.println("Guardando clientes");
    }

    public static void guardarPagos(List PagosDeRepostajes){
        System.out.println("Guardando pagos");
    }
}
