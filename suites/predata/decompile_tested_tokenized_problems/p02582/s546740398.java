import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final char[] charArray = new Scanner(System.in).next().toCharArray();
        int x = 0;
        if (charArray[0] == 'R' && charArray[1] == 'R' && charArray[2] == 'R') {
            x = 3;
        }
        else if ((charArray[0] == 'R' && charArray[1] == 'R') || (charArray[1] == 'R' && charArray[2] == 'R')) {
            x = 2;
        }
        else if (charArray[0] == 'R' || charArray[1] == 'R' || charArray[2] == 'R') {
            x = 1;
        }
        System.out.println(x);
    }
}
