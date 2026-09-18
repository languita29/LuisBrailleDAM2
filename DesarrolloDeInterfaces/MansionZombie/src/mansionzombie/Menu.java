
package mansionzombie;

import java.util.*;

public class Menu {
    public static int menuDificultades(){
        Scanner sc=new Scanner(System.in);
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
    
    
    
    
    
}
