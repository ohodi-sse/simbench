import java.util.Scanner;





public class Main
{
    static int[] dp;
    
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final char[] charArray = scanner.next().toCharArray();
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