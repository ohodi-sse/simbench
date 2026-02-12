import java.util.List;
import java.util.Objects;
import java.util.InputMismatchException;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static long gcd(long n, long n2) {
        while (n2 != 0L) {
            final long n3 = n % n2;
            final long n4 = n2;
            n2 = n3;
            n = n4;
        }
        return n;
    }
    
    private static long lcm(final long n, final long n2) {
        final long n3 = n * n2;
        long n4 = n2;
        long n5 = n;
        while (n4 != 0L) {
            final long n6 = n5 % n4;
            final long n7 = n4;
            n4 = n6;
            n5 = n7;
        }
        return n3 / n5;
    }
    
    private static void main$3231c38a() throws IOException {
        final InputStream in = System.in;
        final PrintStream out = System.out;
        final InputReader inputReader = new InputReader(in);
        final PrintWriter printWriter = new PrintWriter(out);
        int codePoint;
        for (codePoint = inputReader.read(); inputReader.isSpaceChar(codePoint); codePoint = inputReader.read()) {}
        final StringBuilder sb = new StringBuilder();
        do {
            sb.appendCodePoint(codePoint);
            codePoint = inputReader.read();
        } while (!inputReader.isSpaceChar(codePoint));
        final String string = sb.toString();
        int max = 0;
        int n = 0;
        for (int i = 0; i < string.length(); ++i) {
            if (string.charAt(i) == 'R') {
                ++n;
            }
            else {
                max = Math.max(n, max);
                n = 0;
            }
        }
        printWriter.println(Math.max(max, n));
        printWriter.close();
    }
    
    public static final class InputReader
    {
        private InputStream stream;
        private byte[] buf;
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;
        private BufferedReader br;
        
        public InputReader(final InputStream stream) {
            this.buf = new byte[1024];
            this.br = new BufferedReader(new InputStreamReader(System.in));
            this.stream = stream;
        }
        
        public final int read() {
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
        
        private String nextLine() {
            String line = "";
            try {
                line = this.br.readLine();
            }
            catch (final IOException ex) {
                ex.printStackTrace();
            }
            return line;
        }
        
        private int nextInt() {
            int n;
            for (n = this.read(); this.isSpaceChar(n); n = this.read()) {}
            int n2 = 1;
            if (n == 45) {
                n2 = -1;
                n = this.read();
            }
            int n3 = 0;
            while (n >= 48 && n <= 57) {
                n3 = n3 * 10 + (n - 48);
                n = this.read();
                if (this.isSpaceChar(n)) {
                    return n3 * n2;
                }
            }
            throw new InputMismatchException();
        }
        
        private long nextLong() {
            int n;
            for (n = this.read(); this.isSpaceChar(n); n = this.read()) {}
            int n2 = 1;
            if (n == 45) {
                n2 = -1;
                n = this.read();
            }
            long n3 = 0L;
            while (n >= 48 && n <= 57) {
                n3 = n3 * 10L + (n - 48);
                n = this.read();
                if (this.isSpaceChar(n)) {
                    return n3 * n2;
                }
            }
            throw new InputMismatchException();
        }
        
        private double nextDouble() {
            int n;
            for (n = this.read(); this.isSpaceChar(n); n = this.read()) {}
            int n2 = 1;
            if (n == 45) {
                n2 = -1;
                n = this.read();
            }
            double n3 = 0.0;
            while (!this.isSpaceChar(n) && n != 46) {
                if (n == 101 || n == 69) {
                    return n3 * Math.pow(10.0, this.nextInt());
                }
                if (n < 48 || n > 57) {
                    throw new InputMismatchException();
                }
                n3 = n3 * 10.0 + (n - 48);
                n = this.read();
            }
            if (n == 46) {
                int n4 = this.read();
                double n5 = 1.0;
                while (!this.isSpaceChar(n4)) {
                    if (n4 == 101 || n4 == 69) {
                        return n3 * Math.pow(10.0, this.nextInt());
                    }
                    if (n4 < 48 || n4 > 57) {
                        throw new InputMismatchException();
                    }
                    n5 /= 10.0;
                    n3 += (n4 - 48) * n5;
                    n4 = this.read();
                }
            }
            return n3 * n2;
        }
        
        private String readString() {
            int codePoint;
            for (codePoint = this.read(); this.isSpaceChar(codePoint); codePoint = this.read()) {}
            final StringBuilder sb = new StringBuilder();
            do {
                sb.appendCodePoint(codePoint);
                codePoint = this.read();
            } while (!this.isSpaceChar(codePoint));
            return sb.toString();
        }
        
        public final boolean isSpaceChar(final int n) {
            final SpaceCharFilter filter = this.filter;
            return n == 32 || n == 10 || n == 13 || n == 9 || n == -1;
        }
        
        private String next() {
            int codePoint;
            for (codePoint = this.read(); this.isSpaceChar(codePoint); codePoint = this.read()) {}
            final StringBuilder sb = new StringBuilder();
            do {
                sb.appendCodePoint(codePoint);
                codePoint = this.read();
            } while (!this.isSpaceChar(codePoint));
            return sb.toString();
        }
        
        public interface SpaceCharFilter
        {
            boolean isSpaceChar$134632();
        }
    }
    
    public final class ListNode
    {
        private int val;
        private ListNode next;
        
        private ListNode(final Main obj) {
            Objects.requireNonNull(obj);
        }
        
        private ListNode(final Main obj, final int val) {
            Objects.requireNonNull(obj);
            this.val = val;
        }
        
        private ListNode(final Main obj, final int val, final ListNode next) {
            Objects.requireNonNull(obj);
            this.val = val;
            this.next = next;
        }
    }
    
    public final class TreeNode
    {
        private int val;
        private TreeNode left;
        private TreeNode right;
        
        private TreeNode(final Main obj) {
            Objects.requireNonNull(obj);
        }
        
        private TreeNode(final Main obj, final int val) {
            Objects.requireNonNull(obj);
            this.val = val;
        }
        
        private TreeNode(final Main obj, final int val, final TreeNode left, final TreeNode right) {
            Objects.requireNonNull(obj);
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
    final class Node
    {
        private int val;
        private List<Node> children;
        
        private Node(final Main obj) {
            Objects.requireNonNull(obj);
        }
        
        private Node(final Main obj, final int val) {
            Objects.requireNonNull(obj);
            this.val = val;
        }
        
        private Node(final Main obj, final int val, final List<Node> children) {
            Objects.requireNonNull(obj);
            this.val = val;
            this.children = children;
        }
    }
}
