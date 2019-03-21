import java.util.*;

public class PrimitiveCalculator {
    private static List<Integer> optimal_sequence(int n) {
        int[] operations = new int[n + 1];

        operations[1] = 0;

        //сначала для каждого числа до n считаем количество операций, которым оно может быть достигнуто
        for (int i = 2; i <= n; i++) {
            int min = operations[i - 1] + 1;
            if (i % 2 == 0) {
                min = Math.min(min, operations[i / 2] + 1);
            }
            if (i % 3 == 0) {
                min = Math.min(min, operations[i / 3] + 1);
            }
            operations[i] = min;
        }

        //ищем для каждой операции придыдущую и выполняем ее
        int i = n;
        List<Integer> sequence = new ArrayList<Integer>();
        sequence.add(i);
        while (i != 1) {
            if ((operations[i - 1] + 1) == operations[i]) {
               i--;
            }
            else if ((i % 2 == 0) && ((operations[i / 2] + 1) == operations[i])) {
                i/=2;
            }
            else if ((i % 3 == 0) && ((operations[i / 3] + 1) == operations[i])) {
                i/=3;
            }
            sequence.add(i);

        }

        Collections.reverse(sequence);

        return sequence;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}

