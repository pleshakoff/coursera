import java.util.*;

public class FibonacciHuge {
    private static long getFibonacciHugeNaive(long n, long m) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % m;
    }



    private static long getFibonacciHugeFast(long n, int m) {
        if (n<=1)
            return n;

        int arrayLimit=6*m;
        long[] numbers = new long[arrayLimit];
        numbers[0]=0;
        numbers[1]=1;
        for (int i=2;i<=arrayLimit;i++)
        {
            numbers[i]= (numbers[i-1]+numbers[i-2])%m;
            if ((numbers[i]==1)&&(numbers[i-1]==0))
               return numbers[(int) (n%(i-1))];
            if (i==n)
              return numbers[i]%m;
         }
         return -1;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        int m = scanner.nextInt();
        System.out.println(getFibonacciHugeFast(n, m));
    }
}

