import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final String next = new Scanner(System.in).next();
        int x = 0;
        final char[] charArray;
        if ((charArray = next.toCharArray())[0] == 'R' && charArray[1] == 'R' && charArray[2] == 'R') {
            x = 3;
        }
        else if (charArray[0] == 'R' && charArray[1] == 'R') {
            x = 2;
        }
        else if (charArray[1] == 'R' && charArray[2] == 'R') {
            x = 2;
        }
        else if (charArray[0] == 'R' || charArray[1] == 'R' || charArray[2] == 'R') {
            x = 1;
        }
        System.out.println(x);
    }
}
