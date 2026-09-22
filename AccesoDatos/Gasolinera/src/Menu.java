import java.util.List;
import java.util.Scanner;

public  class Menu {
    public static void opcionesMenu(){

        Scanner sc=new Scanner(System.in);

        informacionMenu();
        int op=0;
        op=sc.nextInt();
        while(op!=0){
            switch(op){
                case 1:
                    GestionClientes.altaCliente();
                    break;
                case 2:

                    GestionClientes.listarClientes();

                    break;
                case 3:

                    GestionClientes.buscarClientes();
                    break;
                case 4:

                    GestionRepostaje.procesarPago();

                    break;
                case 5:

                    GestionRepostaje.consultarPagos();

                    break;
                default :
                    System.out.println("nuemero dado invalido vuelva a dar un numero en rango");
                    op=sc.nextInt();
            }
            informacionMenu();
            op=sc.nextInt();

        }
     }
     public static void informacionMenu(){
         System.out.println("=== GESTION DE GASOLINERA ===");
         System.out.println("1. Dar de alta un cliente");
         System.out.println("2. Listar clientes");
         System.out.println("3. Buscar clientes");
         System.out.println("4. Procesar un pago de repostaje");
         System.out.println("5. Consultar pagos");
         System.out.println("0. Salir");
         System.out.println("opcion:");
     }

}
