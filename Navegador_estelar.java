import java.util.Arrays;

public class Navegador_estelar {
    public static void main(String[] args) {

        int[][] terreno = {
                {0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 1, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0}
        };


        System.out.println("Terreno inicial:");
        mostrarMatriz(terreno);


        int[][] ruta = multiplicarMatrices(terreno, terreno);


        System.out.println("\nRuta de exploración planificada:");
        mostrarMatriz(ruta);
    }


    public static void mostrarMatriz(int[][] matriz) {
        for (int[] fila : matriz) {
            for (int valor : fila) {
                System.out.print(valor + " ");
            }
            System.out.println();
        }
    }

    public static int[][] multiplicarMatrices(int[][] matriz1, int[][] matriz2) {
        int filasMatriz1 = matriz1.length;
        int columnasMatriz1 = matriz1[0].length;
        int columnasMatriz2 = matriz2[0].length;

        int[][] resultado = new int[filasMatriz1][columnasMatriz2];

        for (int i = 0; i < filasMatriz1; i++) {
            for (int j = 0; j < columnasMatriz2; j++) {
                for (int k = 0; k < columnasMatriz1; k++) {
                    resultado[i][j] += matriz1[i][k] * matriz2[k][j];
                }
            }
        }

        return resultado;
    }
}
