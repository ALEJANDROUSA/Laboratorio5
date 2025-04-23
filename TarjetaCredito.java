package Banco;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TarjetaCredito extends Cuenta implements IDepositar {

    private final double cupo;
    private LocalDate fechaUltimaCompra; 
    private double valorUltimaCompra;
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    public TarjetaCredito(String numeroProducto, int anioApertura, Titular titular, double cupo) {
  
        super(numeroProducto, anioApertura, cupo, titular);
        if (cupo <= 0) {
            throw new IllegalArgumentException("El cupo debe ser positivo.");
        }
        this.cupo = cupo;
        this.fechaUltimaCompra = null;
        this.valorUltimaCompra = 0;
    }

 
    @Override
    public boolean depositar(double monto) {
         if (monto <= 0) {
            System.err.println("Error (TC " + numeroProducto + "): Monto de pago inválido: " + monto);
            return false;
        }
    
        this.saldo += monto;
        if (this.saldo > this.cupo) {
            this.saldo = this.cupo; 
        }
        System.out.println("Pago de " + monto + " aplicado a TC " + numeroProducto + ". Crédito disponible: " + this.saldo);
        return true;
    }

   
    @Override
    public boolean retirarBase(double monto) {
        if (monto <= 0) {
            System.err.println("Error (TC " + numeroProducto + "): Monto de compra inválido: " + monto);
            return false;
        }
      
        if (this.saldo >= monto) {
            this.saldo -= monto;
            this.fechaUltimaCompra = LocalDate.now();
            this.valorUltimaCompra = monto;
            System.out.println("Compra de " + monto + " realizada con TC " + numeroProducto + ". Crédito disponible: " + this.saldo);
             System.out.println(" -> Registro TC: Última compra el " + fechaUltimaCompra.format(DATE_FORMATTER) + " por " + valorUltimaCompra);
            return true;
        } else {
            System.err.println("Error (TC " + numeroProducto + "): Crédito insuficiente ("+this.saldo+") para compra de " + monto);
            return false;
        }
    }

    
    public double getCupo() {
        return cupo;
    }

    public LocalDate getFechaUltimaCompra() {
        return fechaUltimaCompra;
    }

    public double getValorUltimaCompra() {
        return valorUltimaCompra;
    }

   
    @Override
    public double getSaldo() {
        return super.getSaldo(); 
    }

 
    public double getCreditoDisponible() {
        return this.saldo;
    }
}