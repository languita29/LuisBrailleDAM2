
package mansionzombie;

public class Superviviente extends Personaje{
    private final int VIDAS=20;
    private boolean botiquin;
    private int armas;
    private int protecciones;

    public Superviviente() {
        super(20, 4);
        this.botiquin = false;
        this.armas = 0;
        this.protecciones = 0;
    }

    
    public boolean isBotiquin() {
        return botiquin;
    }

    public void setBotiquin(boolean botiquin) {
        this.botiquin = botiquin;
    }

    public int getArmas() {
        return armas;
    }

    public void setArmas(int armas) {
        this.armas = armas;
    }

    public int getProtecciones() {
        return protecciones;
    }

    public void setProtecciones(int protecciones) {
        this.protecciones = protecciones;
    }

    @Override
    public String toString() {
        return "Superviviente" + "VIDAS=" + VIDAS + ", vidasRestantes=" + getVidasRestantes() + ", puntosAtaque=" + getPuntosAtaque() + ", botiquin=" + botiquin + ", armas=" + armas + ", protecciones=" + protecciones;
    }
    
    
}
