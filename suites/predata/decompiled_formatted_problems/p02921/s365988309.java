import java.io.Reader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;





public class Main
{
    public static void main(final String[] array) throws IOException {
        final Scanner scanner = new Scanner();
        final PrintWriter printWriter = new PrintWriter(System.out);
        final char[] charArray = scanner.next().toCharArray();
        final char[] charArray2 = scanner.next().toCharArray();
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            if (charArray[i] == charArray2[i]) {
                ++x;
            }
        }
        printWriter.println(x);
        printWriter.flush();
        printWriter.close();
    }
    
    static class Scanner
    {
        BufferedReader br;
        StringTokenizer st;
        
        Scanner() {
            this.br = new BufferedReader(new InputStreamReader(System.in));
        }
        
        String next() throws IOException {
            while (this.st == null || !this.st.hasMoreTokens()) {
                this.st = new StringTokenizer(this.br.readLine());
            }
            return this.st.nextToken();
        }
        
        int nextInt() throws IOException {
            return Integer.parseInt(this.next());
        }
        
        long nextLong() throws IOException {
            return Long.parseLong(this.next());
        }
        
        Integer[] nextIntegerArray(final int n) throws IOException {
            final Integer[] array = new Integer[n];
            for (int i = 0; i < n; ++i) {
                array[i] = this.nextInt();
            }
            return array;
        }
        
        double nextDouble() throws IOException {
            return Double.parseDouble(this.next());
        }
        
        int[] nextIntArray(final int n) throws IOException {
            final int[] array = new int[n];
            for (int i = 0; i < n; ++i) {
                array[i] = this.nextInt() - 1;
            }
            return array;
        }
    }
}