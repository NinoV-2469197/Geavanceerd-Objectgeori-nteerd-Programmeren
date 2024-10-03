/*
Schrijf een klasse Matrix, waarmee je een 3x3 matrix kan voorstellen.
Voorzie de nodige methods om twee matrices op te tellen en te vermenigvuldigen
 */
public class Matrix {
    private final int[][] data;

    public Matrix() {
        this.data = new int[3][3];
    }

    public Matrix(int[][] data) {
        if (data.length != 3 || data[0].length != 3) {
            throw new IllegalArgumentException("Matrix must be 3x3.");
        }
        this.data = data;
    }

    public Matrix add(Matrix other) {
        int[][] result = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result[i][j] = this.data[i][j] + other.data[i][j];
            }
        }
        return new Matrix(result);
    }

    public Matrix multiply(Matrix other) {
        int[][] result = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result[i][j] = 0;
                for (int k = 0; k < 3; k++) {
                    result[i][j] += this.data[i][k] * other.data[k][j];
                }
            }
        }
        return new Matrix(result);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append("[");
            for (int j = 0; j < 3; j++) {
                sb.append(this.data[i][j]);
                if (j < 2) sb.append(", ");
            }
            sb.append("]\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[][] data1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] data2 = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};

        Matrix matrix1 = new Matrix(data1);
        Matrix matrix2 = new Matrix(data2);

        Matrix sum = matrix1.add(matrix2);
        Matrix product = matrix1.multiply(matrix2);

        System.out.println("Matrix 1:");
        System.out.println(matrix1);

        System.out.println("Matrix 2:");
        System.out.println(matrix2);

        System.out.println("Sum:");
        System.out.println(sum);

        System.out.println("Product:");
        System.out.println(product);
    }
}
