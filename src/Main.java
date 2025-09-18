// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        double[][] data = {
                {1,2,3},
                {4,5,6},
        };
        double[][] data2 = {
                {1,2},
                {3,4},
                {5,6}
        };
        Matrix m = Matrix.createMatrix(data);
        Matrix n = Matrix.createMatrix(data2);
        Matrix x = (Matrix) m.times(n);
        x.printMatrix();

    }
}