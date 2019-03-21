import java.util.Scanner;

import static java.lang.Math.*;

public class PlacingParentheses {
    private static long getMaximValue(String exp) {

      String[] expArr = exp.split("");
      int n = exp.length()/2+1;

      long[] digits = new long[n];
      for (int i = 0; i < n;i++) {
        digits[i]= Long.parseLong(expArr[i*2]);
      }

      String[] oper = new String[n-1];
      for (int i = 0; i < n-1;i++) {
            oper[i]= expArr[i*2+1];
      }

      long[][] min = new long[n][n];
      long[][] MAX = new long[n][n];

       for (int i = 0; i < n; i++) {
          MAX[i][i]=digits[i];
          min[i][i]=digits[i];
        }

        for (int pos = 1; pos < n; pos++) {
            for (int i = 0; i < n-pos; i++) {
                int j=i+pos;
                minAndMax(i,j,MAX,min,oper);
                prinMatrix(n, min, MAX);
            }
        }


        return MAX[0][n-1];
    }

    private static void prinMatrix(int n, long[][] min, long[][] MAX) {

//        System.out.println();
//        System.out.println();
//
//        for (int i = 0; i < n; i++) {
//        for (int j = 0; j < n; j++)
//                System.out.print(MAX[i][j]+" ");
//            System.out.println();
//        }
//        System.out.println();
//        System.out.println();
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++)
//                System.out.print(min[i][j]+" ");
//            System.out.println();
//        }
    }

    private static void minAndMax(int i, int j, long[][] M, long[][] m, String[] oper) {

        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        for (int k = i; k <= j-1; k++) {
            long a = eval(M[i][k],M[k+1][j],oper[k]);
            long b = eval(M[i][k],m[k+1][j],oper[k]);
            long c = eval(m[i][k],M[k+1][j],oper[k]);
            long d = eval(m[i][k],m[k+1][j],oper[k]);
            max = max(max, max(a,max(b,max(c,d))));
            min = min(min, min(a,min(b,min(c,d))));
        }
        M[i][j]=max;
        m[i][j]=min;
    }

    private static long eval(long a, long b, String op) {
        if (op.equals("+")) {
            return a + b;
        } else if (op.equals("-")) {
            return a - b;
        } else if (op.equals("*")) {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        System.out.println(getMaximValue(exp));
//        System.out.println(getMaximValue(""));
    }
}

