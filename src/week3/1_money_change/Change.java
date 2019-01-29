import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        int[] coins = {10,5,1};
        int n = 0;
        for (int coin : coins) {
            int i = ( m / coin);
            n=n+i;
           m=m%coin;
        }
        return n;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

