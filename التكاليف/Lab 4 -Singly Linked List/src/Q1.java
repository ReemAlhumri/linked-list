public class Q1 {
    private int size;
    private Node head;

    public class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }
    public class SinglyLinkedList<E> {
        private Node<E> head = null;
        private Node<E> tail = null;
        private int size = 0;

        public SinglyLinkedList() { }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        public E first() {
            if (isEmpty()) return null;
            return head.getElement();
        }

        public E last() {
            if (isEmpty()) return null;
            return tail.getElement();
        }

        public void addFirst(E e) {
            head = new Node<>(e, head);
            if (size == 0)
                tail = head;
            size++;
        }

        public void addLast(E e) {
            Node<E> newest = new Node<>(e, null);
            if (isEmpty())
                head = newest;
            else
                tail.setNext(newest);
            tail = newest;
            size++;
        }

        public E removeFirst() {
            if (isEmpty()) return null;
            E answer = head.getElement();
            head = head.getNext();
            size--;
            if (size == 0)
                tail = null;
            return answer;
        }
    }



    public boolean equals(Object o) {
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        SinglyLinkedList other = (SinglyLinkedList) o;
        if (size != other.size) return false;
        Node walkA = head;
        Node walkB = other.head;
        while (walkA != null) {
            if (!walkA.getElement().equals(walkB.getElement())) return false;
            walkA = walkA.getNext();
            walkB = walkB.getNext();
        }
        return true;
    }
    public Node secondToLast() {
        
        if (head == null || head.getNext() == null) return null;
        Node node = head;
        while (node.getNext().getNext() != null) {
            node = node.getNext();
        }
        return node;
    }
    public int size() {
        int size = 0;
        Node node = head;
        while (node != null) {
            size++;
            node = node.getNext();
        }
        return size;
    }
    public void rotate() {
        if (head != null) {
            Node oldHead = head;
            head = oldHead.getNext();
            oldHead.setNext(null);
            Node node = head;
            while (node.getNext() != null) {
                node = node.getNext();
            }
            node.setNext(oldHead);
        }
    }
    public void concatenate(SinglyLinkedList list) {
        if (head == null) {
            head = list.head;
        } else {
            Node node = head;
            while (node.getNext() != null) {
                node = node.getNext();
            }
            node.setNext(list.head);
        }
    }
    public void reverse() {
        Node current = head;
        Node previous = null;
        Node next = null;
        while (current != null) {
            next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }
        head = previous;
    }
}