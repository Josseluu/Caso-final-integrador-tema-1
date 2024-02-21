import java.util.ArrayList;
import java.util.List;

class SistemaAlertaMonitoreo {
    private List<Double> nivelesRadiacion;
    private List<Double> temperaturas;
    private List<Double> presiones;

    public SistemaAlertaMonitoreo() {
        nivelesRadiacion = new ArrayList<>();
        temperaturas = new ArrayList<>();
        presiones = new ArrayList<>();
    }

    public void agregarDatos(double radiacion, double temperatura, double presion) {
        nivelesRadiacion.add(radiacion);
        temperaturas.add(temperatura);
        presiones.add(presion);
    }

    public void monitorear() {
        // Verificar niveles extremos y alertar a la tripulación si es necesario
        double maxRadiacion = encontrarMaximo(nivelesRadiacion);
        double minTemperatura = encontrarMinimo(temperaturas);
        double maxPresion = encontrarMaximo(presiones);

        if (maxRadiacion > 100.0) {
            System.out.println("¡Alerta! Nivel de radiación extremo: " + maxRadiacion);
        }
        if (minTemperatura < -20.0) {
            System.out.println("¡Alerta! Temperatura extremadamente baja: " + minTemperatura);
        }
        if (maxPresion > 110.0) {
            System.out.println("¡Alerta! Presión extremadamente alta: " + maxPresion);
        }
    }

    public void listarEventosRaros(int N) {
        System.out.println("Los " + N + " primeros números primos:");
        int contador = 0;
        int numero = 2;
        while (contador < N) {
            if (esPrimo(numero)) {
                System.out.print(numero + " ");
                contador++;
            }
            numero++;
        }
        System.out.println();
    }

    private boolean esPrimo(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private double encontrarMaximo(List<Double> lista) {
        double max = Double.MIN_VALUE;
        for (double valor : lista) {
            if (valor > max) {
                max = valor;
            }
        }
        return max;
    }

    private double encontrarMinimo(List<Double> lista) {
        double min = Double.MAX_VALUE;
        for (double valor : lista) {
            if (valor < min) {
                min = valor;
            }
        }
        return min;
    }
}

public class Sistema_de_alerta_y_monitoreo {
    public static void main(String[] args) {
        SistemaAlertaMonitoreo sistema = new SistemaAlertaMonitoreo();

        // Simulación de datos de monitoreo
        sistema.agregarDatos(95.0, -15.0, 100.0);
        sistema.agregarDatos(110.0, -25.0, 90.0);
        sistema.agregarDatos(80.0, -10.0, 120.0);

        // Monitoreo y alertas
        sistema.monitorear();

        // Listar los primeros 5 números primos
        sistema.listarEventosRaros(5);
    }
}

