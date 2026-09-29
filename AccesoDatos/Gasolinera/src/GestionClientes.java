import jdk.swing.interop.SwingInterOpUtils;

import java.util.*;

public class GestionClientes {

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
        
        if (buscarClientes(matricula, listaClientes).isEmpty()){
            Clientes c1 = new Clientes(Clientes.contId, nombre,telefono,matricula);
            Clientes.contId ++;
            listaClientes.add(c1);
            System.out.println("Cliente creado con el id "+c1.getIndentificador());
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

    public static String nombreCliente(LinkedList<Clientes> listaClientes, int id){

        Iterator<Clientes> iterador = listaClientes.iterator();
        boolean encontrado = false;
        String nomCliente = null;

        while(iterador.hasNext() && encontrado == false){
            Clientes c1 = iterador.next();
            if(c1.getIndentificador() == id){
                nomCliente = c1.getNombre();
                encontrado = true;
            }
        }

        return nomCliente;
    }
    public static void ultimoId(LinkedList <Clientes>lista){
        int id=1;

        for (Clientes c1: lista){
            id = Math.max(c1.getIndentificador(), id);
        }

        Clientes.contId = id + 1;
    }
}
