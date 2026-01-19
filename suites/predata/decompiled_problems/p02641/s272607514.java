import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;

// 
// Decompiled by Procyon v0.6.0
// 

static class FastReader
{
    BufferedReader br;
    StringTokenizer st;
    
    public FastReader() {
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
    
    int[] readArray(final int n) {
        final int[] array = new int[n];
        for (int i = 0; i < n; ++i) {
            array[i] = this.nextInt();
        }
        return array;
    }
    
    long[] readLongArray(final int n) {
        final long[] array = new long[n];
        for (int i = 0; i < n; ++i) {
            array[i] = this.nextLong();
        }
        return array;
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
import java.io.Reader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashSet;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    static int getgcd(int i, int n) {
        while (i != n) {
            if (i > n) {
                i -= n;
            }
            else {
                n -= i;
            }
        }
        return i;
    }
    
    static boolean isSorted(final int[] array, final int n) {
        for (int i = 1; i < n; ++i) {
            if (array[i] < array[i - 1]) {
                return false;
            }
        }
        return true;
    }
    
    static boolean isPrime(final long n) {
        if (n == 2L) {
            return true;
        }
        if (n % 2L == 0L) {
            return false;
        }
        for (int n2 = 3; n2 <= n / 2L; n2 += 2) {
            if (n % n2 == 0L) {
                return false;
            }
        }
        return true;
    }
    
    static void printArray(final int[] array) {
        for (int length = array.length, i = 0; i < length; ++i) {
            System.out.print("" + array[i]);
        }
        System.out.println();
    }
    
    public static void main(final String[] array) throws NumberFormatException, IOException {
        final FastReader fastReader = new FastReader();
        final int nextInt = fastReader.nextInt();
        final int nextInt2 = fastReader.nextInt();
        final HashSet set = new HashSet();
        for (int i = 0; i < nextInt2; ++i) {
            set.add(fastReader.nextInt());
        }
        final boolean b = true;
        if (!set.contains(nextInt)) {
            System.out.println(nextInt);
        }
        else {
            int x = nextInt;
            int x2 = nextInt;
            while (b) {
                if (!set.contains(--x)) {
                    System.out.println(x);
                    break;
                }
                if (!set.contains(++x2)) {
                    System.out.println(x2);
                    break;
                }
            }
        }
    }
    
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;
        
        public FastReader() {
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
        
        int[] readArray(final int n) {
            final int[] array = new int[n];
            for (int i = 0; i < n; ++i) {
                array[i] = this.nextInt();
            }
            return array;
        }
        
        long[] readLongArray(final int n) {
            final long[] array = new long[n];
            for (int i = 0; i < n; ++i) {
                array[i] = this.nextLong();
            }
            return array;
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
