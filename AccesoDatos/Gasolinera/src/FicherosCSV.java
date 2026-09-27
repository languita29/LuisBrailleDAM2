import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.*;
import java.util.LinkedList;

public class FicherosCSV implements Ficheros{
    Path directorio;
    Path clientes;
    Path pagos;

    public FicherosCSV() throws IOException {
        directorio = Path.of("datos");
        Files.createDirectory(directorio);
        clientes = directorio.resolve("clientes.csv");
        pagos = directorio.resolve("pagos.csv");
    }


    @Override
    public LinkedList<Clientes> leerClientes() {
        return new LinkedList<Clientes>();
    }

    @Override
    public LinkedList<PagosDeRepostajes> leerRepostajes() {

        return new LinkedList<PagosDeRepostajes>();
    }

    @Override
    public void guardarClientes( LinkedList<Clientes> listaClientes) {
        try(BufferedWriter boli = Files.newBufferedWriter(clientes, StandardOpenOption.CREATE)){
            boli.write("ID;NOMBRE;TELEFONO;MATRICULA");
            boli.newLine();

            for(Clientes c1 : listaClientes){
                boli.write(c1.getIndentificador()+";"+c1.getNombre()+";"+c1.getTelefono()+";"+c1.getMatricula());
                boli.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error en guardarClientes: "+e.getMessage());;
        }
    }

    @Override
    public void guardarRepostajes( LinkedList<PagosDeRepostajes> lista) {

    }
}
