import jdk.swing.interop.SwingInterOpUtils;

import java.util.*;

public class GestionClientes {

    static FicherosCSV f1=new FicherosCSV();

    public static void altaCliente(LinkedList<Clientes> listaClientes){
        Scanner sc = new Scanner(System.in);

        String nombre;
        String telefono;
        String matricula;

        System.out.println("Aqui se crea el cliente ");
        System.out.println("Indica nombre:");
        nombre = sc.nextLine();
        System.out.println("Indica telefono:");
        telefono = sc.nextLine();
        System.out.println("Indica matricula:");
        matricula = sc.nextLine();
        
        if (buscarClientes(matricula).isEmpty()){
            Clientes c1 = new Clientes(Clientes.contId, nombre,telefono,matricula);
            Clientes.contId ++;
            listaClientes.add(c1);
        } else{
            System.out.println("Ya exite");
        }

    }




    public static void listarClientes(LinkedList<Clientes> listaClientes){

       if (listaClientes.isEmpty()){
           System.out.println("No exite el cliente");
       }else{//ordenar lista
           System.out.println("ID\tNOMBRE\tTELEFONO\tMATRICULA\t");
           for(Clientes c1: listaClientes){

               System.out.println(c1.toString());
           }
       }
    }
    public static LinkedList<Clientes> buscarClientes(String palabra, LinkedList<Clientes> lista){

        palabra=palabra.toLowerCase();
        LinkedList<Clientes> clienteEncontrados=new LinkedList<>();
        for (Clientes c1:lista){
            if(c1.getNombre().toLowerCase().contains(palabra) || c1.getMatricula().toLowerCase().contains(palabra) || c1.getTelefono().toLowerCase().contains(palabra)){
                clienteEncontrados.add(c1);
            }
        }
        return clienteEncontrados;
    }
}
