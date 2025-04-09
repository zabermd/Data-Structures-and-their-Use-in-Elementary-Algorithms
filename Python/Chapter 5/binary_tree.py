class TreeNode:
    def __init__(self, elem):
        self.elem = elem
        self.left = None
        self.right = None

class BinaryTree:
    def __init__(self):
        self.root = None

    # 1. Create a binary tree from array (ignoring index 0)
    def create_tree_from_array(self, arr, i):
        if i >= len(arr):
            return None
        node = TreeNode(arr[i])
        node.left = self.create_tree_from_array(arr, 2 * i)
        node.right = self.create_tree_from_array(arr, 2 * i + 1)
        return node

    # 2. Depth of a node
    def depth(self, node, key, d):
        if node is None:
            return -1
        if node.elem == key:
            return d
        left = self.depth(node.left, key, d + 1)
        if left != -1:
            return left
        return self.depth(node.right, key, d + 1)

    # 3. Height of a node
    def height(self, node):
        if node is None:
            return -1
        left = self.height(node.left)
        right = self.height(node.right)
        return max(left, right) + 1

    # 4. Number of nodes
    def count_nodes(self, node):
        if node is None:
            return 0
        return 1 + self.count_nodes(node.left) + self.count_nodes(node.right)

    # 5. Full binary tree check
    def is_full(self, node):
        if node is None:
            return True
        if (node.left is None and node.right is not None) or (node.left is not None and node.right is None):
            return False
        return self.is_full(node.left) and self.is_full(node.right)

    # 6. Complete binary tree check
    def is_complete(self, node, index, total_nodes):
        if node is None:
            return True
        if index > total_nodes:
            return False
        return (self.is_complete(node.left, 2 * index, total_nodes) and
                self.is_complete(node.right, 2 * index + 1, total_nodes))

    # 7. Perfect binary tree check
    def is_perfect(self, node, depth, level):
        if node is None:
            return True
        if node.left is None and node.right is None:
            return depth == level
        if node.left is None or node.right is None:
            return False
        return (self.is_perfect(node.left, depth, level + 1) and
                self.is_perfect(node.right, depth, level + 1))

    # 8. Balanced binary tree check
    def is_balanced(self, node):
        return self.check_balance(node) != -1

    def check_balance(self, node):
        if node is None:
            return 0
        left = self.check_balance(node.left)
        right = self.check_balance(node.right)
        if left == -1 or right == -1 or abs(left - right) > 1:
            return -1
        return max(left, right) + 1

# Testing the BinaryTree class
if __name__ == "__main__":
    bt = BinaryTree()
    arr = [0, 1, 2, 3, 4, 5, 6, 7]  # index 0 is ignored
    bt.root = bt.create_tree_from_array(arr, 1)

    print("Depth of 6:", bt.depth(bt.root, 6, 0))
    print("Height of root:", bt.height(bt.root))
    print("Number of nodes:", bt.count_nodes(bt.root))
    print("Is Full:", bt.is_full(bt.root))
    total_nodes = bt.count_nodes(bt.root)
    print("Is Complete:", bt.is_complete(bt.root, 1, total_nodes))
    print("Is Perfect:", bt.is_perfect(bt.root, bt.height(bt.root), 0))
    print("Is Balanced:", bt.is_balanced(bt.root))
