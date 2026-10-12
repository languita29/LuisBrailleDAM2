import java.util.LinkedList;

public interface Ficheros {
    public LinkedList<Clientes> leerClientes();
    public void escribirClientes(LinkedList<Clientes>listaClientes);
    public LinkedList<PagosRepostaje> leerPagos();
    public void escribirPagos(LinkedList<PagosRepostaje>listaPagos);
}
