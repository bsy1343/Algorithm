package Softeer.Lv2;

import java.util.Scanner;

// https://softeer.ai/practice/6268
public class 전광판 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        String[] VAL = {"1110111", "0010010", "1011101", "1011011", "0111010", "1101011", "1101111", "1110010", "1111111", "1111011"};
        String EMPTY_VAL = "0000000";
        int[] A, B;
        int N = 5;

        for (int t = 0; t < T; t++) {
            A = new int[5];
            B = new int[5];

            String sa = String.format("%5s", sc.next());
            String sb = String.format("%5s", sc.next());
            for (int i = N - 1; i >= 0; i--) {
                A[i] = (sa.charAt(i) == ' ') ? -1 : sa.charAt(i) - '0';
                B[i] = (sb.charAt(i) == ' ') ? -1 : sb.charAt(i) - '0';
            }

            int cnt = 0;
            for (int i = 0; i < 5; i++) {
                if (A[i] != B[i]) {
                    String a_vaule = A[i] == -1 ? EMPTY_VAL : VAL[A[i]];
                    String b_vaule = B[i] == -1 ? EMPTY_VAL : VAL[B[i]];
                    for (int j = 0; j < 7; j++) {
                        if (a_vaule.charAt(j) != b_vaule.charAt(j)) {
                            cnt++;
                        }
                    }
                }
            }
            System.out.println(cnt);
        }

        sc.close();
    }
}
