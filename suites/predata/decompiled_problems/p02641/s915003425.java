import java.io.Reader;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.util.Arrays;
import java.io.IOException;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) throws IOException {
        new Main().solve();
    }
    
    public void solve() throws IOException {
        final FastScanner fastScanner = new FastScanner();
        final int nextInt = fastScanner.nextInt();
        final int nextInt2 = fastScanner.nextInt();
        if (nextInt2 == 0) {
            System.out.println(nextInt);
            return;
        }
        final int[] nextIntArr = fastScanner.nextIntArr(nextInt2);
        Arrays.sort(nextIntArr);
        int abs = 1000000;
        int x = -1;
        for (int i = 0; i < 1000; ++i) {
            if (!this.exist(nextIntArr, i)) {
                if (Math.abs(i - nextInt) < abs) {
                    abs = Math.abs(i - nextInt);
                    x = i;
                }
            }
        }
        System.out.println(x);
    }
    
    boolean exist(final int[] array, final int n) {
        for (int length = array.length, i = 0; i < length; ++i) {
            if (array[i] == n) {
                return true;
            }
        }
        return false;
    }
    
    public class FastScanner
    {
        BufferedReader reader;
        private StringTokenizer st;
        
        public FastScanner(final Main obj) {
            Objects.requireNonNull(obj);
            this.st = null;
            this.reader = new BufferedReader(new InputStreamReader(System.in));
        }
        
        public String next() throws IOException {
            if (this.st == null || !this.st.hasMoreElements()) {
                this.st = new StringTokenizer(this.reader.readLine());
            }
            return this.st.nextToken();
        }
        
        public String nextLine() throws IOException {
            this.st = null;
            return this.reader.readLine();
        }
        
        public int nextInt() throws NumberFormatException, IOException {
            return Integer.parseInt(this.next());
        }
        
        public long nextLong() throws NumberFormatException, IOException {
            return Long.parseLong(this.next());
        }
        
        public int[] nextIntArr(final int n) throws NumberFormatException, IOException {
            final int[] array = new int[n];
            for (int i = 0; i < n; ++i) {
                array[i] = this.nextInt();
            }
            return array;
        }
        
        public long[] nextLongArr(final int n) throws NumberFormatException, IOException {
            final long[] array = new long[n];
            for (int i = 0; i < n; ++i) {
                array[i] = this.nextLong();
            }
            return array;
        }
        
        public void close() throws IOException {
            this.reader.close();
        }
    }
}
import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;
import java.io.BufferedReader;

// 
// Decompiled by Procyon v0.6.0
// 

public class FastScanner
{
    BufferedReader reader;
    private StringTokenizer st;
    
    public FastScanner(final Main obj) {
        Objects.requireNonNull(obj);
        this.st = null;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }
    
    public String next() throws IOException {
        if (this.st == null || !this.st.hasMoreElements()) {
            this.st = new StringTokenizer(this.reader.readLine());
        }
        return this.st.nextToken();
    }
    
    public String nextLine() throws IOException {
        this.st = null;
        return this.reader.readLine();
    }
    
    public int nextInt() throws NumberFormatException, IOException {
        return Integer.parseInt(this.next());
    }
    
    public long nextLong() throws NumberFormatException, IOException {
        return Long.parseLong(this.next());
    }
    
    public int[] nextIntArr(final int n) throws NumberFormatException, IOException {
        final int[] array = new int[n];
        for (int i = 0; i < n; ++i) {
            array[i] = this.nextInt();
        }
        return array;
    }
    
    public long[] nextLongArr(final int n) throws NumberFormatException, IOException {
        final long[] array = new long[n];
        for (int i = 0; i < n; ++i) {
            array[i] = this.nextLong();
        }
        return array;
    }
    
    public void close() throws IOException {
        this.reader.close();
    }
}
