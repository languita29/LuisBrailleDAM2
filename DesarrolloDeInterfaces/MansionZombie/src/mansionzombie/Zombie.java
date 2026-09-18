
package mansionzombie;

public class Zombie {
    private int vidasRestantes;
    private int puntosAtaque;

    public Zombie() {
        this.vidasRestantes = dados();
        this.puntosAtaque = dados();
    }
    
    
    public int dados(){
        return (int) (Math.random()*2)+2+(0-1);//cambiar al num de habitacion cuando lo cree
    }
    public int getVidasRestantes() {
        return vidasRestantes;
    }

    public void setVidasRestantes(int vidasRestantes) {
        this.vidasRestantes = vidasRestantes;
    }

    public int getPuntosAtaque() {
        return puntosAtaque;
    }

    public void setPuntosAtaque(int puntosAtaque) {
        this.puntosAtaque = puntosAtaque;
    }

    @Override
    public String toString() {
        return "Zombie{" + "vidasRestantes=" + vidasRestantes + ", puntosAtaque=" + puntosAtaque + '}';
    }
    
}
