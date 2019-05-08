package cn.zhueian.leetcode.leetcode.conti;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Auther: qiucy
 * @Date: 2019-04-30 16:08
 * @Description:
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class T21_MergeTwoSortedLists {
    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode list = null;
        List<Integer> temp = new ArrayList<>();
        temp.add(l1.val);
        while (l1.next != null){
            temp.add(l1.val);
        }
        temp.add(l2.val);
        while (l2.next != null){
            temp.add(l2.val);
        }
        Collections.sort(temp);
        for (int i = 0; i < temp.size(); i++) {
            list.val = temp.get(i);
            list = list.next;
        }
        return list;
    }

}
