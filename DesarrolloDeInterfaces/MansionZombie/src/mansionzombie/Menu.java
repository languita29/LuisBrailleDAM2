
package mansionzombie;

import java.util.*;

public class Menu {
    
    static Scanner sc=new Scanner(System.in);
    public static int menuDificultades(){
        
        int op;
        System.out.println("Elige el nivel de dificultad al que te gustaria jugar");
        System.out.println("1. Fácil: la mansión se supera jugando 5 habitaciones");
        System.out.println("2. Difícil: la mansión se supera jugando 10 habitaciones");
        op=sc.nextInt();
        while (op != 1 && op!= 2) {
            System.out.println("1. Fácil: la mansión se supera jugando 5 habitaciones");
            System.out.println("2. Difícil: la mansión se supera jugando 10 habitaciones");
            op=sc.nextInt(); 
        }
        return op;
        
    }
    
    public static void menuOpciones(Habitacion h1, Superviviente s1){
        System.out.println("Elija una opción: ");
        while(h1.getNumZombies()>0 && s1.getVidasRestantes()>0){
            System.out.println("1. Combatir zombie");
            int op = sc.nextInt();
            while(op != 1){
                System.out.println("1. Combatir zombie");
                op = sc.nextInt();
            }
            Jugadas.combatir(s1);
            h1.setNumZombies(h1.getNumZombies()-1);
        }
        if(h1.getNumZombies()==0 && s1.geth1.getNumZombies() > 0)
        
    
    
    
    
    
    }
    
    
    
}
