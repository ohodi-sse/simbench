import java.io.OutputStream;
import java.io.Reader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Arrays;
import java.io.PrintWriter;
import java.io.BufferedReader;





public class Main
{
    static final long MOD = 1000000007L;
    public static String[] Ws;
    public static int wsIndx;
    public static BufferedReader in;
    public static long cnt;
    public static PrintWriter pw;
    
    public static void main(final String[] array) throws Exception {
        solutionC(array);
        if (Main.in != null) {
            Main.in.close();
        }
        Main.pw.flush();
        Main.pw.close();
    }
    
    public static void solutionA(final String[] array) throws Exception {
        Main.pw.println(nextInt() * nextInt());
    }
    
    public static void solutionB(final String[] array) throws Exception {
        final int nextInt = nextInt();
        final long[] nextLongs = nextLongs();
        Arrays.sort(nextLongs);
        long n = nextLongs[0];
        for (int i = 1; i < nextInt; ++i) {
            long multiplyExact;
            try {
                multiplyExact = Math.multiplyExact(n, nextLongs[i]);
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
    
    public static void solutionC(final String[] array) throws Exception {
        Main.pw.println(new BigDecimal(nextString()).multiply(new BigDecimal(nextString())).longValue());
    }
    
    public static void solutionD(final String[] array) throws Exception {
    }
    
    public static void check() throws Exception {
        if (Main.in == null) {
            Main.in = new BufferedReader(new InputStreamReader(System.in));
        }
        if (Main.Ws == null || Main.Ws.length <= Main.wsIndx) {
            Main.Ws = Main.in.readLine().split(" ");
            Main.wsIndx = 0;
        }
    }
    
    public static int nextInt() throws Exception {
        check();
        return Integer.parseInt(Main.Ws[Main.wsIndx++]);
    }
    
    public static long nextLong() throws Exception {
        check();
        return Long.parseLong(Main.Ws[Main.wsIndx++]);
    }
    
    public static String nextString() throws Exception {
        check();
        return Main.Ws[Main.wsIndx++];
    }
    
    public static int[] nextInts() throws Exception {
        check();
        final int[] array = new int[Main.Ws.length];
        for (int i = 0; i < array.length; ++i) {
            array[i] = Integer.parseInt(Main.Ws[i]);
        }
        Main.wsIndx = Main.Ws.length;
        return array;
    }
    
    public static long[] nextLongs() throws Exception {
        check();
        final long[] array = new long[Main.Ws.length];
        for (int i = 0; i < array.length; ++i) {
            array[i] = Long.parseLong(Main.Ws[i]);
        }
        Main.wsIndx = Main.Ws.length;
        return array;
    }
    
    public static String[] nextStrings() throws Exception {
        check();
        Main.wsIndx = Main.Ws.length;
        return Main.Ws;
    }
    
    static {
        Main.Ws = null;
        Main.wsIndx = 0;
        Main.in = null;
        Main.cnt = 0L;
        Main.pw = new PrintWriter(System.out);
    }
}