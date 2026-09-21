
package mansionzombie;

public class Habitacion {
 private int busqueda;
 private int habActual;
 private int numZombies;

    public Habitacion() {
        this.busqueda = 3;
        this.habActual = 1;
        this.numZombies = 1;
    }
    public int getBusqueda() {
        return busqueda;
    }

    public void setBusqueda(int busqueda) {
        this.busqueda = busqueda;
    }

    public int getHabActual() {
        return habActual;
    }

    public void setHabActual(int habActual) {
        this.habActual = habActual;
    }

    public int getNumZombies() {
        return numZombies;
    }

    public void setNumZombies(int numZombies) {
        this.numZombies = numZombies;
    }

    @Override
    public String toString() {
        return "Habitacion{" + "busqueda=" + busqueda + ", habActual=" + habActual + ", numZombies=" + numZombies + '}';
    }
    
    
}
