import java.io.IOException;
import java.util.HashSet;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() throws IOException {
        final BufferedReader bufferedReader;
        final String[] split;
        final int int1 = Integer.parseInt((split = (bufferedReader = new BufferedReader(new InputStreamReader(System.in))).readLine().split(" "))[0]);
        final int int2 = Integer.parseInt(split[1]);
        int x = 0;
        int n = Integer.MAX_VALUE;
        final HashSet set = new HashSet();
        final String[] split2 = bufferedReader.readLine().split(" ");
        for (int i = 0; i < int2; ++i) {
            set.add(Integer.parseInt(split2[i]));
        }
        for (int j = 0; j <= 101; ++j) {
            final int abs;
            if (!set.contains(j) && (abs = Math.abs(int1 - j)) < n) {
                n = abs;
                x = j;
            }
        }
        System.out.println(x);
    }
}
