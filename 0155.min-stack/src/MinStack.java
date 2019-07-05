import jdk.nashorn.internal.ir.ReturnNode;

import java.util.Stack;

//栈顶元素 = 真实值 - 上一个最小的元素
//上一个最小的元素 = 真实值 -栈顶元素
//真实值 = min
class MinStack {
    private long min;
    private Stack<Long> stack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        min = Long.MAX_VALUE;
        stack = new Stack<>();
    }

    public void push(int x) {
        long value = (long) x - this.min;
        this.stack.push(value);
        this.min = Math.min(x, this.min);
    }

    public void pop() {
        long difference = this.stack.pop();
        if (difference < 0) {
            this.min = this.min - difference;
        }

    }

    public int top() {
        long difference = this.stack.peek();
        if (difference < 0) {
            return (int) this.min;
        } else {
            return (int) (this.min + difference);
        }
    }

    public int getMin() {
        return (int) this.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

//栈顶元素 = 真实值 - 上一个最小的元素
//上一个最小的元素 = 真实值 -栈顶元素
//真实值 = min
class MinStack2 {
    private Stack<Integer> value = new Stack<>();
    private Stack<Integer> minValue = new Stack<>();

    /**
     * initialize your data structure here.
     */
    public MinStack2() {

    }

    public void push(int x) {
        value.push(x);
        if (minValue.isEmpty()) {
            minValue.push(x);
        } else {
            minValue.push(Math.min(minValue.peek(), x));
        }
    }

    public void pop() {
        value.pop();
        minValue.pop();
    }

    public int top() {
        return value.peek();
    }

    public int getMin() {
        return minValue.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
class MinStack3 {
    private Stack<Integer> value = new Stack<>();
    private int minValue = Integer.MAX_VALUE;

    /**
     * initialize your data structure here.
     */
    public MinStack3() {

    }

    public void push(int x) {
        if (minValue >= x) {
            value.push(minValue);
            minValue = x;
        }
        value.push(x);
    }

    public void pop() {
        if (value.pop() == minValue) {
            minValue = value.pop();
        }
    }

    public int top() {
        return value.peek();
    }

    public int getMin() {
        return minValue;
    }
}
