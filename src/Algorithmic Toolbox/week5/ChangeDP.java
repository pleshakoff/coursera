import java.util.Scanner;

public class ChangeDP {
    private static int getChange(int m) {
        int coins[] = {1,3,4};

        int valMinCoins[] = new int[m+1];

        valMinCoins[0] = 0;
        for (int money = 1; money <=m; money++) {
            valMinCoins[money]=0;
            for (int coin : coins)
            {
               if (money>=coin)
               {
                   int minVal = valMinCoins[money-coin]+1;
                   if ((valMinCoins[money] == 0) || (minVal < valMinCoins[money])) {
                       valMinCoins[money]=minVal;
                   }
               }
            }
        }

        //write your code here
        return valMinCoins[m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

