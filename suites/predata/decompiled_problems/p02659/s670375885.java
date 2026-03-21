import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;





class FastReader
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
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;





public class Main
{
    public static void main(final String[] array) throws IOException {
        final FastReader fastReader = new FastReader();
        final PrintWriter printWriter = new PrintWriter(System.out);
        System.out.println((long)(fastReader.nextDouble() * 100.0 + 0.05) * fastReader.nextLong() / 100L);
    }
}