package csp;

import java.util.Scanner;

public class Main {
    static int n;
    static int m;
    static int[] option; // a_i
    static int[] answer; // b_i
    static int[] prefix; // c_i

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        option = new int[n + 1];
        answer = new int[n + 1];
        prefix = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            option[i] = scanner.nextInt();
        }

        // 计算前缀积 c_i = a_1 * a_2 * ... * a_i
        prefix[0] = 1;
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] * option[i];
        }

        // 计算 b_i
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            answer[i] = (m % prefix[i] - sum) / prefix[i - 1];
            sum += prefix[i - 1] * answer[i];
        }

        // 输出 b_1 到 b_n
        for (int i = 1; i <= n; i++) {
            System.out.print(answer[i] + " ");
        }
        System.out.println();
    }
}