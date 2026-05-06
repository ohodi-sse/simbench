import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        int x = 0;
        final String nextLine = scanner.nextLine();
        final String nextLine2 = scanner.nextLine();
        for (int i = 0; i < 3; ++i) {
            if (nextLine.charAt(i) == nextLine2.charAt(i)) {
                ++x;
            }
        }
        System.out.println(x);
    }
}
