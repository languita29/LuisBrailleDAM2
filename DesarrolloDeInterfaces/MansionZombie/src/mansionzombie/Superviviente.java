package mansionzombie;

public class Superviviente extends Personaje {
    private final int MAX_VIDAS = 20;
    private boolean botiquin;
    private int armas;
    private int protecciones;
            
            
    public Superviviente() {
        super(20, 4);
        
        botiquin = false;
        armas = 0;
        protecciones = 0;
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
   
}
