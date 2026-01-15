import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final String[] array2 = new String[2];
        for (int i = 0; i < 2; ++i) {
            array2[i] = scanner.next();
        }
        final String[] split = array2[0].split("");
        final String[] split2 = array2[1].split("");
        int x = 0;
        for (int j = 0; j < split.length; ++j) {
            if (split[j].equals(split2[j])) {
                ++x;
            }
        }
        System.out.println(x);
    }
}
