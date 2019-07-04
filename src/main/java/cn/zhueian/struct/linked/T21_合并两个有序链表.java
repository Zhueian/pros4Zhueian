package cn.zhueian.struct.linked;

/**
 * @Auther: qiucy
 * @Date: 2019-06-26 16:31
 * @Description:将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class T21_合并两个有序链表 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        ListNode init1 = l1;
        ListNode inti2 = l2;
        int count = 0;
        ListNode temp = null;
        ListNode head = null;
        for(;;){
            if (l1 == null || l2 == null) break;
            ++count;
            if (l1.val>l2.val){
                if (count == 1) head = l1;
                temp = l1;
                l1 = l1.next;
            }else{
                if (count == 1) head = l2;
                temp = l2;
                l2 = l2.next;
            }
        }
        if (init1 == null && inti2 != null) return inti2;
        else if (init1 != null && inti2 == null) return init1;
        else return init1.val <= inti2.val?l2:init1;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (l1 != null && l2 != null){
            if (l1 == null) return l2;
            if (l2 == null) return l1;
            if (l1.val > l2.val){
                cur = l2;
                l2 = l2.next;
            }else {
                cur = l1;
                l1 = l1.next;
            }
        }
        return head.next;
    }

    /**
     * sum = 1
     * sum = n*(n-1)!
     * @param n
     * @return
     */
    public static int jiecheng(int n){
        if (n == 0) return 1;
        return n*jiecheng(n-1);
    }

    public static void main(String[] args) {
        System.out.println(jiecheng(10));
    }
}
