import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static int[][] numbers;
    
    private static void main$3231c38a() {
        final String next = new Scanner(System.in).next();
        int max = 0;
        for (int i = 0; i < 3; ++i) {
            final char char1;
            if ((char1 = next.charAt(i)) == 'R') {
                int b = 1;
                for (int index = i + 1; index < 3 && char1 == next.charAt(index); ++index) {
                    ++b;
                }
                max = Math.max(max, b);
            }
        }
        System.out.println(max);
    }
}
