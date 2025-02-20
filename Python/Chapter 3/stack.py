class Node:
    def __init__(self, elem):
        self.elem = elem
        self.next = None


class LinkedListStack:
    def __init__(self):
        self.top = None

    def push(self, elem):
        new_node = Node(elem)
        new_node.next = self.top
        self.top = new_node

    def pop(self):
        if self.is_empty():
            raise IndexError("Stack is empty")
        popped_elem = self.top.elem
        self.top = self.top.next
        return popped_elem

    def peek(self):
        if self.is_empty():
            raise IndexError("Stack is empty")
        return self.top.elem

    def is_empty(self):
        return self.top is None

    def display_stack(self):
        current = self.top
        print("Stack (top to bottom): ", end="")
        while current:
            print(f"{current.elem} -> ", end="")
            current = current.next
        print("NULL")

class StackOperations:

    @staticmethod
    def reverse_stack(stack):
        temp_stack = LinkedListStack()
        while not stack.is_empty():
            temp_stack.push(stack.pop())
        return temp_stack

    @staticmethod
    def evaluate_postfix(expression):
        stack = LinkedListStack()

        for ch in expression:
            if ch.isdigit():
                stack.push(int(ch))
            else:
                operand2 = stack.pop()
                operand1 = stack.pop()
                if ch == '+':
                    stack.push(operand1 + operand2)
                elif ch == '-':
                    stack.push(operand1 - operand2)
                elif ch == '*':
                    stack.push(operand1 * operand2)
                elif ch == '/':
                    stack.push(operand1 // operand2)  # Integer division

        return stack.pop()

    @staticmethod
    def is_balanced_parentheses(expression):
        stack = LinkedListStack()

        for ch in expression:
            if ch in "({[":
                stack.push(ch)
            elif ch in ")}]":
                if stack.is_empty():
                    return False
                top = stack.pop()
                if (ch == ')' and top != '(') or (ch == '}' and top != '{') or (ch == ']' and top != '['):
                    return False

        return stack.is_empty()

if __name__ == "__main__":
    # Testing Reverse Stack
    stack = LinkedListStack()
    stack.push(10)
    stack.push(20)
    stack.push(30)
    print("Original Stack:")
    stack.display_stack()

    stack = StackOperations.reverse_stack(stack)
    print("Reversed Stack:")
    stack.display_stack()

    # Testing Postfix Expression Evaluation
    postfix_expression = "53+82-*"  # (5 + 3) * (8 - 2) = 48
    result = StackOperations.evaluate_postfix(postfix_expression)
    print("Postfix Evaluation Result:", result)

    # Testing Parentheses Matching
    expr1 = "{[()]}"  # Balanced
    expr2 = "{[(])}"  # Not Balanced
    print("Is Balanced:", StackOperations.is_balanced_parentheses(expr1))  # True
    print("Is Balanced:", StackOperations.is_balanced_parentheses(expr2))  # False
