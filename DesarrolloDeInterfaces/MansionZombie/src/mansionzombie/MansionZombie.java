
package mansionzombie;

public class MansionZombie {

    public static void main(String[] args) {
        Superviviente s1=new Superviviente();
       int num= Menu.menuDificultades();
       int habitaciones=0;
       if (num==1){
           habitaciones=5;
       }else if(num ==2){
           habitaciones=10;
       }
       while(Habitacion.habActual <= habitaciones && s1.getVidasRestantes()>0){
           Habitacion h1 = new Habitacion();
           
           Menu.menuOpciones(s1, h1);
           
           
           
           
           
           
           
           
           Habitacion.habActual ++;
           
       }
    }
    
}
