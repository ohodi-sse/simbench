import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.util.StringTokenizer;
import java.io.BufferedReader;

// 
// Decompiled by Procyon v0.6.0
// 

static class InputReader
{
    BufferedReader br;
    StringTokenizer st;
    
    public InputReader(final InputStream in) {
        this.br = new BufferedReader(new InputStreamReader(in));
    }
    
    public String nextToken() {
        while (this.st == null || !this.st.hasMoreTokens()) {
            String line;
            try {
                line = this.br.readLine();
            }
            catch (final IOException cause) {
                throw new RuntimeException(cause);
            }
            if (line == null) {
                return null;
            }
            this.st = new StringTokenizer(line);
        }
        return this.st.nextToken();
    }
    
    public int nextInt() {
        return Integer.parseInt(this.nextToken());
    }
    
    public long nextLong() {
        return Long.parseLong(this.nextToken());
    }
}
import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
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
        new Task().solve(inputReader, printWriter);
        printWriter.close();
    }
    
    static class Task
    {
        public void solve(final InputReader inputReader, final PrintWriter printWriter) {
            final int nextInt = inputReader.nextInt();
            final int nextInt2 = inputReader.nextInt();
            final int[] array = new int[nextInt2];
            final boolean[] array2 = new boolean[101];
            for (int i = 0; i < nextInt2; ++i) {
                array2[inputReader.nextInt()] = true;
            }
            int x = 101;
            int x2 = 0;
            for (int j = nextInt; j >= 0; --j) {
                if (!array2[j]) {
                    x2 = j;
                    break;
                }
            }
            for (int k = nextInt + 1; k <= 100; ++k) {
                if (!array2[k]) {
                    x = k;
                    break;
                }
            }
            if (x - nextInt < nextInt - x2) {
                printWriter.println(x);
            }
            else {
                printWriter.println(x2);
            }
        }
    }
    
    static class InputReader
    {
        BufferedReader br;
        StringTokenizer st;
        
        public InputReader(final InputStream in) {
            this.br = new BufferedReader(new InputStreamReader(in));
        }
        
        public String nextToken() {
            while (this.st == null || !this.st.hasMoreTokens()) {
                String line;
                try {
                    line = this.br.readLine();
                }
                catch (final IOException cause) {
                    throw new RuntimeException(cause);
                }
                if (line == null) {
                    return null;
                }
                this.st = new StringTokenizer(line);
            }
            return this.st.nextToken();
        }
        
        public int nextInt() {
            return Integer.parseInt(this.nextToken());
        }
        
        public long nextLong() {
            return Long.parseLong(this.nextToken());
        }
    }
}
import java.io.PrintWriter;

// 
// Decompiled by Procyon v0.6.0
// 

static class Task
{
    public void solve(final InputReader inputReader, final PrintWriter printWriter) {
        final int nextInt = inputReader.nextInt();
        final int nextInt2 = inputReader.nextInt();
        final int[] array = new int[nextInt2];
        final boolean[] array2 = new boolean[101];
        for (int i = 0; i < nextInt2; ++i) {
            array2[inputReader.nextInt()] = true;
        }
        int x = 101;
        int x2 = 0;
        for (int j = nextInt; j >= 0; --j) {
            if (!array2[j]) {
                x2 = j;
                break;
            }
        }
        for (int k = nextInt + 1; k <= 100; ++k) {
            if (!array2[k]) {
                x = k;
                break;
            }
        }
        if (x - nextInt < nextInt - x2) {
            printWriter.println(x);
        }
        else {
            printWriter.println(x2);
        }
    }
}
