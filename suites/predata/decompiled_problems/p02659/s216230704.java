import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;

// 
// Decompiled by Procyon v0.6.0
// 

public static class MyScanner
{
    BufferedReader br;
    StringTokenizer st;
    
    public MyScanner() {
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }
    
    String next() {
        while (true) {
            if (this.st != null) {
                if (this.st.hasMoreElements()) {
                    break;
                }
            }
            try {
                this.st = new StringTokenizer(this.br.readLine());
            }
            catch (final IOException ex) {
                ex.printStackTrace();
            }
        }
        return this.st.nextToken();
    }
    
    int nextInt() {
        return Integer.parseInt(this.next());
    }
    
    long nextLong() {
        return Long.parseLong(this.next());
    }
    
    double nextDouble() {
        return Double.parseDouble(this.next());
    }
    
    String nextLine() {
        String line = "";
        try {
            line = this.br.readLine();
        }
        catch (final IOException ex) {
            ex.printStackTrace();
        }
        return line;
    }
}
import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    static Scanner sc;
    static final int MOD = 1000000007;
    static final double PI = 3.141592653589793;
    public static PrintWriter out;
    
    public static void main(final String[] array) {
        final String string = Main.sc.nextBigDecimal().multiply(Main.sc.nextBigDecimal()).toString();
        String x = "";
        for (int i = 0; i < string.length(); ++i) {
            final char char1 = string.charAt(i);
            if (char1 == '.') {
                break;
            }
            x += char1;
        }
        Main.out.println(x);
        Main.out.close();
    }
    
    public static int[] init(final int n) {
        final int[] array = new int[n];
        for (int i = 0; i < n; ++i) {
            array[i] = Main.sc.nextInt();
        }
        return array;
    }
    
    public static int gcd(final int n, final int n2) {
        if (n == 0) {
            return n2;
        }
        return gcd(n2 % n, n);
    }
    
    public static boolean prime(final int n) {
        if (n < 2) {
            return false;
        }
        for (int n2 = 2; n2 * n2 <= n; ++n2) {
            if (n % n2 == 0) {
                return false;
            }
        }
        return true;
    }
    
    static {
        Main.sc = new Scanner(System.in);
        Main.out = new PrintWriter(new BufferedOutputStream(System.out));
    }
    
    static class Pair<S extends Comparable<S>, T extends Comparable<T>> implements Comparable<Pair<S, T>>
    {
        S first;
        T second;
        
        public Pair() {
        }
        
        Pair(final S first, final T second) {
            this.first = first;
            this.second = second;
        }
        
        public S getX() {
            return this.first;
        }
        
        public T getY() {
            return this.second;
        }
        
        @Override
        public int compareTo(final Pair<S, T> pair) {
            final int compareTo = this.first.compareTo(pair.first);
            if (compareTo == 0) {
                return this.second.compareTo(pair.second);
            }
            return compareTo;
        }
        
        public void show() {
            System.out.println("[" + String.valueOf(this.getX()) + " , " + String.valueOf(this.getY()));
        }
        
        @Override
        public int hashCode() {
            return (31 + this.first.hashCode()) * 31 + this.second.hashCode();
        }
        
        @Override
        public boolean equals(final Object o) {
            if (!(o instanceof Pair)) {
                return false;
            }
            if (o == this) {
                return true;
            }
            final Pair pair = (Pair)o;
            return this.first.equals(pair.first) && this.second.equals(pair.second);
        }
        
        @Override
        public String toString() {
            return "Pair{" + String.valueOf(this.first) + ", " + String.valueOf(this.second);
        }
    }
    
    public static class MyScanner
    {
        BufferedReader br;
        StringTokenizer st;
        
        public MyScanner() {
            this.br = new BufferedReader(new InputStreamReader(System.in));
        }
        
        String next() {
            while (true) {
                if (this.st != null) {
                    if (this.st.hasMoreElements()) {
                        break;
                    }
                }
                try {
                    this.st = new StringTokenizer(this.br.readLine());
                }
                catch (final IOException ex) {
                    ex.printStackTrace();
                }
            }
            return this.st.nextToken();
        }
        
        int nextInt() {
            return Integer.parseInt(this.next());
        }
        
        long nextLong() {
            return Long.parseLong(this.next());
        }
        
        double nextDouble() {
            return Double.parseDouble(this.next());
        }
        
        String nextLine() {
            String line = "";
            try {
                line = this.br.readLine();
            }
            catch (final IOException ex) {
                ex.printStackTrace();
            }
            return line;
        }
    }
}
// 
// Decompiled by Procyon v0.6.0
// 

static class Pair<S extends Comparable<S>, T extends Comparable<T>> implements Comparable<Pair<S, T>>
{
    S first;
    T second;
    
    public Pair() {
    }
    
    Pair(final S first, final T second) {
        this.first = first;
        this.second = second;
    }
    
    public S getX() {
        return this.first;
    }
    
    public T getY() {
        return this.second;
    }
    
    @Override
    public int compareTo(final Pair<S, T> pair) {
        final int compareTo = this.first.compareTo(pair.first);
        if (compareTo == 0) {
            return this.second.compareTo(pair.second);
        }
        return compareTo;
    }
    
    public void show() {
        System.out.println("[" + String.valueOf(this.getX()) + " , " + String.valueOf(this.getY()));
    }
    
    @Override
    public int hashCode() {
        return (31 + this.first.hashCode()) * 31 + this.second.hashCode();
    }
    
    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof Pair)) {
            return false;
        }
        if (o == this) {
            return true;
        }
        final Pair pair = (Pair)o;
        return this.first.equals(pair.first) && this.second.equals(pair.second);
    }
    
    @Override
    public String toString() {
        return "Pair{" + String.valueOf(this.first) + ", " + String.valueOf(this.second);
    }
}
