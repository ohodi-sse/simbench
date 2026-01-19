import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.util.StringTokenizer;
import java.io.BufferedReader;

// 
// Decompiled by Procyon v0.6.0
// 

private static class InputReader
{
    private BufferedReader br;
    private StringTokenizer st;
    
    public InputReader(final InputStream in) {
        this.br = new BufferedReader(new InputStreamReader(in), 32768);
        this.st = null;
    }
    
    public String nextToken() {
        while (true) {
            if (this.st != null) {
                if (this.st.hasMoreTokens()) {
                    break;
                }
            }
            try {
                this.st = new StringTokenizer(this.br.readLine());
                continue;
            }
            catch (final IOException cause) {
                throw new RuntimeException(cause);
            }
            break;
        }
        return this.st.nextToken();
    }
    
    public int nextInt() {
        return Integer.parseInt(this.nextToken());
    }
    
    public long nextLong() {
        return Long.parseLong(this.nextToken());
    }
    
    public double nextDouble() {
        return Double.parseDouble(this.nextToken());
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
import java.io.FileInputStream;
import java.io.File;
import java.util.HashSet;
import java.io.PrintWriter;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    private static final String INPUT_FILE_PATH = "";
    
    static void solve(final InputReader inputReader, final PrintWriter printWriter) {
        final int nextInt = inputReader.nextInt();
        final int nextInt2 = inputReader.nextInt();
        final int[] array = new int[nextInt2];
        final HashSet set = new HashSet();
        for (int i = 0; i < nextInt2; ++i) {
            array[i] = inputReader.nextInt();
            set.add(array[i]);
        }
        int n;
        for (n = 0; set.contains(nextInt - n); ++n) {
            if (!set.contains(nextInt + n)) {
                printWriter.println(nextInt + n);
                return;
            }
        }
        printWriter.println(nextInt - n);
    }
    
    public static void main(final String[] array) throws Exception {
        final InputStream inputStream = "".isEmpty() ? System.in : new FileInputStream(new File(""));
        final PrintStream out = System.out;
        final InputReader inputReader = new InputReader(inputStream);
        final PrintWriter printWriter = new PrintWriter(out);
        solve(inputReader, printWriter);
        printWriter.close();
    }
    
    private static class InputReader
    {
        private BufferedReader br;
        private StringTokenizer st;
        
        public InputReader(final InputStream in) {
            this.br = new BufferedReader(new InputStreamReader(in), 32768);
            this.st = null;
        }
        
        public String nextToken() {
            while (true) {
                if (this.st != null) {
                    if (this.st.hasMoreTokens()) {
                        break;
                    }
                }
                try {
                    this.st = new StringTokenizer(this.br.readLine());
                    continue;
                }
                catch (final IOException cause) {
                    throw new RuntimeException(cause);
                }
                break;
            }
            return this.st.nextToken();
        }
        
        public int nextInt() {
            return Integer.parseInt(this.nextToken());
        }
        
        public long nextLong() {
            return Long.parseLong(this.nextToken());
        }
        
        public double nextDouble() {
            return Double.parseDouble(this.nextToken());
        }
    }
}
