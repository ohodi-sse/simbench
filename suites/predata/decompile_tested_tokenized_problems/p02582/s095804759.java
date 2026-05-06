import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final char[] charArray = new Scanner(System.in).next().toCharArray();
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            if (charArray[i] == 'R') {
                ++x;
            }
        }
        if (x == 2 && charArray[1] != 'R') {
            x = 1;
        }
        System.out.println(x);
    }
}
