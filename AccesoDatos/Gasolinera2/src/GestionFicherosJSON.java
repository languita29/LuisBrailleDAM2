import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;

public class GestionFicherosJSON implements InterfazFicheros{
    Path directorio;
    Path fichClientes;
    Path fichPagos;

    public GestionFicherosJSON() throws IOException {
        this.directorio = Path.of("datosJSON");
        this.fichClientes = directorio.resolve("clientes.json");
        this.fichPagos = directorio.resolve("pagos.json");

        if(!Files.exists(directorio)){
            Files.createDirectories(directorio);
        }
        if(!Files.exists(fichClientes)){
            Files.createFile(fichClientes);
        }
        if(!Files.exists(fichPagos)){
            Files.createFile(fichPagos);
        }
    }


    public String limpiar(String cadena){
        return cadena.split(":")[1].trim().replace("\"", "");
    }

    @Override
    public LinkedList<Clientes> leerClientes() {
        LinkedList<Clientes> listaClientes = new LinkedList<>();
        try (BufferedReader leer = Files.newBufferedReader(fichClientes)){
            leer.readLine();
            leer.readLine();

            String lineaCliente = leer.readLine();

            while(lineaCliente!=null&&lineaCliente.contains("]")){
                lineaCliente = lineaCliente.substring(1, lineaCliente.indexOf("}"));
                String[] arrayCliente = lineaCliente.split(",");
                Clientes c1 = new Clientes(Integer.parseInt(limpiar(arrayCliente[0])), limpiar(arrayCliente[1]), limpiar(arrayCliente[2]), limpiar(arrayCliente[3]));
                listaClientes.add(c1);
                lineaCliente = leer.readLine();
            }
        } catch (IOException e) {
            System.out.println("No se ha encontrado ningun cliente en el fichero");
        }
        return listaClientes;
    }

    @Override
    public LinkedList<PagosRepostaje> leerPagos() {
        LinkedList<PagosRepostaje>listaPagos=new LinkedList<>();
        try (BufferedReader leer=Files.newBufferedReader(fichPagos)){
            leer.readLine();
            leer.readLine();
            String cadena=leer.readLine();
            while(cadena!=null && cadena.contains("}")){
                String[] arrayCadena=cadena.split(",");
                PagosRepostaje p1=new PagosRepostaje(Integer.parseInt(limpiar(arrayCadena[0])),Integer.parseInt(limpiar(arrayCadena[1])),limpiar(arrayCadena[2]),Double.parseDouble(limpiar(arrayCadena[3])), Double.parseDouble(limpiar(arrayCadena[4])), limpiar(arrayCadena[5]));
                listaPagos.add(p1);
                cadena=leer.readLine();
            }
        } catch (IOException e) {
            System.out.println("No hay ningun pago creado en clientes");
        }
        return listaPagos;
    }

    @Override
    public void escribirClientes(LinkedList<Clientes> listaClientes) {

    }

    @Override
    public void escribirPagos(LinkedList<PagosRepostaje> listaPagos) {

    }

    @Override
    public void escribirCliente(Clientes c1) {

    }

    @Override
    public void escribirPago(PagosRepostaje p1) {

    }
}
