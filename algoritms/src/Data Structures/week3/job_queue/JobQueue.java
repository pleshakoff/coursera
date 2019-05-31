import java.awt.*;
import java.io.*;
import java.util.StringTokenizer;

public class JobQueue {

    private int numWorkers;
    private int[] jobs;

    private int[] assignedWorker;
    private long[] startTime;

    private FastScanner in;
    private PrintWriter out;


    public static void main(String[] args) throws IOException {
        new JobQueue().solve();
    }

    private class Event {
        int job;
        long start;
        long finish;

        Event(int job, long start, long finish) {
            this.job = job;
            this.start = start;
            this.finish = finish;
        }
    }

    private class PriorityQueue{
        private int size = 0;
        private Event[] data;

        PriorityQueue(int qSize) {
            this.data = new Event[qSize];
        }

        private int parent(int i) {
            return (i - 1)/2;
        }


        private int leftChild(int i) {
            return 2 * i + 1;
        }

        private int rightChild(int i) {
            return 2 * i + 2;
        }

        private void siftUp(int i) {
            if (size > 1) {
                while (i > 0 && checkNodes(data[i],data[parent(i)])) {
                    swapArrayElements(i,parent(i));
                    i=parent(i);
                }
            }
        }


        private void siftDown(int i) {
            if (size > 1) {
                int minIndex = i;
                int leftChild = leftChild(i);
                if ((leftChild < data.length) && checkNodes(data[leftChild],data[minIndex])) {
                    minIndex = leftChild;
                }
                int rightChild = rightChild(i);
                if ((rightChild < data.length) && checkNodes(data[rightChild],data[minIndex])) {
                    minIndex = rightChild;
                }
                if (i != minIndex) {
                    swapArrayElements(i, minIndex);
                    siftDown(minIndex);
                }
            }

        }


        private void insert(Event event)
        {
            if (size == data.length){
                new  RuntimeException("end of array");
            }
            size++;
            data[size-1]=event;
            siftUp(size-1);
        }

        private Event extractMax() {
            if (size<1)
                return null;
            Event res = data[0];
            data[0]=data[size-1];
            size--;
            siftDown(0);
            return res;

        }

        private void swapArrayElements(int pos1, int pos2) {
            Event tmp = data[pos1];
            data[pos1] = data[pos2];
            data[pos2] = tmp;
        }

    }



    private void readData() throws IOException {
        numWorkers = in.nextInt();
        int m = in.nextInt();
        jobs = new int[m];
        for (int i = 0; i < m; ++i) {
            jobs[i] = in.nextInt();
        }
    }


    boolean checkNodes(Event child, Event parent){
        return (child.finish<parent.finish)||(child.finish==parent.finish && child.job<parent.job);
    }



    private void assignJobs() {
        // TODO: replace this code with a faster algorithm.
        PriorityQueue priorityQueue = new PriorityQueue(numWorkers);
        int init = Math.min(numWorkers,jobs.length);

        for (int i = 0; i < init; i++) {
            priorityQueue.insert(new Event(i,0,jobs[i]));
            out.println(i + " " + 0);
        }
        for (int i = init; i < jobs.length; i++) {
            Event event = priorityQueue.extractMax();
            out.println(event.job + " " + event.finish);
            priorityQueue.insert(new Event(event.job,event.finish,event.finish+jobs[i]));
       }



    }

    public void solve() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        readData();
        assignJobs();
      //  writeResponse();
        out.close();
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
