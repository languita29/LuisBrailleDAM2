import java.util.Collection;
import java.util.LinkedList;

public interface Ficheros {
    public LinkedList<Clientes> leerClientes();
    public LinkedList <PagosDeRepostajes> leerRepostajes();
    public void guardarClientes(LinkedList<Clientes> lista);
    public void guardarRepostajes(LinkedList<PagosDeRepostajes> lista);

}
