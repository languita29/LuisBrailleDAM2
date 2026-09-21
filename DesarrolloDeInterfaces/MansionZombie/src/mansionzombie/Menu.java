
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
    
    public static void menuOpciones(Superviviente s1){
        
        int op=0;
        if(null){
            System.out.println("1. Combatir contra un zombie: sólo estará disponible si hay al menos un zombie activo en\n" +
            "la habitación.");
            op=sc.nextInt();
            while(op!=1){
                System.out.println("1. Combatir contra un zombie: sólo estará disponible si hay al menos un zombie activo en\n" +
                "la habitación.");
                op=sc.nextInt();
            } 
            Jugadas.combatir(s1);
        }
        
    
    
    
    
    
    }
    
    
    
}
