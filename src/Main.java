public class Main {
    public static void main(String[] args) {
        int[][] aData = {
                {1, 2, 3},
                {4, 5, 6},
                {3, 5, 7}
        };


        int[][] bData = {
                {7, 8, 5},
                {9, 10, 6},
                {11, 12, 4}
        };

        IMatrix A = new Matrix(aData);
        IMatrix B = new Matrix(bData);

        System.out.println("Matice A:");
        System.out.println(A);

        System.out.println("Matice B:");
        System.out.println(B);

        System.out.println("A + B:");
        System.out.println(A.add(B));

        System.out.println("A * 2:");
        System.out.println(A.times(2));

        System.out.println("A * B:");
        System.out.println(A.times(B));

        System.out.println("Transponovaná A:");
        System.out.println(A.transpose());

        System.out.println("Je A čtvercová? " + A.isSquare());
        System.out.println("Trace A: " + A.getTrace());

    }
}
