import java.util.*;
import java.io.*;

public class tree_orders {
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

	public class TreeOrders {
		int n;
		int[] key, left, right;
		
		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
			key = new int[n];
			left = new int[n];
			right = new int[n];
			for (int i = 0; i < n; i++) { 
				key[i] = in.nextInt();
				left[i] = in.nextInt();
				right[i] = in.nextInt();
			}
		}

		void addNodeToResultInOrder(int i,ArrayList<Integer> result) {
			if (i == -1) return;
		    addNodeToResultInOrder(left[i],result);
         	result.add(key[i]);
			addNodeToResultInOrder(right[i],result);
		}

		void addNodeToResultPreOrder(int i,ArrayList<Integer> result) {
			if (i == -1) return;
			result.add(key[i]);
			addNodeToResultPreOrder(left[i],result);
			addNodeToResultPreOrder(right[i],result);
		}

		void addNodeToResultPostOrder(int i,ArrayList<Integer> result) {
			if (i == -1) return;
			addNodeToResultPostOrder(left[i],result);
			addNodeToResultPostOrder(right[i],result);
			result.add(key[i]);
		}



		List<Integer> inOrder() {
			ArrayList<Integer> result = new ArrayList<Integer>();
			if (key.length > 0) {
				addNodeToResultInOrder(0,result);
			}
			return result;
		}

		List<Integer> preOrder() {
			ArrayList<Integer> result = new ArrayList<Integer>();
			if (key.length > 0) {
				addNodeToResultPreOrder(0,result);
			}
			return result;
		}

		List<Integer> postOrder() {
			ArrayList<Integer> result = new ArrayList<Integer>();
			if (key.length > 0) {
				addNodeToResultPostOrder(0,result);
			}
			return result;
		}
	}

	static public void main(String[] args) throws IOException {
            new Thread(null, new Runnable() {
                    public void run() {
                        try {
                            new tree_orders().run();
                        } catch (IOException e) {
                        }
                    }
                }, "1", 1 << 26).start();
	}

	public void print(List<Integer> x) {
		for (Integer a : x) {
			System.out.print(a + " ");
		}
		System.out.println();
	}

	public void run() throws IOException {
		TreeOrders tree = new TreeOrders();
		tree.read();
		print(tree.inOrder());
		print(tree.preOrder());
		print(tree.postOrder());
	}
}
