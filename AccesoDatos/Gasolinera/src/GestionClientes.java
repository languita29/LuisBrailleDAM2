import java.util.Scanner;

public class GestionClientes {
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
        


        Clientes c1 = new Clientes();

    }




    public static void listarClientes(){
        System.out.println("Aqui se listan los clientes");
    }
    public static void buscarClientes(){
        System.out.println("Aqui se buscan los clientes");
    }
}
