import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Scanner;

public class PagosDeRepostajes implements Comparable<PagosDeRepostajes>{
    Scanner sc=new Scanner(System.in);
    public static int idPagosCont;
    private int identificador;
    private final int idCliente;
    private LocalDate fecha;
    public final DateTimeFormatter FORMATO_FECHA=DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private double importe;
    private  double litros;
    private String combustible;

    public PagosDeRepostajes(int identificador, int idCliente, String fecha, double importe, double litros, String combustible) {
        this.identificador= identificador;
        this.idCliente = idCliente;
        setFecha(fecha);
        setCombustible(combustible);
        setImporte(importe);
        setLitros(litros);
    }

    public int getIdentificador() {
        return identificador;
    }


    public int getIdCliente() {
        return idCliente;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(String fechaPago) {
        if(fechaPago == ""){
            this.fecha = LocalDate.now();
        } else {
            boolean comprobacion = false;
            while(comprobacion == false){
                try{
                    this.fecha = LocalDate.parse(fechaPago, FORMATO_FECHA);
                    comprobacion =true;
                } catch ( DateTimeParseException errorFormato){
                    System.out.println("La fecha tiene que ser de este formato dd/MM/yyyy");
                    System.out.println("Indicalo de nuevo");
                    fechaPago=sc.nextLine();
                }
            }
        }


    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        while (importe<0){//no se como hacer que sea decimal aún
            System.out.println("el importe dado no es positivo indique uno nuevo");
            importe=sc.nextDouble();
        }
        this.importe = importe;
    }

    public double getLitros() {
        return litros;
    }

    public void setLitros(double litros) {
        while (litros<0){//no se como hacer que sea decimal aún
            System.out.println("la cantidad de litros dada no es positiva indique uno nuevo");
            sc.nextLine();
            litros=sc.nextDouble();
        }
        this.litros = litros;
    }

    public String getCombustible() {
        return combustible;
    }

    public void setCombustible(String combustible) {
        while (combustible == "" || combustible == null){//no se como hacer que sea decimal aún
            System.out.println("la cantidad de combustible no esta escrita por favor vuelva a intentarlo");
            combustible=sc.nextLine();
        }
        this.combustible = combustible;
    }

    @Override
    public String toString() {
        return identificador+"\t"+idCliente+"\t"+fecha+"\t"+importe+" €\t"+litros+"\t"+combustible;
    }

    @Override
    public int compareTo(PagosDeRepostajes o) {
        int fecha=o.getFecha().compareTo(this.fecha);
        if (fecha ==0){
             fecha=o.getIdentificador()-this.identificador;
        }
        return fecha;
    }
}
