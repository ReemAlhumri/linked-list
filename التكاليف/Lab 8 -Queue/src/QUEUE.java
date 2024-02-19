public class QUEUE {
    private QUEUE data;

    public interface Queue<E> {
        int size();
        boolean isEmpty();
        void enqueue(E e);
        E first();
        E dequeue();
    }
    public class ArrayQueue<E> implements Queue<E> {
        public static final int CAPACITY = 1000;
        private E[] data;
        private int f = 0;
        private int sz = 0;

        public ArrayQueue() { this(CAPACITY); }

        public ArrayQueue(int capacity) {
            data = (E[]) new Object[capacity];
        }

        public int size() { return sz; }

        public boolean isEmpty() { return (sz == 0); }

        public void enqueue(E e) throws IllegalStateException {
            if (sz == data.length) throw new IllegalStateException("Queue is full");
            int avail = (f + sz) % data.length;
            data[avail] = e;
            sz++;
        }

        public E first() {
            if (isEmpty()) return null;
            return data[f];
        }

        public E dequeue() {
            if (isEmpty()) return null;
            E answer = data[f];
            data[f] = null;
            f = (f + 1) % data.length;
            sz--;
            return answer;
        }
    }
    public class LinkedQueue<E> implements Queue<E> {
        private SinglyLinkedList<E> list = new SinglyLinkedList<>();

        public LinkedQueue() { }

        public int size() { return list.size(); }

        public boolean isEmpty() { return list.isEmpty(); }

        public void enqueue(E element) { list.addLast(element); }

        public E first() { return list.first(); }

        public E dequeue() { return list.removeFirst(); }
        private class SinglyLinkedList<E> {
            public int size() {
                return 0;
            }

            public boolean isEmpty() {
                return false;
            }

            public void addLast(E element) {

            }

            public E first() {
                return null;
            }

            public E removeFirst() {
                return null;
            }
        }
    }
    public void rotate() {
        if (!isEmpty()) {
            E e = dequeue();
            E[] data = new E[0];
            int sz = 0;
            int f = 0;
            data[(f + sz) % data.length] = e;
            sz++;
        }
    }

    private E dequeue() {
        return null;
    }

    private boolean isEmpty() {
        return false;
    }
    public ArrayQueue<E> clone() throws CloneNotSupportedException {
        ArrayQueue<E> other = (ArrayQueue) super.clone();
        other.data = data.clone(0);
        return other;
    }

    private E[] clone(int i) {
        return new E[0];
    }

    public void concatenate(LinkedQueue<E> Q2) {
        while (!Q2.isEmpty()) {
            enqueue(Q2.dequeue());
        }
    }

    private void enqueue(E dequeue) {
    }
    public int josephus(int n, int k) {
        Queue<Integer> queue = new ArrayQueue<>();
        for (int i = 1; i <= n; i++) {
            queue.enqueue(i);
        }
        while (queue.size() > 1) {
            for (int i = 0; i < k - 1; i++) {
                queue.enqueue(queue.dequeue());
            }
            queue.dequeue();
        }
        return queue.dequeue();
    }
    public void roundRobinScheduling(Queue<Process> queue, int quantum) {
        while (!queue.isEmpty()) {
            Process process = queue.dequeue();
            process.onExit();
            if (!process.isAlive()) {
                queue.enqueue(process);
            }
        }
    }
}