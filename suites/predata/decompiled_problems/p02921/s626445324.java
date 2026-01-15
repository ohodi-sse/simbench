import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) throws Exception {
        final Scanner scanner = new Scanner(System.in);
        final char[] charArray = scanner.nextLine().toCharArray();
        final char[] charArray2 = scanner.nextLine().toCharArray();
        int i = 0;
        for (int j = 0; j < 3; ++j) {
            if (charArray[j] == charArray2[j]) {
                ++i;
            }
        }
        System.out.printf("%d\n", i);
    }
}
