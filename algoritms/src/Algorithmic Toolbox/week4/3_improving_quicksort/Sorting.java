import java.io.*;
import java.util.*;

public class Sorting {
    private static Random random = new Random();

    private static int[] partition3(int[] a, int left, int right) {
        //write your code here
        int x = a[left];
        int m1 = left;
        int m2 = right;
        int j = left+1;
        while (j <= m2) {
            if (a[j] < x) {
                m1++;
                swapArrayElements(a, m1, j);
                j++;
            }
            else
            if (a[j] > x) {
                swapArrayElements(a,j, m2);
                m2--;
            }
            else
            if (a[j] == x) {
               j++;
            }
        }
        swapArrayElements(a, left, m1);

// 1 2 1 1 2 1 3
        int[] m = {m1, m2};
        return m;
    }

    private static int partition2(int[] a, int left, int right) {
        int x = a[left];
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            if (a[i] <= x) {
                j++;
                swapArrayElements(a, i, j);
            }
        }
        swapArrayElements(a, left, j);
        return j;
    }

    private static void randomizedQuickSort(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int k = random.nextInt(r - l + 1) + l;
        swapArrayElements(a, l, k);

        //use partition3
        //int m = partition2(a, l, r);
        int[] res3 = partition3(a, l, r);
        randomizedQuickSort(a, l, res3[0] - 1);
        randomizedQuickSort(a, res3[1]+1, r);
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        randomizedQuickSort(a, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    static void swapArrayElements(int[] array, int pos1, int pos2) {
        int tmp = array[pos1];
        array[pos1] = array[pos2];
        array[pos2] = tmp;

    }

}

