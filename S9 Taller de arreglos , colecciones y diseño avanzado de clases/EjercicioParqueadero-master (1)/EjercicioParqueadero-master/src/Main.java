import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Creacion de un objeto
        Parqueadero par = new Parqueadero();

        System.out.println("Bienvenido al sistema de gestion del parquedero");
        while (true){
            Menu();
            int opciones = sc.nextInt();
            sc.nextLine();
            switch (opciones){
                case 1:
                    System.out.println("Ingrese la placa: ");
                    String placaIngreso = sc.nextLine();
                    int resultadoIngreso = par.entrarCarro(placaIngreso);
                    imprimeIngreso(resultadoIngreso);
                    break;
                case 2:
                    System.out.println("ingrese placa que desea salir");
                    String placaSalida = sc.nextLine();
                    int valorPagar = par.sacarCarro(placaSalida);
                    imprimeSalida(valorPagar);
                    break;
                case 3:
                    imprimeParqueadero(par);
                    break;
                case 4:
                    int puestosDisponibles = par.consultarPuestosDisponibles();
                    System.out.println("Cantidad de puestos disponibles: " + puestosDisponibles);
                    break;
                case 5:
                    System.out.print("Ingrese la cantidad de horas a avanzar: ");
                    int horasAAvanzar = sc.nextInt();
                    par.avanzarReloj(horasAAvanzar);
                    System.out.println("Hora actual después de avanzar el reloj: " + par.getHoraActual());
                    break;
                case 6:
                    System.out.print("Ingrese la nueva tarifa: ");
                    int nuevaTarifa = sc.nextInt();
                    par.cambiarTarifa(nuevaTarifa);
                    System.out.println("Nueva tarifa del parqueadero: " + par.getTarifa());
                    break;
                case 7:
                    System.out.println("Saliendo");
                    sc.close();
                    return;
                default:
                    System.out.println("Opcion no valida. Ingrese una opcion valida");
            }

        }
    }

    private static void Menu(){
        System.out.println("Menu");
        System.out.println("1.- Ingresar un carro al parquedero");
        System.out.println("2.- Dar salida a un carro del parquedero");
        System.out.println("3.- Informar los ingresos del parquedero");
        System.out.println("4.- Consultar cantidad de puestos disponibles");
        System.out.println("5.- Avanzar el reloj del parquedero");
        System.out.println("6.- Cambiar la tarifa del parquedero");
        System.out.println("7.- Salir");
        System.out.print("Ingrese la opcion que desea realizar");
    }
    private static void imprimeIngreso(int resultado){
        switch (resultado){
            case Parqueadero.NO_HAY_PUESTO:
                System.out.println("El parquedero esta lleno, no hay puesto disponible");
                break;
            case Parqueadero.PARQUEADERO_CERRADO:
                System.out.println("El parquedero esta cerrado en este momento");
                break;
            case Parqueadero.CARRO_YA_EXISTE:
                System.out.println("Ya hay un carro con la misma placa ingresada");
                break;
            default:
                System.out.println("Carro ingresado al parquedero exitoso");
                break;

        }
    }
    private static void imprimeSalida(int Pago){
        switch (Pago){
            case Parqueadero.CARRO_NO_EXISTE:
                System.out.println("El carro no esta en el parquedero");
                break;
            case Parqueadero.PARQUEADERO_CERRADO:
                System.out.println("El parquedero esta cerrado en este momento");
                break;
            default:
                System.out.println("El carro ha salido del parqueadero. Valor a pagar: " + Pago);
        }
    }
    private static void imprimeParqueadero(Parqueadero parqueadero){
        System.out.println("Ingresos del parquedero");
        System.out.println("Hora actual: " + parqueadero.darHoraActual());
        System.out.println("Parqueadero abierto: " + (parqueadero.estaAbierto() ? "Si" : "No"));
        System.out.println("Tarifa por hora: $" + parqueadero.darTarifa());
        System.out.println("Monto en caja: $" + parqueadero.darMontoCaja());
        System.out.println("Puestos Libres: " + parqueadero.calcularPuestosLibres());
    }


}
