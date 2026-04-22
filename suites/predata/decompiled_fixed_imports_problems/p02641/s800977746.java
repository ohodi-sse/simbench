import java.io.Reader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main
{
    static int divisors(final long n) {
        long n2 = n;
        int n3 = 0;
        if (n == 1L) {
            return 1;
        }
        for (int n4 = 1; n4 < n2; ++n4) {
            if (n % n4 == 0L) {
                n2 = n / n4;
                if (n2 != n4) {
                    ++n3;
                }
                ++n3;
            }
        }
        return n3;
    }
    
    public static void main(final String[] array) throws IOException {
        final FastReader fastReader = new FastReader();
        final int nextInt = fastReader.nextInt();
        final int nextInt2 = fastReader.nextInt();
        final ArrayList list = new ArrayList();
        for (int i = 0; i < nextInt2; ++i) {
            list.add(fastReader.nextInt());
        }
        int j = 0;
        int n = 0;
        while (j == 0) {
            if (!list.contains(nextInt - n)) {
                j = 1;
                System.out.println(nextInt - n);
            }
            else if (!list.contains(nextInt + n)) {
                j = 1;
                System.out.println(nextInt + n);
            }
            ++n;
        }
    }
    
    static class FastReader
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
                catch (final IOException ex) {
                    ex.printStackTrace();
                }
            }
            return this.st.nextToken();
        }
        
        int nextInt() {
            return Integer.parseInt(this.next());
        }
        
        long nextLong() {
            return Long.parseLong(this.next());
        }
        
        double nextDouble() {
            return Double.parseDouble(this.next());
        }
        
        String nextLine() {
            String line = "";
            try {
                line = this.br.readLine();
            }
            catch (final IOException ex) {
                ex.printStackTrace();
            }
            return line;
        }
        
        public Character charAt(final int n) {
            return null;
        }
    }
}