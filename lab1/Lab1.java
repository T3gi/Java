/*
* ІО - 33 Титок Володимир
* Залікова №3324
*/

public class Lab1 {

    // C5 = 3324 % 5 = 4 - матричний добуток
    // C7 = 3324 % 7 = 6 - float
    // C11 = 3324 % 11 = 2 - сума найбільших елементів кожного стовпця матриці

    public static float[][] matrixMultiplication(float[][] matrix1, float[][] matrix2){
        float[][] result = new float[matrix1.length][matrix2[0].length];
        for (int i = 0; i < matrix1.length; i++){
            for (int j = 0; j < matrix2[0].length; j++){
                for (int k = 0; k < matrix2.length; k++){
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }

    public static float matrixRowMax(float[][] matrix){
        float result = 0;
        float row_max;
        for (int i = 0; i < matrix.length; i++){
            row_max = matrix[0][i];
            for (int j = 0; j < matrix[0].length; j++){
                if (row_max < matrix[j][i]){
                    row_max = matrix[j][i];
                }
            }
            result += row_max;
        }
        return result;
    }

    public static void printMatrix(float[][] matrix, String name){
        System.out.println("Matrix " + name + ":");
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                System.out.print("\t" + matrix[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        float[][] A = {
            {1, 1, 1, 1},
            {2, 2, 2, 2},
            {3, 3, 3, 3},
            {4, 4, 4, 4}
        };

        float[][] B = {
            {1, 2, 3, 4},
            {1, 2, 3, 4},
            {1, 2, 3, 4},
            {1, 2, 3, 4}
        };

        int rows = 4;
        int cols = 4;

        float[][] C = new float[rows][cols];
        float sum;

        C = matrixMultiplication(A, B);
        printMatrix(C, "C");
        
        sum = matrixRowMax(C);
        System.out.println("Sum = " + sum);
    }
}
