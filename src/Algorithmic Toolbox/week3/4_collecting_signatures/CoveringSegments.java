import java.util.*;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class CoveringSegments {

    private static int[] optimalPoints(Segment[] segments) {
        //write your code here
        for (int i = 0; i < segments.length; i++) {
            for (int j = i+1; j < segments.length; j++) {
               if (segments[j].start<segments[i].start)
               {
                   swapArrayElements(segments,i,j);
               }
            }
        }
        int[] pointsTmp = new int[segments.length];
        int pointsCount = 0;
        for (int i = 0; i < segments.length; i++) {
            int leftP = segments[i].start;
            int rightP = segments[i].end;
            for (int j = i+1; j < segments.length; j++) {
                if ((segments[j].start>=leftP)&&(segments[j].start<=rightP))
                {
                    leftP=segments[j].start;
                    rightP=min(rightP,segments[j].end);
                    i++;
                }
            }
            pointsTmp[pointsCount]=rightP;
            pointsCount++;
        }
        int[] points = new int[pointsCount];
        System.arraycopy(pointsTmp, 0, points, 0, pointsCount);
        return points;
    }

    private static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        int[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }
    }

    static <T> void swapArrayElements(T[] array, int pos1, int pos2) {
        T tmp = array[pos1];
        array[pos1] = array[pos2];
        array[pos2] = tmp;

    }

}
 
