import java.io.IOException;
import java.util.Set;
import java.util.HashSet;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) throws IOException {
        final FastReader fastReader = new FastReader();
        final int nextInt = fastReader.nextInt();
        final int nextInt2 = fastReader.nextInt();
        final HashSet set = new HashSet();
        for (int i = 0; i < nextInt2; ++i) {
            set.add(fastReader.nextInt());
        }
        System.out.println(solve(nextInt, nextInt2, set));
    }
    
    static int solve(final int i, final int n, final Set<Integer> set) {
        if (!set.contains(i)) {
            return i;
        }
        int n2 = i - 1;
        int n3 = i + 1;
        int j = 0;
        int k = 0;
        while (j == 0) {
            if (!set.contains(n2)) {
                j = 1;
            }
            else {
                --n2;
            }
        }
        while (k == 0) {
            if (!set.contains(n3)) {
                k = 1;
            }
            else {
                ++n3;
            }
        }
        if (i - n2 == n3 - i) {
            return Math.min(n2, n3);
        }
        return (i - n2 < n3 - i) ? n2 : n3;
    }
}
