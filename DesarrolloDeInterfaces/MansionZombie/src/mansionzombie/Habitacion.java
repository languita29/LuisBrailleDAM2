
package mansionzombie;

public class Habitacion {
    public static int maxHabitaciones;
    private int busqueda;
    public static int numHabitación = 1;
    private int numZombies;

    public Habitacion() {
        this.busqueda = 3;
        this.numZombies = 1;
    }

    public int getBusqueda() {
        return busqueda;
    }

    public void setBusqueda(int busqueda) {
        this.busqueda = busqueda;
    }

    public int getNumZombies() {
        return numZombies;
    }

    public void setNumZombies(int numZombies) {
        this.numZombies = numZombies;
    }

    @Override
    public String toString() {
        return "Habitacion{" + "busqueda=" + busqueda + ", numZombies=" + numZombies + '}';
    }
    
    
}
