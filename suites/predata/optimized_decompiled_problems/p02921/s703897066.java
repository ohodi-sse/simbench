import java.io.IOException;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() throws IOException {
        try (final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            final String[] split = bufferedReader.readLine().split("");
            final String[] split2 = bufferedReader.readLine().split("");
            int x = 0;
            for (int i = 0; i < 3; ++i) {
                if (split[i].equals(split2[i])) {
                    ++x;
                }
            }
            System.out.println(x);
        }
    }
}
