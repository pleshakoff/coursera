import java.util.*;

public class Inversions {

    private static long getNumberOfInversions(int[] a, int[] b, int left, int right) {
        //6 1 5 2 4 3
        long numberOfInversions = 0;
        if (right == left) {
            b[left] = a[left];
            return numberOfInversions;
        }
        int ave = (left + right) / 2;
        numberOfInversions += getNumberOfInversions(a, b, left, ave);
        numberOfInversions += getNumberOfInversions(a, b, ave + 1, right);


        int i=left,j=ave+1;
        for (int cnt = left; cnt <=right ; cnt++) {
            if (i>ave)
            {
                b[cnt]=a[j];
                j++;

            }
            else
            if (j>right)
            {
                b[cnt]=a[i];
                i++;
            }
            else
            if ((a[i] > a[j])) {
                numberOfInversions+=ave-i+1;
                b[cnt]=a[j];
                j++;
            }
            else
            {
                b[cnt]=a[i];
                i++;

            }
        }

        for (int k = left; k <=right; k++) {
            a[k]=b[k];
        }

        return numberOfInversions;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        long numberOfInversions = getNumberOfInversions(a, b, 0, a.length - 1);
        System.out.println(numberOfInversions);
//        for (int bb:b
//             ) {
//            System.out.print(bb+" ");
//
//        }
    }

    static void swapArrayElements(int[] array, int pos1, int pos2) {
        int tmp = array[pos1];
        array[pos1] = array[pos2];
        array[pos2] = tmp;

    }
}

