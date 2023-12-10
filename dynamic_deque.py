class DynamicDeque:

    def __init__(self):
        self.deque = []

    def is_empty(self):
        return not bool(self.deque)

    def appendleft(self, x):
        self.deque.insert(0, x)

    def append(self, x):
        self.deque.append(x)

    def clear(self):
        if self.deque:
            self.deque = []
            return "Deque cleared"
        else:
            return "Deque already cleared"
    def copy(self):
        new_deque = DynamicDeque()
        new_deque.deque = self.deque.copy()
        return new_deque

    def count(self, x):
        return f"Item {x} is found {self.deque.count(x)} times"

    def insert(self, i, x):
        self.deque.insert(i, x)

    def extend(self, iterable):
        for element in iterable:
            self.append(element)

    def extendleft(self, iterable):
        for element in iterable:
            self.appendleft(element)


    def pop(self):
        if not self.is_empty():
            return self.deque.pop()
        else:
            raise ValueError("Cannot pop from empty deque")

    def popleft(self):
        if not self.is_empty():
            return self.deque.pop(0)
        else:
            raise ValueError("Cannot pop from empty deque")

    def __str__(self):
        return " ".join(str(x) for x in self.deque)
