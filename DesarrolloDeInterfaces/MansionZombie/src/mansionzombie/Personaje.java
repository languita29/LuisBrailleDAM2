package mansionzombie;

public abstract class Personaje {
    private int puntosVida;
    private int puntosAtaque;

    public Personaje(int puntosVida, int puntosAtaque) {
        this.puntosVida = puntosVida;
        this.puntosAtaque = puntosAtaque;
    }
    
    public int dado(){
        return (int) ((Math.random()*puntosAtaque)+1);
    }
    
    public void recibirAtaque(int ataque){
        puntosVida =  Math.max(puntosVida-ataque, 0);
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public void setPuntosVida(int puntosVida) {
        this.puntosVida = puntosVida;
    }

    public int getPuntosAtaque() {
        return puntosAtaque;
    }

    public void setPuntosAtaque(int puntosAtaque) {
        this.puntosAtaque = puntosAtaque;
    }
    
    public boolean vivo(){
        return puntosVida>0;
    }
}
