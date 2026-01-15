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

public class Main
{
    static PrintWriter pw;
    static Scanner sc;
    static char[] arr;
    static int[][] dp;
    
    static long ceildiv(final long n, final long n2) {
        return (n + n2 - 1L) / n2;
    }
    
    static int mod(final long n, final int n2) {
        return (int)((n % n2 + n2) % n2);
    }
    
    static void put(final TreeMap<Integer, Integer> treeMap, final Integer n) {
        if (treeMap.containsKey(n)) {
            treeMap.replace(n, treeMap.get(n) + 1);
        }
        else {
            treeMap.put(n, 1);
        }
    }
    
    static void rem(final TreeMap<Integer, Integer> treeMap, final Integer n) {
        if (treeMap.get(n) == 1) {
            treeMap.remove(n);
        }
        else {
            treeMap.replace(n, treeMap.get(n) - 1);
        }
    }
    
    static long gcd(final long n, final long n2) {
        return (n2 == 0L) ? n : gcd(n2, n % n2);
    }
    
    static int Int(final boolean b) {
        return b ? 1 : 0;
    }
    
    public static void main(final String[] array) throws Exception {
        Main.sc = new Scanner(System.in);
        Main.pw = new PrintWriter(System.out);
        final String nextLine = Main.sc.nextLine();
        int max = 0;
        for (int i = 0; i < 3; ++i) {
            int a = 0;
            while (i < 3 && nextLine.charAt(i) == 'R') {
                ++a;
                ++i;
            }
            max = Math.max(a, max);
            if (a == 0) {}
        }
        Main.pw.println(max);
        Main.pw.close();
    }
    
    static void printArr(final int[] array) {
        for (int i = 0; i < array.length - 1; ++i) {
            Main.pw.print("" + array[i]);
        }
        Main.pw.println(array[array.length - 1]);
    }
    
    static void printArr(final long[] array) {
        for (int i = 0; i < array.length - 1; ++i) {
            Main.pw.print("" + array[i]);
        }
        Main.pw.println(array[array.length - 1]);
    }
    
    static void printArr(final Integer[] array) {
        for (int i = 0; i < array.length; ++i) {
            Main.pw.print("" + array[i]);
        }
        Main.pw.println();
    }
    
    static void printArr(final char[] array) {
        for (int i = 0; i < array.length; ++i) {
            Main.pw.print((array[i] == '\0') ? '1' : array[i]);
        }
        Main.pw.println();
    }
    
    static void printArr(final ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); ++i) {
            Main.pw.print(String.valueOf(list.get(i)));
        }
        Main.pw.println();
    }
    
    static class Scanner
    {
        StringTokenizer st;
        BufferedReader br;
        
        public Scanner(final InputStream in) {
            this.br = new BufferedReader(new InputStreamReader(in));
        }
        
        public Scanner(final FileReader in) {
            this.br = new BufferedReader(in);
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
            return Double.parseDouble(this.next());
        }
        
        public int[] nextArr(final int n) throws IOException {
            final int[] array = new int[n];
            for (int i = 0; i < array.length; ++i) {
                array[i] = this.nextInt();
            }
            return array;
        }
        
        public Integer[] nextsort(final int n) throws IOException {
            final Integer[] array = new Integer[n];
            for (int i = 0; i < n; ++i) {
                array[i] = this.nextInt();
            }
            return array;
        }
        
        public Pair nextPair() throws IOException {
            return new Pair(this.nextInt(), this.nextInt());
        }
        
        public Pair[] nextPairArr(final int n) throws IOException {
            final Pair[] array = new Pair[n];
            for (int i = 0; i < n; ++i) {
                array[i] = this.nextPair();
            }
            return array;
        }
        
        public boolean ready() throws IOException {
            return this.br.ready();
        }
    }
    
    static class Pair implements Comparable<Pair>
    {
        int x;
        int y;
        
        public Pair(final int x, final int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public int hashCode() {
            return this.x * 1000 + this.y;
        }
        
        @Override
        public int compareTo(final Pair pair) {
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
        public boolean equals(final Object o) {
            if (o == null) {
                return false;
            }
            if (this.getClass() != o.getClass()) {
                return false;
            }
            final Pair pair = (Pair)o;
            return this.x == pair.x && this.y == pair.y;
        }
        
        public Pair clone() {
            return new Pair(this.x, this.y);
        }
        
        @Override
        public String toString() {
            return this.x + " " + this.y;
        }
        
        public void add(final Pair pair) {
            this.x += pair.x;
            this.y += pair.y;
        }
    }
    
    static class Union
    {
        int[] rep;
        int[] size;
        int sets;
        
        public Union(final int sets) {
            this.rep = new int[sets];
            this.size = new int[sets];
            this.sets = sets;
            Arrays.fill(this.size, 1);
            for (int i = 0; i < sets; ++i) {
                this.rep[i] = i;
            }
        }
        
        public void join(final int n, final int n2) {
            final int set = this.getSet(n);
            final int set2 = this.getSet(n2);
            if (set == set2) {
                return;
            }
            --this.sets;
            if (this.size[set] > this.size[set2]) {
                this.rep[set2] = set;
                final int[] size = this.size;
                final int n3 = set;
                size[n3] += this.size[set2];
            }
            else {
                this.rep[set] = set2;
                final int[] size2 = this.size;
                final int n4 = set2;
                size2[n4] += this.size[set];
            }
        }
        
        public int getSet(final int n) {
            if (this.rep[n] == n) {
                return n;
            }
            return this.rep[n] = this.getSet(this.rep[n]);
        }
    }
}
