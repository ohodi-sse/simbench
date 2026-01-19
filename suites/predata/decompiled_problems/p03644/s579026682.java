import java.io.Reader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.StringTokenizer;
import java.io.BufferedReader;

// 
// Decompiled by Procyon v0.6.0
// 

static class InputReader
{
    BufferedReader in;
    StringTokenizer tok;
    
    public String nextString() {
        while (!this.tok.hasMoreTokens()) {
            try {
                this.tok = new StringTokenizer(this.in.readLine(), " ");
                continue;
            }
            catch (final IOException ex) {
                throw new InputMismatchException();
            }
            break;
        }
        return this.tok.nextToken();
    }
    
    public int nextInt() {
        return Integer.parseInt(this.nextString());
    }
    
    public InputReader(final InputStream in) {
        this.in = new BufferedReader(new InputStreamReader(in));
        this.tok = new StringTokenizer("");
    }
}
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.PrintStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final InputStream in = System.in;
        final PrintStream out = System.out;
        final InputReader inputReader = new InputReader(in);
        final PrintWriter printWriter = new PrintWriter(out);
        new TaskB().solve(1, inputReader, printWriter);
        printWriter.close();
    }
    
    static class TaskB
    {
        public void solve(final int n, final InputReader inputReader, final PrintWriter printWriter) {
            int nextInt;
            int x;
            for (nextInt = inputReader.nextInt(), x = 1; x * 2 <= nextInt; x *= 2) {}
            printWriter.println(x);
        }
    }
    
    static class InputReader
    {
        BufferedReader in;
        StringTokenizer tok;
        
        public String nextString() {
            while (!this.tok.hasMoreTokens()) {
                try {
                    this.tok = new StringTokenizer(this.in.readLine(), " ");
                    continue;
                }
                catch (final IOException ex) {
                    throw new InputMismatchException();
                }
                break;
            }
            return this.tok.nextToken();
        }
        
        public int nextInt() {
            return Integer.parseInt(this.nextString());
        }
        
        public InputReader(final InputStream in) {
            this.in = new BufferedReader(new InputStreamReader(in));
            this.tok = new StringTokenizer("");
        }
    }
}
import java.io.PrintWriter;

// 
// Decompiled by Procyon v0.6.0
// 

static class TaskB
{
    public void solve(final int n, final InputReader inputReader, final PrintWriter printWriter) {
        int nextInt;
        int x;
        for (nextInt = inputReader.nextInt(), x = 1; x * 2 <= nextInt; x *= 2) {}
        printWriter.println(x);
    }
}
