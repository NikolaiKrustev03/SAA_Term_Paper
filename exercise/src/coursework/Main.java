package coursework;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StaticDeque deque1 = new StaticDeque(5);
        deque1.append(1);
        deque1.append(2);
        deque1.appendLeft(0);
        System.out.println("Deque 1: " + deque1);
        System.out.println(deque1.pop());
        System.out.println(deque1);
        deque1.insert(2, 4);
        System.out.println(deque1);
    }
}
