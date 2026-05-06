import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final String next = scanner.next();
        final String next2 = scanner.next();
        scanner.close();
        System.out.println(WeatherMatch(next, next2));
    }
    
    public static int WeatherMatch(final String s, final String s2) {
        if (s.length() == 0) {
            return 0;
        }
        if (s.charAt(0) == s2.charAt(0)) {
            return 1 + WeatherMatch(s.substring(1), s2.substring(1));
        }
        return WeatherMatch(s.substring(1), s2.substring(1));
    }
}
