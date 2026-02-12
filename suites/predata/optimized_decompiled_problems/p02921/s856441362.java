import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() throws Exception {
        final BufferedReader bufferedReader;
        final String line = (bufferedReader = new BufferedReader(new InputStreamReader(System.in))).readLine();
        final String line2 = bufferedReader.readLine();
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            if (line.charAt(i) == line2.charAt(i)) {
                ++x;
            }
        }
        System.out.println(x);
    }
}
