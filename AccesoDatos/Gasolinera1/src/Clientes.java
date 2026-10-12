public class Clientes  implements Comparable<Clientes>{
    private int id;
    private String nombre;
    private String telefono;
    private String matricula;
    public Clientes(int id, String nombre, String telefono, String matricula)  {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.matricula = matricula;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return getId()+"\t"+getNombre()+"\t"+getTelefono()+"\t"+getMatricula();
    }

    @Override
    public int compareTo(Clientes o) {
        int num =this.nombre.toLowerCase().compareTo(o.getNombre().toLowerCase());
        if(num==0){
            num=this.id-o.getId();
        }
        return num ;
    }
}
