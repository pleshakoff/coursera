package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Pleeshakoff on 15.01.2019.
 */
public class MaxPairwiseProduct {

    static int getMaxPairwiseProduct(int[] numbers) {
        int product = 0;
        int n = numbers.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                product = Math.max(product,
                        numbers[i] * numbers[j]);
            }
        }
        return product;
    }

    static int getMaxPairwiseProductFaster(int[] numbers) {
        int n = numbers.length;
        int index1 = 0;
        for (int i=1;i<n;i++)
        {
            if (numbers[i]>numbers[index1]) {
                index1=i;
            }
        }

        int index2=0;
        for (int i=1;i<n;i++)
        {
            if ((numbers[i]>numbers[index2]) && (index1!=i)) {
                index2=i;
            }
        }
        printlnArray(numbers);
        return numbers[index1]*numbers[index2];
    }

    static void swapArrayElements(int[] array, int pos1, int pos2){
        int tmp = array[pos1];
        array[pos1]=array[pos2];
        array[pos2]=tmp;

    }

    static void printlnArray(int[] numbers){
        for (int i=0; i < numbers.length;i++) {
            System.out.println(numbers[i]);
        }
    }


    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProductFaster(numbers));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;
        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                        InputStreamReader(stream));
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
}
