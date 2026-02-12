import java.io.OutputStream;
import java.io.Reader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.math.BigDecimal;
import java.io.PrintWriter;
import java.io.BufferedReader;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static long MOD = 1000000007L;
    private static String[] Ws;
    private static int wsIndx;
    private static BufferedReader in;
    private static long cnt;
    private static PrintWriter pw;
    
    private static void main$3231c38a() throws Exception {
        Main.pw.println(new BigDecimal(nextString()).multiply(new BigDecimal(nextString())).longValue());
        if (Main.in != null) {
            Main.in.close();
        }
        Main.pw.flush();
        Main.pw.close();
    }
    
    private static void solutionA$3231c38a() throws Exception {
        Main.pw.println(nextInt() * nextInt());
    }
    
    private static void solutionB$3231c38a() throws Exception {
        final int nextInt = nextInt();
        check();
        final long[] a = new long[Main.Ws.length];
        for (int i = 0; i < a.length; ++i) {
            a[i] = Long.parseLong(Main.Ws[i]);
        }
        Main.wsIndx = Main.Ws.length;
        Arrays.sort(a);
        long n = a[0];
        for (int j = 1; j < nextInt; ++j) {
            long multiplyExact;
            try {
                multiplyExact = Math.multiplyExact(n, a[j]);
            }
            catch (final Exception ex) {
                Main.pw.println(-1);
                return;
            }
            if (multiplyExact >= 1000000000000000001L) {
                Main.pw.println(-1);
                return;
            }
            n = multiplyExact;
        }
        Main.pw.println(n);
    }
    
    private static void solutionC$3231c38a() throws Exception {
        Main.pw.println(new BigDecimal(nextString()).multiply(new BigDecimal(nextString())).longValue());
    }
    
    private static void solutionD$3231c38a() throws Exception {
    }
    
    private static void check() throws Exception {
        if (Main.in == null) {
            Main.in = new BufferedReader(new InputStreamReader(System.in));
        }
        if (Main.Ws == null || Main.Ws.length <= Main.wsIndx) {
            Main.Ws = Main.in.readLine().split(" ");
            Main.wsIndx = 0;
        }
    }
    
    private static int nextInt() throws Exception {
        check();
        return Integer.parseInt(Main.Ws[Main.wsIndx++]);
    }
    
    private static long nextLong() throws Exception {
        check();
        return Long.parseLong(Main.Ws[Main.wsIndx++]);
    }
    
    private static String nextString() throws Exception {
        check();
        return Main.Ws[Main.wsIndx++];
    }
    
    private static int[] nextInts() throws Exception {
        check();
        final int[] array = new int[Main.Ws.length];
        for (int i = 0; i < array.length; ++i) {
            array[i] = Integer.parseInt(Main.Ws[i]);
        }
        Main.wsIndx = Main.Ws.length;
        return array;
    }
    
    private static long[] nextLongs() throws Exception {
        check();
        final long[] array = new long[Main.Ws.length];
        for (int i = 0; i < array.length; ++i) {
            array[i] = Long.parseLong(Main.Ws[i]);
        }
        Main.wsIndx = Main.Ws.length;
        return array;
    }
    
    private static String[] nextStrings() throws Exception {
        check();
        Main.wsIndx = Main.Ws.length;
        return Main.Ws;
    }
    
    static {
        Main.Ws = null;
        Main.wsIndx = 0;
        Main.in = null;
        Main.pw = new PrintWriter(System.out);
    }
}
