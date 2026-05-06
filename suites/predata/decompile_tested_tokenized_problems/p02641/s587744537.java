import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.util.StringTokenizer;
import java.io.BufferedReader;

// 
// Decompiled by Procyon v0.6.0
// 

class InputReader
{
    BufferedReader br;
    StringTokenizer st;
    
    public InputReader(final InputStream in) {
        this.br = new BufferedReader(new InputStreamReader(in));
        this.st = null;
    }
    
    public String next() {
        while (true) {
            if (this.st != null) {
                if (this.st.hasMoreTokens()) {
                    break;
                }
            }
            try {
                this.st = new StringTokenizer(this.br.readLine());
                continue;
            }
            catch (final IOException cause) {
                throw new RuntimeException(cause);
            }
            break;
        }
        return this.st.nextToken();
    }
    
    public int nextInt() {
        return Integer.parseInt(this.next());
    }
    
    public long nextLong() {
        return Long.parseLong(this.next());
    }
    
    public double nextDouble() {
        return Double.parseDouble(this.next());
    }
}
import java.io.PrintWriter;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final InputReader inputReader = new InputReader(System.in);
        final PrintWriter printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)), true);
        new TaskB().solve(1, inputReader, printWriter);
        printWriter.flush();
        printWriter.close();
    }
}
// 
// Decompiled by Procyon v0.6.0
// 

class Pair
{
    int first;
    int second;
    
    Pair(final int first, final int second) {
        this.first = first;
        this.second = second;
    }
}
import java.util.Arrays;
import java.io.PrintWriter;

// 
// Decompiled by Procyon v0.6.0
// 

class TaskB
{
    public void solve(final int n, final InputReader inputReader, final PrintWriter printWriter) {
        final int nextInt = inputReader.nextInt();
        final int nextInt2 = inputReader.nextInt();
        final boolean[] a = new boolean[102];
        Arrays.fill(a, true);
        final int[] array = new int[nextInt2];
        for (int i = 0; i < nextInt2; ++i) {
            a[array[i] = inputReader.nextInt()] = false;
        }
        int n2 = Integer.MAX_VALUE;
        int x = -1;
        for (int j = 0; j <= nextInt; ++j) {
            if (a[j]) {
                final int abs = Math.abs(nextInt - j);
                if (abs < n2) {
                    x = j;
                    n2 = abs;
                }
            }
        }
        for (int k = nextInt + 1; k <= 101; ++k) {
            if (a[k]) {
                final int abs2 = Math.abs(nextInt - k);
                if (abs2 < n2) {
                    x = k;
                    n2 = abs2;
                }
            }
        }
        printWriter.println(x);
    }
    
    long __gcd(final long n, final long n2) {
        if (n2 == 0L) {
            return n;
        }
        return this.__gcd(n2, n % n2);
    }
    
    public int getInt(final int n) {
        int n2 = -1;
        switch (n) {
            case 0: {
                n2 = 6;
                break;
            }
            case 1: {
                n2 = 2;
                break;
            }
            case 2: {
                n2 = 5;
                break;
            }
            case 3: {
                n2 = 5;
                break;
            }
            case 4: {
                n2 = 4;
                break;
            }
            case 5: {
                n2 = 5;
                break;
            }
            case 6: {
                n2 = 6;
                break;
            }
            case 7: {
                n2 = 3;
                break;
            }
            case 8: {
                n2 = 7;
                break;
            }
            case 9: {
                n2 = 6;
                break;
            }
        }
        return n2;
    }
    
    public int isPow(long n) {
        int n2;
        for (n2 = 0; n > 0L; n /= 2L, ++n2) {}
        return n2;
    }
}
