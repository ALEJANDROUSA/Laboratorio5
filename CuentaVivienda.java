package Banco;

public class CuentaVivienda extends Cuenta implements IDepositar {

    private final double precioVivienda;
    private final String tipoVivienda; 

    public CuentaVivienda(String numeroProducto, int anioApertura, Titular titular, double precioVivienda, String tipoVivienda) {
        super(numeroProducto, anioApertura,  titular);
        if (precioVivienda <= 0) {
            throw new IllegalArgumentException("El precio de la vivienda debe ser positivo.");
        }
        this.precioVivienda = precioVivienda;
        this.tipoVivienda = tipoVivienda;

       
    }


    @Override
    public boolean depositar(double monto) {
        if (monto <= 0) {
             System.err.println("Error (Vivienda " + numeroProducto + "): Monto inválido para depositar: " + monto);
             return false;
        }
    
        if (this.saldo + monto <= this.precioVivienda) {
             boolean exito = super.depositarBase(monto); 
             if(exito) System.out.println(" -> Registro Vivienda: Depósito válido.");
             return exito;
        } else {
             System.err.println("Error (Vivienda " + numeroProducto + "): Depósito de " + monto + " excede el precio (" + this.precioVivienda + "). Saldo actual: " + this.saldo);
             return false;
        }
    }

  
    @Override
    public boolean retirarBase(double monto) {
         System.err.println("Error (Vivienda " + numeroProducto + "): Los retiros estándar no están permitidos.");
         return false;
    }


    public double getPrecioVivienda() {
        return precioVivienda;
    }

    public String getTipoVivienda() {
        return tipoVivienda;
    }
}