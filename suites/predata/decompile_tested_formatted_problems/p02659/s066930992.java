import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final Long value = Long.parseLong(scanner.next());
        final String[] split = scanner.next().split("\\.", -1);
        System.out.println(value * Long.parseLong(split[0]) + value * Integer.parseInt(split[1]) / 100L);
    }
}
