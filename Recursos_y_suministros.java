
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Recursos {
    private static final int DIAS_EN_SEMANA = 7;
    private static final int SEMANAS_EN_MES = 4;

    private List<Integer> consumoDiario;

    public Recursos() {
        consumoDiario = new ArrayList<>();

        Random random = new Random();
        for (int i = 0; i < DIAS_EN_SEMANA * SEMANAS_EN_MES; i++) {
            consumoDiario.add(random.nextInt(16) * 5);
        }
    }

    public List<Integer> getConsumoDiario() {
        return consumoDiario;
    }

    public int calcularConsumoMedio() {
        int sum = 0;
        for (int consumo : consumoDiario) {
            sum += consumo;
        }
        return sum / consumoDiario.size();
    }

    public int calcularConsumoMinimo() {
        int min = Integer.MAX_VALUE;
        for (int consumo : consumoDiario) {
            if (consumo < min) {
                min = consumo;
            }
        }
        return min;
    }

    public int calcularConsumoMaximo() {
        int max = Integer.MIN_VALUE;
        for (int consumo : consumoDiario) {
            if (consumo > max) {
                max = consumo;
            }
        }
        return max;
    }
}

public class Recursos_y_suministros {
    public static void main(String[] args) {
        Recursos recursos = new Recursos();

        System.out.println("Consumo diario de recursos: " + recursos.getConsumoDiario());
        System.out.println("Consumo medio: " + recursos.calcularConsumoMedio());
        System.out.println("Consumo mínimo: " + recursos.calcularConsumoMinimo());
        System.out.println("Consumo máximo: " + recursos.calcularConsumoMaximo());
    }
}
