import java.io.IOException;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

// 
// Decompiled by Procyon v0.6.0
// 

final class Main
{
    private static void main$3231c38a() throws IOException {
        final PrintWriter printWriter = new PrintWriter(System.out);
        final String line = new BufferedReader(new InputStreamReader(System.in)).readLine();
        int x = 0;
        if (line.equals("RRS") || line.equals("SRR")) {
            x = 2;
        }
        else if (line.equals("RRR")) {
            x = 3;
        }
        else if (line.contains("R")) {
            x = 1;
        }
        printWriter.println(x);
        printWriter.close();
    }
}
