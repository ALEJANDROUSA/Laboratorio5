package Banco;


public class Cuenta {
    protected final String numeroProducto;
    protected final int anioApertura;
    protected double saldo;
    protected final Titular titular;

    protected Cuenta(String numeroProducto, int anioApertura,  Titular titular) {
        this.titular = titular;
        this.numeroProducto = numeroProducto;
        this.anioApertura = anioApertura;
       
    }



    public double getSaldo() {
        return saldo;
    }

    public Titular getTitular() {
        return titular;
    }

    public String getNumeroProducto() {
        return numeroProducto;
    }

    public int getAnioApertura() {
        return anioApertura;
    }


    public String getTipoProducto() {
        return this.getClass().getSimpleName();
    }

    @Override
    public String toString() {
        return getTipoProducto() + " [num=" + numeroProducto + ", año=" + anioApertura + ", saldo=" + saldo + ", titular=" + titular.getNombre() + "]";
    }
}