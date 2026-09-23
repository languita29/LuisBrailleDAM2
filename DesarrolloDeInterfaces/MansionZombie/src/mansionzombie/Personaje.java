package mansionzombie;


public abstract class Personaje {
    private int vidasRestantes;
    private int puntosAtaque;

    public Personaje(int vidasRestantes, int puntosAtaque) {
        this.vidasRestantes = vidasRestantes;
        this.puntosAtaque = puntosAtaque;
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
    
    
}
