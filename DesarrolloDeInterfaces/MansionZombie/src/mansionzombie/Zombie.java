
package mansionzombie;

public class Zombie extends Personaje{
    
    public Zombie() {
        super(dados(), dados()); 
    }
    
    public static int dados(){
        return (int) (Math.random()*2)+2+(Habitacion.habActual-1);
    }

    @Override
    public String toString() {
        return "Zombie{" + "vidasRestantes=" + getVidasRestantes() + ", puntosAtaque=" + getPuntosAtaque() + '}';
    }
    
}
