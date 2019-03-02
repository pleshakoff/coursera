import java.util.Random;
import java.util.Scanner;

public class PointsAndSegments {

    /*

    3 1
-100 100
-100 100
-100 100
2
     */

    private static Random random = new Random();

    private static int[] fastCountSegments(int[] starts, int[] ends, int[] points) {
        randomizedQuickSort(starts, ends, 0, starts.length - 1);

        int[] cnt = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            if (starts.length>0&& points[i] >= starts[0]) {
                int pos = getPos(points[i], starts, ends);
                for (int j = 0; j <= pos; j++) {
                    if (starts[j] <= points[i] && points[i] <= ends[j]) {
                        cnt[i]++;
                    }
                }
            }

        }
        return cnt;
    }

    private static int getPos(int point, int[] starts, int[] ends) {
        int left = 0, right = starts.length - 1;
        int mid = 0;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (starts[mid] <= point && (starts[mid + 1] > point))
                return mid;
            else if (point > starts[mid])
                left = mid + 1;
            else
                right = mid - 1;
        }
        if (left == right) {
            return right;
        }
        else
        return mid;

    }

    ;


    private static int getCnt(int point, int[] starts, int[] ends, int left, int right) {

        if (left == right) {
            if (starts[left] <= point && point <= ends[left])
                return 1;
            else
                return 0;

        } else if (left + 1 == right) {
            return getCnt(point, starts, ends, left, left) +
                    getCnt(point, starts, ends, right, right);
        } else {
            int mid = left + (right - left) / 2;
            return getCnt(point, starts, ends, left, mid) +
                    getCnt(point, starts, ends, mid + 1, right);

        }
    }

    ;


    private static int[] naiveCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < starts.length; j++) {
                if (starts[j] <= points[i] && points[i] <= ends[j]) {
                    cnt[i]++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[] starts = new int[n];
        int[] ends = new int[n];
        int[] points = new int[m];
        for (int i = 0; i < n; i++) {
            starts[i] = scanner.nextInt();
            ends[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            points[i] = scanner.nextInt();
        }
        //use fastCountSegments
        int[] cnt = fastCountSegments(starts, ends, points);
        for (int x : cnt) {
            System.out.print(x + " ");
        }
    }

    private static int partition2(int[] a, int[] a2, int left, int right) {
        int x = a[left];
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            if (a[i] <= x) {
                j++;
                swapArrayElements(a, a2, i, j);
            }
        }
        swapArrayElements(a, a2, left, j);
        return j;
    }


    private static void randomizedQuickSort(int[] a, int[] a2, int l, int r) {
        if (l >= r) {
            return;
        }
        int k = random.nextInt(r - l + 1) + l;
        swapArrayElements(a, a2, l, k);

        //use partition3
        int m = partition2(a, a2, l, r);
        //int[] res3 = partition2(a,a2, l, r);
        randomizedQuickSort(a, a2, l, m - 1);
        randomizedQuickSort(a, a2, m + 1, r);
    }


    static void swapArrayElements(int[] array, int[] array2, int pos1, int pos2) {
        int tmp = array[pos1];
        array[pos1] = array[pos2];
        array[pos2] = tmp;

        tmp = array2[pos1];
        array2[pos1] = array2[pos2];
        array2[pos2] = tmp;


    }

}

