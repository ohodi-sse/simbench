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
        final String line;
        final String substring = (line = new BufferedReader(new InputStreamReader(System.in)).readLine()).substring(0, 1);
        final String substring2 = line.substring(1, 2);
        final String substring3 = line.substring(2, 3);
        int x = 0;
        if (substring.equals("R")) {
            x = 1;
            if (substring2.equals("R")) {
                x = 2;
                if (substring3.equals("R")) {
                    x = 3;
                }
            }
        }
        else if (substring2.equals("R")) {
            x = 1;
            if (substring3.equals("R")) {
                x = 2;
            }
        }
        else if (substring3.equals("R")) {
            x = 1;
        }
        System.out.println(x);
    }
}
