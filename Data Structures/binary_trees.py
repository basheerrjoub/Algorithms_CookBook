class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None

    def print_tree(self, node):
        if node is None:
            return
        print(node)
        self.print_tree(node.left)
        self.print_tree(node.right)

    def depth(self):
        if self is None:
            return 0
        left_depth = self.left.depth() if self.left is not None else 0
        right_depth = self.right.depth() if self.right is not None else 0
        return max(left_depth, right_depth) + 1

    def is_full_binary_tree(self):
        if (self.left is None and self.right is not None) or (
            self.left is not None and self.right is None
        ):
            return False
        if self.right is None and self.left is None:
            return True

        lefisfull = self.left.is_full_binary_tree()
        rigisfull = self.right.is_full_binary_tree()

        return lefisfull and rigisfull

    def is_perfect(self, level=0, depth=None):
        if self is None:
            return True

        # Check if the node is leaf Node
        if self.left is None and self.right is None:
            return level + 1 == depth
        if self.left is None or self.right is None:
            return False

        return self.left.is_perfect(level + 1, depth) and self.right.is_perfect(
            level + 1, depth
        )

    def __str__(self):
        return f"Node: {self.data}"


def depth(root):
    if root is None:
        return 0
    left_depth = root.left.depth() if root.left is not None else 0
    right_depth = root.right.depth() if root.right is not None else 0
    return max(left_depth, right_depth) + 1


# Check if the tree is balanced
def is_balanced(root):
    if root is None:
        return True
    left_depth = root.left.depth() if root.left is not None else 0
    right_depth = root.right.depth() if root.right is not None else 0
    if abs(left_depth - right_depth) > 1:
        return False

    return is_balanced(root.left) and is_balanced(root.right)


# Get Number of nodes under a specefic node
def number_of_nodes(root):
    if root is None:
        return 0
    return 1 + number_of_nodes(root.left) + number_of_nodes(root.right)


node1 = Node(1)
node2 = Node(2)
node3 = Node(3)
node4 = Node(4)
node5 = Node(5)
node6 = Node(6)
node7 = Node(7)

node1.left = node2
node1.right = node3
node2.left = node4
node2.right = node5
node3.left = node6
node3.right = node7
m1 = Node(12)
m2 = Node(14)
node7.left = m1
m1.left = m2
print(is_balanced(node1))
