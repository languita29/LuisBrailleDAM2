
package mansionzombie;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    static Scanner sc = new Scanner(System.in);
    
    public static void pedirValidar(Habitacion h1, Superviviente s1){
        boolean salir = false;
        
        while(!salir){
            mostrarMenu(h1, s1);
            int op = sc.nextInt();
            
            if(op == 1 && s1.vivo() && h1.getNumZombies() > 0){
                System.out.println("Combatiendo...");
                //combate
                if(s1.vivo())
                    h1.setNumZombies(h1.getNumZombies()-1);
            } else if (op == 2 && s1.vivo()&& h1.getNumZombies()==0&&h1.getBusqueda()>0){
                System.out.println("Buscando...");                
                //buqueda
                h1.setBusqueda(h1.getBusqueda()-1);
            } else if (op == 3 && s1.vivo() && h1.getNumZombies()==0 && s1.isBotiquin()){
                System.out.println("Curando ...");
                //curar
                s1.setBotiquin(false);
            } else if (op == 4 && s1.vivo() && Habitacion.numHabitación < Habitacion.maxHabitaciones){
                System.out.println("Pasando a la siguiente habitación.");
                salir = true;
            } else if (op == 4 && s1.vivo() && Habitacion.numHabitación == Habitacion.maxHabitaciones){
                System.out.println("Saliendo de la mansión.");
                salir = true;
            } else {
                System.out.println("Has indicado una opción incorrecta.");
            }
        }
        
        
        
    }
    
    public static void mostrarMenu(Habitacion h1, Superviviente s1){
        System.out.println("Elige una opción:");
        if(s1.vivo() && h1.getNumZombies() > 0){
            System.out.println("    1. Combatir");
        } else {
            if(s1.vivo()&& h1.getNumZombies()==0&&h1.getBusqueda()>0){
                System.out.println("    2. Buscar");
            }
            if(s1.vivo() && h1.getNumZombies()==0 && s1.isBotiquin()){
                System.out.println("    3. Curar");
            }
            if(s1.vivo() && h1.getNumZombies()==0 && Habitacion.numHabitación < Habitacion.maxHabitaciones){
                System.out.println("    4. Avanzar a la siguiente habitación");
            }
            if(s1.vivo() && h1.getNumZombies()==0 && Habitacion.numHabitación == Habitacion.maxHabitaciones){
                System.out.println("    4. Salir de la mansión");
            } 
        }
    }
}
