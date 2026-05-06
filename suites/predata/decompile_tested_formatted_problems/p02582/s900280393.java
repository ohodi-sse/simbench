import java.io.IOException;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// 
// Decompiled by Procyon v0.6.0
// 

class Main
{
    public static void main(final String[] array) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (int n = 1, i = 0; i < n; ++i) {
            final char[] charArray = bufferedReader.readLine().toCharArray();
            int max = 0;
            int n2 = 0;
            for (int j = 0; j < 3; ++j) {
                if (charArray[j] == 'S') {
                    max = Math.max(max, n2);
                    n2 = 0;
                }
                else {
                    ++n2;
                }
            }
            System.out.println(Math.max(n2, max));
        }
    }
}
