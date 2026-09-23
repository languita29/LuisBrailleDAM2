
package mansionzombie;

public class Jugadas {
    static public void combatir(Superviviente s1){
        int ronda = 1;
        
        Zombie z1 = new Zombie();
        
        while(z1.getVidasRestantes() > 0 && s1.getVidasRestantes() > 0){
            System.out.println("Ronda "+ronda+":");
            System.out.println("Vidas restantes superviviente: "+s1.getVidasRestantes());
            System.out.println("Vidas restantes zombie: "+z1.getVidasRestantes());
            
            int tiradaSuperviente =  dadoSuperviviente();
            System.out.println("Has atacado al zombie con una puntuacion en el dado de :"+ tiradaSuperviente +" más tus armas de "+s1.getArmas()+", al zombie le queda "+z1.getVidasRestantes()+" vidas.");
            z1.setVidasRestantes(z1.getVidasRestantes() - (tiradaSuperviente+s1.getArmas()));

            if(z1.getVidasRestantes()>0){
                int tiradaZombie = dadoZombie(z1);

                tiradaZombie = tiradaZombie - s1.getProtecciones();//hacer comprobacion para que no llegue a negativo

                s1.setVidasRestantes(s1.getVidasRestantes()- tiradaZombie);
                System.out.println("El zombie te ha atacado con "+tiradaZombie+", te quedan "+s1.getVidasRestantes()+" vidas restantes.");
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
