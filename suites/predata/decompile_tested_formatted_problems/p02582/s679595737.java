import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final String nextLine = new Scanner(System.in).nextLine();
        final ArrayList list = new ArrayList();
        for (int i = 0; i < nextLine.length(); ++i) {
            list.add(nextLine.charAt(i));
        }
        int n = 0;
        if (Collections.frequency(list, 'S') == 3) {
            System.out.println("0");
        }
        else if (Collections.frequency(list, 'R') == 3) {
            System.out.println("3");
        }
        else {
            for (int j = 0; j < nextLine.length() - 1; ++j) {
                if ((char)list.get(j) == 'R' && (char)list.get(j + 1) == 'R') {
                    n = 1;
                }
            }
            if (n == 1) {
                System.out.println("2");
            }
            else {
                System.out.println("1");
            }
        }
    }
}
