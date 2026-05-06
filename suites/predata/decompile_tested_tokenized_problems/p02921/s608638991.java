import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        int x = 0;
        final Scanner scanner = new Scanner(System.in);
        final String nextLine = scanner.nextLine();
        final String nextLine2 = scanner.nextLine();
        final String[] split = nextLine.split("");
        final String[] split2 = nextLine2.split("");
        for (int i = 0; i < 3; ++i) {
            if (split[i].equals(split2[i])) {
                ++x;
            }
        }
        System.out.println(x);
    }
}
