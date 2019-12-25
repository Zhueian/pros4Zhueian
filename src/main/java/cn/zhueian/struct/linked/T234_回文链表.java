package cn.zhueian.struct.linked;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qiucy on 2019/12/16.
 * 请判断一个链表是否为回文链表。

 示例 1:

 输入: 1->2
 输出: false
 示例 2:

 输入: 1->2->2->1
 输出: true

 */
public class T234_回文链表 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        List<Integer> sbf = new ArrayList<>();
        recu(head,sbf);
        System.out.println(sbf);
        for (int i = 0; i < sbf.size()/2; i++) {
            if (!sbf.get(i).equals( sbf.get(sbf.size()-i-1))) return false;
        }
        return true;
    }

    private void recu(ListNode head, List<Integer> sbf) {
        if (head!=null) {
            sbf.add(head.val);
            recu(head.next,sbf);
        }
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
