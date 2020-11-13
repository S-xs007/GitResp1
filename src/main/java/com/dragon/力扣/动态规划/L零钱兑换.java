package com.dragon.力扣.动态规划;

import java.util.*;

public class L零钱兑换 {
    public int coinChange(int[] coins, int amount) {
        int max = Integer.MAX_VALUE;
        int[] dp = new int[amount+1];
        Arrays.fill(dp,max);
        dp[0] = 0;
        for(int i = 1;i<=amount;i++){
            for(int j = 0;j<coins.length;j++){
                if(i>=coins[j]) {
                    dp[i] = Math.min(dp[i - coins[j]] + 1,dp[i]);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<>();
        if(s.length()<=10)return list;
        HashMap<String,Integer> map=  new HashMap<>();
        for(int i = 9;i<s.length();i++){
                String x = s.substring(i-9,i+1);
                map.put(x,map.getOrDefault(x,0)+1);
        }
        Set<String> tem = map.keySet();
        for(String x:tem){
            if(map.get(x)>1){
                list.add(x);
            }
        }
        return list;

    }


    public List<String> findRepeatedDnaSequences1(String s) {
        HashSet<String> seen = new HashSet<>();
        HashSet<String> re = new HashSet<>();
        for(int i = 9;i<s.length();i++){
            String x = s.substring(i-9,i+1);
            if(seen.contains(x))re.add(x);
            seen.add(x);
        }
        return new ArrayList<>(re);
    }

    }
