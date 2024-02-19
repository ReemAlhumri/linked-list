import java.util.Scanner;

public class STACK {
    private STACK data;

    public interface Stack<E> {
        int size();
        boolean isEmpty();
        void push(E e);
        E top();
        E pop();
    }
    public class ArrayStack<E> implements Stack<E> {
        public static final int CAPACITY = 1000;
        private E[] data;
        private int t = -1;

        public ArrayStack() { this(CAPACITY); }

        public ArrayStack(int capacity) {
            data = (E[]) new Object[capacity];
        }

        public int size() { return (t + 1); }

        public boolean isEmpty() { return (t == -1); }

        public void push(E e) throws IllegalStateException {
            if (size() == data.length) throw new IllegalStateException("Stack is full");
            data[++t] = e;
        }

        public E top() {
            if (isEmpty()) return null;
            return data[t];
        }

        public E pop() {
            if (isEmpty()) return null;
            E answer = data[t];
            data[t] = null;
            t--;
            return answer;
        }
    }
    public class LinkedStack<E> implements Stack<E> {
        private SinglyLinkedList<E> list = new SinglyLinkedList<>();

        public LinkedStack() { }

        public int size() { return list.size(); }

        public boolean isEmpty() { return list.isEmpty(); }

        public void push(E element) { list.addFirst(element); }

        public E top() { return list.first(); }

        public E pop() { return list.removeFirst(); }

        private class SinglyLinkedList<E> {
            public int size() {
                return 0;
            }

            public boolean isEmpty() {
                return false;
            }

            public void addFirst(E element) {

            }

            public E first() {
                return null;
            }

            public E removeFirst() {
                return null;
            }
        }
    }
    public void transfer(Stack<E> S, Stack<E> T) {
        while (!S.isEmpty()) {
            T.push(S.pop());
        }
    }
    public void removeAll(Stack<E> S) {
        if (!S.isEmpty()) {
            S.pop();
            removeAll(S);
        }
    }
    public int evaluatePostfix(String postfix) {
        Stack<Integer> stack = new ArrayStack<>();
        String[] tokens = postfix.split(" ");
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(num1 + num2);
                        break;
                    case "-":
                        stack.push(num1 - num2);
                        break;
                    case "*":
                        stack.push(num1 * num2);
                        break;
                    case "/":
                        stack.push(num1 / num2);
                        break;
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
    public E[] clone() throws CloneNotSupportedException {
        ArrayStack<E> other = (ArrayStack) super.clone();
        other.data = data.clone();
        return new E[0];
    }

    public class PostfixEvaluator {
        public void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a postfix expression:");
            String postfix = scanner.nextLine();
            ArrayStack<Integer> stack = new ArrayStack<>();
            String[] tokens = postfix.split(" ");
            for (String token : tokens) {
                if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                    int num2 = stack.pop();
                    int num1 = stack.pop();
                    switch (token) {
                        case "+":
                            stack.push(num1 + num2);
                            break;
                        case "-":
                            stack.push(num1 - num2);
                            break;
                        case "*":
                            stack.push(num1 * num2);
                            break;
                        case "/":
                            stack.push(num1 / num2);
                            break;
                    }
                } else {
                    stack.push(Integer.parseInt(token));
                }
            }
            System.out.println("The value of the postfix expression is: " + stack.pop());
        }
    }

}