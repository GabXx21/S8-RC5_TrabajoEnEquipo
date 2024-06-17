public class Cliente {

    private CuentaCorriente cuentaCorriente;
    private CuentaAhorros cuentaAhorros;
    private CuentaCDT cuentaCDT;

    public Cliente() {
        this.cuentaCorriente = new CuentaCorriente();
        this.cuentaAhorros = new CuentaAhorros();
        this.cuentaCDT = new CuentaCDT();
    }

    public void mostrarSaldos() {
        System.out.println("Saldo Cuenta Corriente: " + cuentaCorriente.getSaldo());
        System.out.println("Saldo Cuenta Ahorros: " + cuentaAhorros.getSaldo());
        System.out.println("Saldo CDT: " + cuentaCDT.getSaldo());
        System.out.println("Saldo Total: " + (cuentaCorriente.getSaldo() + cuentaAhorros.getSaldo() + cuentaCDT.getSaldo()));
    }

    public void consignarEnCuentaCorriente(double monto) {
        cuentaCorriente.consignar(monto);
    }

    public void retirarDeCuentaCorriente(double monto) {
        if (!cuentaCorriente.retirar(monto)) {
            System.out.println("Saldo insuficiente en cuenta corriente.");
        }else{
            System.out.println("Retiro exitoso.\nSaldo restante: " + cuentaCorriente.getSaldo());
        }
    }

    public void consignarEnCuentaAhorros(double monto) {
        cuentaAhorros.consignar(monto);
    }

    public void retirarDeCuentaAhorros(double monto) {
        if (!cuentaAhorros.retirar(monto)) {
            System.out.println("Saldo insuficiente en cuenta de ahorros.");
        }else{
            System.out.println("Retiro exitoso.\nSaldo restante: " + cuentaAhorros.getSaldo());
        }
    }

    public void invertirEnCDT(double monto, double tasaInteresMensual) {
        cuentaCDT.invertir(monto, tasaInteresMensual);
    }

    public void cerrarCDT() {
        double monto = cuentaCDT.cerrarInversion();
        cuentaCorriente.consignar(monto);
        System.out.println("Se cerro la inversion en CDT.\nSe a consignado:" + monto + " a su cuenta corriente.");
    }

    public void avanzarMes() {
        cuentaAhorros.aplicarInteresMensual();
        cuentaCDT.aplicarInteresMensual();
    }

    public CuentaCorriente getCuentaCorriente(){
        return cuentaCorriente;
    }

    public CuentaAhorros getCuentaAhorros() {
        return cuentaAhorros;
    }

    public CuentaCDT getCuentaCDT() {
        return cuentaCDT;
    }
}
