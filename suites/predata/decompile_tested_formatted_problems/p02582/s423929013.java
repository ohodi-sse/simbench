import java.io.IOException;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) throws IOException {
        final PrintWriter printWriter = new PrintWriter(System.out);
        final String line = new BufferedReader(new InputStreamReader(System.in)).readLine();
        int x;
        if (line.charAt(0) == 'R' && line.charAt(1) == 'R' && line.charAt(2) == 'R') {
            x = 3;
        }
        else if (line.charAt(0) == 'R' && line.charAt(1) == 'R') {
            x = 2;
        }
        else if (line.charAt(1) == 'R' && line.charAt(2) == 'R') {
            x = 2;
        }
        else if (line.charAt(0) == 'S' && line.charAt(1) == 'S' && line.charAt(2) == 'S') {
            x = 0;
        }
        else {
            x = 1;
        }
        printWriter.println(x);
        printWriter.close();
    }
}
