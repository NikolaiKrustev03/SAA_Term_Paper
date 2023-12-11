package coursework;

import java.util.List;

public class DynamicDequeTest {
    public static void main(String[] args) {
        testDynamicDequeOperations();
    }

    private static void testDynamicDequeOperations() {
        DynamicDeque dynamicDeque = new DynamicDeque();

        System.out.println("DynamicDeque Operations:");

        // Append
        System.out.println(dynamicDeque.appendLeft(1));
        System.out.println(dynamicDeque.append(4));
        System.out.println(dynamicDeque.appendLeft(5));
        System.out.println(dynamicDeque.append(8));

        // Print deque
        System.out.println(dynamicDeque);

        // Pop
        System.out.println(dynamicDeque.popLeft());
        System.out.println(dynamicDeque.pop());

        // Print deque
        System.out.println(dynamicDeque);

        // Extend
        List<Object> listToExtend = List.of(3, 4 ,5);
        dynamicDeque.extend(listToExtend);

        // Print deque
        System.out.println(dynamicDeque);

        // Add more test cases as needed

        // Clear
        System.out.println(dynamicDeque.clear());

        // Print the final state of the deque
        System.out.println(dynamicDeque);
    }
}
