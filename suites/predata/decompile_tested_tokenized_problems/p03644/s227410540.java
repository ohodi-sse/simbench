import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String... array) {
        try (final Scanner scanner = new Scanner(System.in)) {
            System.out.println(Integer.parseInt(Integer.toBinaryString(scanner.nextInt()).replaceAll("1", "0").replaceFirst("^0", "1"), 2));
        }
    }
}
