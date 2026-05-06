import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final Main main = new Main();
        final Scanner scanner = new Scanner(System.in);
        main.solve(scanner);
        scanner.close();
    }
    
    void solve(final Scanner scanner) {
        final int nextInt = scanner.nextInt();
        if (nextInt == 0) {
            System.out.println(0);
        }
        else if (nextInt == 1) {
            System.out.println(1);
        }
        else if (nextInt > 1 && nextInt <= 3) {
            System.out.println(2);
        }
        else if (nextInt > 3 && nextInt <= 7) {
            System.out.println(4);
        }
        else if (nextInt > 7 && nextInt <= 15) {
            System.out.println(8);
        }
        else if (nextInt > 15 && nextInt <= 31) {
            System.out.println(16);
        }
        else if (nextInt > 31 && nextInt <= 63) {
            System.out.println(32);
        }
        else if (nextInt > 63 && nextInt <= 100) {
            System.out.println(64);
        }
    }
}
