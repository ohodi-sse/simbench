import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final String next = (scanner = new Scanner(System.in)).next();
        final String next2 = scanner.next();
        final char[] charArray = next.toCharArray();
        final char[] charArray2 = next2.toCharArray();
        if (charArray[0] == charArray2[0] && charArray[1] == charArray2[1] && charArray[2] == charArray2[2]) {
            System.out.println("3");
            return;
        }
        if ((charArray[0] == charArray2[0] && charArray[1] == charArray2[1]) || (charArray[1] == charArray2[1] && charArray[2] == charArray2[2]) || (charArray[0] == charArray2[0] && charArray[2] == charArray2[2])) {
            System.out.println("2");
            return;
        }
        if (charArray[0] == charArray2[0] || charArray[1] == charArray2[1] || charArray[2] == charArray2[2]) {
            System.out.println("1");
            return;
        }
        System.out.println("0");
    }
}
