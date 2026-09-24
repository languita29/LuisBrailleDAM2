import java.util.LinkedList;
import java.util.Scanner;

public class GestionRepostaje {
    public static void procesarPago(LinkedList<Clientes> listaClientes) {
        Scanner sc = new Scanner(System.in);
        GestionClientes.listarClientes(listaClientes);

        if (listaClientes.isEmpty()){
            System.out.println("Primero tienes que dar de alta un usuario.");
        } else {
            System.out.print("El id tine que ser positivo, indicalo de nuevo: ");
            int id = sc.nextInt();
            while(id < 0){
                System.out.print("El id tine que ser positivo, indicalo de nuevo: ");
                id = sc.nextInt();

            }


            for(Clientes c1 : listaClientes){
                if(c1.getIndentificador() == id)
                    //Solicitar datos de pago
                    //Crear pago
                    //Asignar id pago
                    //Puntos 4 y 5
            }
        }




    }

    public static void consultarPagos(){
        System.out.println("Mostramos los pagos correspondientes");
    }
}
