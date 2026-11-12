
package mansionzombie;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    static Scanner sc = new Scanner(System.in);
    
    public static void pedirValidar(Habitacion h1, Superviviente s1){
        boolean salir = false;
        
        while(!salir && s1.vivo()){
            mostrarResumen(h1, s1);
            mostrarMenu(h1, s1);
            int op = sc.nextInt();
            
            if(op == 1 && s1.vivo() && h1.getNumZombies() > 0){
                System.out.println("Combatiendo...");
                Acciones.Combatir(s1);
                if(s1.vivo())
                    System.out.println("Has derrotado al zombie.");
                    h1.setNumZombies(h1.getNumZombies()-1);
            } else if (op == 2 && s1.vivo()&& h1.getNumZombies()==0&&h1.getBusqueda()>0){
                System.out.println("Buscando...");                
                Acciones.buscar(s1, h1);
                h1.setBusqueda(h1.getBusqueda()-1);
            } else if (op == 3 && s1.vivo() && h1.getNumZombies()==0 && s1.isBotiquin()){
                System.out.println("Curando ...");
                Acciones.curar(s1);
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
    
    private static void mostrarResumen(Habitacion h1, Superviviente s1){
        System.out.println("-------------------");
        System.out.println("Habitacion: "+Habitacion.numHabitación+" de "+Habitacion.maxHabitaciones);
        System.out.println("Vidas: "+s1.getPuntosVida());
        System.out.println("Armas: "+s1.getArmas());
        System.out.println("Proteciones: "+s1.getProtecciones());
        System.out.println("Botiquin: "+s1.isBotiquin());
        System.out.println("Tienes "+h1.getBusqueda()+" busquedas.");
        System.out.println("Hay "+h1.getNumZombies()+" zombies en la habitación.");
        System.out.println("-------------------");
    }
}
