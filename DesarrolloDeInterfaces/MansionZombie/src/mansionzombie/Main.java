package mansionzombie;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        Superviviente s1 = new Superviviente();
        dificultad();
        
        while(s1.vivo() && Habitacion.numHabitación <= Habitacion.maxHabitaciones){
            Habitacion h1 = new Habitacion();
            
            Menu.pedirValidar(h1, s1);
            
            
            if(s1.vivo())
                Habitacion.numHabitación ++;
        }
        
        if(s1.vivo()){
            System.out.println("Has ganado!!");
        } else {
            System.out.println("GAME OVER...");
        }
    }
    
    public static void dificultad(){
        System.out.println("Indica la dificultad del juego:");
        System.out.println("    1. Fácil (5 habitaciones)");
        System.out.println("    2. Dificil (10 habitaciones)");
        int op = sc.nextInt();
        
        while(op!=1&&op!=2){
            System.out.println("Has indicado una opción incorrecta.");
            System.out.println("Indica la dificultad del juego:");
            System.out.println("    1. Fácil (5 habitaciones)");
            System.out.println("    2. Dificil (10 habitaciones)");
            op = sc.nextInt();
        }
        
        if(op==1){
            Habitacion.maxHabitaciones=5;
        } else {
            Habitacion.maxHabitaciones=10;
        }
        
        System.out.println("Has elegido "+Habitacion.maxHabitaciones+" habitaciones.");
    }
}
