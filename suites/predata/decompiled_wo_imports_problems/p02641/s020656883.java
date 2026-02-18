public final class Main
{
    private static void main$3231c38a() {
        final InputStream in = System.in;
        final PrintStream out = System.out;
        final InputReader inputReader = new InputReader(in);
        final PrintWriter printWriter = new PrintWriter(out);
        new Solver();
        int n = 1;
    Label_0034:
        while (n-- != 0) {
            final InputReader inputReader2 = inputReader;
            final PrintWriter printWriter2 = printWriter;
            final InputReader inputReader3 = inputReader2;
            final int nextInt = inputReader2.nextInt();
            final int nextInt2 = inputReader3.nextInt();
            final HashSet<Integer> set = new HashSet<Integer>();
            for (int i = 0; i < nextInt2; ++i) {
                set.add(inputReader3.nextInt());
            }
            int n2;
            for (n2 = 0; set.contains(nextInt - n2); ++n2) {
                if (!set.contains(nextInt + n2)) {
                    printWriter2.println(nextInt + n2);
                    continue Label_0034;
                }
            }
            printWriter2.println(nextInt - n2);
        }
        printWriter.close();
    }
    
    static final class Solver
    {
        private static void solve(final InputReader inputReader, final PrintWriter printWriter) {
            final int nextInt = inputReader.nextInt();
            final int nextInt2 = inputReader.nextInt();
            final HashSet set = new HashSet();
            for (int i = 0; i < nextInt2; ++i) {
                set.add(inputReader.nextInt());
            }
            int n;
            for (n = 0; set.contains(nextInt - n); ++n) {
                if (!set.contains(nextInt + n)) {
                    printWriter.println(nextInt + n);
                    return;
                }
            }
            printWriter.println(nextInt - n);
        }
    }
    
    static final class InputReader
    {
        private boolean finished;
        private InputStream stream;
        private byte[] buf;
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;
        
        public InputReader(final InputStream stream) {
            this.finished = false;
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
        
        private int peek() {
            if (this.numChars == -1) {
                return -1;
            }
            if (this.curChar >= this.numChars) {
                this.curChar = 0;
                try {
                    this.numChars = this.stream.read(this.buf);
                }
                catch (final IOException ex) {
                    return -1;
                }
                if (this.numChars <= 0) {
                    return -1;
                }
            }
            return this.buf[this.curChar];
        }
        
        public final int nextInt() {
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
        
        private String nextString() {
            int n;
            for (n = this.read(); this.isSpaceChar(n); n = this.read()) {}
            final StringBuilder sb = new StringBuilder();
            do {
                if (Character.isValidCodePoint(n)) {
                    sb.appendCodePoint(n);
                }
                n = this.read();
            } while (!this.isSpaceChar(n));
            return sb.toString();
        }
        
        private boolean isSpaceChar(final int n) {
            if (this.filter != null) {
                return this.filter.isSpaceChar$134632();
            }
            return isWhitespace(n);
        }
        
        private static boolean isWhitespace(final int n) {
            return n == 32 || n == 10 || n == 13 || n == 9 || n == -1;
        }
        
        private String readLine0() {
            final StringBuilder sb = new StringBuilder();
            for (int codePoint = this.read(); codePoint != 10 && codePoint != -1; codePoint = this.read()) {
                if (codePoint != 13) {
                    sb.appendCodePoint(codePoint);
                }
            }
            return sb.toString();
        }
        
        private String readLine() {
            String s;
            for (s = this.readLine0(); s.trim().length() == 0; s = this.readLine0()) {}
            return s;
        }
        
        private String readLine(final boolean b) {
            if (b) {
                String s;
                for (s = this.readLine0(); s.trim().length() == 0; s = this.readLine0()) {}
                return s;
            }
            return this.readLine0();
        }
        
        private BigInteger readBigInteger() {
            try {
                return new BigInteger(this.nextString());
            }
            catch (final NumberFormatException ex) {
                throw new InputMismatchException();
            }
        }
        
        private char nextCharacter() {
            int n;
            for (n = this.read(); this.isSpaceChar(n); n = this.read()) {}
            return (char)n;
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
        
        private boolean isExhausted() {
            int peek;
            while (this.isSpaceChar(peek = this.peek()) && peek != -1) {
                this.read();
            }
            return peek == -1;
        }
        
        private String next() {
            return this.nextString();
        }
        
        private SpaceCharFilter getFilter() {
            return this.filter;
        }
        
        private void setFilter(final SpaceCharFilter filter) {
            this.filter = filter;
        }
        
        private int[] nextIntArray(final int n) {
            final int[] array = new int[n];
            for (int i = 0; i < n; ++i) {
                array[i] = this.nextInt();
            }
            return array;
        }
        
        private int[] nextSortedIntArray(final int n) {
            final int[] array = new int[n];
            for (int i = 0; i < n; ++i) {
                array[i] = this.nextInt();
            }
            final int[] array2;
            Arrays.sort(array2 = array);
            return array2;
        }
        
        private int[] nextSumIntArray(final int n) {
            final int[] array;
            (array = new int[n])[0] = this.nextInt();
            for (int i = 1; i < n; ++i) {
                array[i] = array[i - 1] + this.nextInt();
            }
            return array;
        }
        
        private long[] nextLongArray(final int n) {
            final long[] array = new long[n];
            int i = 0;
        Label_0006:
            while (i < n) {
                final long[] array2 = array;
                final int n2 = i;
                int n3;
                for (n3 = this.read(); this.isSpaceChar(n3); n3 = this.read()) {}
                int n4 = 1;
                if (n3 == 45) {
                    n4 = -1;
                    n3 = this.read();
                }
                long n5 = 0L;
                while (n3 >= 48 && n3 <= 57) {
                    n5 = n5 * 10L + (n3 - 48);
                    n3 = this.read();
                    if (this.isSpaceChar(n3)) {
                        array2[n2] = n5 * n4;
                        ++i;
                        continue Label_0006;
                    }
                }
                throw new InputMismatchException();
            }
            return array;
        }
        
        private long[] nextSumLongArray(final int n) {
            final long[] array;
            (array = new long[n])[0] = this.nextInt();
            for (int i = 1; i < n; ++i) {
                array[i] = array[i - 1] + this.nextInt();
            }
            return array;
        }
        
        private long[] nextSortedLongArray(final int n) {
            final long[] array = new long[n];
            int i = 0;
        Label_0011:
            while (i < n) {
                final long[] array2 = array;
                final int n2 = i;
                int n3;
                for (n3 = this.read(); this.isSpaceChar(n3); n3 = this.read()) {}
                int n4 = 1;
                if (n3 == 45) {
                    n4 = -1;
                    n3 = this.read();
                }
                long n5 = 0L;
                while (n3 >= 48 && n3 <= 57) {
                    n5 = n5 * 10L + (n3 - 48);
                    n3 = this.read();
                    if (this.isSpaceChar(n3)) {
                        array2[n2] = n5 * n4;
                        ++i;
                        continue Label_0011;
                    }
                }
                throw new InputMismatchException();
            }
            final long[] array3;
            Arrays.sort(array3 = array);
            return array3;
        }
        
        public interface SpaceCharFilter
        {
            boolean isSpaceChar$134632();
        }
    }
}