class PriorityQueue:
    def __init__(self):
        self.queue = []

    def is_empty(self):
        return len(self.queue) == 0

    def insert(self, item, priority):
        self.queue.append((item, priority))
        self.queue.sort(key=lambda x: x[1], reverse=True)

    def remove(self):
        if not self.is_empty():
            return self.queue.pop()
        else:
            raise Exception("Priority Queue is empty!")

    def __repr__(self):
        return str(self.queue)


pq = PriorityQueue()
print("Inserting items into the priority queue")
pq.insert("Task 1", 3)
pq.insert("Task 2", 1)
pq.insert("Task 3", 2)
pq.insert("Task 4", 5)
pq.insert("Task 5", 4)
print(pq)

print("Removing items from the priority queue")
while not pq.is_empty():
    task, priority = pq.remove()
    print(f"Task: {task}, Priority: {priority}")
