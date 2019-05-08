package cn.zhueian.leetcode.leetcode.conti;

/**
 * @Auther: qiucy
 * @Date: 2018-12-27 19:26
 * @Description:给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class L2_AddTwoNumbers {

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
            next = null;
        }
    }
    public ListNode at(ListNode l1,ListNode l2){
        ListNode ret = new ListNode(0);
        ListNode cur = ret;

        int sum = 0;
        while(true){
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            cur.val = sum%10;
            sum /= 10;
            if(l1 != null || l2 != null || sum != 0){
                cur = (cur.next = new ListNode(0));
            }else{
                break;
            }
        }
        return ret;
    }
}

