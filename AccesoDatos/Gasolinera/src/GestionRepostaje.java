import java.util.LinkedList;
import java.util.Scanner;

public class GestionRepostaje {
    public static void procesarPago(LinkedList<Clientes> listaClientes) {
        Scanner sc = new Scanner(System.in);
        GestionClientes.listarClientes(listaClientes);

        if (listaClientes.isEmpty()){
            System.out.println("Primero tienes que dar de alta un usuario.");
        } else {
            System.out.print("Dime el id del usuario: ");
            int id = sc.nextInt();
            while(id < 0){
                System.out.print("El id tine que ser positivo, indicalo de nuevo: ");
                id = sc.nextInt();

            }

            for(Clientes c1 : listaClientes){
                if(c1.getIndentificador() == id){

                    System.out.println("Fecha (dd/MM/aaaa; vacío para hoy): ");
                    String fecha=sc.nextLine();
                    System.out.println("Importe (€): ");
                    double importe=sc.nextDouble();
                    System.out.println("Litros: ");
                    double litros=sc.nextDouble();
                    System.out.println("Combustible: ");
                    String combustible=sc.nextLine();
                    PagosDeRepostajes p1 = new PagosDeRepostajes(,id,importe,litros,combustible);
                    //Ver donde tengo que meter p1
                    System.out.println("Pago "+//id pago+"registrado para "+ c1.getNombre()+": "+importe);
                }
            }
        }




    }

    public static void consultarPagos(){
        System.out.println("Mostramos los pagos correspondientes");
    }
}
