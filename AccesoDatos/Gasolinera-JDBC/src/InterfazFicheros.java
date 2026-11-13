import java.util.LinkedList;

public interface InterfazFicheros {
    LinkedList<Clientes> leerClientes();
    LinkedList<PagosRepostaje> leerPagos();

    void escribirClientes(LinkedList<Clientes>listaClientes);
    void escribirPagos(LinkedList<PagosRepostaje>listaPagos);

    void escribirCliente(Clientes c1);
    void escribirPago(PagosRepostaje p1);
}
