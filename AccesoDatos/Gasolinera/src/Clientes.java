import java.util.Scanner;

public class Clientes implements Comparable<Clientes>{
    public static int contId = 1;
    private int indentificador;
    private String nombre;
    private String telefono;
    private String matricula;
    Scanner sc=new Scanner(System.in);

    public Clientes(int indentificador, String nombre, String telefono, String matricula) {
        this.indentificador = indentificador;
        setNombre(nombre);
        setTelefono(telefono);
        setMatricula(matricula);
    }

    public int getIndentificador() {
        return indentificador;
    }

    public void setIndentificador(int indentificador) {
        while (indentificador<0){
            System.out.println("No valen numeros negativos");
            System.out.printf("Indica un id nuevo");
            indentificador=sc.nextInt();
        }
          this.indentificador = indentificador;;

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
        //Hay que validar que la matricula no exite ya
        this.matricula = matricula.toUpperCase().strip();
    }

    @Override
    public String toString() {
        return indentificador+"\t"+nombre+"\t"+telefono+"\t"+matricula;
    }

    @Override
    public int compareTo(Clientes o) {
        
        return 0;
    }
}
