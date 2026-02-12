import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final char[] charArray = (scanner = new Scanner(System.in)).next().toCharArray();
        final char[] charArray2 = scanner.next().toCharArray();
        System.out.println(((charArray[0] == charArray2[0]) + (charArray[1] == charArray2[1]) + (charArray[2] == charArray2[2])) ? 1 : 0);
    }
}
