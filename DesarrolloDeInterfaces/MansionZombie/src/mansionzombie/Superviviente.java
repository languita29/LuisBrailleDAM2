
package mansionzombie;

public class Superviviente {
    private final int VIDAS=20;
    private int vidasRestantes;
    private int puntosAtaque;
    private boolean botiquin;
    private int armas;
    private int protecciones;

    public Superviviente() {
        this.vidasRestantes =20 ;
        this.puntosAtaque = 4;
        this.botiquin = false;
        this.armas = 0;
        this.protecciones = 0;
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
        return "Superviviente" + "VIDAS=" + VIDAS + ", vidasRestantes=" + vidasRestantes + ", puntosAtaque=" + puntosAtaque + ", botiquin=" + botiquin + ", armas=" + armas + ", protecciones=" + protecciones;
    }
    
    
}
