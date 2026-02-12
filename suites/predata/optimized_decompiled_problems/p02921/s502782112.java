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
        final BufferedReader bufferedReader;
        final String line = (bufferedReader = new BufferedReader(new InputStreamReader(System.in))).readLine();
        final String line2 = bufferedReader.readLine();
        final char[] array = new char[3];
        final char[] array2 = new char[3];
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            array[i] = line.charAt(i);
            array2[i] = line2.charAt(i);
            if (array[i] == array2[i]) {
                ++x;
            }
        }
        System.out.println(x);
    }
}
