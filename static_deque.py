class StaticDeque:

    def __init__(self, max_len: int):
        self.max_len = max_len
        self.deque = [None] * self.max_len
        self.head = 0
        self.tail = 0

    def is_full(self) -> bool:
        return self.deque[self.tail] is not None

    def is_empty(self) -> bool:
        for el in self.deque:
            if el is not None:
                return False
        else:
            return True

    def appendleft(self, x) -> str:
        if self.is_full():
            print(f"Full deque, cannot append {x} left")
        else:
            self.deque[self.tail] = x
            self.tail = (self.tail + 1) % self.max_len
            return f"Element {x} added at position {self.tail}"

    def append(self, x) -> str:
        if self.is_full():
            print(f"Full deque, cannot append {x}")
        else:
            self.head = (self.head - 1) % self.max_len
            self.deque[self.head] = x
            return f"Element {x} added at position {self.head}"

    def clear(self) -> str:
        if self.deque != [None] * self.max_len:
            self.head = 0
            self.tail = 0
            self.deque = [None] * self.max_len
            return "Deque cleared"
        else:
            return "Deque is already cleared"

    def copy(self):
        new_deque = StaticDeque(self.max_len)
        new_deque.deque = self.deque.copy()
        new_deque.head = self.head
        new_deque.tail = self.tail
        return new_deque

    def count(self, x):
        return f"Item {x} is found {self.deque.count(x)} time(s)"

    def insert(self, i: int, x):
        if not (0 <= i < self.max_len):
            print("Index out of range")
        elif self.deque[i] is None:
            self.deque[i] = x
        else:
            print(f"There's already value ({self.deque[i]}) at index {i}")

    def extend(self, iterable):
        if len(iterable) <= len([element for element in self.deque if element is None]):
            for element in iterable:
                self.append(element)
        else:
            raise ValueError(f"Not enough space for all elements in {iterable}")

    def extendleft(self, iterable):
        if len(iterable) <= (self.tail - self.head - 1) % self.max_len:
            for element in iterable:
                self.appendleft(element)
        else:
            raise ValueError(f"Not enough space for all elements in {iterable}")

    def index(self, x, start=None, stop=None):
        if start is None:
            start = 0
        if stop is None:
            stop = self.max_len - 1
        if start < 0 or stop >= self.max_len:
            raise ValueError("Invalid indices")
        else:
            for i in range(start, stop + 1):
                if self.deque[i] == x:
                    print(f"Value {x} found at index {i}")
                    break
            else:
                print(f"{x} not found between indices {start} and {stop} ")

    def popleft(self):
        if self.is_empty():
            raise ValueError("Deque is empty")

        self.tail = 0

        while self.deque[self.tail] is None:
            self.tail = (self.tail + 1) % self.max_len

        popped_element = self.deque[self.tail]
        self.deque[self.tail] = None
        self.tail = (self.tail + 1) % self.max_len

        return popped_element

    def pop(self):
        if self.is_empty():
            raise ValueError("Deque is empty")

        self.head = self.max_len - 1

        while self.deque[self.head] is None:
            self.head = (self.head - 1) % self.max_len

        popped_element = self.deque[self.head]
        self.deque[self.head] = None
        self.head = (self.head - 1) % self.max_len

        return popped_element

    def __str__(self):
        if self.deque:
            return " ".join(str(x) for x in self.deque)


static_deque = StaticDeque(5)

print(static_deque.pop())

print(static_deque)
