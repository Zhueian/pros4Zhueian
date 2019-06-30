package cn.zhueian.struct.linked;

import java.util.HashSet;

/**
 * @Auther: qiucy
 * @Date: 2019-06-30 11:47
 * @Description:给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * 示例 1:
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 *
 * 1，1，2
 */
public class T83_删除链表重复元素 {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode deleteDuplicates(ListNode head) {
        ListNode start = head;
        while(start!=null){
            if (start.next == null) break;
            if (start.val != start.next.val) start = start.next;
            else start.next = start.next.next;
        }
        return head;
    }
}
