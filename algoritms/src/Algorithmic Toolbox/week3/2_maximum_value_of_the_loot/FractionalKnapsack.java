import java.util.Scanner;

import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.Math.negateExact;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        int n = values.length;
        for (int I = 0; I < n; I++) {

            {
                double maxprice = 0.0;
                int maxElement = 0;
                for (int i = 0; i < n; i++) {
                    double price = (double) values[i] / weights[i];
                    if (price > maxprice) {
                        maxprice = price;
                        maxElement = i;
                    }
                }
                int takenCapacity = min(capacity, weights[maxElement]);
                double takenValue = takenCapacity * maxprice;
                values[maxElement] -= takenValue;
                value += takenValue;
                capacity -= takenCapacity;
            }
        }

        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
} 
