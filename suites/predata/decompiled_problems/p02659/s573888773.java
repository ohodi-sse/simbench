import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println(Long.parseLong(scanner.next()) * Math.round(Double.parseDouble(scanner.next()) * 100.0) / 100L);
    }
}
