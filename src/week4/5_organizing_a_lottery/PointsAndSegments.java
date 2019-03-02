import java.util.Scanner;

public class PointsAndSegments {

    private static int[] fastCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        int mid = (starts.length-1)/2;
        for (int i = 0; i < points.length; i++) {
               cnt[i] = getCnt(points[i],starts, ends,0, starts.length-1);
        }
        return cnt;
    }

    private static int getCnt(int point,int[] starts, int[] ends,int left, int right){

          if (left == right)
          {
              if (starts[left] <= point && point <= ends[left])
                  return 1;
              else
                  return 0;

          }
          else
          if (left+1 == right)
          {
              return getCnt(point,starts, ends,left,left)+
                      getCnt(point,starts, ends,right,right);
          }
          else
          {
              int mid = left + (right - left) / 2;
              return getCnt(point,starts, ends,left, mid)+
                      getCnt(point,starts, ends,mid+1,right);

          }
    };


    private static int[] naiveCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < starts.length; j++) {
                if (starts[j] <= points[i] && points[i] <= ends[j]) {
                    cnt[i]++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[] starts = new int[n];
        int[] ends = new int[n];
        int[] points = new int[m];
        for (int i = 0; i < n; i++) {
            starts[i] = scanner.nextInt();
            ends[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            points[i] = scanner.nextInt();
        }
        //use fastCountSegments
        int[] cnt = fastCountSegments(starts, ends, points);
        for (int x : cnt) {
            System.out.print(x + " ");
        }
    }
}

