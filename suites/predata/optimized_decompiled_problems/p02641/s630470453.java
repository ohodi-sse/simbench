import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int int1 = Integer.parseInt((scanner = new Scanner(System.in)).next());
        final int int2 = Integer.parseInt(scanner.next());
        final ArrayList list = new ArrayList();
        for (int i = 1; i <= int2; ++i) {
            list.add(Integer.parseInt(scanner.next()));
        }
        Collections.sort((List<Comparable>)list);
        int n = Integer.MAX_VALUE;
        int n2 = Integer.MAX_VALUE;
        for (int j = int1; j <= 101; ++j) {
            if (!list.contains(j)) {
                n = j;
                break;
            }
        }
        for (int k = int1; k >= 0; --k) {
            if (!list.contains(k)) {
                n2 = k;
                break;
            }
        }
        System.out.println((Math.abs(int1 - n2) <= Math.abs(n - int1)) ? n2 : n);
    }
}
