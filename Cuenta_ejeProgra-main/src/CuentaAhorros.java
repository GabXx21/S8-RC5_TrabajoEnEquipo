public class CuentaAhorros {
    private double saldo;
    private final double TASA_INTERES = 0.006; //0.6%

    public CuentaAhorros() {
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

    public void aplicarInteresMensual() {
        saldo += saldo * TASA_INTERES;
    }

}
