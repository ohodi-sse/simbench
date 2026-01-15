import java.io.Writer;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    private static final BufferedReader br;
    private static final PrintWriter pw;
    
    public static void main(final String[] array) throws IOException {
        final String line = Main.br.readLine();
        int x;
        if (line.charAt(1) == 'R') {
            x = 1 + ((line.charAt(0) == 'R') ? 1 : 0) + ((line.charAt(2) == 'R') ? 1 : 0);
        }
        else {
            x = ((line.charAt(0) == 'R' | line.charAt(2) == 'R') ? 1 : 0);
        }
        Main.pw.println(x);
        Main.pw.close();
    }
    
    static {
        br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    }
}
