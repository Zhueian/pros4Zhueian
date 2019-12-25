package cn.zhueian.struct.linked;

/**
 * Created by qiucy on 2019/12/16.
 * 给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。

 请你返回该链表所表示数字的 十进制值 。

  

 示例 1：



 输入：head = [1,0,1]
 输出：5
 解释：二进制数 (101) 转化为十进制数 (5)
 示例 2：

 输入：head = [0]
 输出：0
 示例 3：

 输入：head = [1]
 输出：1
 示例 4：

 输入：head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
 输出：18880
 示例 5：

 输入：head = [0,0]
 输出：0
 */
public class T1290_二进制链表转整数 {

    public int getDecimalValue(ListNode head) {
        if (head == null) return 0;
        StringBuffer sbf = new StringBuffer();
        dfs4CountLength(head,sbf);
        String s = sbf.toString();
        int length = s.length();
        int ans = 0;
        System.out.println(s);
        for (int i = length-1; i >= 0;i--) {
            int t = 1;
            for (int j = 0; j < i; j++) {
                t*=2;
            }
            ans+=Integer.parseInt(s.charAt(length-i-1)+"")*t;
        }
        return ans;
    }

    private void dfs4CountLength(ListNode head, StringBuffer sbf) {
        if (head != null){
            sbf.append(head.val);
            dfs4CountLength(head.next,sbf);
        }
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public static void main(String[] args) {
//        Integer.parseInt("100100111000000");
        int ans = 0;
        for (int i = 16; i >= 0;i--) {
            int t = 1;
            for (int j = 0; j < i; j++) {
                t*=2;
            }
            ans+=Integer.parseInt("1")*t;
        }
        System.out.println(ans);
    }
}
