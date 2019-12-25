package cn.zhueian.algorithm.搜索.深搜;

import javax.validation.constraints.Null;

/**
 * Created by qiucy on 2019/12/12.
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

 示例：

 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 输出：7 -> 0 -> 8
 原因：342 + 465 = 807
 */
public class T2_两数相加 {
    //数字怎么都超了
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1.next == null && l1.val == 0 ) return l2;
        if (l1.next == null && l2.val == 0 ) return l1;
        StringBuilder sbd1 = new StringBuilder();
        StringBuilder sbd2 = new StringBuilder();
        dfs2Num(l1,sbd1);
        dfs2Num(l2,sbd2);
        System.out.println(Long.parseLong(sbd1.toString()));
        System.out.println(Long.parseLong(sbd2.toString()));
        Long sum = Long.parseLong(sbd1.toString())+Long.parseLong(sbd2.toString());
        System.out.println(sum);
        Long a = sum%10;
        ListNode head  = new ListNode(Integer.parseInt(a+""));
        dfs2Node(sum/10,head);
        return head;
    }
    public ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
			else if (l1 == null) return l2;
        else if (l2 == null) return l1;

        int a = l1.val + l2.val;
        ListNode p = new ListNode(a % 10);
        p.next = addTwoNumbers(l1.next,l2.next);
        if (a >= 10) p.next = addTwoNumbers(p.next, new ListNode(1));
        return p;
    }

    private void dfs2Node(Long num,ListNode node) {
        if (num!=0){
            Long a = num%10;
            ListNode next = node.next = new ListNode(Integer.parseInt(a+""));
            num/=10;
            dfs2Node(num,next);
        }else
            node = null;
    }

    private void dfs2Num(ListNode node, StringBuilder sbd) {
        if (node!=null) {
            dfs2Num(node.next,sbd);
            sbd.append(node.val);

        }
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
   }

    public static void main(String[] args) {
        T2_两数相加 t = new T2_两数相加();
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1.next != null && l1.val == 0 ) return l2;
        if (l2.next != null && l2.val == 0 ) return l1;
        ListNode head = new ListNode(0);
        looper4Com(l1,l2,head);
        return head.next;
    }

    private void looper4Com(ListNode l1, ListNode l2,ListNode head) {
        ListNode t = head;
        int overIn = 0;
        while (l1 != null && l2 != null){
            int val1 = l1.val;
            int val2 = l2.val;
            int sum = val1+val2+overIn;
            int red = sum%10;
            overIn/=10;
            t = t.next;
            t = new ListNode(red);
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 == null){
            while (l2!=null){
                int val2 = l2.val;
                int sum = overIn+val2;
                int red = sum%10;
                overIn/=10;
                t = new ListNode(red);
                t = t.next;
                l2 = l2.next;
            }

        }else if(l2 == null){
            while (l1!=null){
                int val1 = l1.val;
                int sum = overIn+val1;
                int red = sum%10;
                overIn/=10;
                t = new ListNode(red);
                t = t.next;
                l1 = l1.next;
            }
        }
        if (overIn != 0){
            t = new ListNode(overIn);
        }
    }

    /**
     *
     输入：(2 -> 4 -> 3) +
          (5 -> 6 -> 4)
     输出：7 -> 0 -> 8
     原因：342 + 465 = 807
     * @param node
     * @return
     */
    public ListNode reverList(ListNode node){
        ListNode newHead = null;
        while (node!=null){
            ListNode next = node.next;
            node.next = newHead;
            newHead = node;
            node = next;
//            newHead = head;
        }
        return newHead;
    }

}
