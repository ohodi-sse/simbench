import java.io.IOException;
import java.util.InputMismatchException;
import java.io.InputStream;

// 
// Decompiled by Procyon v0.6.0
// 

final class FastScanner
{
    private InputStream stream;
    private byte[] buf;
    private int curChar;
    private int numChars;
    
    public FastScanner(final InputStream stream) {
        this.buf = new byte[1024];
        this.stream = stream;
    }
    
    private int read() {
        if (this.numChars == -1) {
            throw new InputMismatchException();
        }
        if (this.curChar >= this.numChars) {
            this.curChar = 0;
            try {
                this.numChars = this.stream.read(this.buf);
            }
            catch (final IOException ex) {
                throw new InputMismatchException();
            }
            if (this.numChars <= 0) {
                return -1;
            }
        }
        return this.buf[this.curChar++];
    }
    
    private static boolean isSpaceChar(final int n) {
        return n == 32 || n == 10 || n == 13 || n == 9 || n == -1;
    }
    
    private static boolean isEndline(final int n) {
        return n == 10 || n == 13 || n == -1;
    }
    
    private int nextInt() {
        return Integer.parseInt(this.next());
    }
    
    public final int[] nextIntArray(final int n) {
        final int[] array = new int[n];
        for (int i = 0; i < n; ++i) {
            array[i] = Integer.parseInt(this.next());
        }
        return array;
    }
    
    private int[][] nextIntMap(final int n, final int n2) {
        final int[][] array = new int[n][n2];
        for (int i = 0; i < n; ++i) {
            array[i] = this.nextIntArray(n2);
        }
        return array;
    }
    
    private long nextLong() {
        return Long.parseLong(this.next());
    }
    
    private long[] nextLongArray(final int n) {
        final long[] array = new long[n];
        for (int i = 0; i < n; ++i) {
            array[i] = Long.parseLong(this.next());
        }
        return array;
    }
    
    private long[][] nextLongMap(final int n, final int n2) {
        final long[][] array = new long[n][n2];
        for (int i = 0; i < n; ++i) {
            final long[][] array2 = array;
            final int n3 = i;
            final long[] array3 = new long[n2];
            for (int j = 0; j < n2; ++j) {
                array3[j] = Long.parseLong(this.next());
            }
            array2[n3] = array3;
        }
        return array;
    }
    
    private double nextDouble() {
        return Double.parseDouble(this.next());
    }
    
    private double[] nextDoubleArray(final int n) {
        final double[] array = new double[n];
        for (int i = 0; i < n; ++i) {
            array[i] = Double.parseDouble(this.next());
        }
        return array;
    }
    
    private double[][] nextDoubleMap(final int n, final int n2) {
        final double[][] array = new double[n][n2];
        for (int i = 0; i < n; ++i) {
            final double[][] array2 = array;
            final int n3 = i;
            final double[] array3 = new double[n2];
            for (int j = 0; j < n2; ++j) {
                array3[j] = Double.parseDouble(this.next());
            }
            array2[n3] = array3;
        }
        return array;
    }
    
    public final String next() {
        int codePoint;
        for (codePoint = this.read(); isSpaceChar(codePoint); codePoint = this.read()) {}
        final StringBuilder sb = new StringBuilder();
        do {
            sb.appendCodePoint(codePoint);
        } while (!isSpaceChar(codePoint = this.read()));
        return sb.toString();
    }
    
    private String[] nextStringArray(final int n) {
        final String[] array = new String[n];
        for (int i = 0; i < n; ++i) {
            array[i] = this.next();
        }
        return array;
    }
    
    private String nextLine() {
        int codePoint;
        for (codePoint = this.read(); isEndline(codePoint); codePoint = this.read()) {}
        final StringBuilder sb = new StringBuilder();
        do {
            sb.appendCodePoint(codePoint);
        } while (!isEndline(codePoint = this.read()));
        return sb.toString();
    }
    
    private int[][] nextPackedIntArrays(final int n, final int n2) {
        final int[][] array = new int[n][n2];
        for (int i = 0; i < n2; ++i) {
            for (int j = 0; j < n; ++j) {
                array[j][i] = Integer.parseInt(this.next());
            }
        }
        return array;
    }
}
import java.io.OutputStream;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.io.InputStream;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private InputStream is;
    private int __t__;
    private int __f__;
    private int __FILE_DEBUG_FLAG__;
    private String __DEBUG_FILE_NAME__;
    private FastScanner in;
    private PrintWriter out;
    
    public Main() {
        this.__t__ = 1;
        this.__f__ = 0;
        this.__FILE_DEBUG_FLAG__ = this.__f__;
        this.__DEBUG_FILE_NAME__ = "src/O1";
    }
    
    private void solve() {
        final int int1 = Integer.parseInt(this.in.next());
        final int int2 = Integer.parseInt(this.in.next());
        final int[] nextIntArray = this.in.nextIntArray(int2);
        final int[] array = new int[301];
        for (int i = 0; i < int2; ++i) {
            final int[] array2 = array;
            final int n = nextIntArray[i];
            ++array2[n];
        }
        int x = 0;
        for (int j = 0; j < array.length; ++j) {
            if (array[j] == 0 && Math.abs(int1 - j) < Math.abs(int1 - x)) {
                x = j;
            }
        }
        System.out.println(x);
    }
    
    private void run() {
        if (this.__FILE_DEBUG_FLAG__ == this.__t__) {
            try {
                this.is = new FileInputStream(this.__DEBUG_FILE_NAME__);
            }
            catch (final FileNotFoundException ex) {
                ex.printStackTrace();
            }
            System.out.println("FILE_INPUT!");
        }
        else {
            this.is = System.in;
        }
        this.in = new FastScanner(this.is);
        this.out = new PrintWriter(System.out);
        final int int1 = Integer.parseInt(this.in.next());
        final int int2 = Integer.parseInt(this.in.next());
        final int[] nextIntArray = this.in.nextIntArray(int2);
        final int[] array = new int[301];
        for (int i = 0; i < int2; ++i) {
            final int[] array2 = array;
            final int n = nextIntArray[i];
            ++array2[n];
        }
        int x = 0;
        for (int j = 0; j < array.length; ++j) {
            if (array[j] == 0 && Math.abs(int1 - j) < Math.abs(int1 - x)) {
                x = j;
            }
        }
        System.out.println(x);
    }
    
    private static void main$3231c38a() {
        final Main main;
        if ((main = new Main()).__FILE_DEBUG_FLAG__ == main.__t__) {
            try {
                main.is = new FileInputStream(main.__DEBUG_FILE_NAME__);
            }
            catch (final FileNotFoundException ex) {
                ex.printStackTrace();
            }
            System.out.println("FILE_INPUT!");
        }
        else {
            main.is = System.in;
        }
        main.in = new FastScanner(main.is);
        main.out = new PrintWriter(System.out);
        final int int1 = Integer.parseInt(main.in.next());
        final int int2 = Integer.parseInt(main.in.next());
        final int[] nextIntArray = main.in.nextIntArray(int2);
        final int[] array = new int[301];
        for (int i = 0; i < int2; ++i) {
            final int[] array2 = array;
            final int n = nextIntArray[i];
            ++array2[n];
        }
        int x = 0;
        for (int j = 0; j < array.length; ++j) {
            if (array[j] == 0 && Math.abs(int1 - j) < Math.abs(int1 - x)) {
                x = j;
            }
        }
        System.out.println(x);
    }
}
