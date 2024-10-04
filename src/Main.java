import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ConversorDeMonedas conversor = new ConversorDeMonedas();

            while (true) {
                int opcionSeleccionada = mostrarMenu(conversor, scanner);
                if (opcionSeleccionada == -1) break;
                conversion(conversor, opcionSeleccionada, scanner);
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("Error al obtener los datos de la API: " + e.getMessage());
        }
    }

    private static int mostrarMenu(ConversorDeMonedas conversor, Scanner scanner) {
        System.out.println("\nSeleccione la opción de conversión:");
        int tasasContador = conversor.getCantidadMonedas();

        for (int i = 0; i < tasasContador; i++) {
            System.out.printf("%d. De USD a %s%n", i * 2 + 1, conversor.getMonedas()[i]);
            System.out.printf("%d. De %s a USD%n", i * 2 + 2, conversor.getMonedas()[i]);
        }

        System.out.println("0. Salir");
        System.out.print("Opción: ");
        int opcion = scanner.nextInt();

        if (opcion > 0 && opcion <= tasasContador * 2) {
            return opcion;
        } else {
            System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            return -1;
        }
    }

    private static void conversion(ConversorDeMonedas conversor, int opcionSeleccionada, Scanner scanner) {

        if (opcionSeleccionada % 2 != 0) {
            int tasaIndex = (opcionSeleccionada - 1) / 2;
            double cantidadUSD = obtenerCantidadAConvertir("USD", scanner);
            double cantidadConvertida = conversor.convertirDolarAMoneda(cantidadUSD, tasaIndex);
            System.out.printf("USD %.2f es equivalente a %.2f %s%n", cantidadUSD, cantidadConvertida, conversor.getMonedas()[tasaIndex]);
        } else {
            int tasaIndex = (opcionSeleccionada / 2 - 1);
            double cantidad = obtenerCantidadAConvertir(conversor.getMonedas()[tasaIndex], scanner);
            double cantidadConvertida = conversor.convertirMonedaADolar(cantidad, tasaIndex);
            System.out.printf("%.2f %s es equivalente a USD %.2f%n", cantidad, conversor.getMonedas()[tasaIndex], cantidadConvertida);
        }
    }

    private static double obtenerCantidadAConvertir(String tasa, Scanner scanner) {
        double cantidad;
        do {
            System.out.printf("Ingrese la cantidad en %s: ", tasa);
            while (!scanner.hasNextDouble()) {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.next();
            }
            cantidad = scanner.nextDouble();
        } while (cantidad < 0);
        return cantidad;
    }
}
