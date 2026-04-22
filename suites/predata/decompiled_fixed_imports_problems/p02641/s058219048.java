import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main
{
    public static void main(final String[] array) throws IOException {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        final int[] array2 = new int[nextInt2];
        final int[] array3 = new int[102];
        for (int i = 0; i < nextInt2; ++i) {
            array2[i] = scanner.nextInt();
            final int[] array4 = array3;
            final int n = array2[i];
            ++array4[n];
        }
        int x = 0;
        int abs = Integer.MAX_VALUE;
        for (int j = 0; j <= 101; ++j) {
            if (array3[j] == 0 && Math.abs(nextInt - j) < abs) {
                abs = Math.abs(nextInt - j);
                x = j;
            }
        }
        System.out.println(x);
    }
}











class Scanner
{
    StringTokenizer st;
    BufferedReader br;
    
    public Scanner(final InputStream in) {
        this.br = new BufferedReader(new InputStreamReader(in));
    }
    
    public String next() throws IOException {
        while (this.st == null || !this.st.hasMoreTokens()) {
            this.st = new StringTokenizer(this.br.readLine());
        }
        return this.st.nextToken();
    }
    
    public int nextInt() throws IOException {
        return Integer.parseInt(this.next());
    }
    
    public long nextLong() throws IOException {
        return Long.parseLong(this.next());
    }
    
    public String nextLine() throws IOException {
        return this.br.readLine();
    }
    
    public double nextDouble() throws IOException {
        final String next = this.next();
        StringBuilder sb = new StringBuilder("0");
        double n = 0.0;
        double n2 = 1.0;
        boolean b = false;
        boolean b2 = false;
        int n3 = 0;
        if (next.charAt(0) == '-') {
            b2 = true;
            ++n3;
        }
        for (int i = n3; i < next.length(); ++i) {
            if (next.charAt(i) == '.') {
                n = (double)Long.parseLong(sb.toString());
                sb = new StringBuilder("0");
                b = true;
            }
            else {
                sb.append(next.charAt(i));
                if (b) {
                    n2 *= 10.0;
                }
            }
        }
        return (n + Long.parseLong(sb.toString()) / n2) * (b2 ? -1 : 1);
    }
    
    public boolean ready() throws IOException {
        return this.br.ready();
    }
}