import java.util.Locale;

public class Clientes implements Comparable<Clientes>{
    public static int contId;
    private int identificador;
    private String nombre;
    private String telefono;
    private String matricula;

    public Clientes(int identificador, String nombre, String telefono, String matricula) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.telefono = telefono;
        this.matricula = matricula.toUpperCase();
    }

    public static int getContId() {
        return contId;
    }

    public static void setContId(int contId) {
        Clientes.contId = contId;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return identificador+"\t"+nombre+"\t"+telefono+"\t"+matricula;
    }

    @Override
    public int compareTo(Clientes o) {
        int n=this.getNombre().toLowerCase().compareTo((o.getNombre().toLowerCase()));
        if(n==0){
            n=this.getIdentificador()-o.getIdentificador();
        }

        return n;
    }


}
