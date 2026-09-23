import java.util.Collection;
import java.util.List;

public class FicherosCSV implements Ficheros{
    @Override
    public Collection<Clientes> leerClientes() {
        return List.of();
    }

    @Override
    public Collection<PagosDeRepostajes> leerRepostajes() {

        return List.of();
    }

    @Override
    public void guardarClientes(Clientes c1) {

    }

    @Override
    public void guardarRepostajes(PagosDeRepostajes p1) {

    }
}
