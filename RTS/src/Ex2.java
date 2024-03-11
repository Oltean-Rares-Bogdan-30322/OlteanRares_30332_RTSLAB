public class Ex2 {
    public static void main(String[] args) {
        int[][] matrix1 = {{2, 3, 1}, {7, 1, 6}, {9, 2, 4}};
        int[][] matrix2 = {{8, 5, 3}, {3, 9, 2}, {2, 7, 3}};

        int[][] SumMatrix = addMatrix(matrix1,matrix2);
        System.out.println("sum of matrices:");
        printMatrix(SumMatrix);

        int[][] ProductMatrix = multiplyMatrix(matrix1,matrix2);
        System.out.println("product of matrices:");
        printMatrix(ProductMatrix);
    }

    public static int[][] addMatrix(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int cols = matrix1[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }
    public static int[][] multiplyMatrix(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int cols1 = matrix1[0].length;
        int cols2 = matrix2[0].length;
        int[][] result = new int[rows][cols2];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols1; j++) {
                for(int k= 0; k < cols2;k++) {
                     result[i][j] += matrix1[i][k]*matrix2[k][j];
                }
            }
        }
        return result;
    }

    public static void printMatrix (int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
