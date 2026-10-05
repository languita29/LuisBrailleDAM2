import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class PagosRepostaje implements Comparable<PagosRepostaje>{
    private int id;
    private int idCliente;
    private String fecha;
    private double importe;
    private double litros;
    private String combustible;

    public PagosRepostaje(int id, int idCliente, String fecha, double importe, double litros, String combustible) {
        this.id = id;
        this.idCliente = idCliente;
        this.fecha = fecha;
        this.importe = importe;
        this.litros = litros;
        this.combustible = combustible;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIDCLIENTE() {
        return idCliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public double getLitros() {
        return litros;
    }

    public void setLitros(double litros) {
        this.litros = litros;
    }

    public String getCombustible() {
        return combustible;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    @Override
    public int compareTo(PagosRepostaje o) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fecha1 = LocalDate.parse(this.fecha, formato);
        LocalDate fecha2 = LocalDate.parse(o.fecha, formato);

        int resultado = fecha2.compareTo(fecha1);

        if(resultado == 0){
            resultado = o.id-this.id;
        }
        return resultado;
    }
}
