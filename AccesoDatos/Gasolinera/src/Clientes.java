import java.util.Locale;
import java.util.Scanner;

public class Clientes implements Comparable<Clientes>{
    public static int contId;
    private int indentificador;
    private String nombre;
    private String telefono;
    private String matricula;
    Scanner sc=new Scanner(System.in);

    public Clientes(int indentificador, String nombre, String telefono, String matricula) {
        this.indentificador = indentificador;
        setNombre(nombre.strip());
        setTelefono(telefono.strip());
        setMatricula(matricula.strip());
    }

    public int getIndentificador() {
        return indentificador;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        while (telefono == "" || telefono == null){
            System.out.println("No vale un telefono vacio ");
            System.out.println("Indica un telefono nuevo");
            telefono=sc.nextLine();
        }
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        while (nombre == "" || nombre == null){
            System.out.println("No vale un nombre vacio ");
            System.out.println("Indica un nombre nuevo");
            nombre=sc.nextLine();
        }
        this.nombre = nombre;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        while (matricula == "" || matricula == null){
            System.out.println("No vale un matricula vacio ");
            System.out.println("Indica un matricula nuevo");
            matricula=sc.nextLine();
        }
        this.matricula = matricula.toUpperCase();
    }

    @Override
    public String toString() {
        return indentificador+"\t"+nombre+"\t"+telefono+"\t"+matricula;
    }

    @Override
    public int compareTo(Clientes o) {
        int resultado = this.nombre.toLowerCase().compareTo(o.getNombre().toLowerCase());
        if(resultado == 0){
            resultado = this.indentificador-o.getIndentificador();
        }
        return resultado;
    }
}
