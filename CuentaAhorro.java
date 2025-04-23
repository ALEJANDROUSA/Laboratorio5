package Banco;

public abstract class Cuenta {
    protected String numeroProducto;
    protected int anioApertura;
    protected double saldo;
    protected String nombreTitular; 

    protected Cuenta(String numeroProducto, int anioApertura, double saldoInicial, String nombreTitular) {
      
            this.nombreTitular = nombreTitular;
        
        this.numeroProducto = numeroProducto;
        this.anioApertura = anioApertura;
        this.saldo = saldoInicial;
    }

   
    public void depositar(double monto) {
        if (monto > 0) {
            this.saldo += monto;
            System.out.println("Deposito (" + monto + ") en " + numeroProducto + ". Saldo: " + this.saldo);
        } else {
            System.err.println("Error: Monto inválido para depositar: " + monto);
        }
    }

  
    public void retirar(double monto) {
        if (monto <= 0) {
            System.err.println("Error: Monto inválido para retirar: " + monto);
        } else if (this.saldo >= monto) {
            this.saldo -= monto;
             System.out.println("Retiro (" + monto + ") en " + numeroProducto + ". Saldo: " + this.saldo);
        } else {
            System.err.println("Error: Saldo insuficiente en " + numeroProducto + " (" + this.saldo + ") para retirar " + monto);
        }
    }


    public String getNumeroProducto() { return numeroProducto; }
    public int getAnioApertura() { return anioApertura; }
    public double getSaldo() { return saldo; }
    public String getNombreTitular() { return nombreTitular; }
    public String getTipoProducto() { return this.getClass().getSimpleName(); } 

    @Override
    public String toString() {
        return getTipoProducto() + " Nro: " + numeroProducto + ", Titular: " + nombreTitular + ", Saldo: " + saldo;
    }
}
