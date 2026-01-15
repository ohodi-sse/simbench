import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        try (final Scanner scanner = new Scanner(System.in)) {
            int nextInt;
            int x;
            for (nextInt = scanner.nextInt(), x = 1; x << 1 <= nextInt; x <<= 1) {}
            System.out.println(x);
        }
    }
}
