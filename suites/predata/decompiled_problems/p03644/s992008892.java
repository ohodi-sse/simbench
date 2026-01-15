import java.io.Reader;
import java.io.InputStreamReader;
import java.io.BufferedReader;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    static final long MOD = 1000000007L;
    public static String[] Ws;
    public static int wsIndx;
    public static BufferedReader in;
    
    public static void main(final String[] array) throws Exception {
        int nextInt;
        int i;
        for (nextInt = nextInt(), i = 1; i <= nextInt; i *= 2) {}
        System.out.println(i / 2);
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
    }
}
