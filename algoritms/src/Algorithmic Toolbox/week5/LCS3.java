import java.util.*;

public class LCS3 {

    private static int lcs3(int[] a, int[] b, int[] c) {
        if (a.length == 0 || b.length == 0) {
            return 0;

        }

        int fromSize = a.length + 1;
        int toSize = b.length + 1;
        int xSize = c.length + 1;
        int d[][][] = new int[toSize][fromSize][xSize];
        int length = 0;

        d[0][0][0] = 0;

        for (int i = 1; i < toSize; i++) {
            d[i][0][0] = 0;
        }

        for (int j = 1; j < fromSize; j++) {
            d[0][j][0] = 0;
        }

        for (int k = 1; k < xSize; k++) {
            d[0][0][k] = 0;
        }

        for (int j = 1; j < fromSize; j++)
            for (int i = 1; i < toSize; i++)
                for (int k = 1; k < xSize; k++) {
                    int prev = Math.max(Math.max((d[i][j - 1][k]), d[i - 1][j][k]),d[i][j][k-1]);
                    if ((a[j - 1] == b[i - 1])&& (a[j - 1]==c[k - 1])&&(b[i - 1]==c[k - 1])) {
                        //если совпали то рассматриваем результат двух последовательностей без совпавших символов
                        prev = d[i - 1][j - 1][k-1] + 1;
                        if (prev > length) {
                            length = prev;
                        }
                    }
                    d[i][j][k] = prev;
                }
        return length;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int an = scanner.nextInt();
        int[] a = new int[an];
        for (int i = 0; i < an; i++) {
            a[i] = scanner.nextInt();
        }
        int bn = scanner.nextInt();
        int[] b = new int[bn];
        for (int i = 0; i < bn; i++) {
            b[i] = scanner.nextInt();
        }
        int cn = scanner.nextInt();
        int[] c = new int[cn];
        for (int i = 0; i < cn; i++) {
            c[i] = scanner.nextInt();
        }
        System.out.println(lcs3(a, b, c));
    }
}

