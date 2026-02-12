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
        final String[] split2 = bufferedReader.readLine().split(" ");
        final HashSet set = new HashSet();
        for (int i = 0; i < int2; ++i) {
            set.add(Integer.parseInt(split2[i]));
        }
        for (int j = 0; j <= 200; ++j) {
            if (!set.contains(int1 - j)) {
                System.out.println(int1 - j);
                return;
            }
            if (!set.contains(int1 + j)) {
                System.out.println(int1 + j);
                return;
            }
        }
    }
}
