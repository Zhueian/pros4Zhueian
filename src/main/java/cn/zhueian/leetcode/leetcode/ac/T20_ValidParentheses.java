package cn.zhueian.leetcode.leetcode.ac;

import java.util.HashSet;
import java.util.Stack;

/**
 * @Auther: qiucy
 * @Date: 2019-04-30 15:40
 * @Description:
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 */
public class T20_ValidParentheses {
    public boolean isValid(String s) {
        if (s == null || s.length() % 2 != 0) return false;
        Stack<Character> container = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == '('){
                container.push(')');
            }else if(chars[i] == '['){
                container.push(']');
            }else if (chars[i] == '{'){
                container.push('}');
            }else if (container.isEmpty() || container.pop() != chars[i]){
                return false;
            }
        }
        return container.isEmpty();
    }
}
