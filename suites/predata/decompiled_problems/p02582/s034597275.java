import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final String nextLine = scanner.nextLine();
        scanner.close();
        if (nextLine.contains("RRR")) {
            System.out.println(3);
        }
        else if (nextLine.contains("RR")) {
            System.out.println(2);
        }
        else if (nextLine.contains("R")) {
            System.out.println(1);
        }
        else {
            System.out.println(0);
        }
    }
}
