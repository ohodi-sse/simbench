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
        int x = 0;
        if (nextInt == 0) {
            System.out.println("0");
            return;
        }
        for (int i = 0; i < 7; ++i) {
            x = (int)Math.pow(2.0, i);
            if (nextInt / x == 1) {
                break;
            }
        }
        System.out.println(x);
    }
}
