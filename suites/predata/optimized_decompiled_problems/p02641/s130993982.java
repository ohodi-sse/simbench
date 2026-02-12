import java.util.ArrayList;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

final class Main
{
    private static Scanner sc;
    
    private static void main$3231c38a() {
        final int nextInt = Main.sc.nextInt();
        final int nextInt2;
        if ((nextInt2 = Main.sc.nextInt()) != 0) {
            final ArrayList list = new ArrayList();
            for (int i = 0; i < nextInt2; ++i) {
                list.add(Main.sc.nextInt());
            }
            int n;
            for (n = 0; list.contains(nextInt - n); ++n) {
                if (!list.contains(nextInt + n)) {
                    System.out.println(nextInt + n);
                    return;
                }
            }
            System.out.println(nextInt - n);
            return;
        }
        System.out.println(nextInt);
    }
    
    static {
        Main.sc = new Scanner(System.in);
    }
}
