import java.io.PrintWriter;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) throws Exception {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final PrintWriter printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        final char[] charArray = bufferedReader.readLine().toCharArray();
        int max = 0;
        int n = 0;
        for (final char c : charArray) {
            if (c == 'S') {
                max = Math.max(max, n);
                n = 0;
            }
            else if (c == 'R') {
                ++n;
            }
        }
        printWriter.println(Math.max(n, max));
        printWriter.close();
    }
}
