import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.util.HashSet;

public class Main
{
    public static void main(final String[] array) {
        final FastReader fastReader = new FastReader();
        final int nextInt = fastReader.nextInt();
        final int nextInt2 = fastReader.nextInt();
        if (nextInt2 == 0) {
            System.out.println(nextInt);
        }
        else {
            final HashSet set = new HashSet();
            for (int i = 0; i < nextInt2; ++i) {
                set.add(fastReader.nextInt());
            }
            if (!set.contains(nextInt)) {
                System.out.println(nextInt);
            }
            else {
                int j;
                for (j = nextInt + 1; set.contains(j); ++j) {}
                int n;
                for (n = nextInt - 1; set.contains(n); --n) {}
                final int n2 = j - nextInt;
                final int n3 = 0;
                int n4;
                if (n < 0) {
                    n4 = n3 + nextInt + Math.abs(n);
                }
                else {
                    n4 = nextInt - n;
                }
                if (n2 < n4) {
                    System.out.println(nextInt + n2);
                }
                else {
                    System.out.println(nextInt - n4);
                }
            }
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
                    if (this.st.hasMoreElements()) {
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
    }
}