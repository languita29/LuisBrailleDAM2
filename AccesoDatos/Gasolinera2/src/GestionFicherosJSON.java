import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.LinkedList;

public class GestionFicherosJSON implements InterfazJSON{

    Path directorio;
    Path clientes;
    Path pagos;

    public GestionFicherosJSON() throws IOException {
        this.directorio = Path.of("datosjson");
        this.clientes = directorio.resolve("clientes.json");
        this.pagos = directorio.resolve("pagos.json");

        if(!Files.exists(directorio)){
            Files.createDirectories(directorio);
        }
        if(!Files.exists(clientes)){
            Files.createFile(clientes);
            escribirCabecera(clientes);
        }
        if(!Files.exists(pagos)){
            Files.createFile(pagos);
        }
    }

    public void  escribirCabecera(Path fichero){
        try (BufferedWriter escribir = Files.newBufferedWriter(fichero, StandardCharsets.UTF_8, StandardOpenOption.CREATE)){

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public LinkedList<Clientes> leerClientes() {
        LinkedList<Clientes>listaClientes=new LinkedList<>();
        try (BufferedReader leer=Files.newBufferedReader(clientes)){
            leer.readLine();
            leer.readLine();
            String cliente=leer.readLine();
            while(cliente!=null){
                cliente= cliente.substring(1,cliente.indexOf("}"));
                String[] arrayCliente= cliente.split(",");
                Clientes c1=new Clientes(Integer.parseInt(arrayCliente[0].split(":")[1]),arrayCliente[1].split(":")[1],arrayCliente[2].split(":")[1],arrayCliente[3].split(":")[1]);
                listaClientes.add(c1);
                cliente=leer.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error en la lectura de clientes del fichero. "+e.getMessage());
        }
        return listaClientes;
    }

    @Override
    public void escribirClientes(Clientes c1) {
        try (BufferedWriter escribir=Files.newBufferedWriter(clientes, StandardCharsets.UTF_8, StandardOpenOption.APPEND)){
            escribir.newLine();
            escribir.write("{\"id\": "+c1.getId()+",\"nombre\": \""+c1.getNombre()+"\",\"telefono\": \""+c1.getTelefono()+"\",\"matricula\": \""+c1.getMatricula()+"\"}");
        } catch (IOException e) {
            System.out.println("Error en la escritura de clientes del fichero. "+e.getMessage());
        }
    }

    @Override
    public LinkedList<PagosRepostaje> leerPagos() {
        LinkedList<PagosRepostaje>listaPagos=new LinkedList<>();
        try (BufferedReader leer=Files.newBufferedReader(pagos)){
            leer.readLine();
            leer.readLine();
            String pagos=leer.readLine();
            while(pagos!=null){
                pagos=pagos.substring(1,pagos.indexOf("}"));
                String[] arrayPagos= pagos.split(",");
                PagosRepostaje p1=new PagosRepostaje(Integer.parseInt(arrayPagos[0].split(":")[1]),Integer.parseInt(arrayPagos[1].split(":")[1]),arrayPagos[2].split(":")[1],Double.parseDouble(arrayPagos[3].split(":")[1]),Double.parseDouble(arrayPagos[4].split(":")[1]),arrayPagos[5].split(":")[1]);
                listaPagos.add(p1);
                pagos=leer.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error en la lectura de pagos del fichero. "+e.getMessage());
        }
        return listaPagos;
    }

    @Override
    public void escribirPagos(PagosRepostaje p1) {
        try (BufferedWriter escribir=Files.newBufferedWriter(pagos, StandardCharsets.UTF_8, StandardOpenOption.APPEND)){
                escribir.newLine();
                escribir.write("{ \"id\" :"+p1.getId()+",\"clienteID\" :"+p1.getIDCLIENTE()+",\"fecha\": \""+p1.getFecha() +"\",\"importe\": "+p1.getImporte()+",\"litros\": "+p1.getLitros()+",\"combustible\": \""+p1.getCombustible()+"\"},");
        } catch (IOException e) {
            System.out.println("Error en la escritura de pagos del fichero. "+e.getMessage());

        }
    }
}
