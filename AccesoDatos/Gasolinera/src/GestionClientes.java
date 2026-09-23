import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;
import java.util.Scanner;

public class GestionClientes {

    static FicherosCSV f1=new FicherosCSV();

    public static void altaCliente(){
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
            f1.guardarClientes(c1);
        } else{
            System.out.println("Ya exite");
        }

    }




    public static void listarClientes(){
       Collection<Clientes> listaClientes= f1.leerClientes();
       if (listaClientes.isEmpty()){
           System.out.println("No exite el cliente");
       }else{//ordenar lista
           System.out.println("ID\tNOMBRE\tTELEFONO\tMATRICULA\t");
           for(Clientes c1: listaClientes){

               System.out.println(c1.toString());
           }
       }
    }
    public static Collection<Clientes> buscarClientes(String palabra){

        palabra=palabra.toLowerCase();
        Collection <Clientes> lista=f1.leerClientes();
        Collection<Clientes> clienteEncontrados=new ArrayList<>();
        for (Clientes c1:lista){
            if(c1.getNombre().toLowerCase().contains(palabra) || c1.getMatricula().toLowerCase().contains(palabra) || c1.getTelefono().toLowerCase().contains(palabra)){
                clienteEncontrados.add(c1);
            }
        }
        return clienteEncontrados;
    }
}
