import java.util.*;
import java.io.*;

public class MajorityElement {

    private static int getMajorityElement(int[] a, int left, int right) {
        if (left == right) {
            return a[left];
        }
        if (left + 1 == right) {
            if (a[left] == a[right]) {
                return a[left];
            } else
                return -1;
        }
        int mid = left + (right - left) / 2;

        int majorityElementLeft = checkMajority(a, left, right, getMajorityElement(a, left, mid));
        int majorityElementRight = checkMajority(a, left, right, getMajorityElement(a, mid + 1, right));


        return Math.max(majorityElementLeft,majorityElementRight);

//        int majorityElement;
//
//        if (majorityElementLeft > -1 && majorityElementRight == -1) {
//            majorityElement = majorityElementLeft;
//        } else if (majorityElementRight > -1 && majorityElementLeft == -1) {
//            majorityElement= majorityElementRight;
//        } else if (majorityElementRight == majorityElementLeft) {
//            majorityElement= majorityElementLeft;
//        } else
//            majorityElement= -1;
//
//        ;

    }

    private static int checkMajority(int[] a, int left, int right, int majorityElement) {
        int cnt=0;
        if (majorityElement > -1) {
            for (int i = left; i <= right; i++) {
                if (a[i] == majorityElement) {
                    cnt++;
                }
            }
            if (cnt > (right-left+1) / 2) {
                return majorityElement;
            }
            else
                return -1;
        }
        else
         return majorityElement;
    }


    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        if (getMajorityElement(a, 0, a.length-1) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
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
}

