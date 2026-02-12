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

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private BufferedReader br;
    private StringTokenizer tokenizer;
    private int totalCases;
    private int testNum;
    private PrintWriter out;
    
    public Main() {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        this.tokenizer = null;
        this.out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    }
    
    private static void solve() throws IOException {
    }
    
    private void execute() throws IOException {
        final int int1 = Integer.parseInt(this.ns());
        final int int2;
        if ((int2 = Integer.parseInt(this.ns())) == 0) {
            this.out.println(int1);
            this.out.close();
            return;
        }
        final int[] array = new int[int2];
        for (int i = 0; i < int2; ++i) {
            array[i] = Integer.parseInt(this.ns());
        }
        int n = Integer.MAX_VALUE;
        int n2 = array[0];
        final HashSet set = new HashSet();
        for (int j = 0; j < int2; ++j) {
            set.add(array[j]);
            final int abs;
            if ((abs = Math.abs(int1 - array[j])) < n) {
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
    
    private static void main$3231c38a() throws IOException {
        final Main main;
        final int int1 = Integer.parseInt((main = new Main()).ns());
        final int int2;
        if ((int2 = Integer.parseInt(main.ns())) == 0) {
            main.out.println(int1);
        }
        else {
            final int[] array = new int[int2];
            for (int i = 0; i < int2; ++i) {
                array[i] = Integer.parseInt(main.ns());
            }
            int n = Integer.MAX_VALUE;
            int n2 = array[0];
            final HashSet set = new HashSet();
            for (int j = 0; j < int2; ++j) {
                set.add(array[j]);
                final int abs;
                if ((abs = Math.abs(int1 - array[j])) < n) {
                    n = abs;
                    n2 = array[j];
                }
            }
            int n3 = 1;
            while (true) {
                final int n4 = n2 - n3;
                final int n5 = n2 + n3;
                if (!set.contains(n4)) {
                    main.out.println(n4);
                    break;
                }
                if (!set.contains(n5)) {
                    main.out.println(n5);
                    break;
                }
                ++n3;
            }
        }
        main.out.close();
    }
    
    private static void debug(final Object... a) {
        System.out.println(Arrays.deepToString(a));
    }
    
    private int ni() throws IOException {
        return Integer.parseInt(this.ns());
    }
    
    private long nl() throws IOException {
        return Long.parseLong(this.ns());
    }
    
    private double nd() throws IOException {
        return Double.parseDouble(this.ns());
    }
    
    private String ns() throws IOException {
        while (this.tokenizer == null || !this.tokenizer.hasMoreTokens()) {
            this.tokenizer = new StringTokenizer(this.br.readLine());
        }
        return this.tokenizer.nextToken();
    }
    
    private String nline() throws IOException {
        this.tokenizer = null;
        return this.br.readLine();
    }
    
    private static boolean input() throws IOException {
        return true;
    }
}
