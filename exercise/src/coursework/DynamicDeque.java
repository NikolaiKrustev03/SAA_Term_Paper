package coursework;

import java.util.ArrayList;
import java.util.List;

class DynamicDeque {
    private List<Object> deque;

    public DynamicDeque() {
        deque = new ArrayList<>();
    }

    public boolean isEmpty() {
        return deque.isEmpty();
    }

    public void appendLeft(Object x) {
        deque.add(0, x);
    }

    public void append(Object x) {
        deque.add(x);
    }

    public void clear() {
        if (!deque.isEmpty()) {
            deque.clear();
            System.out.println("Deque cleared");
        } else {
            System.out.println("Deque already cleared");
        }
    }

    public DynamicDeque copy() {
        DynamicDeque newDeque = new DynamicDeque();
        newDeque.deque.addAll(deque);
        return newDeque;
    }

    public int count(Object x) {
        int count = 0;
        for (Object element : deque) {
            if (element.equals(x)) {
                count++;
            }
        }
        return count;
    }

    public void insert(int i, Object x) {
        if(0 <= i && i <= deque.size()) {
            deque.add(i, x);
        }
        else {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }

    public void extend(Iterable<?> iterable) {
        for (Object element : iterable) {
            append(element);
        }
    }

    public void extendLeft(Iterable<?> iterable) {
        for (Object element : iterable) {
            appendLeft(element);
        }
    }

    public Object pop() {
        if (!isEmpty()) {
            Object removedElement = deque.remove(deque.size() - 1);
            return "Removed element at position " + deque.size() +": " + removedElement;
        } else {
            throw new IllegalArgumentException("Cannot pop from empty deque");
        }
    }

    public Object popLeft() {
        if (!isEmpty()) {
            Object removedElement = deque.remove(0);
            return "Removed element at position 0: " + removedElement;
        } else {
            throw new IllegalArgumentException("Cannot pop from empty deque");
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Object x : deque) {
            sb.append(x).append(" ");
        }
        return "Deque: " + sb.toString();
    }
}