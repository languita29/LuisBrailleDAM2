import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.LinkedList;

public class GestionFicherosJSON implements InterfazFicheros{
    Path directorio;
    Path fichClientes;
    Path fichPagos;
    final String CABECERA = "{\n [\n";
    final String CIERRE =  "\n ]\n}";

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

            while(lineaCliente!=null&&!lineaCliente.contains("]")){
                lineaCliente = lineaCliente.substring(lineaCliente.indexOf("{")+1, lineaCliente.indexOf("}"));
                String[] arrayCliente = lineaCliente.split(",");
                Clientes c1 = new Clientes(Integer.parseInt(limpiar(arrayCliente[0])), limpiar(arrayCliente[1]), limpiar(arrayCliente[2]), limpiar(arrayCliente[3]));
                listaClientes.add(c1);
                lineaCliente = leer.readLine();
            }
        } catch (IOException e) {
            System.out.println("Fallo en lectura de clientes json.");
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
            while(cadena!=null && !cadena.contains("]")){
                cadena = cadena.substring(cadena.indexOf("{")+1, cadena.indexOf("}"));
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

    public String clienteAJSON(Clientes c1){
        return "   {\"id\": "+c1.getId()+",\"nombre\": \""+c1.getNombre()+"\",\"telefono\": \""+c1.getTelefono()+"\",\"matricula\": \""+c1.getMatricula()+"\"}";
    }


    @Override
    public void escribirClientes(LinkedList<Clientes> listaClientes) {
        try (BufferedWriter escribir = Files.newBufferedWriter(fichClientes, StandardCharsets.UTF_8, StandardOpenOption.CREATE)){
            escribir.write(CABECERA);
            String lineaDeClientes = listaClientes.stream().map(this::clienteAJSON).reduce(
                    (String s1, String s2) -> { return s1 + ",\n" + s2;}
            ).orElse("");
            escribir.write(lineaDeClientes);
            escribir.write(CIERRE);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public String pagosAJSON(PagosRepostaje p1){
        return "   {\"id\": "+p1.getId()+",\"clienteId\": "+p1.getIDCLIENTE()+",\"fecha\": \""+p1.getFecha()+"\",\"importe\": "+p1.getImporte()+",\"litros\": "+p1.getLitros()+",\"combustible\": \""+p1.getCombustible()+"\"}";
    }
    @Override
    public void escribirPagos(LinkedList<PagosRepostaje> listaPagos) {
        try (BufferedWriter escribir=Files.newBufferedWriter(fichPagos)){
            escribir.write(CABECERA);
            String conversion=listaPagos.stream().map(this::pagosAJSON).reduce(
                    (String s1,String s2) ->{return s1 + ",\n" +s2;}
            ).orElse("");
            escribir.write(conversion);

            escribir.write(CIERRE);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void escribirCliente(Clientes c1) {
        LinkedList<Clientes> listaClientes = leerClientes();
        listaClientes.add(c1);
        escribirClientes(listaClientes);
    }

    @Override
    public void escribirPago(PagosRepostaje p1) {
        LinkedList<PagosRepostaje>listaPagos=leerPagos();
        listaPagos.add(p1);
        escribirPagos(listaPagos);
    }
}
