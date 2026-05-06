import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        new Main().run();
    }
    
    public void run() {
        final Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.nextLong() * Math.round(scanner.nextDouble() * 100.0) / 100L);
        scanner.close();
    }
}
