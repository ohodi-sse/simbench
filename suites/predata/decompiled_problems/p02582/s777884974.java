// 
// Decompiled by Procyon v0.6.0
// 

static class pair implements Comparable<pair>
{
    int x;
    int y;
    
    public pair(final int x, final int y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public int compareTo(final pair pair) {
        return this.y - this.x - (pair.y - pair.x);
    }
}
import java.util.HashMap;
import java.util.TreeSet;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.ArrayList;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    static pair[] a;
    static int[][] memo;
    static int maxSize;
    static boolean[][] exist;
    static ArrayList<Integer>[] startAt;
    static ArrayList<Integer>[] endAt;
    
    static int dp(final int n, final int n2) {
        if (n > n2) {
            return 0;
        }
        if (Main.memo[n][n2] != -1) {
            return Main.memo[n][n2];
        }
        int n3 = Math.max(dp(n + 1, n2), dp(n, n2 - 1));
        for (final int intValue : Main.startAt[n]) {
            if (Main.a[intValue].y >= n2) {
                continue;
            }
            n3 = Math.max(n3, 1 + dp(Main.a[intValue].x, Main.a[intValue].y) + (Main.exist[Main.a[intValue].y + 1][n2] ? 1 : 0) + dp(Main.a[intValue].y + 1, n2));
        }
        for (final int intValue2 : Main.endAt[n2]) {
            if (Main.a[intValue2].x <= n) {
                continue;
            }
            n3 = Math.max(n3, 1 + dp(Main.a[intValue2].x, Main.a[intValue2].y) + (Main.exist[n][Main.a[intValue2].x - 1] ? 1 : 0) + dp(Main.a[intValue2].y + 1, n2));
        }
        return Main.memo[n][n2] = n3;
    }
    
    public static void main(final String[] array) throws NumberFormatException, IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final PrintWriter printWriter = new PrintWriter(System.out);
        final char[] charArray = bufferedReader.readLine().toCharArray();
        if (charArray[0] == 'R' && charArray[1] == 'R' && charArray[2] == 'R') {
            printWriter.println(3);
        }
        else if ((charArray[0] == 'R' && charArray[1] == 'R') || (charArray[1] == 'R' && charArray[2] == 'R')) {
            printWriter.println(2);
        }
        else if (charArray[0] == 'R' || charArray[1] == 'R' || charArray[2] == 'R') {
            printWriter.println(1);
        }
        else {
            printWriter.println(0);
        }
        printWriter.flush();
        printWriter.close();
    }
    
    static void compress(final pair[] array) {
        final TreeSet set = new TreeSet();
        for (int i = 0; i < array.length; ++i) {
            set.add(array[i].x);
            set.add(array[i].y);
        }
        set.add(0);
        set.add(1000000000);
        final HashMap hashMap = new HashMap();
        final Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            hashMap.put((int)iterator.next(), hashMap.size());
        }
        for (int j = 0; j < array.length; ++j) {
            array[j].x = (int)hashMap.get(array[j].x);
            array[j].y = (int)hashMap.get(array[j].y);
        }
        Main.maxSize = hashMap.size();
    }
    
    static class pair implements Comparable<pair>
    {
        int x;
        int y;
        
        public pair(final int x, final int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public int compareTo(final pair pair) {
            return this.y - this.x - (pair.y - pair.x);
        }
    }
}
