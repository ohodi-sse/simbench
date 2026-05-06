import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

class Main
{
    static Scanner sc;
    
    public static void main(final String[] array) {
        final long nextLong = Main.sc.nextLong();
        final long n = 0L;
        final String next = Main.sc.next();
        System.out.println((n + 100L * nextLong * Character.getNumericValue(next.charAt(0)) + 10L * nextLong * Character.getNumericValue(next.charAt(2)) + nextLong * Character.getNumericValue(next.charAt(3))) / 100L);
    }
    
    static {
        Main.sc = new Scanner(System.in);
    }
}
