package coursework;

import java.util.Arrays;

class StaticDeque {
    private final int maxLen;
    private Object[] deque;
    private int head;
    private int tail;

    public StaticDeque(int max_len) {
        this.maxLen = max_len;
        this.deque = new Object[max_len];
        this.head = 0;
        this.tail = 0;
    }

    public boolean isFull() {
        return deque[tail] != null;
    }

    public boolean isEmpty() {
        for (Object el : deque) {
            if (el != null) {
                return false;
            }
        }
        return true;
    }

    public String appendLeft(Object x) {
        if (isFull()) {
            return "Full deque, cannot append " + x + " left";
        } else {
            deque[tail] = x;
            tail = (tail + 1) % maxLen;
            return "Element " + x + " added at position " + tail;
        }
    }

    public String append(Object x) {
        if (isFull()) {
            return "Full deque, cannot append " + x;
        } else {
            head = (head - 1 + maxLen) % maxLen;
            deque[head] = x;
            return "Element " + x + " added at position " + head;
        }
    }

    public String clear() {
        if (!Arrays.equals(deque, new Object[maxLen])) {
            head = 0;
            tail = 0;
            deque = new Object[maxLen];
            return "Deque cleared";
        } else {
            return "Deque is already cleared";
        }
    }

    public StaticDeque copy() {
        StaticDeque new_deque = new StaticDeque(maxLen);
        new_deque.deque = Arrays.copyOf(deque, maxLen);
        new_deque.head = head;
        new_deque.tail = tail;
        return new_deque;
    }

    public int count(Object x) {
        int count = 0;
        for (Object el : deque) {
            if (el != null && el.equals(x)) {
                count++;
            }
        }
        return count;
    }

    public void insert(int i, Object x) {
        if (!(0 <= i && i < maxLen)) {
            System.out.println("Index out of range");
        } else if (deque[i] == null) {
            deque[i] = x;
        } else {
            System.out.println("There's already value (" + deque[i] + ") at index " + i);
        }
    }

    public void extend(Object[] iterable) {
        if (iterable.length <= count(null)) {
            for (Object element : iterable) {
                append(element);
            }
        } else {
            throw new IllegalArgumentException("Not enough space for all elements in " + Arrays.toString(iterable));
        }
    }

    public void extendLeft(Object[] iterable) {
        if (!isFull()) {
            for (Object element : iterable) {
                appendLeft(element);
            }
        } else {
            throw new IllegalArgumentException("Not enough space for all elements in " + Arrays.toString(iterable));
        }
    }

    public void index(Object x, Integer start, Integer stop) {
        if (start == null) {
            start = 0;
        }
        if (stop == null) {
            stop = maxLen - 1;
        }
        if (start < 0 || stop >= maxLen) {
            throw new IllegalArgumentException("Invalid indices");
        } else {
            for (int i = start; i <= stop; i++) {
                if (deque[i] != null && deque[i].equals(x)) {
                    System.out.println("Value " + x + " found at index " + i);
                    return;
                }
            }
            System.out.println(x + " not found between indices " + start + " and " + stop);
        }
    }

    public Object popLeft() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Deque is empty");
        }
        tail = 0;
        while (deque[tail] == null) {
            tail = (tail + 1) % maxLen;
        }
        Object popped_element = deque[tail];
        deque[tail] = null;
        tail = (tail + 1) % maxLen;
        return "Removed element: "+ popped_element;
    }

    public Object pop() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Deque is empty");
        }
        head = (head - 1 + maxLen) % maxLen;
        while (deque[head] == null) {
            head = (head - 1 + maxLen) % maxLen;
        }
        Object popped_element = deque[head];
        deque[head] = null;
        head = (head - 1 + maxLen) % maxLen;
        return "Popped " + popped_element;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Object x : deque) {
            sb.append((x != null ? x : "null")).append(" ");
        }
        return "Deque: " + sb.toString().trim();
    }
}


