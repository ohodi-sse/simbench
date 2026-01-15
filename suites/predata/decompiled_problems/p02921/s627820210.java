import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final char[] charArray = scanner.nextLine().toCharArray();
        final char[] charArray2 = scanner.nextLine().toCharArray();
        int x = 0;
        if (charArray[0] == charArray2[0]) {
            ++x;
        }
        if (charArray[1] == charArray2[1]) {
            ++x;
        }
        if (charArray[2] == charArray2[2]) {
            ++x;
        }
        System.out.println(x);
    }
}
