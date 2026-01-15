import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final String[] split = new Scanner(System.in).nextLine().split("");
        int n = 0;
        int i = 0;
        int x = 0;
        while (i < split.length) {
            if (split[i].equals("R")) {
                ++n;
                if (x < n) {
                    x = n;
                }
            }
            else {
                n = 0;
            }
            ++i;
        }
        System.out.println(x);
    }
}
