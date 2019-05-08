package cn.zhueian.leetcode.leetcode.ac;

import java.util.HashSet;

/**
 * @Auther: qiucy
 * @Date: 2019-03-12 23:53
 * @Description:
 */
class T41_环形链表Solution {

    public static void main(String[] args) {

    }

    public boolean hasCycle(T41_环形链表ListNode head) {

        return false;
    }
    /**
     * best
     */
    public boolean hasCycle2(T41_环形链表ListNode head) {
        if (head == null) return false;
        T41_环形链表ListNode rabit = head;
        T41_环形链表ListNode turtle = head;
        while(rabit.next != null && rabit.next.next != null){
            rabit = rabit.next.next;
            turtle = turtle.next;
            if(rabit == turtle) return true;
        }
        return false;
    }

    public boolean hasCycle3(T41_环形链表ListNode head) {
        if(head == null) return false;
        HashSet<T41_环形链表ListNode> ttt = new HashSet<>();
        ttt.add(head);
        while(head.next != null){
            head = head.next;
            if (ttt.contains(head)) return true;
            else ttt.add(head);

        }
        return false;
    }

    /**
     * 太叼了
     * @param head
     * @return
     */
    public boolean hasCycle4(T41_环形链表ListNode head) {
        for(T41_环形链表ListNode i = head;i != null;i = i.next){
            if(i.val == Integer.MAX_VALUE){
                return true;
            }else{
                i.val = Integer.MAX_VALUE;
            }
        }
        return false;
    }
    /**
     * best2
     */
//    public boolean hasCycle2(ListNode head) {
//        ListNode p = head,pre = head;
//        while(p != null && p.next != null){
//            if (p.next == head) return true;
//            p = p.next;
//            pre.next = head;
//            pre = p;
//        }
//        return false;
//    }
}
class T41_环形链表ListNode{
    int val;
    T41_环形链表ListNode next;
    T41_环形链表ListNode(int x) {
          val = x;
          next = null;
    }
    /**
     * 给定一个链表，判断链表中是否有环。
     *
     * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
     *
     *
     *
     * 示例 1：
     *
     * 输入：head = [3,2,0,-4], pos = 1
     * 输出：true
     * 解释：链表中有一个环，其尾部连接到第二个节点。
     *
     *
     * 示例 2：
     *
     * 输入：head = [1,2], pos = 0
     * 输出：true
     * 解释：链表中有一个环，其尾部连接到第一个节点。
     */
}

