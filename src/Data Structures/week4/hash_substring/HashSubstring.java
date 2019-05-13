import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class HashSubstring {

    private static FastScanner in;
    private static PrintWriter out;

    private static int prime = 1000000007;
    private static int multiplier = 263;
    private static String pattern;
    private static String text;
    private static int[] hashes;
    private static int textLength;
    private static int patternLength;


    public static void main(String[] args) throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        printOccurrences(getOccurrences(readInput()));
        out.close();
    }

    private static Data readInput() throws IOException {
        String pattern = in.next();
        String text = in.next();
        return new Data(pattern, text);
    }

    private static void printOccurrences(List<Integer> ans) throws IOException {
        for (Integer cur : ans) {
            out.print(cur);
            out.print(" ");
        }
    }

    //    H ← array of length |T| − |P| + 1
//    S ← T[|T| − |P|..|T| − 1]
//    H[|T| − |P|] ← PolyHash(S, p, x)
//    y ← 1
//            for i from 1 to |P|:
//    y ← (y × x) mod p

//    for i from |T| − |P| − 1 down to 0:
//       H[i] ← (xH[i + 1] + T[i] − yT[i + |P|]) mod p
//    return H

    private static void precomputeHashes() {

        System.out.println("");
        System.out.println("");
        System.out.println("NEW");

        hashes = new int[textLength-patternLength+1];
        hashes[textLength-patternLength]=hashFunc(text.substring(textLength-patternLength,textLength));//!!!!!!
        System.out.println(hashes[textLength-patternLength] +" "+text.substring(textLength-patternLength,textLength));
        long y=1;
        for (int i = 1; i <=patternLength; i++) {
            y=(y*multiplier)%prime;
        }
        for (int i = textLength-patternLength-1; i >=0 ; i--) {
           hashes[i]= (int) (((multiplier*hashes[i+1]+text.charAt(i)-y*text.charAt(i+patternLength))%prime+prime)%prime);
//          H[i] ← (xH[i + 1] + T[i] − yT[i + |P|]) mod p
            System.out.println(hashes[i] +" "+text.substring(i,i+patternLength));
        }
    }

    private static void precomputeHashesOld() {
//        System.out.println("");
//        System.out.println("");
//        System.out.println("OLD");

        hashes = new int[textLength-patternLength+1];
        for (int i = textLength-patternLength; i >=0 ; i--) {
            hashes[i]=hashFunc(text.substring(i,i+patternLength));
       //     System.out.println(hashes[i] +" "+text.substring(i,i+patternLength));
        }
    }



//    H ← array of length |T| − |P| + 1
//    S ← T[|T| − |P|..|T| − 1]
//    H[|T| − |P|] ← PolyHash(S, p, x)
//    y ← 1
//            for i from 1 to |P|:
//    y ← (y × x) mod p

//    for i from |T| − |P| − 1 down to 0:
//       H[i] ← (xH[i + 1] + T[i] − yT[i + |P|]) mod p
//    return H


    private static int hashFunc(String s) {
        long hash = 0;
        for (int i = s.length() - 1; i >= 0; --i)
            hash = (hash * multiplier + s.charAt(i)) % prime;
        return (int)hash;
    }


    private static List<Integer> getOccurrences(Data input) {
        pattern = input.pattern;
        text = input.text;
        textLength = text.length();
        patternLength = pattern.length();

        List<Integer> occurrences = new ArrayList<Integer>();
//        precomputeHashes();
        precomputeHashesOld();

        for (int i = 0; i + patternLength <= textLength; ++i) {
            boolean equal = true;
            if (hashFunc(text.substring(i,i+patternLength))==hashes[i])
            {
                for (int j = 0; j < patternLength; ++j) {
                    if (pattern.charAt(j) != text.charAt(i + j)) {
                        equal = false;
                        break;
                    }
                }
            }
            if (equal)
                occurrences.add(i);
        }
        return occurrences;
    }

    static class Data {
        String pattern;
        String text;
        public Data(String pattern, String text) {
            this.pattern = pattern;
            this.text = text;
        }
    }

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}

