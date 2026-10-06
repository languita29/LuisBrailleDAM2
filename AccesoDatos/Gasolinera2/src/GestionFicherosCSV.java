import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.LinkedList;

public class GestionFicherosCSV implements InterfazCSV {
    Path directorio;
    Path clientes;
    Path pagos;

    public GestionFicherosCSV() throws IOException {
        this.directorio = Path.of("datos");
        this.clientes = directorio.resolve("clientes.csv");
        this.pagos = directorio.resolve("pagos.csv");
        if(!Files.exists(directorio)){
            Files.createDirectories(directorio);
        }
        if(!Files.exists(clientes)){
            Files.createFile(clientes);
        }
        if(!Files.exists(pagos)){
            Files.createFile(pagos);
        }
    }

    @Override
    public LinkedList<Clientes> leerClientes() {
        LinkedList<Clientes>listaClientes=new LinkedList<>();
        try (BufferedReader leer=Files.newBufferedReader(clientes)){
            leer.readLine();
            String cliente=leer.readLine();
            while(cliente!=null){
                cliente= cliente.substring(0,cliente.length()-1);
               String[] arrayCliente= cliente.split(",");
               Clientes c1=new Clientes(Integer.parseInt(arrayCliente[0]),arrayCliente[1],arrayCliente[2],arrayCliente[3]);
               listaClientes.add(c1);
                cliente=leer.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error en la lectura de clientes del fichero. "+e.getMessage());
        }
        return listaClientes;
    }

    @Override
    public void escribirClientes(LinkedList<Clientes> listaClientes) {

        try (BufferedWriter escribir=Files.newBufferedWriter(clientes, StandardCharsets.UTF_8, StandardOpenOption.CREATE)){
            escribir.write("ID,NOMBRE,TELEFONO,MATRICULA;");
            for(Clientes c1:listaClientes){
                escribir.newLine();
                escribir.write(c1.getId()+","+c1.getNombre()+","+c1.getTelefono()+","+c1.getMatricula()+";");
            }
        } catch (IOException e) {
            System.out.println("Error en la escritura de clientes del fichero. "+e.getMessage());
        }
    }

    @Override
    public LinkedList<PagosRepostaje> leerPagos() {
        LinkedList<PagosRepostaje>listaPagos=new LinkedList<>();
        try (BufferedReader leer=Files.newBufferedReader(pagos)){
            leer.readLine();
            String pagos=leer.readLine();
            while(pagos!=null){
                pagos=pagos.substring(0,pagos.length()-1);
                String arrayPagos[]= pagos.split(",");
                PagosRepostaje p1=new PagosRepostaje(Integer.parseInt(arrayPagos[0]),Integer.parseInt(arrayPagos[1]),arrayPagos[2],Double.parseDouble(arrayPagos[3]),Double.parseDouble(arrayPagos[4]),arrayPagos[5]);
                listaPagos.add(p1);
                pagos=leer.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error en la lectura de pagos del fichero. "+e.getMessage());
        }
        return listaPagos;
    }

    @Override
    public void escribirPagos(LinkedList<PagosRepostaje> listaPagos) {
        try (BufferedWriter escribir=Files.newBufferedWriter(pagos)){
            escribir.write("ID,CLIENTE,FECHA,IMPORTE,LITROS,COMBUSTIBLE;");
            for(PagosRepostaje p1:listaPagos){
                escribir.newLine();
                escribir.write(p1.getId()+","+p1.getIDCLIENTE()+","+p1.getFecha() +","+p1.getImporte()+","+ p1.getLitros()+","+p1.getCombustible()+";");
            }
        } catch (IOException e) {
            System.out.println("Error en la escritura de pagos del fichero. "+e.getMessage());

        }
    }
}
