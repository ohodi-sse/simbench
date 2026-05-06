import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final String next = scanner.next();
        final String next2 = scanner.next();
        final char[] charArray = next.toCharArray();
        final char[] charArray2 = next2.toCharArray();
        if (charArray[0] == charArray2[0] && charArray[1] == charArray2[1] && charArray[2] == charArray2[2]) {
            System.out.println("3");
        }
        else if ((charArray[0] == charArray2[0] && charArray[1] == charArray2[1]) || (charArray[1] == charArray2[1] && charArray[2] == charArray2[2]) || (charArray[0] == charArray2[0] && charArray[2] == charArray2[2])) {
            System.out.println("2");
        }
        else if (charArray[0] == charArray2[0] || charArray[1] == charArray2[1] || charArray[2] == charArray2[2]) {
            System.out.println("1");
        }
        else {
            System.out.println("0");
        }
    }
}
