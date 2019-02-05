import java.util.*;

public class LargestNumber {

    private static String largestNumber(String[] a) {
        //write your code here
        String result = "";
        for (int i = 0; i < a.length; i++) {
            int max = 0;
            int maxIndex=0;
            for (int j = 0; j < a.length; j++) {
               int current=Integer.valueOf(makeBigDigit(a[j]));
               if (max<current)
               {
                   max=current;
                   maxIndex=j;
               }

            }
            result+=a[maxIndex];
            a[maxIndex]="0";


        }
        return result;
    }

    static String makeBigDigit(String s)
    {
        String last = s.substring(s.length() - 1);
        StringBuilder stringBuilder = new StringBuilder(s);
        for (int i = s.length(); i < 4; i++)
            stringBuilder.append(last);
        return stringBuilder.toString();


    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}

