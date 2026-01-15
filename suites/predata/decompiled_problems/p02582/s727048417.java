import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final char[] charArray = scanner.nextLine().toCharArray();
        scanner.close();
        final boolean b = charArray[0] == 'R';
        final boolean b2 = charArray[1] == 'R';
        final boolean b3 = charArray[2] == 'R';
        int x;
        if (b && b2 && b3) {
            x = 3;
        }
        else if ((b && b2) || (b2 && b3)) {
            x = 2;
        }
        else if (b || b2 || b3) {
            x = 1;
        }
        else {
            x = 0;
        }
        System.out.println(x);
    }
}
