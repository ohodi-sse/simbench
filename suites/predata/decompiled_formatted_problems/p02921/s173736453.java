import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;





public class Main
{
    public static void main(final String[] array) {
        final FastIO fastIO = new FastIO();
        int x = 0;
        final String read = fastIO.read();
        final String read2 = fastIO.read();
        for (int i = 0; i < read.length(); ++i) {
            if (read.charAt(i) == read2.charAt(i)) {
                ++x;
            }
        }
        System.out.println(x);
    }
    
    private static class FastIO
    {
        private StringTokenizer stringTokenizer;
        private BufferedReader bufferedReader;
        
        public FastIO() {
            this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            this.stringTokenizer = null;
        }
        
        public String read() {
            if (this.stringTokenizer != null) {
                if (this.stringTokenizer.hasMoreTokens()) {
                    return this.stringTokenizer.nextToken();
                }
            }
            try {
                this.stringTokenizer = new StringTokenizer(this.bufferedReader.readLine());
            }
            catch (final IOException cause) {
                throw new RuntimeException(cause);
            }
            return this.stringTokenizer.nextToken();
        }
        
        public int readInt() {
            return Integer.parseInt(this.read());
        }
        
        public long readLong() {
            return Long.parseLong(this.read());
        }
    }
}