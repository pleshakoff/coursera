import java.util.*;

public class LCM {


  private static long lcm_naive(int a, int b) {
    for (long l = 1; l <= (long) a * b; ++l)
      if (l % a == 0 && l % b == 0)
        return l;

    return (long) a * b;
  }

  private static int gcd_fast(int a, int b) {
    int divisible=a;
    int divider=b;

    int reminder = divisible % divider;
    while (reminder!=0)
    {
      divisible = divider;
      divider =reminder;
      reminder = divisible % divider;
    }
    return divider;
  }



  private static long lcm_fast(int a, int b) {
    return (long)a*b/gcd_fast(a,b);
  }






  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(lcm_fast(a, b));
  }
}
