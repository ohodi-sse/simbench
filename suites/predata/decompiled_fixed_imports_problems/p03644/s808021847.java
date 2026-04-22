import java.util.Scanner;

public class Main
{
    public static int N;
    public static int K;
    public static int a;
    public static String ans;
    
    public static void main(final String[] array) {
        Main.N = new Scanner(System.in).nextInt();
        for (int i = 1; i <= Main.N; ++i) {
            int a = 0;
            for (int n = i; n % 2 == 0; n /= 2, ++a) {}
            if (Main.a < a) {
                Main.a = a;
                Main.ans = "" + i;
            }
        }
        System.out.println(Main.ans);
    }
    
    static {
        Main.a = -1;
        Main.ans = "";
    }
}