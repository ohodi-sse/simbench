import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();
        int n = 0;
        int x = 0;
        while (s.length() > 0) {
            if (s.startsWith("R")) {
                ++n;
            }
            else {
                n = 0;
            }
            if (n > x) {
                x = n;
            }
            s = removeLeadingZeroes(s);
        }
        System.out.println(x);
    }
    
    static String removeLeadingZeroes(final String str) {
        final StringBuilder sb = new StringBuilder(str);
        if (sb.length() > 0) {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}
