public class Arbol implements Comparable<Arbol>{
    private int id;
    private String nombre;
    private String especie;
    private int edad;
    private double altura;

    public Arbol(int id, String nombre, String especie, int edad, double altura) {
        this.id = id;
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
        this.altura = altura;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public int getEdad() {
        return edad;
    }

    public double getAltura() {
        return altura;
    }

    @Override
    public String toString() {
        return "Arbol [ ID=" + id + ", nombre='" + nombre + '\'' + ", especie='" + especie + '\'' + ", edad=" + edad + ", altura=" + altura + ']';
    }

    @Override
    public int compareTo(Arbol o) {
        int num = this.especie.compareTo(o.getEspecie());
        if(num == 0){
            num = this.nombre.compareTo(o.getNombre());
            if(num == 0){
                num = this.id - o.getId();
            }
        }
        return num;
    }
    public String toJson(){
        return "{ID=" + id + ", nombre='" + nombre + '\'' + ", especie='" + especie + '\'' + ", edad=" + edad + ", altura=" + altura + '}';
    }
}
