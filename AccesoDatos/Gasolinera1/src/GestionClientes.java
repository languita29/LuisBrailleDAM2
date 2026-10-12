import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class GestionClientes {

    static Scanner sc=new Scanner(System.in);

    public static void altaCliente(LinkedList<Clientes>listaClientes){
        String nombre;
        String telefono;
        String matricula;
        System.out.println("Indicame el nombre del cliente");
        nombre=sc.nextLine().trim();
        while(nombre.isBlank()){
            System.out.println("Indicame el nombre del cliente");
            nombre=sc.nextLine().trim();
        }
        System.out.println("Indicame el telefono del cliente");
        telefono=sc.nextLine().trim();
        while(telefono.isBlank()){
            System.out.println("Indicame el telefono del cliente");
            telefono=sc.nextLine().trim();
        }
        System.out.println("Indicame la matricula del cliente");
        matricula=sc.nextLine().trim().toUpperCase();
        while(matricula.isBlank()){
            System.out.println("Indicame la matricula del cliente");
            matricula=sc.nextLine().trim().toUpperCase();
        }

        boolean existeMatricula = false;

        for (Clientes c1:listaClientes){
            if(c1.getMatricula().equals(matricula)){
                System.out.println("La matricula del cliente ya esta creada");
                existeMatricula = true;
            }

        }

        if(!existeMatricula){
            Clientes c1 = new Clientes(ultimoId(listaClientes),nombre,telefono,matricula);
            listaClientes.add(c1);
            System.out.println("Creado cliente con id "+c1.getId());
        }
    }
    public static void listarClientes(LinkedList<Clientes>listaClientes){
        Collections.sort(listaClientes);
        if(listaClientes.isEmpty()){
            System.out.println("No hay clientes en la lista");
        }else{
            System.out.println("ID\tNOMBRE\tTELEFONO\tMATRICULA");
            for (Clientes c1:listaClientes){
                System.out.println(c1.toString());
            }
        }
    }
    public static void buscClientes(LinkedList<Clientes> listaClientes){
        LinkedList<Clientes> clientesEncontrados = new LinkedList<>();
        System.out.println("Indica la palabra a buscar: ");
        String palabra = sc.nextLine().toLowerCase();

        while(palabra.isBlank()){
            System.out.println("Indica la palabra a buscar: ");
            palabra = sc.nextLine().toLowerCase();
        }

        for(Clientes c1 : listaClientes){
            if(c1.getNombre().toLowerCase().contains(palabra) || c1.getMatricula().toLowerCase().contains(palabra) || c1.getTelefono().contains(palabra)){
                clientesEncontrados.add(c1);
            }
        }

        listarClientes(clientesEncontrados);
    }
    public static int ultimoId(LinkedList<Clientes>listaClientes){
        int num = 0;

        for(Clientes c1 :listaClientes){
            num = Math.max(c1.getId(), num);
        }
        return ++num ;
    }
}
