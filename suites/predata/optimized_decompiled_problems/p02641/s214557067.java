import java.io.InputStream;
import java.io.FileInputStream;
import java.io.File;
import java.io.Reader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.BufferedReader;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static BufferedReader br;
    private static StringTokenizer tokenizer;
    
    private static void solve() {
        final int int1 = Integer.parseInt(next());
        final int int2 = Integer.parseInt(next());
        final ArrayList list = new ArrayList();
        for (int i = 0; i < int2; ++i) {
            list.add(Integer.parseInt(next()));
        }
        final HashMap hashMap = new HashMap();
        final Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            hashMap.put((int)iterator.next(), Boolean.TRUE);
        }
        int x = -1;
        for (int j = 0; j <= 100; ++j) {
            final int k = int1 - j;
            final int l = int1 + j;
            if (!hashMap.containsKey(k)) {
                x = k;
                break;
            }
            if (!hashMap.containsKey(l)) {
                x = l;
                break;
            }
        }
        System.out.println(x);
    }
    
    private static void main$3231c38a() {
        Main.br = new BufferedReader(new InputStreamReader(System.in));
        final String getenv;
        if ((getenv = System.getenv("DD_PATH")) != null) {
            try {
                Main.br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(getenv))));
            }
            catch (final Exception cause) {
                throw new RuntimeException(cause);
            }
        }
        final int int1 = Integer.parseInt(next());
        final int int2 = Integer.parseInt(next());
        final ArrayList list = new ArrayList();
        for (int i = 0; i < int2; ++i) {
            list.add(Integer.parseInt(next()));
        }
        final HashMap hashMap = new HashMap();
        final Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            hashMap.put((int)iterator.next(), Boolean.TRUE);
        }
        int x = -1;
        for (int j = 0; j <= 100; ++j) {
            final int k = int1 - j;
            final int l = int1 + j;
            if (!hashMap.containsKey(k)) {
                x = k;
                break;
            }
            if (!hashMap.containsKey(l)) {
                x = l;
                break;
            }
        }
        System.out.println(x);
    }
    
    private static String next() {
        while (true) {
            if (Main.tokenizer != null) {
                if (Main.tokenizer.hasMoreTokens()) {
                    break;
                }
            }
            try {
                Main.tokenizer = new StringTokenizer(Main.br.readLine());
                continue;
            }
            catch (final Exception cause) {
                throw new RuntimeException(cause);
            }
            break;
        }
        return Main.tokenizer.nextToken();
    }
    
    private static int ni() {
        return Integer.parseInt(next());
    }
    
    private static long nl() {
        return Long.parseLong(next());
    }
    
    private static double nd() {
        return Double.parseDouble(next());
    }
    
    private static int[] na(final int n) {
        final int[] array = new int[n];
        for (int i = 0; i < n; ++i) {
            array[i] = Integer.parseInt(next());
        }
        return array;
    }
    
    private static char[] ns() {
        return next().toCharArray();
    }
    
    private static long[] nal(final int n) {
        final long[] array = new long[n];
        for (int i = 0; i < n; ++i) {
            array[i] = Long.parseLong(next());
        }
        return array;
    }
    
    static {
        Main.tokenizer = null;
    }
}
