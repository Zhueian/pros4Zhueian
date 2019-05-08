package cn.zhueian.leetcode.leetcode.ac;

/**
 * @Auther: qiucy
 * @Date: 2019-03-03 19:57
 * @Description:
 */
public class T242_ValidAnagram {
    /**
     * 字符串
     * 两个字符串包含的字符是否完全相同
     * s = "anagram", t = "nagaram", return true.
     * s = "rat", t = "car", return false.
     */
    public static void main(String[] args) {
        System.out.println("asas~!~~~");
        new T242_ValidAnagram().isEqual("","");
    }
    public Boolean isEqual(String a,String b){
        int [] cnt = new int[26];
        char[] lettersA = a.toCharArray();
        char[] lettersB = b.toCharArray();
        for (char c : lettersA) {
            cnt[c - 'a']++;
        }
        for (char c : lettersB) {
            cnt[c - 'b']--;
        }
        for (int i : cnt) {
            if(i != 0){
                return false;
            }
        }
        return true;
    }
}
