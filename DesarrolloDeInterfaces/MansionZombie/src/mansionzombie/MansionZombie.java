
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
       while(habitaciones>0 && s1.getPuntosAtaque()>0){
           habitaciones --;
       }
    }
    
}
