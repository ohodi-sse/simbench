import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        for (int nextInt = new Scanner(System.in).nextInt(), i = 1; i <= nextInt; i <<= 1) {
            if (nextInt < i << 1) {
                System.out.println(i);
            }
        }
    }
}
