import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public  class Menu {
    public static void opcionesMenu(){

        FicherosCSV f1 = new FicherosCSV();

        LinkedList<Clientes> listaClientes = f1.leerClientes();
        LinkedList<PagosDeRepostajes> listaRepostajes = f1.leerRepostajes();

        Scanner sc=new Scanner(System.in);

        informacionMenu();
        int op=0;
        op=sc.nextInt();
        while(op!=0){
            switch(op){
                case 1:
                    GestionClientes.altaCliente(listaClientes);
                    break;
                case 2:

                    GestionClientes.listarClientes(listaClientes);

                    break;
                case 3:
                    System.out.print("Texto que buscar: ");
                    String palabra=sc.nextLine();
                    LinkedList<Clientes> clienteEncontrados = GestionClientes.buscarClientes(palabra, listaClientes);
                    GestionClientes.listarClientes(clienteEncontrados);
                    break;
                case 4:

                    GestionRepostaje.procesarPago(listaClientes);

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
        System.out.println("Saliendo del programa ... guardando datos.");
        f1.guardarClientes(listaClientes);
        f1.guardarRepostajes(listaRepostajes);
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
