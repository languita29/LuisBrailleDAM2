import jdk.swing.interop.SwingInterOpUtils;

import java.io.IOException;
import java.util.*;

public class Menu{
    static Scanner sc=new Scanner(System.in);
    public static void elegirOpcion(){
        try {
            GestionFicherosCSV f = new GestionFicherosCSV();
            LinkedList<Clientes> listaClientes= f.leerClientes();
            LinkedList<PagosRepostaje> listaPagos = f.leerPagos();

            int op= mostraInfo();
            while (op!=0){
                switch (op){
                    case 1->{

                        GestionClientes.altaCliente(listaClientes);

                    }
                    case 2-> {
                        GestionClientes.listarClientes(listaClientes);
                    }
                    case 3->{
                        GestionClientes.buscClientes(listaClientes);
                    }
                    case 4->{
                        GestionPagos.pago(listaClientes, listaPagos);
                    }case 5->{
                        GestionPagos.listarPagos(listaClientes, listaPagos);
                    }case 0->{
                        System.out.println("Hasta pronto.");
                    }
                    default -> {
                        System.out.println("Numero dado incorrecto");
                    }

                }

                op = Menu.mostraInfo();
            }

            f.escribirClientes(listaClientes);
            f.escribirPagos(listaPagos);

        } catch (IOException e) {
            System.out.println("Ha sucedido un error al crear los ficheros.");
        }

        }
    public static int mostraInfo(){
        System.out.println("===GESTION DE GASOLINERA===");
        System.out.println("1.Dar de alta un cliente");
        System.out.println("2.Listar clientes");
        System.out.println("3. Buscar clientes");
        System.out.println("4. Procesar un pago de repostaje");
        System.out.println("5. Consultar pagos");
        System.out.println("0. Salir");
        System.out.println("Opcion:");
        int op=sc.nextInt();
        return  op;
    }
}

