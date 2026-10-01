import jdk.swing.interop.SwingInterOpUtils;

import java.util.*;

public class GestionClientes {
   static Scanner  sc = new Scanner(System.in);
    public static void altaCliente(LinkedList<Clientes> listaClientes){


        String nombre;
        String telefono;
        String matricula;
        System.out.println("indica un nombre");
        nombre=sc.nextLine();

        while(nombre==null || nombre.isBlank()){
            System.out.println("El nombre no ha sido indicado vuelva a escribirlo");
            nombre=sc.nextLine().trim();
        }
        System.out.println("indica un telefono");
        telefono=sc.nextLine();

        while(telefono==null || telefono.isBlank()){
            System.out.println("El telefono no ha sido indicado vuelva a escribirlo");
            telefono=sc.nextLine().trim();
        }

        System.out.println("indica una matricula");
        matricula=sc.nextLine();
        while(matricula==null || matricula.isBlank()){
            System.out.println("La matricula no ha sido indicado vuelva a escribirlo");
            matricula=sc.nextLine();
        }
        Iterator<Clientes> iterador=listaClientes.iterator();

        boolean existe = false;

        while(iterador.hasNext() && !existe){
            Clientes c1=iterador.next();
            if(c1.getMatricula().equals(matricula.toUpperCase())){
                existe = true;
            }
        }

        if (!existe){
            Clientes c1 = new Clientes(Clientes.contId, nombre,telefono,matricula);
            Clientes.contId ++;
            listaClientes.add(c1);
            System.out.println("Cliente creado con el id "+c1.getIdentificador());
        } else{
            System.out.println("Ya exite cliente con esa matricula.");
        }

    }




    public static void listarClientes(LinkedList<Clientes> listaClientes){

       if (listaClientes.isEmpty()){
           System.out.println("No hay clientes en la lista.");
       }else{
           Collections.sort(listaClientes);
           System.out.println("ID\tNOMBRE\tTELEFONO\tMATRICULA\t");
           for(Clientes c1: listaClientes){

               System.out.println(c1.toString());
           }
       }
    }
    public static void buscarClientes(LinkedList<Clientes> lista){
        LinkedList<Clientes>listaEncontrados=new LinkedList<>();
        System.out.println("indica la palabra que quieres encontrar");
        String palabra=sc.nextLine();
        while (palabra==null||palabra.isBlank()){
            System.out.println("indica la palabra que quieres encontrar");
             palabra=sc.nextLine();
        }
        for(Clientes c1:lista){
            if(c1.getNombre().toLowerCase().contains(palabra.toLowerCase())||c1.getMatricula().toLowerCase().contains(palabra.toLowerCase())||c1.getTelefono().toLowerCase().contains(palabra.toLowerCase())){
                listaEncontrados.add(c1);
            }
        }

        listarClientes(listaEncontrados);

    }

    public static String nombreCliente(LinkedList<Clientes> listaClientes, int id){

        Iterator<Clientes> iterador = listaClientes.iterator();
        boolean encontrado = false;
        String nomCliente = null;

        while(iterador.hasNext() && encontrado == false){
            Clientes c1 = iterador.next();
            if(c1.getIdentificador() == id){
                nomCliente = c1.getNombre();
                encontrado = true;
            }
        }

        return nomCliente;
    }
    public static void ultimoId(LinkedList <Clientes>lista){
        int id=1;

        for (Clientes c1: lista){
            id = Math.max(c1.getIdentificador(), id);
        }

        Clientes.contId = id + 1;
    }
}
