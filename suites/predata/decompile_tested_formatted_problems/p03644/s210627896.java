import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final int int1 = Integer.parseInt(new Scanner(System.in).next());
        for (int i = 0; i < 10; ++i) {
            if (Math.pow(2.0, i) > int1) {
                System.out.println((int)Math.pow(2.0, i - 1));
                return;
            }
        }
    }
}
