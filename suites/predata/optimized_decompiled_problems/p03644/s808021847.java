import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static int N;
    private static int K;
    private static int a;
    private static String ans;
    
    private static void main$3231c38a() {
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
