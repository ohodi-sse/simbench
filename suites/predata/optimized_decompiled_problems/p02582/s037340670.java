import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final String next;
        final char[] charArray = (next = (scanner = new Scanner(System.in)).next()).toCharArray();
        final int length = next.length();
        int x = 1;
        for (int i = 0; i < length - 1; ++i) {
            if (charArray[i] == 'R' && charArray[i + 1] == 'R') {
                ++x;
            }
            else if ((charArray[0] == 'R' && charArray[2] == 'R' && x == 1) || (charArray[1] == 'R' && charArray[2] == 'S' && x == 1) || (charArray[0] == 'R' && x == 1) || (charArray[2] == 'R' && x == 1)) {
                x = 1;
            }
            else if (charArray[i] != 'R' && x == 1) {
                x = 0;
            }
        }
        System.out.println(x);
        scanner.close();
    }
}
