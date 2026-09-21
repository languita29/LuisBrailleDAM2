
package mansionzombie;

public class Jugadas {
    static public void combatir(Superviviente s1){
        int ataqueSuperviviente = 0;
        int ataqueZombie = 0;
        int ronda = 0;
        
        Zombie z1 = new Zombie();
        
        while(z1.getVidasRestantes() > 0 && s1.getVidasRestantes() > 0){
            System.out.println("Ronda "+ronda+":");
            System.out.println("Vidas restantes superviviente: "+s1.getVidasRestantes());
            System.out.println("Vidas restantes superviviente: "+z1.getVidasRestantes());
            
            ataqueSuperviviente = dadoSuperviviente() + s1.getArmas();
            System.out.println("Has atacado al zombie con una puntuacion en el dado de :"+(dadoSuperviviente()-s1.getArmas()) +" más tus armas de "+s1.getArmas());
            z1.setVidasRestantes(z1.getVidasRestantes() - ataqueSuperviviente);

            if(z1.getVidasRestantes()>0){
                ataqueZombie = dadoZombie(z1);

                ataqueZombie = ataqueZombie - s1.getArmas();//hacer comprobacion para que no llegue a negativo

                s1.setVidasRestantes(s1.getVidasRestantes()- ataqueZombie);
                System.out.println("El zombie te ha atacado con "+ataqueZombie);
            } 
        }
        if(z1.getVidasRestantes() > 0 && s1.getVidasRestantes() < 0){
            System.out.println("GAME OVER");
        }else if(z1.getVidasRestantes() <0 && s1.getVidasRestantes() > 0){
            System.out.println("Enhorabuena has matado al zombie");
        }
        
        
    
    }
    
    
    static public int dadoSuperviviente(){
        return (int)(Math.random()*4+1);
    }
    
    
    
    static public int dadoZombie(Zombie z1){
        return (int)(Math.random()*z1.getPuntosAtaque());
    }
    
}
