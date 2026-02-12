import java.util.ArrayList;
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
        int x = 0;
        final ArrayList list = new ArrayList();
        for (int i = 0; i < next.length(); ++i) {
            list.add(next.charAt(i));
        }
        if ((char)list.get(0) == 'R') {
            if ((char)list.get(1) == 'R') {
                if ((char)list.get(2) == 'R') {
                    x = 3;
                }
                else {
                    x = 2;
                }
            }
            else {
                x = 1;
            }
        }
        else if ((char)list.get(1) == 'R') {
            if ((char)list.get(2) == 'R') {
                x = 2;
            }
            else {
                x = 1;
            }
        }
        else if ((char)list.get(2) == 'R') {
            x = 1;
        }
        System.out.println(x);
    }
}
