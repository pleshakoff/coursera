import java.util.*;

class EditDistance {

    public static int EditDistance(String s, String t) {

        String[] fromArray = s.split("");
        String[] toArray = t.split("");

        int fromSize = fromArray.length+1;
        int toSize = toArray.length+1;
        int d[][] = new int[toSize][fromSize];


        d[0][0] = 0;

        for (int i = 1; i < toSize; i++) {
            d[i][0] = d[i - 1][0] + 1;
        }

        for (int j = 1; j < fromSize; j++) {
            d[0][j] = d[0][j - 1] + 1;
        }

        //направо = добавление
        //вниз = удаление

        for (int j = 1; j < fromSize; j++)
            for (int i =1; i < toSize; i++) {

               int insertion = d[i-1][j]+1;
               int del = d[i][j-1]+1;
               int replace =  d[i-1][j-1]+1;
               int eq =  d[i-1][j-1];

               if (fromArray[j-1].equals(toArray[i-1]))
               {
                   d[i][j]=Math.min(Math.min(insertion,del),eq);
               }
               else
               {
                   d[i][j]=Math.min(Math.min(insertion,del),replace);
               }
            }

//        for (int j = 0; j < fromSize; j++) {
//            for (int i = 0; i < toSize; i++)
//                System.out.print(d[i][j]+" ");
//            System.out.println();
//        }

        //write your code here
        return d[toSize-1][fromSize-1];
    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        String s = scan.next();
        String t = scan.next();

        System.out.println(EditDistance(s, t));
    }

}
