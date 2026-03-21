import java.util.Arrays;
import java.util.HashSet;
import java.io.IOException;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.BufferedReader;





public class Main
{
    BufferedReader br;
    StringTokenizer tokenizer;
    int totalCases;
    int testNum;
    PrintWriter out;
    
    public Main() {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        this.tokenizer = null;
        this.out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    }
    
    void solve() throws IOException {
    }
    
    void execute() throws IOException {
        final int ni = this.ni();
        final int ni2 = this.ni();
        if (ni2 == 0) {
            this.out.println(ni);
            this.out.close();
            return;
        }
        final int[] array = new int[ni2];
        for (int i = 0; i < ni2; ++i) {
            array[i] = this.ni();
        }
        int n = Integer.MAX_VALUE;
        int n2 = array[0];
        final HashSet set = new HashSet();
        for (int j = 0; j < ni2; ++j) {
            set.add(array[j]);
            final int abs = Math.abs(ni - array[j]);
            if (abs < n) {
                n = abs;
                n2 = array[j];
            }
        }
        int n3 = 1;
        while (true) {
            final int n4 = n2 - n3;
            final int n5 = n2 + n3;
            if (!set.contains(n4)) {
                this.out.println(n4);
                break;
            }
            if (!set.contains(n5)) {
                this.out.println(n5);
                break;
            }
            ++n3;
        }
        this.out.close();
    }
    
    public static void main(final String[] array) throws IOException {
        new Main().execute();
    }
    
    void debug(final Object... a) {
        System.out.println(Arrays.deepToString(a));
    }
    
    int ni() throws IOException {
        return Integer.parseInt(this.ns());
    }
    
    long nl() throws IOException {
        return Long.parseLong(this.ns());
    }
    
    double nd() throws IOException {
        return Double.parseDouble(this.ns());
    }
    
    String ns() throws IOException {
        while (this.tokenizer == null || !this.tokenizer.hasMoreTokens()) {
            this.tokenizer = new StringTokenizer(this.br.readLine());
        }
        return this.tokenizer.nextToken();
    }
    
    String nline() throws IOException {
        this.tokenizer = null;
        return this.br.readLine();
    }
    
    boolean input() throws IOException {
        return true;
    }
}