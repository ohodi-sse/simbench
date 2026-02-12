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
        final String[] array = new String[next.length()];
        final String[] array2 = new String[next.length()];
        int x = 0;
        for (int i = 0; i < next.length(); ++i) {
            final String[] array3 = array;
            final int n = i;
            final String s = next;
            final int beginIndex = i;
            array3[n] = s.substring(beginIndex, beginIndex + 1);
        }
        for (int j = 0; j < next2.length(); ++j) {
            final String[] array4 = array2;
            final int n2 = j;
            final String s2 = next2;
            final int beginIndex2 = j;
            array4[n2] = s2.substring(beginIndex2, beginIndex2 + 1);
        }
        for (int k = 0; k < next.length(); ++k) {
            if (array[k].equals(array2[k])) {
                ++x;
            }
        }
        System.out.println(x);
    }
}
