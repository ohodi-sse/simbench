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
        int i = 0;
        for (int j = 0; j < 3; ++j) {
            if (line.charAt(j) == line2.charAt(j)) {
                ++i;
            }
        }
        System.out.print(i);
    }
}
