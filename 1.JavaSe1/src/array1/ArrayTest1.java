package array1;

public class ArrayTest1 {
    public static void main(String[] args) {
        int[][] a = new int[][]{{1, 2, 3}};
        int[][] b = a;
        b[0][1] = 919;
        for (int[] x : a) {
            for (int y : x)
                System.out.print(y + " ");
            System.out.println();
        }
    }
}
