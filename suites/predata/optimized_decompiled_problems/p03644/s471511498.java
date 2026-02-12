import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        int i;
        for (int n = i = new Scanner(System.in).nextInt(); i > 0; --i) {
            for (int j = 0; j < n; ++j) {
                if (i == Math.pow(2.0, j)) {
                    System.out.println(i);
                    return;
                }
            }
        }
    }
}
