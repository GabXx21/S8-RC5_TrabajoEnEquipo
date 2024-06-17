public class CuentaCorriente {
    private double saldo;

    public CuentaCorriente(){
        this.saldo = 0;
    }

    public double getSaldo() {
        return saldo;
    }

    public void consignar(double monto) {
        if (monto > 0) {
            saldo += monto;
        }
    }

    public boolean retirar(double monto) {
        if (monto > 0 && saldo >= monto) {
            saldo -= monto;
            return true;
        }
        return false;
    }

}
