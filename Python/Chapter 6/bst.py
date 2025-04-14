class Node:
    def __init__(self, elem):
        self.elem = elem
        self.left = None
        self.right = None

class BinarySearchTree:
    def __init__(self):
        self.root = None

    # Insert element
    def insert(self, elem):
        self.root = self._insert_recursive(self.root, elem)

    def _insert_recursive(self, node, elem):
        if node is None:
            return Node(elem)
        if elem < node.elem:
            node.left = self._insert_recursive(node.left, elem)
        elif elem > node.elem:
            node.right = self._insert_recursive(node.right, elem)
        return node

    # Search for an element
    def search(self, elem):
        return self._search_recursive(self.root, elem)

    def _search_recursive(self, node, elem):
        if node is None:
            return False
        if elem == node.elem:
            return True
        elif elem < node.elem:
            return self._search_recursive(node.left, elem)
        else:
            return self._search_recursive(node.right, elem)

    # Delete using Inorder Successor
    def delete_with_successor(self, elem):
        self.root = self._delete_successor(self.root, elem)

    def _delete_successor(self, node, elem):
        if node is None:
            return None
        if elem < node.elem:
            node.left = self._delete_successor(node.left, elem)
        elif elem > node.elem:
            node.right = self._delete_successor(node.right, elem)
        else:
            if node.left is None:
                return node.right
            elif node.right is None:
                return node.left
            successor = self._find_min(node.right)
            node.elem = successor.elem
            node.right = self._delete_successor(node.right, successor.elem)
        return node

    # Delete using Inorder Predecessor
    def delete_with_predecessor(self, elem):
        self.root = self._delete_predecessor(self.root, elem)

    def _delete_predecessor(self, node, elem):
        if node is None:
            return None
        if elem < node.elem:
            node.left = self._delete_predecessor(node.left, elem)
        elif elem > node.elem:
            node.right = self._delete_predecessor(node.right, elem)
        else:
            if node.left is None:
                return node.right
            elif node.right is None:
                return node.left
            predecessor = self._find_max(node.left)
            node.elem = predecessor.elem
            node.left = self._delete_predecessor(node.left, predecessor.elem)
        return node

    def _find_min(self, node):
        while node.left:
            node = node.left
        return node

    def _find_max(self, node):
        while node.right:
            node = node.right
        return node

    # Balance the BST
    def balance(self):
        sorted_array = self._to_sorted_array()
        self.root = self._build_balanced_bst(sorted_array, 0, len(sorted_array) - 1)

    def _build_balanced_bst(self, arr, start, end):
        if start > end:
            return None
        mid = (start + end) // 2
        node = Node(arr[mid])
        node.left = self._build_balanced_bst(arr, start, mid - 1)
        node.right = self._build_balanced_bst(arr, mid + 1, end)
        return node

    def _to_sorted_array(self):
        result = []
        self._inorder_fill(self.root, result)
        return result

    def _inorder_fill(self, node, arr):
        if node is None:
            return
        self._inorder_fill(node.left, arr)
        arr.append(node.elem)
        self._inorder_fill(node.right, arr)

    # In-order print
    def print_in_order(self):
        self._print_in_order(self.root)
        print()

    def _print_in_order(self, node):
        if node is None:
            return
        self._print_in_order(node.left)
        print(node.elem, end=' ')
        self._print_in_order(node.right)

# Example Usage
if __name__ == "__main__":
    bst = BinarySearchTree()
    values = [30, 10, 50, 5, 20, 40, 60, 1]

    for v in values:
        bst.insert(v)

    print("In-order before deletion:")
    bst.print_in_order()

    print("Search 20:", bst.search(20))
    print("Search 100:", bst.search(100))

    bst.delete_with_successor(30)
    print("In-order after deleting 30 using successor:")
    bst.print_in_order()

    bst.insert(30)
    bst.delete_with_predecessor(50)
    print("In-order after deleting 50 using predecessor:")
    bst.print_in_order()

    bst.balance()
    print("In-order after balancing:")
    bst.print_in_order()
