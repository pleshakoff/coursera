import java.util.*;
import java.io.*;

public class tree_height {

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

	public class Node {
       int parentId;
       int height;
       List<Node> children;

		public Node(int parentId) {
			this.parentId = parentId;
			height = 0;
			children = new ArrayList<>();
		}

		void addChildren(Node node)
		{
			children.add(node);
		}
	}


	public class TreeHeight {
		int n;
		Node parent[];
		Stack<Node> stack = new Stack<>();

		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
			parent = new Node[n];

			//считываем массив из аутпута
			for (int i = 0; i < n; i++) {
				parent[i] = new Node(in.nextInt());
			}

			//строим дерево
			for (int i = 0; i < n; i++) {
				Node child = parent[i];
				if (child.parentId == -1) {
                    child.height=1;
                    stack.push(child);
                }
                else
                 parent[child.parentId].addChildren(child);
			}
			};


//		int computeHeight() {
//                        // Replace this code with a faster implementation
//			int maxHeight = 0;
//			while (!stack.empty()) {
//				Node node = stack.pop();
//				maxHeight = Math.max(maxHeight, node.heght);
//				for (int i = 0; i < n; i++) {
//					if (parent[i] == node.id) {
//						stack.push(new Node(i,node.heght+1));
//					}
//				}
//			}
//			return maxHeight;
//		}

		int computeHeight() {
			// Replace this code with a faster implementation
			int maxHeight = 0;
			while (!stack.empty()) {
				Node node = stack.pop();
				maxHeight = Math.max(maxHeight, node.height);
				for (Node child:node.children) {
					child.height = node.height+1;
					stack.push(child);
				}
			}
			return maxHeight;
		}



	}

	static public void main(String[] args) throws IOException {
            new Thread(null, new Runnable() {
                    public void run() {
                        try {
                            new tree_height().run();
                        } catch (IOException e) {
                        }
                    }
                }, "1", 1 << 26).start();
	}
	public void run() throws IOException {
		TreeHeight tree = new TreeHeight();
		tree.read();
		System.out.println(tree.computeHeight());
	}
}
