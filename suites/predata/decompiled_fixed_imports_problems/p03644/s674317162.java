import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.io.Reader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Main
{
    public static void main(final String[] array) throws IOException {
        final FastScanner fastScanner = new FastScanner();
        final int[] array2 = { 1, 2, 4, 8, 16, 32, 64, 128 };
        final int nextInt = fastScanner.nextInt();
        int n = 0;
        for (int i = 0; i < array2.length; ++i) {
            if (array2[i] > nextInt) {
                n = i;
                break;
            }
        }
        System.out.println(array2[n - 1]);
    }
    
    public static class FastScanner
    {
        BufferedReader br;
        StringTokenizer st;
        
        public FastScanner(final String fileName) {
            try {
                this.br = new BufferedReader(new FileReader(fileName));
            }
            catch (final FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        
        public FastScanner() {
            this.br = new BufferedReader(new InputStreamReader(System.in));
        }
        
        String nextToken() {
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
        
        String nextLine() {
            this.st = null;
            try {
                return this.br.readLine();
            }
            catch (final IOException ex) {
                ex.printStackTrace();
                return null;
            }
        }
        
        int nextInt() {
            return Integer.parseInt(this.nextToken());
        }
        
        long nextLong() {
            return Long.parseLong(this.nextToken());
        }
        
        double nextDouble() {
            return Double.parseDouble(this.nextToken());
        }
    }
}