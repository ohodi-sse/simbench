import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println(tenki(scanner.nextLine(), scanner.nextLine()));
        scanner.close();
    }
    
    public static int tenki(final String s, final String s2) {
        int n = 0;
        for (int i = 0; i < 3; ++i) {
            if (s.charAt(i) == s2.charAt(i)) {
                ++n;
            }
        }
        return n;
    }
}
