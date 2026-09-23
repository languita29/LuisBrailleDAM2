
package mansionzombie;

public class MansionZombie {

    public static void main(String[] args) {
       Superviviente s1=new Superviviente();
       int num= Menu.menuDificultades();
       int habitaciones;
       if (num==1){
           habitaciones=5;
       }else {
           habitaciones=10;
       }
       while(Habitacion.habActual <= habitaciones && s1.getVidasRestantes()>0){
           Habitacion h1 = new Habitacion();
           
           Menu.menuOpciones(h1, s1);
           
           
           
           
           
           
           
           
           
           Habitacion.habActual ++;  
       }
    }
    
}
