import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cliente cliente = new Cliente();
        int opcion;
        double montoConsignarCA;
        do {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Visualizar el saldo de la cuenta corriente del cliente.");
            System.out.println("2. Visualizar el saldo de la cuenta de ahorros del cliente.");
            System.out.println("3. Visualizar el saldo del CDT del cliente.");
            System.out.println("4. Visualizar el saldo total que tiene el cliente en los productos del banco.");
            System.out.println("5. Invertir un monto de dinero en un CDT.");
            System.out.println("6. Cerrar la inversión en CDT.");
            System.out.println("7. Consignar un monto de dinero en la cuenta corriente del cliente.");
            System.out.println("8. Retirar un monto de dinero en la cuenta corriente del cliente.");
            System.out.println("9. Consignar un monto de dinero en la cuenta de ahorros del cliente.");
            System.out.println("10. Retirar un monto de dinero en la cuenta de ahorros del cliente.");
            System.out.println("11. Avanzar en un mes la simulación.");
            System.out.println("0. Salir.");
            opcion = scanner.nextInt();

            switch (opcion){
                case 1:
                    System.out.println("Saldo Cuenta Corriente: " + cliente.getCuentaCorriente().getSaldo());
                    break;
                case 2:
                    System.out.println("Saldo Cuenta Ahorros: " + cliente.getCuentaAhorros().getSaldo());
                    break;
                case 3:
                    System.out.println("Saldo CDT: " + cliente.getCuentaCDT().getSaldo());
                    break;
                case 4:
                    cliente.mostrarSaldos();
                    break;
                case 5:
                    System.out.println("Los interese que manejamos son de acuerdo al monto que vaya a ingresar.\n Hasta $500 es un 2%, mayor a $500 y hasta $1500 es un 5% y en adelante el 8%");
                    System.out.println("Ingrese el monto a invertir en el CDT:");
                    double montoInversion = scanner.nextDouble();
                    double tasaInteres;
                    if (montoInversion <=500){
                        tasaInteres = 0.02;
                    } else if (montoInversion>500 && montoInversion<= 1500) {
                        tasaInteres = 0.05;
                    }else {
                        tasaInteres = 0.08;
                    }
                    cliente.invertirEnCDT(montoInversion, tasaInteres);
                    break;
                case 6:
                    cliente.cerrarCDT();
                    break;
                case 7:
                    System.out.println("Ingrese el monto a consignar en la cuenta corriente:");
                    double montoConsignarCC = scanner.nextDouble();
                    cliente.consignarEnCuentaCorriente(montoConsignarCC);
                    break;
                case 8:
                    System.out.println("Ingrese el monto a retirar de la cuenta corriente:");
                    double montoRetirarCC = scanner.nextDouble();
                    cliente.retirarDeCuentaCorriente(montoRetirarCC);
                    break;
                case 9:
                    System.out.println("Ingrese el monto a consignar en la cuenta de ahorros:");
                    montoConsignarCA = scanner.nextDouble();
                    cliente.consignarEnCuentaAhorros(montoConsignarCA);
                    break;
                case 10:
                    System.out.println("Ingrese el monto a retirar de la cuenta de ahorros:");
                    double montoRetirarCA = scanner.nextDouble();
                    cliente.retirarDeCuentaAhorros(montoRetirarCA);
                    System.out.println("Saldo restante: ");
                    break;
                case 11:
                    cliente.avanzarMes();
                    break;
                case 0:
                    System.out.println("Gracias por elegirnos.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 0);

    }
}
