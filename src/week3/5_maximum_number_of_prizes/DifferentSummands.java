import java.util.*;

public class DifferentSummands {

    private static List<Integer> optimalSummands(int n) {
        List<Integer> summands = new ArrayList<>();
        if (n<3)
        {
            summands.add(n);
            return summands;
        }


        int maxNumber=0;
        while (n>0) {
            int nextNumber = maxNumber + 1;
            if (nextNumber >= n-nextNumber)       //1 2 3
                nextNumber = n;
            maxNumber=nextNumber;
            summands.add(nextNumber);
            n-=nextNumber;
        }
        return summands;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
    }
}

