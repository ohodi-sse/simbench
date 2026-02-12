import java.util.Arrays;
import java.io.IOException;
import java.io.FileReader;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.io.OutputStream;
import java.util.TreeMap;
import java.io.PrintWriter;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static PrintWriter pw;
    private static Scanner sc;
    private static char[] arr;
    private static int[][] dp;
    
    private static long ceildiv(final long n, final long n2) {
        return (n + n2 - 1L) / n2;
    }
    
    private static int mod(final long n, final int n2) {
        return (int)((n % n2 + n2) % n2);
    }
    
    private static void put(final TreeMap<Integer, Integer> treeMap, final Integer n) {
        if (treeMap.containsKey(n)) {
            treeMap.replace(n, treeMap.get(n) + 1);
            return;
        }
        treeMap.put(n, 1);
    }
    
    private static void rem(final TreeMap<Integer, Integer> treeMap, final Integer n) {
        if (treeMap.get(n) == 1) {
            treeMap.remove(n);
            return;
        }
        treeMap.replace(n, treeMap.get(n) - 1);
    }
    
    private static long gcd(long n, long n2) {
        while (n2 != 0L) {
            final long n3 = n2;
            n2 = n % n2;
            n = n3;
        }
        return n;
    }
    
    private static int Int(final boolean b) {
        if (b) {
            return 1;
        }
        return 0;
    }
    
    private static void main$3231c38a() throws Exception {
        Main.sc = new Scanner(System.in);
        Main.pw = new PrintWriter(System.out);
        final String line = Main.sc.br.readLine();
        int max = 0;
        for (int i = 0; i < 3; ++i) {
            int a = 0;
            while (i < 3 && line.charAt(i) == 'R') {
                ++a;
                ++i;
            }
            max = Math.max(a, max);
            if (a == 0) {}
        }
        Main.pw.println(max);
        Main.pw.close();
    }
    
    private static void printArr(final int[] array) {
        for (int i = 0; i < array.length - 1; ++i) {
            Main.pw.print("" + array[i]);
        }
        Main.pw.println(array[array.length - 1]);
    }
    
    private static void printArr(final long[] array) {
        for (int i = 0; i < array.length - 1; ++i) {
            Main.pw.print("" + array[i]);
        }
        Main.pw.println(array[array.length - 1]);
    }
    
    private static void printArr(final Integer[] array) {
        for (int i = 0; i < array.length; ++i) {
            Main.pw.print("" + array[i]);
        }
        Main.pw.println();
    }
    
    private static void printArr(final char[] array) {
        for (int i = 0; i < array.length; ++i) {
            Main.pw.print((array[i] == '\0') ? '1' : array[i]);
        }
        Main.pw.println();
    }
    
    private static void printArr(final ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); ++i) {
            Main.pw.print(String.valueOf(list.get(i)));
        }
        Main.pw.println();
    }
    
    static final class Scanner
    {
        private StringTokenizer st;
        BufferedReader br;
        
        public Scanner(final InputStream in) {
            this.br = new BufferedReader(new InputStreamReader(in));
        }
        
        private Scanner(final FileReader in) {
            this.br = new BufferedReader(in);
        }
        
        private String next() throws IOException {
            while (this.st == null || !this.st.hasMoreTokens()) {
                this.st = new StringTokenizer(this.br.readLine());
            }
            return this.st.nextToken();
        }
        
        private int nextInt() throws IOException {
            return Integer.parseInt(this.next());
        }
        
        private long nextLong() throws IOException {
            return Long.parseLong(this.next());
        }
        
        private String nextLine() throws IOException {
            return this.br.readLine();
        }
        
        private double nextDouble() throws IOException {
            return Double.parseDouble(this.next());
        }
        
        private int[] nextArr(final int n) throws IOException {
            final int[] array = new int[n];
            for (int i = 0; i < array.length; ++i) {
                array[i] = Integer.parseInt(this.next());
            }
            return array;
        }
        
        private Integer[] nextsort(final int n) throws IOException {
            final Integer[] array = new Integer[n];
            for (int i = 0; i < n; ++i) {
                array[i] = Integer.parseInt(this.next());
            }
            return array;
        }
        
        private Pair nextPair() throws IOException {
            return new Pair(this.nextInt(), this.nextInt());
        }
        
        private Pair[] nextPairArr(final int n) throws IOException {
            final Pair[] array = new Pair[n];
            for (int i = 0; i < n; ++i) {
                array[i] = new Pair(this.nextInt(), this.nextInt());
            }
            return array;
        }
        
        private boolean ready() throws IOException {
            return this.br.ready();
        }
    }
    
    static final class Pair implements Comparable<Pair>
    {
        private int x;
        private int y;
        
        public Pair(final int x, final int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public final int hashCode() {
            return this.x * 1000 + this.y;
        }
        
        private int compareTo(final Pair pair) {
            final int min = Math.min(this.x, this.y);
            final int min2 = Math.min(pair.x, pair.y);
            if (min != min2) {
                return min - min2;
            }
            if (this.x == pair.x) {
                return this.y - pair.y;
            }
            return this.x - pair.x;
        }
        
        @Override
        public final boolean equals(final Object o) {
            if (o == null) {
                return false;
            }
            if (this.getClass() != o.getClass()) {
                return false;
            }
            final Pair pair = (Pair)o;
            return this.x == pair.x && this.y == pair.y;
        }
        
        private Pair clone() {
            return new Pair(this.x, this.y);
        }
        
        @Override
        public final String toString() {
            return this.x + " " + this.y;
        }
        
        private void add(final Pair pair) {
            this.x += pair.x;
            this.y += pair.y;
        }
    }
    
    static final class Union
    {
        private int[] rep;
        private int[] size;
        private int sets;
        
        private Union(final int sets) {
            this.rep = new int[sets];
            this.size = new int[sets];
            this.sets = sets;
            Arrays.fill(this.size, 1);
            for (int i = 0; i < sets; ++i) {
                final int[] rep = this.rep;
                final int n = i;
                rep[n] = n;
            }
        }
        
        private void join(int set, int set2) {
            set = this.getSet(set);
            set2 = this.getSet(set2);
            if (set == set2) {
                return;
            }
            --this.sets;
            if (this.size[set] > this.size[set2]) {
                this.rep[set2] = set;
                final int[] size = this.size;
                final int n = set;
                size[n] += this.size[set2];
                return;
            }
            this.rep[set] = set2;
            final int[] size2 = this.size;
            final int n2 = set2;
            size2[n2] += this.size[set];
        }
        
        private int getSet(final int n) {
            if (this.rep[n] == n) {
                return n;
            }
            return this.rep[n] = this.getSet(this.rep[n]);
        }
    }
}
