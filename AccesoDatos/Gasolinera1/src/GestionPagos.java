import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.*;


public class GestionPagos {

    static Scanner sc=new Scanner(System.in);

    public static void pago(LinkedList<Clientes> listaClientes, LinkedList<PagosRepostaje> listaPagos){

        int id;
        if(listaClientes.isEmpty()){
            System.out.println("No hay clientes en la lista");
        }else {
            GestionClientes.listarClientes(listaClientes);
            System.out.println("Indicame el id del cliente");
            id=sc.nextInt();
            while(id<0){
                System.out.println("Indicame el id del cliente");
                id=sc.nextInt();
            }
            boolean existe=false;
            for (Clientes c1:listaClientes){
                if(c1.getId()==id){
                    existe=true;
                }
            }
            sc.nextLine();

            if(existe){
                DateTimeFormatter formatoCorrecto = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                boolean valido = false;
                System.out.println("Indicame la fecha");
                String fecha = sc.nextLine();

                if(fecha.isBlank()){
                    fecha = LocalDate.now().format(formatoCorrecto);
                } else {
                    while(!valido){
                        try{
                            LocalDate.parse(fecha, formatoCorrecto);
                            valido = true;
                        } catch (DateTimeException e) {
                            System.out.println("Indicame la fecha");
                            fecha = sc.nextLine();
                        }
                    }
                }

                System.out.println("El importe");
                double importe = decimalCorrecto();


                System.out.println("Indicame los litros");
                double litros = decimalCorrecto();
                sc.nextLine();


                System.out.println("Indicame que combustible has echado");
                String combustible=sc.nextLine();
                while(combustible.isBlank()){
                    System.out.println("Combustible esta vacio vuelva a indicarlo");
                    combustible=sc.nextLine();
                }

                PagosRepostaje p1 = new PagosRepostaje(ultimoIdPagos(listaPagos), id, fecha, importe, litros, combustible);
                listaPagos.add(p1);
                System.out.println("Pago "+p1.getId()+" registrado para "+consultaNombreCliente(listaClientes, p1.getIDCLIENTE())+": "+importe+" €.");
            } else {
                System.out.println("Cliente seleccionado no existe.");
            }

        }

    }

    public static double decimalCorrecto(){

        double num = sc.nextDouble();

        while (num < 0 || Math.round(num*100)/100.0 != num){
            System.out.println("Has indicado un decimal incorrecto.");
            num = sc.nextDouble();
        }
        return num;
    }

    public static void listarPagos(LinkedList<Clientes> listaClientes, LinkedList<PagosRepostaje> listaPagos){
        if(!listaPagos.isEmpty()){
            System.out.println("ID\tCLIENTE\tFECHA\tIMPORTE\tLITROS\tCOMBUSTIBLE");
            Collections.sort(listaPagos);
            for(PagosRepostaje p1: listaPagos){
                System.out.println(p1.getId()+"\t"+consultaNombreCliente(listaClientes, p1.getIDCLIENTE())+"\t"+p1.getFecha()+"\t"+p1.getImporte()+"\t"+p1.getLitros()+"\t"+p1.getCombustible());
            }
        } else {
            System.out.println("Lista de pagos está vacía.");
        }

    }

    public static int ultimoIdPagos(LinkedList<PagosRepostaje>listaPagos){
        int num=0;
        for(PagosRepostaje p1:listaPagos)
            num=Math.max(p1.getId(),num);
        return ++num;
    }

    public static String consultaNombreCliente(LinkedList<Clientes> listaClientes, int idCliente){
        String nombre = "";
        for(Clientes c1 : listaClientes){
            if(c1.getId() == idCliente){
                nombre = c1.getNombre();
            }
        }
        return nombre;
    }
}
