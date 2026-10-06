import java.util.LinkedList;

public interface InterfazJSON {
    public LinkedList<Clientes> leerClientes();
    public void escribirClientes(Clientes c1);
    public LinkedList<PagosRepostaje> leerPagos();
    public void escribirPagos(PagosRepostaje p1);
}
