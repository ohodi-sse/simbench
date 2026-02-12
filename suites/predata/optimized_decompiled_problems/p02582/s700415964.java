import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final String next = (scanner = new Scanner(System.in)).next();
        scanner.close();
        final char[] array = new char[next.length()];
        for (int i = 0; i < next.length(); ++i) {
            array[i] = next.charAt(i);
        }
        int x = -1;
        if (array[0] != 'R' && array[1] != 'R' && array[2] != 'R') {
            x = 0;
        }
        else if ((array[0] == 'S' && array[1] == 'S') || (array[1] == 'S' && array[2] == 'S') || (array[2] == 'S' && array[0] == 'S') || (array[0] == 'R' && array[1] == 'S' && array[2] == 'R')) {
            x = 1;
        }
        else if ((array[0] == 'R' && array[1] == 'R' && array[2] == 'S') || (array[0] == 'S' && array[1] == 'R' && array[2] == 'R')) {
            x = 2;
        }
        else if (array[0] == 'R' && array[1] == 'R' && array[2] == 'R') {
            x = 3;
        }
        System.out.println(x);
    }
}
