import java.math.BigInteger;
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
    public BufferedReader reader;
    public StringTokenizer tokenizer;
    
    public InputReader(final InputStream in) {
        this.reader = new BufferedReader(new InputStreamReader(in), 32768);
        this.tokenizer = null;
    }
    
    public String next() {
        while (true) {
            if (this.tokenizer != null) {
                if (this.tokenizer.hasMoreTokens()) {
                    break;
                }
            }
            try {
                this.tokenizer = new StringTokenizer(this.reader.readLine());
                continue;
            }
            catch (final IOException cause) {
                throw new RuntimeException(cause);
            }
            break;
        }
        return this.tokenizer.nextToken();
    }
    
    public int nextInt() {
        return Integer.parseInt(this.next());
    }
    
    public long nextLong() {
        return Long.parseLong(this.next());
    }
    
    public double nextDouble() {
        return Double.parseDouble(this.next());
    }
    
    public String nextLine() {
        try {
            return this.reader.readLine();
        }
        catch (final Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public boolean hasNext() {
        String line = null;
        try {
            line = this.reader.readLine();
        }
        catch (final Exception ex) {}
        if (line == null) {
            return false;
        }
        this.tokenizer = new StringTokenizer(line);
        return true;
    }
    
    public int[] nextInta(final int n) {
        final int[] array = new int[n];
        for (int i = 0; i < n; ++i) {
            array[i] = this.nextInt();
        }
        return array;
    }
    
    public long[] nextLonga(final int n) {
        final long[] array = new long[n];
        for (int i = 0; i < n; ++i) {
            array[i] = this.nextLong();
        }
        return array;
    }
    
    public int[][] nextIntm(final int n, final int n2) {
        final int[][] array = new int[n][n2];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n2; ++j) {
                array[i][j] = this.nextInt();
            }
        }
        return array;
    }
    
    public long[][] nextLongm(final int n, final int n2) {
        final long[][] array = new long[n][n2];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n2; ++j) {
                array[i][j] = this.nextLong();
            }
        }
        return array;
    }
    
    public BigInteger nextBigInteger() {
        return new BigInteger(this.next());
    }
}
import java.math.BigInteger;
import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.util.Random;
import java.util.Arrays;
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
        final Task task = new Task();
        for (int n = 1, i = 1; i <= n; ++i) {
            task.solve(i, inputReader, printWriter);
        }
        printWriter.close();
    }
    
    static void sort(final int[] a) {
        shuffle(a);
        Arrays.sort(a);
    }
    
    static void sort(final long[] a) {
        shuffle(a);
        Arrays.sort(a);
    }
    
    static void shuffle(final int[] array) {
        final Random random = new Random();
        for (int i = 0; i < array.length; ++i) {
            final int nextInt = random.nextInt(array.length);
            final int n = array[i];
            array[i] = array[nextInt];
            array[nextInt] = n;
        }
    }
    
    static void shuffle(final long[] array) {
        final Random random = new Random();
        for (int i = 0; i < array.length; ++i) {
            final int nextInt = random.nextInt(array.length);
            final long n = array[i];
            array[i] = array[nextInt];
            array[nextInt] = n;
        }
    }
    
    static class Task
    {
        public void solve(final int n, final InputReader inputReader, final PrintWriter printWriter) {
            final char[] charArray = inputReader.next().toCharArray();
            int n2 = 0;
            int max = 0;
            for (int i = 0; i < 3; ++i) {
                if (charArray[i] == 'R') {
                    ++n2;
                }
                else {
                    max = Math.max(max, n2);
                    n2 = 0;
                }
            }
            printWriter.println(Math.max(max, n2));
        }
    }
    
    static class InputReader
    {
        public BufferedReader reader;
        public StringTokenizer tokenizer;
        
        public InputReader(final InputStream in) {
            this.reader = new BufferedReader(new InputStreamReader(in), 32768);
            this.tokenizer = null;
        }
        
        public String next() {
            while (true) {
                if (this.tokenizer != null) {
                    if (this.tokenizer.hasMoreTokens()) {
                        break;
                    }
                }
                try {
                    this.tokenizer = new StringTokenizer(this.reader.readLine());
                    continue;
                }
                catch (final IOException cause) {
                    throw new RuntimeException(cause);
                }
                break;
            }
            return this.tokenizer.nextToken();
        }
        
        public int nextInt() {
            return Integer.parseInt(this.next());
        }
        
        public long nextLong() {
            return Long.parseLong(this.next());
        }
        
        public double nextDouble() {
            return Double.parseDouble(this.next());
        }
        
        public String nextLine() {
            try {
                return this.reader.readLine();
            }
            catch (final Exception ex) {
                ex.printStackTrace();
                return null;
            }
        }
        
        public boolean hasNext() {
            String line = null;
            try {
                line = this.reader.readLine();
            }
            catch (final Exception ex) {}
            if (line == null) {
                return false;
            }
            this.tokenizer = new StringTokenizer(line);
            return true;
        }
        
        public int[] nextInta(final int n) {
            final int[] array = new int[n];
            for (int i = 0; i < n; ++i) {
                array[i] = this.nextInt();
            }
            return array;
        }
        
        public long[] nextLonga(final int n) {
            final long[] array = new long[n];
            for (int i = 0; i < n; ++i) {
                array[i] = this.nextLong();
            }
            return array;
        }
        
        public int[][] nextIntm(final int n, final int n2) {
            final int[][] array = new int[n][n2];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n2; ++j) {
                    array[i][j] = this.nextInt();
                }
            }
            return array;
        }
        
        public long[][] nextLongm(final int n, final int n2) {
            final long[][] array = new long[n][n2];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n2; ++j) {
                    array[i][j] = this.nextLong();
                }
            }
            return array;
        }
        
        public BigInteger nextBigInteger() {
            return new BigInteger(this.next());
        }
    }
}
import java.io.PrintWriter;

// 
// Decompiled by Procyon v0.6.0
// 

static class Task
{
    public void solve(final int n, final InputReader inputReader, final PrintWriter printWriter) {
        final char[] charArray = inputReader.next().toCharArray();
        int n2 = 0;
        int max = 0;
        for (int i = 0; i < 3; ++i) {
            if (charArray[i] == 'R') {
                ++n2;
            }
            else {
                max = Math.max(max, n2);
                n2 = 0;
            }
        }
        printWriter.println(Math.max(max, n2));
    }
}
