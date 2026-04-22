import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;

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
    
    Long nextLong() {
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








public class Main
{
    public static void main(final String[] array) throws IOException {
        final PrintWriter printWriter = new PrintWriter(System.out);
        new test().solve(new FastReader(), printWriter);
        printWriter.close();
    }
}









class test
{
    public void solve(final FastReader fastReader, final PrintWriter printWriter) {
        final int nextInt = fastReader.nextInt();
        final int nextInt2 = fastReader.nextInt();
        final ArrayList list = new ArrayList();
        for (int i = 0; i < nextInt2; ++i) {
            list.add(fastReader.nextInt());
        }
        Collections.sort((List<Comparable>)list);
        if (nextInt2 == 0) {
            printWriter.println(nextInt);
        }
        else {
            if (list.contains(nextInt)) {
                while (true) {
                    int n;
                    int n2;
                    for (n = nextInt, n2 = 1; list.contains(n - n2); ++n2) {
                        if (!list.contains(n + n2)) {
                            final int x = n + n2;
                            printWriter.println(x);
                            return;
                        }
                    }
                    final int x = n - n2;
                    continue;
                }
            }
            printWriter.println(nextInt);
        }
    }
}