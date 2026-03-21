import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.math.BigInteger;
import java.io.PrintStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;





public class Main
{
    public static void main(final String[] array) {
        final InputStream in = System.in;
        final PrintStream out = System.out;
        final MyScanner myScanner = new MyScanner(in);
        final PrintWriter printWriter = new PrintWriter(out);
        new C().solve(1, myScanner, printWriter);
        printWriter.close();
    }
    
    static class C
    {
        public void solve(final int n, final MyScanner myScanner, final PrintWriter printWriter) {
            printWriter.println(BigInteger.valueOf(myScanner.Long()).multiply(BigInteger.valueOf(Math.round(myScanner.Double() * 100.0))).divide(BigInteger.valueOf(100L)).toString());
        }
    }
    
    static class MyScanner
    {
        private BufferedReader in;
        private StringTokenizer st;
        
        public MyScanner(final InputStream in) {
            this.in = new BufferedReader(new InputStreamReader(in));
        }
        
        public String next() {
            while (true) {
                if (this.st != null) {
                    if (this.st.hasMoreTokens()) {
                        break;
                    }
                }
                try {
                    final String line = this.in.readLine();
                    if (line == null) {
                        return null;
                    }
                    this.st = new StringTokenizer(line);
                    continue;
                }
                catch (final IOException ex) {
                    return null;
                }
                break;
            }
            return this.st.nextToken();
        }
        
        public long Long() {
            return Long.parseLong(this.next());
        }
        
        public double Double() {
            return Double.parseDouble(this.next());
        }
    }
}