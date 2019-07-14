package cn.zhueian.struct.hash;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: qiucy
 * @Date: 2019-07-09 10:21
 * @Description:
 * TinyURL是一种URL简化服务， 比如：当你输入一个URL https://leetcode.com/problems/design-tinyurl 时，
 * 它将返回一个简化的URL http://tinyurl.com/4e9iAk.
 *
 * 要求：设计一个 TinyURL 的加密 encode 和解密 decode 的方法。你的加密和解密算法如何设计和运作是没有限制的，
 * 你只需要保证一个URL可以被加密成一个TinyURL，并且这个TinyURL可以用解密方法恢复成原本的URL。
 *
 */
public class T535_TinyUrl的加密和解密 {
    // Your Codec object will be instantiated and called as such:
    // Codec codec = new Codec();
    // codec.decode(codec.encode(url));
    private Map<Integer,String> m = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        int i = longUrl.hashCode();
        m.put(i,longUrl);
        return "http://tinyurl.com/"+i;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return m.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/","")));
    }

    public static void main(String[] args) {
        T535_TinyUrl的加密和解密 a = new T535_TinyUrl的加密和解密();
        String encode = a.encode("https://leetcode.com/problems/design-tinyurl");
        System.out.println(encode);
        String decode = a.decode(encode);
        System.out.println(decode);
    }
}
