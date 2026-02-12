import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static int[] dp;
    
    private static void main$3231c38a() {
        final Scanner scanner;
        final char[] charArray = (scanner = new Scanner(System.in)).next().toCharArray();
        (Main.dp = new int[3])[0] = ((charArray[0] == 'R') ? 1 : 0);
        for (int i = 1; i < 3; ++i) {
            Main.dp[i] = ((charArray[i] == 'R') ? (Main.dp[i - 1] + 1) : 0);
        }
        int max = 0;
        for (int j = 0; j < 3; ++j) {
            max = Math.max(max, Main.dp[j]);
        }
        System.out.println(max);
        scanner.close();
    }
}
