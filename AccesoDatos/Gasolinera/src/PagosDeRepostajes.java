import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class PagosDeRepostajes {
    Scanner sc=new Scanner(System.in);
    private int identificador;
    private int idCliente;
    private Date fecha;
    private double importe;
    private  double litros;
    private String combustible;

    public PagosDeRepostajes(int identificador, int idCliente, Date fecha, double importe, double litros, String combustible) {
        setIdentificador(identificador);
        this.idCliente = idCliente;//falta verificar si el cliente existe
        this.fecha = fecha;
        this.importe = importe;
        this.litros = litros;
        this.combustible = combustible;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        while (identificador<0){
            System.out.println("el numero dado es negativo vuelve a dar otro ");
            sc.nextLine();
            identificador=sc.nextInt();
        }
        this.identificador = identificador;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        if (fecha== null){
            System.out.println("La fecha indicada esta en blanco se pondra la de hoy");
            this.fecha= new Date();
        }
        this.fecha = fecha;
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
}
