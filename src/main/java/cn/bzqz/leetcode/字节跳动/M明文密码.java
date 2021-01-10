package cn.bzqz.leetcode.字节跳动;

import java.util.Scanner;

public class M明文密码 {
    public static void main(String[] args) {
        run();
    }
    private static void run() {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        scanner.nextLine();
        String S = scanner.nextLine();
        int[] S_int = new int[N + K - 1]; // 将输入的01字符串转化为01整数数组，方便下面进行异或操作
        int[] res = new int[N]; // 输出的结果
        for (int i = 0; i < N + K - 1; ++i) { // 将输入的01字符串转化为01整数数组，方便下面进行异或操作
            S_int[i] = S.charAt(i) - '0';
        }
        res[0] = S_int[0]; // 第一段
        for (int i = 1; i < K; ++i) { // 第二段    1- k-1
            res[i] = S_int[i - 1] ^ S_int[i];
        }
        for (int i = K; i < N; i++) { // 第三段
            res[i] = res[i - K] ^ S_int[i - 1] ^ S_int[i];
        }
        for (int i = 0, len = res.length; i < len; ++i) {
            System.out.print(res[i]);
        }
        System.out.println();
        scanner.close();
    }
}
