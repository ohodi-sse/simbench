import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println(Long.parseLong(scanner.next()) * (long)(Double.parseDouble(scanner.next()) * 500.0) / 500L);
    }
}
