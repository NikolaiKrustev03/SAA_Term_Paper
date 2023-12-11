package coursework;

public class StaticDequeTest {
    public static void main(String[] args) {
        testDequeOperations();
    }

    private static void testDequeOperations() {
        StaticDeque deque = new StaticDeque(5);

        System.out.println("Deque Operations:");

        // Append
        System.out.println(deque.appendLeft("A"));
        System.out.println(deque.append("B"));
        System.out.println(deque.appendLeft("C"));
        System.out.println(deque.append("D"));
        System.out.println(deque.popLeft());
        System.out.println(deque.popLeft());
        // Print deque
        System.out.println(deque);

        // Pop
        System.out.println(deque.popLeft());
        System.out.println(deque.pop());

        // Print deque
        System.out.println(deque);

        // Extend
        System.out.println(deque.extend(new Object[]{12, 14, 16}));

        // Print deque
        System.out.println(deque);

        // Clear
        System.out.println(deque.clear());

        // Print deque
        System.out.println(deque);
    }
}

