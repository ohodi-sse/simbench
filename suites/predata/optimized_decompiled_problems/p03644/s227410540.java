import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        try (final Scanner scanner = new Scanner(System.in)) {
            System.out.println(Integer.parseInt(Integer.toBinaryString(scanner.nextInt()).replaceAll("1", "0").replaceFirst("^0", "1"), 2));
        }
    }
}
