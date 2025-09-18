import java.util.Arrays;

public class Matrix implements IMatrix{
    private double matrix[][];

    private Matrix(double[][] matrix){
        this.matrix = new double[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length;i++ ){
            this.matrix[i] = Arrays.copyOf(matrix[i], matrix[i].length);
        }
    }

    public static Matrix createMatrix(double[][] matrix){
        return new Matrix(matrix);
    }
    public void printMatrix(){
        for (double[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public void setByCords(int row, int column, double number){
        this.matrix[row][column] = number;
    }
    public double[][] getField(){
        return this.matrix;
    }
    public Matrix getMatrix(){
        return this;
    }

    @Override
    public IMatrix times(IMatrix matrix) {
        if(this.getColumns() != matrix.getRows()){
            return null;
        }
        double[][] newField = new double[this.getRows()][matrix.getColumns()];
        for (int newI = 0; newI < newField.length; newI++) {
            for (int newJ = 0; newJ < newField[0].length; newJ++) {
                double newNumber = 0;
                for (int i = 0; i <= matrix.getColumns(); i++) {
                    newNumber += this.get(newI,i) * matrix.get(i,newJ);
                }
                newField[newI][newJ] = newNumber;
            }
        }
        return Matrix.createMatrix(newField);
    }

    @Override
    public IMatrix times(int scalar) {
        Matrix newM = Matrix.createMatrix(this.matrix);
        for(int i = 0; i < newM.matrix.length;i++ ){
            for(int j = 0; j < newM.matrix[0].length;j++ ){
                newM.setByCords(i,j,newM.get(i,j)*scalar);
            }
        }
        return newM;
    }

    @Override
    public IMatrix add(IMatrix matrix) {
        Matrix newM = Matrix.createMatrix(this.matrix);
        for(int i = 0; i < newM.matrix.length;i++ ){
            for(int j = 0; j < newM.matrix[0].length;j++ ){
                newM.setByCords(i,j,newM.matrix[i][j] + matrix.get(i,j));
            }
        }
        return newM;
    }

    @Override
    public IMatrix transpose() {
        double[][] newField = new double[this.matrix[0].length][this.matrix.length];
        for(int i = 0; i < this.matrix.length;i++ ){
            for(int j = 0; j < this.matrix[0].length;j++ ){
                newField[j][i] = this.matrix[i][j];
            }
        }

        return Matrix.createMatrix(newField);
    }


    @Override
    public boolean isSquare() {
        return this.matrix[0].length == this.matrix.length;
    }

    @Override
    public boolean isDiagonal() {
        if(!isSquare())
            return false;
        for(int i = 0; i < this.matrix.length;i++ ){
            for(int j = 0; j < this.matrix[0].length;j++ ){
                if(i != j){
                    if(this.matrix[i][j] != 0){
                        return false;
                    }
                }
            }
        }
        return true;
    }


    @Override
    public Number getTrace() {
        if(!isSquare()){
            return null;
        }
        double num = 0;
        for(int i = 0; i < this.matrix.length; i++){
            num = this.matrix[i][i] + num;
        }
        return num;
    }

    @Override
    public int getRows() {
        return this.matrix.length;
    }

    @Override
    public int getColumns() {
        return this.matrix[0].length;
    }

    @Override
    public double get(int n, int m) {
        return this.matrix[n][m];
    }
}
