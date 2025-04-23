package Banco;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CuentaCorriente extends Cuenta implements IRetirar, IDepositar {

    private LocalDate fechaUltimoMovimiento; 
    private double valorUltimoMovimiento;
    private String tipoOperacionUltimoMovimiento;
   

    public CuentaCorriente(String numeroProducto, int anioApertura,  Titular titular) {
        super(numeroProducto, anioApertura, titular);
         
    }

 
    @Override
    public boolean depositar(double monto) {

        
    		this.saldo += monto;
            this.fechaUltimoMovimiento = LocalDate.now();
            this.valorUltimoMovimiento = monto;
            this.tipoOperacionUltimoMovimiento = "Deposito";
             System.out.println(" -> Registro Corriente: Movimiento el " + fechaUltimoMovimiento.getDayOfMonth() + " tipo " + tipoOperacionUltimoMovimiento);
        
        return true;
    }


    @Override
    public boolean retirar(double monto) {
  
        
        
         
            this.fechaUltimoMovimiento = LocalDate.now();
            this.valorUltimoMovimiento = monto;
            this.tipoOperacionUltimoMovimiento = "Retiro";
            System.out.println(" -> Registro Corriente: Movimiento el " + fechaUltimoMovimiento.getDayOfMonth() + " tipo " + tipoOperacionUltimoMovimiento);
        
        return true;
    }

 

    


    public LocalDate getFechaUltimoMovimiento() {
        return fechaUltimoMovimiento;
    }

    public double getValorUltimoMovimiento() {
        return valorUltimoMovimiento;
    }

    public String getTipoOperacionUltimoMovimiento() {
        return tipoOperacionUltimoMovimiento;
    }
}