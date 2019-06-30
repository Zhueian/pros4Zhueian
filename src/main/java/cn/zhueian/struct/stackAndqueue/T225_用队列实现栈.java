package cn.zhueian.struct.stackAndqueue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Auther: qiucy
 * @Date: 2019-06-30 15:43
 * @Description:描述
 * 使用队列实现栈的下列操作：
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 * 注意:
 * 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
 * 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 * 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
 */
public class T225_用队列实现栈 {
    private List<Integer> queue;
    /** Initialize your data structure here. */
    public T225_用队列实现栈() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.remove(queue.size()-1);
    }

    /** Get the top element. */
    public int top() {
       return queue.get(queue.size()-1);
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.size()==0;
    }
}
