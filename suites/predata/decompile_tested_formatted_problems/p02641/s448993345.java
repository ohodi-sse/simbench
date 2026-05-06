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
        int x = nextInt;
        for (int i = 0; i < nextInt2; ++i) {
            list.add(scanner.nextInt());
        }
        for (int j = 0; j <= nextInt2; ++j) {
            if (!list.contains(nextInt - j)) {
                x = nextInt - j;
                break;
            }
            if (!list.contains(nextInt + j)) {
                x = nextInt + j;
                break;
            }
        }
        System.out.println(x);
    }
}
