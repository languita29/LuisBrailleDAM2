import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
//importo las interfaces de IOException por que luego voy a tirar un try cacht
//tambien las interfaces de listas y de scaner


public  class Menu {
    public static void opcionesMenu(){


        try {
            //Creo un objeto de tipo FicheroCSV
            FicherosCSV f1 = new FicherosCSV();
            //Creo dos listas una que sea listarClientes que van a guardar lo que les devuelvan los metodos f1.leer Clientes y repostajes
            LinkedList<Clientes> listaClientes = f1.leerClientes();
            LinkedList<PagosDeRepostajes> listaRepostajes = f1.leerRepostajes();
            //Despues les paso a las clases Gestion Clientes y repostajes Las listas con el contenido que he creado antes
            GestionClientes.ultimoId(listaClientes);
            GestionRepostaje.ultimoId(listaRepostajes);
            Scanner sc=new Scanner(System.in);
            //llamo de nuevo al metodo menu para que me saque que opciones tengo
            informacionMenu();
            //creo un case segun la op que me de el usuario hago una cosa o otra
            int op;
            op=sc.nextInt();
            while(op!=0){
                switch(op){
                    case 1:
                        //Llamamos a la clase y le pasamos la lista que tenemos
                        GestionClientes.altaCliente(listaClientes);
                        break;
                    case 2:
                        //Llamamos a la clase y le pasamos la lista que tenemos
                        GestionClientes.listarClientes(listaClientes);

                        break;
                    case 3:
                        System.out.print("Texto que buscar: ");
                        sc.nextLine();
                        //le pedimos que indique que palabra quiere buscar
                        String palabra=sc.nextLine();
                        //comprobamos que la palabra no este vacia y si pasa pues no paramos de pedirla
                        while(palabra.isEmpty()){
                            System.out.println("No puede estar vacía la palabra: ");
                            palabra = sc.nextLine();
                        }

                        LinkedList<Clientes> clienteEncontrados = GestionClientes.buscarClientes(palabra, listaClientes);
                        GestionClientes.listarClientes(clienteEncontrados);
                        break;
                    case 4:

                        GestionRepostaje.procesarPago(listaClientes, listaRepostajes);

                        break;
                    case 5:

                        GestionRepostaje.consultarPagos(listaRepostajes, listaClientes);

                        break;
                    default :
                        System.out.println("nuemero dado invalido vuelva a dar un numero en rango");
                }
                informacionMenu();
                op=sc.nextInt();

            }
            System.out.println("Saliendo del programa ... guardando datos.");
            f1.guardarClientes(listaClientes);
            f1.guardarRepostajes(listaRepostajes);
        } catch (IOException e){
            System.out.println("No se ha podido crear o acceder a los ficheros, comprueba permisos de acceso a ellos.");
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
