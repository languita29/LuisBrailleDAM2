import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Main {

    private static final Path DIRECTORIO_ENTRADA_DATOS = Path.of("datos/entrada");
    private static final Path FICHERO_ENTRADA_1 = DIRECTORIO_ENTRADA_DATOS.resolve("arbol1.jsonl");
    private static final Path DIRECTORIO_SALIDA_DATOS = Path.of("datos/salida");
    private static final Path FICHERO_SALIDA_1 = DIRECTORIO_SALIDA_DATOS.resolve("arbol1.txt");


    public static void main(String[] args) {

    }

    public static boolean ej1PrepararDirectorioSalida(Path ruta){
        if(!Files.exists(ruta)){
            try {
                //Crear directorios intermedios??
                Files.createDirectories(ruta);
                System.out.println("Directorio "+ruta+" creado.");
                return true;
            } catch (IOException e) {
                System.out.println("Error al crear directorio de salida. "+e.getMessage());
            }
        } else {
            if (Files.isDirectory(ruta)){
                System.out.println("Ya existe el directorio. "+ruta);
            } else {
                System.out.println("La ruta "+ruta+" no es un directorio.");
            }
        }
        return false;
    }

    public static Arbol ej2LecturaEscritura(){
        Arbol a1 = null;
        try(BufferedReader leer = Files.newBufferedReader(FICHERO_ENTRADA_1);
            BufferedWriter escribir = Files.newBufferedWriter(FICHERO_SALIDA_1, StandardCharsets.UTF_8, StandardOpenOption.CREATE)) {
            String linea = leer.readLine();
            a1 = ParseadorArboles.parsear(linea);
            escribir.write(a1.getNombre()+"\n");
        } catch (IOException e) {
            System.out.println("Error al leer o escribir");
        } catch (FormatoJsonIncorrectoException e) {
            System.out.println("Error con el formato de linea JSON.");
        } catch (TipoDatoIncorrectoException e) {
            System.out.println("Error con tipo de dato de la linea JSON");
        }
        return a1;
    }
}
