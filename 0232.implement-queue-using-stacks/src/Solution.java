import java.awt.*;
import java.util.Stack;

class MyQueue {
    Stack<Integer> stack;
    Stack<Integer> auxiliary;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        stack = new Stack<>();
        auxiliary = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(x);
        } else {
            int temp;
            while (!stack.isEmpty()) {
                temp = stack.pop();
                auxiliary.push(temp);
            }
            stack.push(x);
            while (!auxiliary.isEmpty()) {
                temp = auxiliary.pop();
                stack.push(temp);
            }
        }
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        return stack.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        return stack.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
class MyQueue2 {
    Stack<Integer> stack;
    Stack<Integer> auxiliary;
    Integer front;

    /**
     * Initialize your data structure here.
     */
    public MyQueue2() {
        stack = new Stack<>();
        auxiliary = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        if (stack.isEmpty()) {
            front = x;
        }
        stack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (auxiliary.isEmpty()) {
            int temp;
            while (stack.isEmpty()) {
                temp = stack.pop();
                auxiliary.push(temp);
            }
        }
        return auxiliary.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (stack.isEmpty()) {
            return auxiliary.peek();
        } else {
            return front;
        }
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack.isEmpty() && auxiliary.isEmpty();
    }
}