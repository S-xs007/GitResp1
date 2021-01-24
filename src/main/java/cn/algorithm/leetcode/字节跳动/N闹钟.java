package cn.algorithm.leetcode.字节跳动;

import java.util.*;

//3
//5 0
//6 0
//7 0
//59
//6 59
public class N闹钟 {
    public static void main(String[] args) {
        run();
    }

    private static void run() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();  //闹钟个数
        List<Integer> list = new LinkedList<>();
        for(int i =0;i<n;i++){
            list.add(scanner.nextInt()*60+scanner.nextInt());
        }
        int jianGe = scanner.nextInt();
        int time = scanner.nextInt()*60+ scanner.nextInt();
        int t = time-jianGe;
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        int l = 0;
        int r = list.size();
        while(l<r){
            int m = (l + r) >> 1;
            if (t >= list.get(m)) { //因为要找到最晚的，所以找到了也要往后走
                l = m + 1;
            } else {
                r = m;
            }
        }
        if (l-1 < 0)
            System.out.println(list.get(0) / 60 + " " + list.get(0) % 60);
        else
            System.out.println(list.get(l-1) / 60 + " " + list.get(l-1) % 60);
        scanner.close();

    }

}


