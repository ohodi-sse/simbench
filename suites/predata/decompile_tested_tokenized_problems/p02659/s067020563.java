import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

class Main
{
    static int mod;
    
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.nextLong() * Math.round(scanner.nextDouble() * 100.0) / 100L);
    }
    
    static {
        Main.mod = (int)(Math.pow(10.0, 9.0) + 7.0);
    }
}
