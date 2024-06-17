public class CuentaCDT {
    private double saldo;
    private double tasaInteresMensual;
    private boolean invertido;

    public CuentaCDT() {
        this.saldo = 0;
        this.tasaInteresMensual = 0;
        this.invertido = false;
    }

    public double getSaldo() {
        return saldo;
    }

    public void invertir(double monto, double tasaInteresMensual) {
        if (monto > 0 && !invertido) {
            this.saldo = monto;
            this.tasaInteresMensual = tasaInteresMensual;
            this.invertido = true;
        }
    }

    public void aplicarInteresMensual() {
        if (invertido) {
            saldo += saldo * tasaInteresMensual;
        }
    }

    public double cerrarInversion() {
        if (invertido) {
            double total = saldo;
            saldo = 0;
            tasaInteresMensual = 0;
            invertido = false;
            return total;
        }
        return 0;
    }
}
