import java.util.Collection;

public interface Ficheros {
    public Collection<Clientes> leerClientes();
    public Collection <PagosDeRepostajes> leerRepostajes();
    public void guardarClientes(Clientes c1);
    public void guardarRepostajes(PagosDeRepostajes p1);

}
