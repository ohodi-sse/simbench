import java.io.Reader;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;





public class Main
{
    public static void main(final String[] array) throws IOException {
        new Main().solve();
    }
    
    public void solve() throws IOException {
        final FastScanner fastScanner = new FastScanner();
        final String next = fastScanner.next();
        final String next2 = fastScanner.next();
        int x = 0;
        for (int i = 0; i < next.length(); ++i) {
            if (next.charAt(i) == next2.charAt(i)) {
                ++x;
            }
        }
        System.out.println(x);
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