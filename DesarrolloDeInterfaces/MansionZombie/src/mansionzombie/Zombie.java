package mansionzombie;

public class Zombie extends Personaje {
    
    public Zombie() {
        super(resultadoDado(Habitacion.numHabitación), resultadoDado(Habitacion.numHabitación));
    }
    
    public static int resultadoDado(int numHab){
        return (int) ((Math.random()*2)+2+(numHab - 1));
    }
}
