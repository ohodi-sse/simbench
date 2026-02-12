import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() throws NumberFormatException, IOException {
        final FastReader fastReader = new FastReader();
        final PrintWriter printWriter = new PrintWriter(System.out);
        final int int1 = Integer.parseInt(fastReader.next());
        int x = 0;
        int n = -1;
        for (int i = 1; i <= int1; ++i) {
            int n2;
            int n3;
            for (n2 = i, n3 = 0; n2 % 2 == 0; n2 /= 2, ++n3) {}
            if (n3 >= n) {
                n = n3;
                x = i;
            }
        }
        printWriter.println(x);
        printWriter.close();
    }
    
    static final class FastReader
    {
        private BufferedReader br;
        private BufferedReader br1;
        private StringTokenizer st;
        
        public FastReader() {
            this.br = new BufferedReader(new InputStreamReader(System.in));
        }
        
        private FastReader(final String fileName) throws FileNotFoundException {
            this.br = new BufferedReader(new FileReader(fileName));
        }
        
        final String next() {
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
        
        private int nextInt() {
            return Integer.parseInt(this.next());
        }
        
        private long nextLong() {
            return Long.parseLong(this.next());
        }
        
        private double nextDouble() {
            return Double.parseDouble(this.next());
        }
        
        private char[][] readCharArray(final int n, final int n2) {
            final char[][] array = new char[n][n2];
            for (int i = 0; i < n; ++i) {
                final String nextLine = this.nextLine();
                for (int j = 0; j < n; ++j) {
                    array[i][j] = nextLine.charAt(j);
                }
            }
            return array;
        }
        
        private char[][] readCharArray(final int n) {
            final char[][] array = new char[n][n];
            for (int i = 0; i < n; ++i) {
                final String nextLine = this.nextLine();
                for (int j = 0; j < n; ++j) {
                    array[i][j] = nextLine.charAt(j);
                }
            }
            return array;
        }
        
        private int[] readArray(final int n) {
            final int[] array = new int[n];
            for (int i = 0; i < n; ++i) {
                array[i] = Integer.parseInt(this.next());
            }
            return array;
        }
        
        private long[] readLongArray(final int n) {
            final long[] array = new long[n];
            for (int i = 0; i < n; ++i) {
                array[i] = Long.parseLong(this.next());
            }
            return array;
        }
        
        private String nextLine() {
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
