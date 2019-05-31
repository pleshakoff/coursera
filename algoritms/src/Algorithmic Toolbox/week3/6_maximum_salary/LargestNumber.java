import java.util.*;

public class LargestNumber {

    private static String largestNumber(String[] a) {
        //write your code here
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            String max = "0";
            int maxIndex=0;
            for (int j = 0; j < a.length; j++) {
               //int current=Integer.valueOf(makeBigDigit(a[j]));
               if (greaterOrEqual(a[j],max))
               {
                   max=a[j];
                   maxIndex=j;
               }

            }
            result.append(a[maxIndex]);
            a[maxIndex]="0";


        }
        return result.toString();
    }

    static boolean  greaterOrEqual(String left,String right)
    {
        return Integer.valueOf(left+right)>=Integer.valueOf(right+left);
    }

    static String makeBigDigit(String s)
    {
        /*String last = s.substring(s.length() - 1);
        StringBuilder stringBuilder = new StringBuilder(s);
        for (int i = s.length(); i < 3; i++)
            stringBuilder.append(0);
            stringBuilder.append(last);
        return stringBuilder.toString();*/
        return s;


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

