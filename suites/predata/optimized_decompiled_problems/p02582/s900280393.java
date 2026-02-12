import java.io.IOException;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// 
// Decompiled by Procyon v0.6.0
// 

final class Main
{
    private static void main$3231c38a() throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i <= 0; ++i) {
            final char[] charArray = bufferedReader.readLine().toCharArray();
            int max = 0;
            int n = 0;
            for (int j = 0; j < 3; ++j) {
                if (charArray[j] == 'S') {
                    max = Math.max(max, n);
                    n = 0;
                }
                else {
                    ++n;
                }
            }
            System.out.println(Math.max(n, max));
        }
    }
}
