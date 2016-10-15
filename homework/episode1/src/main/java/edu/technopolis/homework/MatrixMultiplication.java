package edu.technopolis.homework;

import java.util.Scanner;
/**
 * Matrix multiplication home task.
 * <br/>
 * Matrix dimension and elements are passed as CLI arguments.
 */
public class MatrixMultiplication {
    public static void main(String... args) {
public static double[][] multiplyMatrix(double[][] matrix1, double[][] matrix2) {
        double[][] matrixResult = new double[matrix1.length][matrix2[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                for (int r = 0; r < matrix1[0].length; r++) {
                    matrixResult[i][j] += matrix1[i][r] * matrix2[r][j];
                }
            }
        }
        return matrixResult;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();


        if (n == 0 || m == 0 || x == 0 || y == 0) {
            System.out.println("Размерность матрицы содержит 0");
        } else if (m != x) {
            System.out.println("Умножение невозможно, так как не выполняется условие: " +
                    "количество столбцов первой матрицы равняется количеству строк второй матрицы");
        } else {
            double[][] matrix1 = new double[n][m];
            double[][] matrix2 = new double[x][y];
            double[][] matrixResult;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    matrix1[i][j] = sc.nextDouble();
                }
            }

            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    matrix2[i][j] = sc.nextDouble();
                }
            }

            matrixResult = multiplyMatrix(matrix1, matrix2);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < y; j++) {
                    System.out.print(matrixResult[i][j] + "  ");
                }
                System.out.println();
            }
        }
    }
}
