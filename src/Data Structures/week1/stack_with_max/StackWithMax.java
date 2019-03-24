import java.util.*;
import java.io.*;

public class StackWithMax {
    class FastScanner {
        StringTokenizer tok = new StringTokenizer("");
        BufferedReader in;

        FastScanner() {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (!tok.hasMoreElements())
                tok = new StringTokenizer(in.readLine());
            return tok.nextToken();
        }
        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
    class Node {
        int val;
        int max;

        public Node(int val, int max) {
            this.val = val;
            this.max = max;
        }
    }

    public void solve() throws IOException {
        FastScanner scanner = new FastScanner();
        int queries = scanner.nextInt();
        Stack<Node> stack = new Stack<Node>();

        int maxVal=Integer.MIN_VALUE;
        for (int qi = 0; qi < queries; ++qi) {
            String operation = scanner.next();
            if ("push".equals(operation)) {
                int value = scanner.nextInt();
                if (value > maxVal) {
                    maxVal = value;
                }
                stack.push(new Node(value,maxVal));
            } else if ("pop".equals(operation)) {
                stack.pop();
                maxVal=stack.peek().max;
            } else if ("max".equals(operation)) {
                System.out.println(maxVal);
            }
        }
    }

    static public void main(String[] args) throws IOException {
        new StackWithMax().solve();
    }
}
