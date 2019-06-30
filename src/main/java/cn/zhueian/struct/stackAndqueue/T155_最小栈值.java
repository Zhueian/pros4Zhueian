package cn.zhueian.struct.stackAndqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Auther: qiucy
 * @Date: 2019-06-30 16:30
 * @Description:
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 */
public class T155_最小栈值 {
    private List<Integer> l = new ArrayList<>();
    private volatile int i = 0;
    public T155_最小栈值() {
    }

    public void push(int x) {
        l.add(x);
        i = getI();
    }

    public void pop() {
        l.remove(l.size()-1);
        i = getI();
    }

    public int top() {
       return l.get(l.size()-1);
    }

    public int getMin() {
        return l.get(i);
    }
    private int getI(){
        if (l.size() <= 0) return i;
        int i = 0;
        int min = l.get(0);
        for (int j = 1; j < l.size(); j++) {
            if (l.get(j)<min) {
                min = l.get(j);
                i = j;
            }
        }
        return i;
    }
}
