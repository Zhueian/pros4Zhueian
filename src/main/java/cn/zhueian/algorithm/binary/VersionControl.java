package cn.zhueian.algorithm.binary;

import java.util.Base64;

/**
 * Created by qiucy on 2019/9/26.
 * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开
 * 发的，所以错误的版本之后的所有版本都是错的。

 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。

 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版
 本。你应该尽量减少对调用 API 的次数。

 示例:

 给定 n = 5，并且 version = 4 是第一个错误的版本。

 调用 isBadVersion(3) -> false
 调用 isBadVersion(5) -> true
 调用 isBadVersion(4) -> true

 所以，4 是第一个错误的版本。 

 */

class T278_第一个错误版本 extends VersionControl{
    /**
     * The isBadVersion API is defined in the parent class VersionControl.
       boolean isBadVersion(int version);
     */
    public int firstBadVersion(int n) {
        int l = 1;
        for (int r = n;l<r;){
            int mid = l+(r-l)/2;
            if (isBadVersion(mid)) r = mid;
            else l = mid+1;
        }
        return l;
    }

    /**
     * 超时O(n)
     * @param n
     * @return
     */
    public int firstBadVersion2(int n) {
        for (int i = 1; i <= n; i++)
            if (isBadVersion(i)) return i;
        return -1;
    }
}
public class  VersionControl{
    boolean isBadVersion(int version){
        return true;
    }
    public static void main(String[] args) {
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decode = decoder.decode("949db88102254368afe2609d4ed27ede");
        for (int i = 0; i < decode.length; i++) {
            System.out.print(decode[i]);
        }
    }
}
