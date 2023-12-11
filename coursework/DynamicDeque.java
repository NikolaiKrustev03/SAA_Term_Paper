package coursework;

import javax.print.attribute.standard.JobKOctets;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

class DynamicDeque {
    private List<Object> deque;

    public DynamicDeque() {
        deque = new ArrayList<>();
    }

    public boolean isEmpty() {
        return deque.isEmpty();
    }

    public Object appendLeft(Object x) {
        deque.add(0, x);
        return "Added " + x + " at the start";
    }

    public Object append(Object x) {
        deque.add(x);
        return "Added " + x + " at the end";
    }

    public Object clear() {
        if (!deque.isEmpty()) {
            deque.clear();
            return "Deque cleared";
        } else {
            throw new IllegalStateException("Deque already cleared");
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

    public Object insert(int i, Object x) {
        if(0 <= i && i <= deque.size()) {
            deque.add(i, x);
            return "Element "+ x + " added at position " + i;
        }
        else {
            if(i > deque.size()){
                append(x);
                return "Index higher than deque size, adding element to the end";
            }

        }
        throw new IndexOutOfBoundsException("Illegal index");
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
            throw new NoSuchElementException("Cannot pop from empty deque");
        }
    }

    public Object popLeft() {
        if (!isEmpty()) {
            Object removedElement = deque.remove(0);
            return "Removed element at position 0: " + removedElement;
        } else {
            throw new NoSuchElementException("Cannot pop from empty deque");
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Object x : deque) {
            sb.append(x).append(" ");
        }
        if (!deque.isEmpty()) {
            return "Deque: " + sb.toString();
        }
        return "Deque: [empty]";
    }
}