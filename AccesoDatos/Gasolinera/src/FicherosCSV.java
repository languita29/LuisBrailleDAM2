import java.util.ArrayList;
import java.util.List;

public class FicherosCSV implements Ficheros {

    @Override
    public Collection<PagosDeRepostajes> leerPagos() {
        return null;
    }

    @Override
    public Collection<Clientes> leerClientes() {
        return null;
    }

    @Override
    public boolean guardarCliente(Clientes c1) {
        return false;
    }

    @Override
    public boolean guardarPagos(PagosDeRepostajes p1) {
        return false;
    }
}
