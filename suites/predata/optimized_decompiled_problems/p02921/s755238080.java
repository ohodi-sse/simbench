import java.util.List;
import java.util.Arrays;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final String next = (scanner = new Scanner(System.in)).next();
        final String next2 = scanner.next();
        final List<String> list = Arrays.asList(next.split(""));
        final List<String> list2 = Arrays.asList(next2.split(""));
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            if (list.get(i).equals(list2.get(i))) {
                ++x;
            }
        }
        System.out.println(x);
    }
}
