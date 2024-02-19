public class DLL {
    private Node<E> header;
    private Node<E> trailer;
    private int size;

    public class Node<E> {
        private E element;
        private Node<E> prev;
        private Node<E> next;

        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        public Node(E element, E header, E next) {

        }

        public E getElement() {
            return element;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public void setNext(Node<Object> trailer) {

        }
    }
    public class DoublyLinkedList<E> {
        private Node<E> header;
        private Node<E> trailer;
        private int size = 0;

        public DoublyLinkedList() {
            header = new Node<>(null, null, null);
            trailer = new Node<>(null, header, null);
            header.setNext(trailer);
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        public E first() {
            if (isEmpty()) return null;
            return header.getNext().getElement();
        }

        public E last() {
            if (isEmpty()) return null;
            return trailer.getPrev().getElement();
        }

        public void addFirst(E e) {
            addBetween(e, header, header.getNext());
        }

        public void addLast(E e) {
            addBetween(e, trailer.getPrev(), trailer);
        }

        public E removeFirst() {
            if (isEmpty()) return null;
            return remove(header.getNext());
        }

        public E removeLast() {
            if (isEmpty()) return null;
            return remove(trailer.getPrev());
        }

        private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
            Node<E> newest = new Node<>(e, predecessor, successor);
            predecessor.setNext(newest);
            successor.setPrev(newest);
            size++;
        }

        private E remove(Node<E> node) {
            Node<E> predecessor = node.getPrev();
            Node<E> successor = node.getNext();
            predecessor.setNext(successor);
            successor.setPrev(predecessor);
            size--;
            return node.getElement();
        }
    }
    public Node<E> findMiddle() {
        Node<E> slow = header;
        Node<E> fast = header;
        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }
    public int size() {
        int size = 0;
        Node<E> node = header.getNext();
        while (node != trailer) {
            size++;
            node = node.getNext();
        }
        return size;
    }
    public boolean equals(Object o) {
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        doublylinkedlist other = (doublylinkedlist) o;
        if (size() != other.size()) return false;
        Node walkA = header.getNext();
        Node walkB = other.header.getNext();
        while (walkA != trailer) {
            if (!walkA.getElement().equals(walkB.getElement())) return false;
            walkA = walkA.getNext();
            walkB = walkB.getNext();
        }
        return true;
    }
    public class doublylinkedlist<E> {
        public Node<DLL.E> header;
        public Node<Object> trailer;
        private Node<E> sentinel;
        private int size = 0;

        public doublylinkedlist() {
            sentinel = new Node<>(null, null, null);
            sentinel.setNext(sentinel);
            sentinel.setPrev(sentinel);
        }

        public int size() {
            return 0;
        }
        // Other methods remain the same, but replace header and trailer with sentinel
    }
    public class CircularDoublyLinkedList<E> {
        private Node<E> tail = null;
        private int size = 0;

        public CircularDoublyLinkedList() { }

        // Other methods remain the same, but add rotate and rotateBackward methods
        public void rotate() {
            if (tail != null)
                tail = tail.getNext();
        }

        public void rotateBackward() {
            if (tail != null)
                tail = tail.getPrev();
        }
    }
    public doublylinkedlist<E> clone() throws CloneNotSupportedException {
        doublylinkedlist<E> other = (doublylinkedlist) super.clone();
        if (size > 0) {
            other.header = new Node<>(null, null, null);
            other.trailer = new Node<Object>(null, other.header, null);
            other.header.setNext(other.trailer);
            Node<E> walk = header.getNext();
            Node<E> otherWalk = other.header;
            for (int i = 0; i < size; i++) {
                Node<E> newest = new Node<>(walk.getElement(), otherWalk, otherWalk.getNext());
                otherWalk.getNext().setPrev(newest);
                otherWalk.setNext(newest);
                walk = walk.getNext();
                otherWalk = otherWalk.getNext();
            }
        }
        return other;
    }
    private class E {
    }
}