import java.util.HashMap;
import java.util.Map;

class CronometroCosmico {
    private String nombrePlaneta;
    private double duracionDiaTierra;
    private double duracionAnioTierra;

    public CronometroCosmico(String nombrePlaneta, double duracionDiaTierra, double duracionAnioTierra) {
        this.nombrePlaneta = nombrePlaneta;
        this.duracionDiaTierra = duracionDiaTierra;
        this.duracionAnioTierra = duracionAnioTierra;
    }

    public String getNombrePlaneta() {
        return nombrePlaneta;
    }

    public Map<String, Double> convertirTiempo(double tiempoTierra) {
        double diasTierra = tiempoTierra / (24 * 3600);
        double anosTierra = tiempoTierra / (365.25 * 24 * 3600);

        Map<String, Double> tiempoPlaneta = new HashMap<>();
        tiempoPlaneta.put("segundos", tiempoTierra * this.duracionDiaTierra);
        tiempoPlaneta.put("minutos", tiempoTierra * this.duracionDiaTierra / 60);
        tiempoPlaneta.put("horas", tiempoTierra * this.duracionDiaTierra / 3600);
        tiempoPlaneta.put("dias", diasTierra * this.duracionDiaTierra);
        tiempoPlaneta.put("anos", anosTierra * this.duracionAnioTierra);

        return tiempoPlaneta;
    }

    public Map<String, Double> mayoresValoresRepresentables() {
        Map<String, Double> mayoresValores = new HashMap<>();
        mayoresValores.put("int", (Math.pow(2, 31) - 1) * this.duracionDiaTierra);
        mayoresValores.put("float", Double.POSITIVE_INFINITY);


        return mayoresValores;
    }
}

public class Cronometro_cosmico {
    public static void main(String[] args) {
        CronometroCosmico tierra = new CronometroCosmico("Tierra", 1, 1);
        CronometroCosmico nuevoPlaneta = new CronometroCosmico("Nuevo Planeta", 1.5, 2);

        System.out.println("Conversiones de tiempo en " + nuevoPlaneta.getNombrePlaneta() + ":");
        double tiempoTierra = 3600; // 1 hora
        Map<String, Double> tiempoConvertido = nuevoPlaneta.convertirTiempo(tiempoTierra);
        for (Map.Entry<String, Double> entry : tiempoConvertido.entrySet()) {
            System.out.println(entry.getKey() + ": " + String.format("%.2f", entry.getValue()));
        }

        System.out.println("\nMayores valores representables en " + nuevoPlaneta.getNombrePlaneta() + ":");
        Map<String, Double> valoresNuevoPlaneta = nuevoPlaneta.mayoresValoresRepresentables();
        for (Map.Entry<String, Double> entry : valoresNuevoPlaneta.entrySet()) {
            System.out.println(entry.getKey() + ": " + String.format("%.2f", entry.getValue()));
        }
    }
}
