import java.io.IOException;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private int mod;
    
    private static void solve(final int n, final int[] array) {
        final HashSet set = new HashSet();
        for (int length = array.length, i = 0; i < length; ++i) {
            set.add(array[i]);
        }
        int n2;
        for (n2 = 0; set.contains(n - n2); ++n2) {
            if (!set.contains(n + n2)) {
                System.out.println(n + n2);
                return;
            }
        }
        System.out.println(n - n2);
    }
    
    private static void main$3231c38a() throws IOException {
        final BufferedReader bufferedReader;
        final String[] split = (bufferedReader = new BufferedReader(new InputStreamReader(System.in))).readLine().split(" ");
        new Main();
        final int int1 = Integer.parseInt(split[0]);
        final int int2;
        final int[] array = new int[int2 = Integer.parseInt(split[1])];
        final String[] split2 = bufferedReader.readLine().split(" ");
        for (int i = 0; i < int2; ++i) {
            array[i] = Integer.parseInt(split2[i]);
        }
        final int n = int1;
        final int[] array2 = array;
        final int n2 = n;
        final HashSet set = new HashSet();
        for (int length = array2.length, j = 0; j < length; ++j) {
            set.add(array2[j]);
        }
        int n3;
        for (n3 = 0; set.contains(n2 - n3); ++n3) {
            if (!set.contains(n2 + n3)) {
                System.out.println(n2 + n3);
                return;
            }
        }
        System.out.println(n2 - n3);
    }
}
