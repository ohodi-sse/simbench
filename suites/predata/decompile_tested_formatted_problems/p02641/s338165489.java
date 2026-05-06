import java.util.HashSet;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Hashtable;

// 
// Decompiled by Procyon v0.6.0
// 

class Main
{
    static boolean[] visited;
    static long[][][] dp;
    static long MOD;
    static Hashtable<String, Long> hash;
    
    public static void main(final String[] array) throws Exception {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final String[] split = bufferedReader.readLine().split(" ");
        String[] split2 = new String[0];
        if (Integer.parseInt(split[1]) != 0) {
            split2 = bufferedReader.readLine().split(" ");
        }
        final HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < split2.length; ++i) {
            set.add(Integer.parseInt(split2[i]));
        }
        int int1;
        int n;
        for (n = (int1 = Integer.parseInt(split[0])); set.contains(int1); ++int1) {}
        int x = int1;
        int j;
        for (j = n - 1; set.contains(j); --j) {}
        if (n - j <= x - n) {
            x = j;
        }
        System.out.println(x);
    }
    
    static long get(final long n, final String s, final long[] array, final int index, final int n2, final int n3) {
        if (index == s.length()) {
            return (n == 0L) ? 1L : 2L;
        }
        if (Main.dp[index][n2][n3] != 0L) {
            return Main.dp[index][n2][n3];
        }
        if (s.charAt(index) == '1') {
            Main.dp[index][n2][n3] = Math.max(get(n ^ array[index], s, array, index + 1, n2, n3 + 1), get(n, s, array, index + 1, n2, n3));
        }
        else {
            Main.dp[index][n2][n3] = Math.min(get(n ^ array[index], s, array, index + 1, n2 + 1, n3), get(n, s, array, index + 1, n2, n3));
        }
        return Main.dp[index][n2][n3];
    }
    
    static {
        Main.MOD = 1000000007L;
        Main.hash = new Hashtable<String, Long>();
    }
}
// 
// Decompiled by Procyon v0.6.0
// 

class Pair
{
    long a;
    long b;
    
    Pair(final long a, final long b) {
        this.a = a;
        this.b = b;
    }
}
