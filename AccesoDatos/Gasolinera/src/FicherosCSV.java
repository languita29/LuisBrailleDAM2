import java.util.Collection;
import java.util.LinkedList;

public class FicherosCSV implements Ficheros{
    @Override
    public LinkedList<Clientes> leerClientes() {
        return List.of();
    }

    @Override
    public LinkedList<PagosDeRepostajes> leerRepostajes() {

        return List.of();
    }

    @Override
    public void guardarClientes( LinkedList<Clientes> lista) {

    }

    @Override
    public void guardarRepostajes( LinkedList<PagosDeRepostajes> lista) {

    }
}
