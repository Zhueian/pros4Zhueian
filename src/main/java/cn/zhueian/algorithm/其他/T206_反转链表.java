package cn.zhueian.algorithm.其他;

/**
 * Created by qiucy on 2019/12/5.
 * 反转一个单链表。

 示例:

 输入: 1->2->3->4->5->NULL
 输出: 5->4->3->2->1->NULL


 进阶:
 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class T206_反转链表 {
    private ListNode res;
    //尼玛方法栈压爆了
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        m(head);
        return res;
    }
    //输入：1->2->null
    //输出：2->1->null
    private void m(ListNode node) {
        if (node.next == null) {
            res = node;
            return;
        }
        ListNode next = node.next;
        m(next);
        next.next = node;
    }

    //递归内存超了.用循环嫩吧
    public ListNode reverseList2(ListNode head) {
        ListNode newHead = null;
        while (head!=null){
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
//            newHead = head;
        }
        return newHead;
    }

    public static void main(String[] args) {
        T206_反转链表 t = new T206_反转链表();
        ListNode l = new ListNode(1);
        ListNode l2 = l.next = new ListNode(2);
        ListNode l3 = l2.next = new ListNode(3);
        ListNode l4 = l3.next = new ListNode(4);
        System.out.println(l.val);
        System.out.println(l.next.val);
        System.out.println(l.next.next.val);
        System.out.println(l.next.next.next.val);
        System.out.println("=========");
        t.reverseList(l);
        System.out.println(t.res.val);
        System.out.println(t.res.next.val);
        System.out.println(t.res.next.next.val);
        System.out.println(t.res.next.next.next.val);
    }

}
 class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
