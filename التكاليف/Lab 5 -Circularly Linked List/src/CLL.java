public class CLL {
    private int size;
    private Node<Object> tail;

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
    public class CircularlyLinkedList<E> {
        private Node<E> tail = null;
        private int size = 0;

        public CircularlyLinkedList() { }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        public E first() {
            if (isEmpty()) return null;
            return tail.getNext().getElement();
        }

        public E last() {
            if (isEmpty()) return null;
            return tail.getElement();
        }

        public void rotate() {
            if (tail != null)
                tail = tail.getNext();
        }

        public void addFirst(E e) {
            if (size == 0) {
                tail = new Node<>(e, null);
                tail.setNext(tail);
            } else {
                Node<E> newest = new Node<>(e, tail.getNext());
                tail.setNext(newest);
            }
            size++;
        }

        public void addLast(E e) {
            addFirst(e);
            tail = tail.getNext();
        }

        public E removeFirst() {
            if (isEmpty()) return null;
            Node<E> head = tail.getNext();
            if (head == tail) tail = null;
            else tail.setNext(head.getNext());
            size--;
            return head.getElement();
        }
    }
    public void addFirst(E e) {
        if (size == 0) {
            tail = new Node<>(e, null);
            tail.setNext(tail);
        } else {
            tail.setNext(new Node<>(e, tail.getNext()));
        }
        size++;
    }

    public int size() {
        if (tail == null) return 0;
        int size = 1;
        Node<Object> node = tail.getNext();
        while (node != tail) {
            size++;
            node = node.getNext();
        }
        return size;
    }
    public boolean equals(Object o) {
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        CircularlyLinkedList other = (CircularlyLinkedList) o;
        if (size() != other.size()) return false;
        Node walkA = tail.getNext();
        Node walkB = other.tail.getNext();
        for (int i = 0; i < size(); i++) {
            if (!walkA.getElement().equals(walkB.getElement())) return false;
            walkA = walkA.getNext();
            walkB = walkB.getNext();
        }
        return true;
    }
    public CircularlyLinkedList<E> clone() throws CloneNotSupportedException {
        CircularlyLinkedList<E> other = (CircularlyLinkedList) super.clone();
        if (size > 0) {
            other.tail = new Node<>(tail.getElement(), null);
            Node<E> walk = tail.getNext();
            Node<E> otherTail = other.tail;
            for (int i = 0; i < size - 1; i++) {
                Node<E> newest = new Node<>(walk.getElement(), null);
                otherTail.setNext(newest);
                otherTail = newest;
                walk = walk.getNext();
            }
            otherTail.setNext(other.tail);
        }
        return other;
    }
    private class E {
    }
}