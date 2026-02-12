import java.io.IOException;
import java.util.InputMismatchException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    static long mod;
    static int[] sieve;
    static ArrayList<Integer> primes;
    
    private static void main$3231c38a() {
        final fast fast;
        final int nextInt = (fast = new fast()).nextInt();
        final int nextInt2 = fast.nextInt();
        final boolean[] array = new boolean[103];
        for (int i = 0; i < nextInt2; ++i) {
            array[fast.nextInt() + 1] = true;
        }
        int n = nextInt;
        int n2 = nextInt;
        int j = nextInt;
        if (array[nextInt + 1]) {
            while (n >= 0 || n2 < 101) {
                if (n >= 0) {
                    --n;
                    if (!array[n + 1]) {
                        j = n;
                        break;
                    }
                }
                if (n2 < 101) {
                    ++n2;
                    if (!array[n2 + 1]) {
                        j = n2;
                        break;
                    }
                    continue;
                }
            }
        }
        final PrintWriter printWriter = new PrintWriter(System.out);
        final StringBuilder x;
        (x = new StringBuilder("")).append(j);
        printWriter.println(x);
        printWriter.close();
    }
    
    static {
        Main.mod = 1000000007L;
    }
    
    static final class fast
    {
        private InputStream i;
        private byte[] buf;
        private int curChar;
        private int numChars;
        
        private static long log2(long n) {
            int n2 = 0;
            if ((n & 0xFFFFFFFFFFFF0000L) != 0x0L) {
                n >>>= 16;
                n2 = 16;
            }
            if (n >= 256L) {
                n >>>= 8;
                n2 += 8;
            }
            if (n >= 16L) {
                n >>>= 4;
                n2 += 4;
            }
            if (n >= 4L) {
                n >>>= 2;
                n2 += 2;
            }
            return n2 + (n >>> 1);
        }
        
        private static boolean next_permutation(final int[] array) {
            int n = -1;
            final int length = array.length;
            for (int i = 0; i < length - 1; ++i) {
                if (array[i] < array[i + 1]) {
                    n = i;
                }
            }
            if (n == -1) {
                return false;
            }
            int n3;
            int n2;
            for (n2 = (n3 = n) + 1; n2 < length && array[n3] < array[n2]; ++n2) {}
            final int n4 = array[n3];
            array[n3] = array[n2 - 1];
            array[n2 - 1] = n4;
            for (int j = n3 + 1, n5 = length - 1; j < n5; ++j, --n5) {
                final int n6 = array[j];
                array[j] = array[n5];
                array[n5] = n6;
            }
            return true;
        }
        
        private static void sieve(final int n) {
            Main.sieve = new int[n + 1];
            Main.primes = new ArrayList<Integer>();
            Main.sieve[1] = 1;
            int n2 = 2;
            while (true) {
                final int n3 = n2;
                if (n3 * n3 > n) {
                    break;
                }
                if (Main.sieve[n2] == 0) {
                    final int n4 = n2;
                    for (int i = n4 * n4; i < n; i += n2) {
                        Main.sieve[i] = 1;
                    }
                }
                ++n2;
            }
            for (int j = 2; j <= n; ++j) {
                if (Main.sieve[j] == 0) {
                    Main.primes.add(j);
                }
            }
        }
        
        private static long pow(long mul, long n) {
            long mul2 = 1L;
            while (n > 0L) {
                if ((n & 0x1L) == 0x1L) {
                    mul2 = mul(mul2, mul);
                }
                mul = mul(mul, mul);
                n >>= 1;
            }
            return mul2;
        }
        
        private static long add(final long... array) {
            long n = 0L;
            for (int length = array.length, i = 0; i < length; ++i) {
                n = (n + Main.mod + array[i]) % Main.mod;
            }
            return n;
        }
        
        private static long mul(final long... array) {
            long n = 1L;
            final int length = array.length;
            for (int i = 0; i < 2; ++i) {
                n = (Main.mod + n * array[i] % Main.mod) % Main.mod;
            }
            return n;
        }
        
        private static long mod_inv(final long n) {
            long n2 = Main.mod - 2L;
            long mul = n;
            long mul2 = 1L;
            while (n2 > 0L) {
                if ((n2 & 0x1L) == 0x1L) {
                    mul2 = mul(mul2, mul);
                }
                mul = mul(mul, mul);
                n2 >>= 1;
            }
            return mul2;
        }
        
        private long gcd(long n, long n2) {
            while (n != 0L) {
                final long n3 = n2 % n;
                n2 = n;
                n = n3;
            }
            return n2;
        }
        
        public fast() {
            this(System.in);
        }
        
        private fast(final InputStream i) {
            this.buf = new byte[1024];
            this.i = i;
        }
        
        private int read() {
            if (this.numChars == -1) {
                throw new InputMismatchException();
            }
            if (this.curChar >= this.numChars) {
                this.curChar = 0;
                try {
                    this.numChars = this.i.read(this.buf);
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
        
        private String nextLine() {
            int codePoint;
            for (codePoint = this.read(); isSpaceChar(codePoint); codePoint = this.read()) {}
            final StringBuilder sb = new StringBuilder();
            int n;
            do {
                sb.appendCodePoint(codePoint);
            } while ((n = (codePoint = this.read())) != 10 && n != 13 && n != -1);
            return sb.toString();
        }
        
        private String nextString() {
            int codePoint;
            for (codePoint = this.read(); isSpaceChar(codePoint); codePoint = this.read()) {}
            final StringBuilder sb = new StringBuilder();
            do {
                sb.appendCodePoint(codePoint);
            } while (!isSpaceChar(codePoint = this.read()));
            return sb.toString();
        }
        
        private long nextLong() {
            int n;
            for (n = this.read(); isSpaceChar(n); n = this.read()) {}
            int n2 = 1;
            if (n == 45) {
                n2 = -1;
                n = this.read();
            }
            long n3 = 0L;
            while (n >= 48 && n <= 57) {
                n3 = n3 * 10L + (n - 48);
                if (isSpaceChar(n = this.read())) {
                    return n3 * n2;
                }
            }
            throw new InputMismatchException();
        }
        
        public final int nextInt() {
            int n;
            for (n = this.read(); isSpaceChar(n); n = this.read()) {}
            int n2 = 1;
            if (n == 45) {
                n2 = -1;
                n = this.read();
            }
            int n3 = 0;
            while (n >= 48 && n <= 57) {
                n3 = n3 * 10 + (n - 48);
                if (isSpaceChar(n = this.read())) {
                    return n3 * n2;
                }
            }
            throw new InputMismatchException();
        }
        
        private static boolean isSpaceChar(final int n) {
            return n == 32 || n == 10 || n == 13 || n == 9 || n == -1;
        }
        
        private static boolean isEndOfLine(final int n) {
            return n == 10 || n == 13 || n == -1;
        }
    }
}
