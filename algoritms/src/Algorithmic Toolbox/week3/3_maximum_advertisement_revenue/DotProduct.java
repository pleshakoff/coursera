import java.util.*;

public class DotProduct {

    static void swapArrayElements(int[] array, int pos1, int pos2){
        int tmp = array[pos1];
        array[pos1]=array[pos2];
        array[pos2]=tmp;

    }


    private static long maxDotProduct(int[] a, int[] b) {

        long result = 0;
        for (int i = 0; i < a.length; i++) {
            int maxA=0; int maxAPos=i;
            int maxB=0; int maxBPos=i;
            for (int j = i; j < a.length; j++) {
               if (a[j]>maxA)
               {
                   maxA=a[j];
                   maxAPos=j;
               }

                if (b[j]>maxB)
                {
                    maxB=b[j];
                    maxBPos=j;
                }
            }
            swapArrayElements(a,i,maxAPos);
            swapArrayElements(b,i,maxBPos);
            result += (long) a[i] * b[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(maxDotProduct(a, b));
    }
}

