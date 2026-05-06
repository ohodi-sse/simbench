import java.util.ArrayList;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        final ArrayList list = new ArrayList();
        for (int i = 0; i < nextInt2; ++i) {
            list.add(scanner.nextInt());
        }
        int n = 0;
        while (true) {
            final int n2 = nextInt - n;
            if (!list.contains(n2)) {
                System.out.println(n2);
                return;
            }
            final int n3 = nextInt + n;
            if (!list.contains(n3)) {
                System.out.println(n3);
                return;
            }
            ++n;
        }
    }
}
