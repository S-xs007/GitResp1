package cn.algorithm.leetcode.哈希表;

import java.util.HashMap;
import java.util.Map;
//连续子数组就是数组范围求和：前缀和
//（sum[j]-sum[i]）%K == 0  这就是一组解（sum[j]-sum[i]就是i到j范围的子数组）
//转化  sum[j]%K == sim[i]%K == 0
public class LC和可被K整除的子数组 {
    public int subarraysDivByK(int[] A, int K) {
        Map<Integer, Integer> record = new HashMap<>();
        record.put(0, 1);   //一定放  因为要从1开始
        int sum = 0, res = 0;
        for (int elem: A) {
            sum += elem;
            int modulus = (sum % K + K) % K;    //防止k是负数
            int same = record.getOrDefault(modulus, 0); //先得到结果，在放到map中，两个相等时一个结果
            res += same;
            record.put(modulus, same + 1);
        }
        return res;
    }
}
