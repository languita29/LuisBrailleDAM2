import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.IOException;
import java.nio.file.*;
import java.util.LinkedList;

public class FicherosCSV implements Ficheros{
    Path directorio;
    Path clientes;
    Path pagos;

    public FicherosCSV() throws IOException {
        directorio = Path.of("datos");

        try {
            Files.createDirectory(directorio);

        } catch (FileAlreadyExistsException e) {
            System.out.println("Directorio "+directorio+" ya existe.");
        }

        clientes = directorio.resolve("clientes.csv");
        pagos = directorio.resolve("pagos.csv");


    }


    @Override
    public LinkedList<Clientes> leerClientes() {
        LinkedList<Clientes> listaClientes = new LinkedList<Clientes>();

        try (BufferedReader lectura = Files.newBufferedReader(clientes)) {
            lectura.readLine();

            String linea = lectura.readLine();

            while (linea != null) {

                String[] array = linea.split(";");

                int id = Integer.parseInt(array[0]);
                String nombre = array[1];
                String telefono = array[2];
                String matricula = array[3];

                Clientes c1 = new Clientes(id, nombre, telefono, matricula);

                listaClientes.add(c1);
                linea = lectura.readLine();
            }
        } catch (EOFException eof){
            eof.getMessage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return listaClientes;
    }

    @Override
    public LinkedList<PagosDeRepostajes> leerRepostajes() {
        LinkedList<PagosDeRepostajes> listaRepostajes = new LinkedList<>();
        try (BufferedReader lectura = Files.newBufferedReader(pagos)) {
            lectura.readLine();

            String lineaCliente = lectura.readLine();

            while (lineaCliente != null){
                String[] array = lineaCliente.split(";");

                int id = Integer.parseInt(array[0]);
                int idCliente = Integer.parseInt(array[1]);
                String fecha = array[2];
                double importe = Double.parseDouble(array[3]);
                double litros = Double.parseDouble(array[4]);
                String combustible = array[5];

                PagosDeRepostajes p1 = new PagosDeRepostajes(id, idCliente, fecha, importe, litros, combustible);
                listaRepostajes.add(p1);

                lineaCliente = lectura.readLine();
            }
        } catch (IOException e){
            System.out.println("Fallo en leerRepostajes: "+e.getMessage());
        }
        return listaRepostajes;
    }

    @Override
    public void guardarClientes( LinkedList<Clientes> listaClientes) {
        try(BufferedWriter escritura = Files.newBufferedWriter(clientes, StandardOpenOption.CREATE)){
            escritura.write("ID;NOMBRE;TELEFONO;MATRICULA");
            escritura.newLine();

            for(Clientes c1 : listaClientes){
                escritura.write(c1.getIndentificador()+";"+c1.getNombre()+";"+c1.getTelefono()+";"+c1.getMatricula());
                escritura.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error en guardarClientes: "+e.getMessage());;
        }
    }

    @Override
    public void guardarRepostajes( LinkedList<PagosDeRepostajes> listaRepostajes) {

        try(BufferedWriter escritura = Files.newBufferedWriter(pagos, StandardOpenOption.CREATE)){
            escritura.write("ID;CLIENTE;FECHA;IMPORTE;LITROS;COMBUSTIBLE");
            escritura.newLine();
            for(PagosDeRepostajes p1 : listaRepostajes){
                String fecha = p1.getFecha().getDayOfMonth()+"/"+p1.getFecha().getMonth()+"/"+p1.getFecha().getYear();
                escritura.write(p1.getIdentificador()+";"+ p1.getIdCliente()+";"+fecha+";"+p1.getImporte()+";"+p1.getLitros()+";"+p1.getCombustible());
                escritura.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error en guardarRepostajes: "+e.getMessage());;
        }




    }
}
