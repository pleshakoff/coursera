import java.util.*;

public class Knapsack {
    static int optimalWeight(int W, int[] bars) {
        //write you code here
        int capacity = W + 1;
        int barsCount = bars.length + 1;
        int d[][] = new int[capacity][barsCount];

        for (int i = 0; i < capacity; i++) {
            d[i][0]=0;
        }

        for (int i = 0; i < barsCount; i++) {
            d[0][i]=0;
        }


        for (int i = 1; i < barsCount; i++) {
            for (int w = 1; w < capacity; w++) {
                d[w][i]=d[w][i-1];
                if (bars[i-1] <= w) {
                  int val = d[w-bars[i-1]][i-1]+bars[i-1];
                    if (val > d[w][i]) {
                        d[w][i]=val;
                    }
                }
            }
        }
//        for (int i = 1; i < barsCount; i++) {
//            for (int w = 1; w < capacity; w++)
//                System.out.print(d[w][i]+" ");
//            System.out.println();
//        }
//

        return d[W][bars.length];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}

