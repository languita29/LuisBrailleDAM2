package mansionzombie;

public class Acciones {
    public static void Combatir(Superviviente s1){
        int ataqueZombie;
        int ataqueSuperviviente;
        int i = 1;
        Zombie z1 = new Zombie();
        System.out.println("El zombie tiene "+z1.getPuntosVida()+" vidas.");
        System.out.println("El zombie tiene "+z1.getPuntosAtaque()+" ataques.");
        while(s1.vivo() && z1.vivo()){
            System.out.println("Ronda "+i);
            ataqueSuperviviente = s1.dado();
            System.out.println("Has lanzado "+ataqueSuperviviente+" de ataque y tienes "+s1.getArmas()+" armas disponibles.");
            ataqueSuperviviente += s1.getArmas();
            z1.recibirAtaque(ataqueSuperviviente);
            System.out.println("El zombie se queda con "+z1.getPuntosVida()+" vidas");
            if(z1.vivo()){
                ataqueZombie = z1.dado();
                System.out.println("El zombie ataca con "+ataqueZombie+" pero tienes "+s1.getProtecciones()+" protecciones.");
                ataqueZombie = Math.max(ataqueZombie-s1.getProtecciones(), 0);
                s1.recibirAtaque(ataqueZombie);
                System.out.println("Te quedas con "+s1.getPuntosVida()+" vidas");
            }
            
            i++;
        }           
    }
    
    public static void buscar(Superviviente s1, Habitacion h1){
        int tirada = dado();
        if(tirada >= 1 && tirada <= 75){
            tirada = dado();
            System.out.println("Has hecho ruido...");
            if(tirada >= 1 && tirada <= 40){
                System.out.println("Has tenido suerte, no ha pasado nada.");
            } else if(tirada >= 41 && tirada <= 80){
                System.out.println("Has alertado a un zombie.");
                h1.setNumZombies(h1.getNumZombies()+1);
            } else if(tirada >= 81 && tirada <= 100){
                System.out.println("Has alertado a dos zombies.");
                h1.setNumZombies(h1.getNumZombies()+2);
            }
        } else if(tirada >= 76 && tirada <= 90){
            if(s1.isBotiquin()){
                System.out.println("Has encontrado un botiquin pero ya tienes uno.");
            } else{
                System.out.println("Has encontrado un botiquin.");
                s1.setBotiquin(true);
            }
        } else if(tirada >= 91 && tirada <= 95){
            System.out.println("Has encontrado un protección.");
            s1.setProtecciones(s1.getProtecciones()+1);
        } else if(tirada >= 96 && tirada <= 100){
            System.out.println("Has encontrado una arma.");
            s1.setArmas(s1.getArmas()+1);
        }
    }
    
    private static int dado(){
        return (int) ((Math.random()*100)+1);
    }
    
    public static void curar(Superviviente s1){
        s1.setPuntosVida( Math.min(s1.getPuntosVida()+4, 20));
    }
}
