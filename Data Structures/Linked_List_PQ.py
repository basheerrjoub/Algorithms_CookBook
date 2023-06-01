class Node:
    def __init__(self, item, priority):
        self.item = item
        self.priority = priority
        self.next = None


class PriorityQueue:
    def __init__(self):
        self.head = None

    def is_empty(self):
        return self.head is None

    def insert(self, item, priority):
        new_node = Node(item, priority)

        if self.is_empty():
            self.head = new_node
        elif priority > self.head.priority:
            new_node.next = self.head
            self.head = new_node
        else:
            current = self.head
            while current.next is not None and current.next.priority > priority:
                current = current.next

            new_node.next = current.next
            current.next = new_node

    def remove(self):
        if self.is_empty():
            raise Exception("Priority Queue is empty!")
        else:
            removed = self.head
            self.head = self.head.next
            return removed.item, removed.priority

    def __repr__(self):
        items = []
        current = self.head
        while current is not None:
            items.append((current.item, current.priority))
            current = current.next
        return str(items)


# Demonstration
if __name__ == "__main__":
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
