import java.util.Scanner;

public class ComunicadorInterplanetario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al Comunicador Interplanetario");
        System.out.println("Por favor, ingresa tu mensaje:");

        String mensaje = scanner.nextLine();

        // Funciones de análisis y traducción de mensajes
        int conteoVocales = contarVocales(mensaje);
        String mensajeInvertido = invertirMensaje(mensaje);
        boolean esPalindromo = esPalindromo(mensaje);

        // Mostrar resultados
        System.out.println("\nAnálisis del mensaje:");
        System.out.println("Número de vocales: " + conteoVocales);
        System.out.println("Mensaje invertido: " + mensajeInvertido);
        System.out.println("Es palíndromo: " + esPalindromo);
    }

    // Función para contar vocales en un mensaje
    public static int contarVocales(String mensaje) {
        int contador = 0;
        for (char c : mensaje.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                    c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                contador++;
            }
        }
        return contador;
    }

    // Función para invertir un mensaje
    public static String invertirMensaje(String mensaje) {
        StringBuilder invertido = new StringBuilder();
        for (int i = mensaje.length() - 1; i >= 0; i--) {
            invertido.append(mensaje.charAt(i));
        }
        return invertido.toString();
    }

    // Función para verificar si un mensaje es palíndromo
    public static boolean esPalindromo(String mensaje) {
        String mensajeSinEspacios = mensaje.replaceAll("\\s", "").toLowerCase();
        int longitud = mensajeSinEspacios.length();
        for (int i = 0; i < longitud / 2; i++) {
            if (mensajeSinEspacios.charAt(i) != mensajeSinEspacios.charAt(longitud - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
