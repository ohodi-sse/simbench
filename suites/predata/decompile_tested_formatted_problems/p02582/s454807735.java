import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final String[] split = new Scanner(System.in).next().split("S");
        int max = 0;
        for (int i = 0; i < split.length; ++i) {
            max = Math.max(max, split[i].length());
        }
        System.out.println(max);
    }
}
