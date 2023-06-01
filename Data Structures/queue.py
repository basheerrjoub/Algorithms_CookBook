class Queue:
    DEFAULT_SIZE = 10

    def __init__(self):
        """Create an Empty Queue"""
        self._size = 0
        self._front = 0
        self._items = [None] * Queue.DEFAULT_SIZE

    def enqueue(self, item):
        """Add element to the queue"""
        index = (self._front + self._size) % len(self._items)
        self._items[index] = item
        self._size += 1

    def dequeue(self):
        answer = self._items[self._front]
        self._items[self._front] = None  # For garbage collection
        self._front = (self._front + 1) % len(self._items)
        self._size -= 1

        return answer

    def __str__(self):
        return f"Queue: {self._items}"


myQ = Queue()
myQ.enqueue("B")
myQ.enqueue("A")
myQ.enqueue("S")
myQ.enqueue("H")
myQ.enqueue("E")
myQ.enqueue("E")
myQ.enqueue("R")
myQ.dequeue()
myQ.dequeue()
myQ.dequeue()
myQ.dequeue()
myQ.dequeue()
myQ.dequeue()
myQ.dequeue()
myQ.enqueue("R")
myQ.enqueue("J")
myQ.enqueue("O")
myQ.enqueue("U")
myQ.enqueue("B")

print(myQ)
