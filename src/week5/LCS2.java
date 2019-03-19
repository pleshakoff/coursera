import java.util.*;

public class LCS2 {

    private static int lcs2(int[] a, int[] b) {

        int fromSize = a.length + 1;
        int toSize = b.length + 1;
        int d[][] = new int[toSize][fromSize];
        int max = 0;
        int length = 0;
        boolean first = true;

        d[0][0] = 0;

        for (int i = 1; i < toSize; i++) {
            d[i][0] = 0;
        }

        for (int j = 1; j < fromSize; j++) {
            d[0][j] = 0;
        }


        for (int j = 1; j < fromSize; j++)
            for (int i = 1; i < toSize; i++) {
                int prev = Math.max(Math.max(d[i - 1][j - 1], d[i][j - 1]), d[i - 1][j]);
//                int prev = Math.max(d[i - 1][j - 1],d[i - 1][j]);
                if (a[j - 1] == b[i - 1] && (a[j - 1]>=max || first)) {
                    prev++;
                    first=false;
                    max=a[j-1];
                    if (prev>length) {
                        length=prev;
                    }

                }
                d[i][j] = prev;
            }

        for (int i = 0; i < toSize; i++) {
            for (int j = 0; j < fromSize; j++)
                System.out.print(d[i][j] + " ");
            System.out.println();
        }

        //Write your code here
//        return d[b.length][a.length];
        return length;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }

        System.out.println(lcs2(a, b));
    }
}

