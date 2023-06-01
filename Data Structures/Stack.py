class Stack:
    def __init__(self):
        self._stack = []

    def push(self, item):
        self._stack.append(item)

    def pop(self):
        if len(self._stack) == 0:
            print("Empty Stack")
            return
        return self._stack.pop()

    def peak(self):
        return self._stack[-1]

    def __str__(self):
        return f"{self._stack}"


myStack = Stack()

myStack.push("B")
myStack.push("A")
myStack.push("S")
myStack.push("H")
myStack.push("E")
myStack.push("E")
myStack.push("R")
str = ""
str += myStack.pop()
str += myStack.pop()
str += myStack.pop()
str += myStack.pop()
str += myStack.pop()
str += myStack.pop()
str += myStack.pop()
str += myStack.pop()

print(str)
