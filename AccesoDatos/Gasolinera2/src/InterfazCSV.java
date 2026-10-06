import java.util.LinkedList;

public interface InterfazCSV {
    public LinkedList<Clientes> leerClientes();
    public void escribirClientes(LinkedList<Clientes>listaClientes);
    public LinkedList<PagosRepostaje> leerPagos();
    public void escribirPagos(LinkedList<PagosRepostaje>listaPagos);
}
