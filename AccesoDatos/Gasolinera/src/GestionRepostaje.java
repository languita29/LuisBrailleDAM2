import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class GestionRepostaje {
    public static void procesarPago(LinkedList<Clientes> listaClientes, LinkedList<PagosDeRepostajes> listaRepostajes) {
        Scanner sc = new Scanner(System.in);
        GestionClientes.listarClientes(listaClientes);

        if (listaClientes.isEmpty()){
            System.out.println("Primero tienes que dar de alta un usuario.");
        } else {
            System.out.print("Dime el id del usuario: ");
            int id = sc.nextInt();
            while(id < 0){
                System.out.print("El id tine que ser positivo, indicalo de nuevo: ");
                id = sc.nextInt();

            }

            Iterator<Clientes> iterador = listaClientes.iterator();
            boolean clienteEncontrado = false;

            while(iterador.hasNext() && clienteEncontrado == false){
                Clientes c1 = iterador.next();
                if(c1.getIndentificador() == id){
                    System.out.println("Fecha (dd/MM/aaaa; vacío para hoy): ");
                    sc.nextLine();
                    String fecha=sc.nextLine();
                    System.out.println("Importe (€): ");
                    double importe=sc.nextDouble();
                    System.out.println("Litros: ");
                    double litros=sc.nextDouble();
                    System.out.println("Combustible: ");
                    sc.nextLine();
                    String combustible=sc.nextLine();

                    PagosDeRepostajes p1 = new PagosDeRepostajes(PagosDeRepostajes.idPagosCont,id,fecha, importe,litros,combustible);
                    listaRepostajes.add(p1);
                    System.out.println("Pago "+PagosDeRepostajes.idPagosCont+"registrado para "+ c1.getNombre()+": "+importe);
                    PagosDeRepostajes.idPagosCont ++;
                    clienteEncontrado = true;
                }
            }

            if(clienteEncontrado == false){
                System.out.println("No se ha encontrado el cliente.");
            }

        }
    }

    public static void consultarPagos(LinkedList<PagosDeRepostajes> listaRepostajes, LinkedList<Clientes> listaClientes){
        if(listaRepostajes.isEmpty()){
            System.out.println("No hay pagos registrados.");
        } else {
            System.out.println("ID\tCLIENTE\tFECHA\tIMPORTE\tLITROS\tCOMBUSTIBLE");
            Collections.sort(listaRepostajes);
            for (PagosDeRepostajes p1 : listaRepostajes){
                String nombre = GestionClientes.nombreCliente(listaClientes, p1.getIdCliente());
                if(nombre!=null){
                    String fecha = p1.FORMATO_FECHA.format(p1.getFecha());
                    System.out.println(p1.getIdentificador()+"\t"+nombre+"\t"+fecha+"\t"+ p1.getImporte()+" €\t"+ p1.getLitros()+"\t"+ p1.getCombustible());
                }
            }
        }
    }
    public  static void ultimoId(LinkedList<PagosDeRepostajes>lista){
       int id=1;
       for (PagosDeRepostajes p1:lista){
           id = Math.max(id, p1.getIdentificador());
       }

       PagosDeRepostajes.idPagosCont=id +1;
    }
}
