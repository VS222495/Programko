public class Matrix implements IMatrix {
    private final int[][] data;
    private final int rows;
    private final int cols;

    public Matrix(int[][] data) {
        this.rows = data.length;
        this.cols = data[0].length;
        this.data = new int[rows][cols];

        // zkopírujeme data z původního pole
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.data[i][j] = data[i][j];
            }
        }
    }

    @Override
    public IMatrix times(int scalar) {
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = data[i][j] * scalar;
            }
        }
        return new Matrix(result);
    }

    @Override
    public IMatrix times(IMatrix matrix) {
        if (this.cols != matrix.getRows()) {
            System.out.println("❌ Tyto matice nejde násobit!");
            return null;
        }

        int[][] result = new int[this.rows][matrix.getColumns()];
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                for (int k = 0; k < this.cols; k++) {
                    result[i][j] += this.data[i][k] * matrix.get(k, j);
                }
            }
        }
        return new Matrix(result);
    }

    @Override
    public IMatrix add(IMatrix matrix) {
        if (this.rows != matrix.getRows() || this.cols != matrix.getColumns()) {
            System.out.println("❌ Tyto matice nejde sečíst!");
            return null;
        }

        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = this.data[i][j] + matrix.get(i, j);
            }
        }
        return new Matrix(result);
    }

    @Override
    public IMatrix transpose() {
        int[][] result = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = data[i][j];
            }
        }
        return new Matrix(result);
    }

    @Override
    public boolean isSquare() {
        return rows == cols;
    }

    @Override
    public int getTrace() {
        if (!isSquare()) {
            System.out.println("je definována jen pro čtvercové matice!");
        }

        int trace = 0;
        for (int i = 0; i < rows; i++) {
            trace += data[i][i];
        }
        return trace;
    }



    @Override
    public int getRows() {
        return rows;
    }

    @Override
    public int getColumns() {
        return cols;
    }

    @Override
    public int get(int n, int m) {
        return data[n][m];
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < rows; i++) {
            result += "[ ";
            for (int j = 0; j < cols; j++) {
                result += data[i][j] + " ";
            }
            result += "]\n";
        }
        return result;
    }
}
