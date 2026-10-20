import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;

public class Main {

    private static final Path DIRECTORIO_ENTRADA_DATOS = Path.of("datos/entrada");
    private static final Path FICHERO_ENTRADA_1 = DIRECTORIO_ENTRADA_DATOS.resolve("arboles1.jsonl");
    private static final Path FICHERO_ENTRADA_2 = DIRECTORIO_ENTRADA_DATOS.resolve("arboles2.jsonl");
    private static final Path FICHERO_ENTRADA_3 = DIRECTORIO_ENTRADA_DATOS.resolve("id_arbol.bin");
    private static final Path FICHERO_ENTRADA_4 = DIRECTORIO_ENTRADA_DATOS.resolve("arboles3.jsonl");
    private static final Path DIRECTORIO_SALIDA_DATOS = Path.of("datos/salida");
    private static final Path FICHERO_SALIDA_1 = DIRECTORIO_SALIDA_DATOS.resolve("arbol1.txt");


    public static void main(String[] args) {
        ej5JSONDuplicadosYMalFormato();
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
        if(!Files.exists(FICHERO_ENTRADA_1)){
            System.out.println("No existe "+FICHERO_ENTRADA_1);
        } else{
            if(!Files.exists(FICHERO_SALIDA_1)){
                try {
                    Files.createFile(FICHERO_SALIDA_1);
                } catch (IOException e) {
                    System.out.println("Error al crear fichero "+FICHERO_SALIDA_1+" "+e.getMessage());
                }
            }
            try(BufferedReader leer = Files.newBufferedReader(FICHERO_ENTRADA_1);
                BufferedWriter escribir = Files.newBufferedWriter(FICHERO_SALIDA_1, StandardCharsets.UTF_8, StandardOpenOption.CREATE)) {
                String linea = leer.readLine();
                a1 = ParseadorArboles.parsear(linea);
                escribir.write(a1.getNombre()+"\n");
            } catch (FormatoJsonIncorrectoException e) {
                System.out.println("Error con el formato de linea JSON.");
            } catch (TipoDatoIncorrectoException e) {
                System.out.println("Error con tipo de dato de la linea JSON");
            } catch (IOException e) {
                System.out.println("Error al leer o escribir");
            }
        }
        return a1;
    }

    public static HashMap<Integer, Arbol> ej3LecturaMapaArboles(){
        HashMap<Integer, Arbol> mapa = new HashMap<>();
        if(!Files.exists(FICHERO_ENTRADA_2)){
            System.out.println("No existe el fichero "+FICHERO_ENTRADA_2);
        } else {
            try (BufferedReader leer = Files.newBufferedReader(FICHERO_ENTRADA_2)){

                String linea = leer.readLine();
                while(linea != null){
                    Arbol a1  = ParseadorArboles.parsear(linea);
                    mapa.putIfAbsent(a1.getId(), a1);
                    linea = leer.readLine();
                }
                System.out.println("Hay "+mapa.size()+" arboles en el mapa del ejercicio 3.");
            } catch (FormatoJsonIncorrectoException e) {
                System.out.println("Error con el formato de linea JSON.");
            } catch (TipoDatoIncorrectoException e) {
                System.out.println("Error con tipo de dato de la linea JSON");
            } catch (IOException e) {
                System.out.println("Error al leer o escribir");
            }
        }
        return mapa;
    }

    public static void ej4BuscarArbolPorId(){
        HashMap<Integer, Arbol> mapa = ej3LecturaMapaArboles();
        if (Files.exists(FICHERO_ENTRADA_3)){
            try (DataInputStream leer = new DataInputStream(Files.newInputStream(FICHERO_ENTRADA_3))){
                int id = leer.readInt();
                boolean encontrado = mapa.containsKey(id);
                if(encontrado){
                    System.out.println(mapa.get(id).toString());
                } else {
                    System.out.println("No existe un arbol con el id "+id);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else{
            System.out.println("el fichero binario "+FICHERO_ENTRADA_3+" no existe");
        }

    }

    public static void ej5JSONDuplicadosYMalFormato(){
        if(Files.exists(FICHERO_ENTRADA_4)){
            HashMap<Integer, Arbol> mapa = new HashMap<>();
            int contLinea = 1;
            try (BufferedReader leer = Files.newBufferedReader(FICHERO_ENTRADA_4)){
                String linea = leer.readLine();
                while(linea != null){
                    try {
                        Arbol a1 = ParseadorArboles.parsear(linea);
                        if(a1!=null)
                            mapa.putIfAbsent(a1.getId(), a1);
                        else
                            System.out.println("Se ha descartado la linea "+contLinea+" por arbol nulo.");
                    } catch (FormatoJsonIncorrectoException e) {
                        System.out.println("Se ha descartado la linea "+contLinea+" por formato incorrecto de JSON.");
                    } catch (TipoDatoIncorrectoException e) {
                        System.out.println("Se ha descartado la linea "+contLinea+" por tipo de dato incorrecto.");
                    }
                    contLinea ++;
                    linea = leer.readLine();
                }
            } catch (IOException e) {
                System.out.println("Error en la lectura del fichero "+FICHERO_ENTRADA_4+" "+ e.getMessage());
            }
            System.out.println("Se han añadido "+mapa.size()+ " en el mapa de ejercicio 4.");
        } else {
            System.out.println("El fichero "+FICHERO_ENTRADA_4+" no existe.");
        }

    }

}
