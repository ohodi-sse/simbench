import java.io.IOException;
import java.util.StringTokenizer;
import java.io.OutputStream;
import java.io.PrintWriter;
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
        final PrintWriter printWriter = new PrintWriter(System.out);
        final String[] split = new StringTokenizer(bufferedReader.readLine()).nextToken().split("");
        int x = 0;
        boolean b = false;
        for (int length = split.length, i = 0; i < length; ++i) {
            if ("R".equals(split[i])) {
                ++x;
                b = true;
            }
            else if (b) {
                break;
            }
        }
        printWriter.println(x);
        bufferedReader.close();
        printWriter.close();
    }
}
