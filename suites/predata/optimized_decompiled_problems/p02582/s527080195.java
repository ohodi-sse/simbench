import java.util.StringTokenizer;
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
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final StringBuilder sb = new StringBuilder();
        final String line = bufferedReader.readLine();
        int max = 0;
        int n = 0;
        for (int i = 0; i < line.length(); ++i) {
            if (line.charAt(i) == 'R') {
                ++n;
            }
            else {
                max = Math.max(max, n);
                n = 0;
            }
        }
        sb.append(Math.max(max, n));
        System.out.print(sb.toString());
    }
    
    private static int nextInt(final BufferedReader bufferedReader) throws IOException {
        return Integer.parseInt(bufferedReader.readLine());
    }
    
    private static int[] nextIntArray(final BufferedReader bufferedReader, final int n) throws IOException {
        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        final int[] array = new int[n];
        for (int i = 0; i < n; ++i) {
            array[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        return array;
    }
    
    static final class Pair<A, B>
    {
        private A first;
        private B second;
        
        private Pair(final A first, final B second) {
            this.first = first;
            this.second = second;
        }
    }
}
