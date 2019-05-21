
import java.util.*;
import java.io.*;

public class is_bst_hard {
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

    public class IsBST {
        class Node {
            int key;
            int left;
            int right;

            Node(int key, int left, int right) {
                this.left = left;
                this.right = right;
                this.key = key;
            }
        }

        int nodes;
        Node[] tree;

        void read() throws IOException {
            FastScanner in = new FastScanner();
            nodes = in.nextInt();
            tree = new Node[nodes];
            for (int i = 0; i < nodes; i++) {
                tree[i] = new Node(in.nextInt(), in.nextInt(), in.nextInt());
            }
        }

        boolean isBinarySearchTree() {
            if (tree.length > 0) {
                return checkSubTree(tree[0],Integer.MIN_VALUE,1 ,Integer.MAX_VALUE,1);
            }
            else
                return true;

        }

        boolean checkSubTree(Node node, int min,int minIsRight, int max,int maxIsRight) {


                if ((node.key < min) ||(node.key==min && minIsRight==0 ) || (node.key > max) || (node.key==max && maxIsRight==0)) {
                    return false;
                }

            int left  = node.left;
            if ((left != -1)) {
                if(tree[left].key>=node.key)
                    return false;
                if (!checkSubTree(tree[left],min,minIsRight,node.key,0))
                    return false;
            }


            int right=node.right;
            if (right != -1) {
                if (tree[right].key<node.key)
                    return false;
                if (!checkSubTree(tree[right],node.key,1,max,maxIsRight))
                    return false;
            }

            // Implement correct algorithm here
            return true;
        }
    }

    static public void main(String[] args) throws IOException {
        new Thread(null, new Runnable() {
            public void run() {
                try {
                    new is_bst_hard().run();
                } catch (IOException e) {
                }
            }
        }, "1", 1 << 26).start();
    }
    public void run() throws IOException {
        IsBST tree = new IsBST();
        tree.read();
        if (tree.isBinarySearchTree()) {
            System.out.println("CORRECT");
        } else {
            System.out.println("INCORRECT");
        }
    }
}
