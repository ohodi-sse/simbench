import java.io.Reader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.BufferedOutputStream;
import java.util.List;
import java.io.PrintWriter;





public class Main
{
    public static PrintWriter out;
    public static final int MAX = 100000;
    static List<Integer>[] edge;
    private static int N;
    
    public static void main(final String[] array) {
        final FastReader fastReader = new FastReader();
        final char[] charArray = fastReader.next().toCharArray();
        final char[] charArray2 = fastReader.next().toCharArray();
        int i = 0;
        for (int j = 0; j < 3; ++j) {
            if (charArray[j] == charArray2[j]) {
                ++i;
            }
        }
        Main.out.print(i);
        Main.out.close();
    }
    
    static {
        Main.out = new PrintWriter(new BufferedOutputStream(System.out));
        Main.N = 200011;
    }
    
    public static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;
        
        public FastReader() {
            this.br = new BufferedReader(new InputStreamReader(System.in));
        }
        
        String next() {
            while (true) {
                if (this.st != null) {
                    if (this.st.hasMoreTokens()) {
                        break;
                    }
                }
                try {
                    this.st = new StringTokenizer(this.br.readLine());
                }
                catch (final Exception ex) {
                    ex.printStackTrace();
                }
            }
            return this.st.nextToken();
        }
        
        int nextInt() {
            return Integer.parseInt(this.next());
        }
        
        double nextDouble() {
            return Double.parseDouble(this.next());
        }
        
        long nextLong() {
            return Long.parseLong(this.next());
        }
        
        String nextLine() {
            String line = "";
            try {
                line = this.br.readLine();
            }
            catch (final Exception ex) {
                ex.printStackTrace();
            }
            return line;
        }
    }
}