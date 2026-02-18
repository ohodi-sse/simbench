public final class Main
{
    private static void main$3231c38a() {
        final InputReader inputReader = new InputReader(System.in);
        final PrintWriter printWriter = new PrintWriter(System.out);
        final int nextInt = inputReader.nextInt();
        final int nextInt2 = inputReader.nextInt();
        final HashSet set = new HashSet();
        for (int i = 0; i < nextInt2; ++i) {
            set.add(inputReader.nextInt());
        }
        Label_0139: {
            if (!set.contains(nextInt)) {
                printWriter.println(nextInt);
            }
            else {
                int n = nextInt;
                int n2 = nextInt;
                do {
                    --n;
                    ++n2;
                    if (!set.contains(n)) {
                        printWriter.println(n);
                        break Label_0139;
                    }
                } while (set.contains(n2));
                printWriter.println(n2);
            }
        }
        printWriter.close();
    }
    
    static final class InputReader
    {
        private final InputStream stream;
        private final byte[] buf;
        private int curChar;
        private int snumChars;
        private SpaceCharFilter filter;
        
        public InputReader(final InputStream stream) {
            this.buf = new byte[8192];
            this.stream = stream;
        }
        
        private int snext() {
            if (this.snumChars == -1) {
                throw new InputMismatchException();
            }
            if (this.curChar >= this.snumChars) {
                this.curChar = 0;
                try {
                    this.snumChars = this.stream.read(this.buf);
                }
                catch (final IOException ex) {
                    throw new InputMismatchException();
                }
                if (this.snumChars <= 0) {
                    return -1;
                }
            }
            return this.buf[this.curChar++];
        }
        
        public final int nextInt() {
            int n;
            for (n = this.snext(); this.isSpaceChar(n); n = this.snext()) {}
            int n2 = 1;
            if (n == 45) {
                n2 = -1;
                n = this.snext();
            }
            int n3 = 0;
            while (n >= 48 && n <= 57) {
                n3 = n3 * 10 + (n - 48);
                n = this.snext();
                if (this.isSpaceChar(n)) {
                    return n3 * n2;
                }
            }
            throw new InputMismatchException();
        }
        
        private long nextLong() {
            int n;
            for (n = this.snext(); this.isSpaceChar(n); n = this.snext()) {}
            int n2 = 1;
            if (n == 45) {
                n2 = -1;
                n = this.snext();
            }
            long n3 = 0L;
            while (n >= 48 && n <= 57) {
                n3 = n3 * 10L + (n - 48);
                n = this.snext();
                if (this.isSpaceChar(n)) {
                    return n3 * n2;
                }
            }
            throw new InputMismatchException();
        }
        
        private int[] nextIntArray(final int n) {
            final int[] array = new int[n];
            for (int i = 0; i < n; ++i) {
                array[i] = this.nextInt();
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
                for (n3 = this.snext(); this.isSpaceChar(n3); n3 = this.snext()) {}
                int n4 = 1;
                if (n3 == 45) {
                    n4 = -1;
                    n3 = this.snext();
                }
                long n5 = 0L;
                while (n3 >= 48 && n3 <= 57) {
                    n5 = n5 * 10L + (n3 - 48);
                    n3 = this.snext();
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
        
        private String readString() {
            int codePoint;
            for (codePoint = this.snext(); this.isSpaceChar(codePoint); codePoint = this.snext()) {}
            final StringBuilder sb = new StringBuilder();
            do {
                sb.appendCodePoint(codePoint);
                codePoint = this.snext();
            } while (!this.isSpaceChar(codePoint));
            return sb.toString();
        }
        
        private String nextLine() {
            int codePoint;
            for (codePoint = this.snext(); this.isSpaceChar(codePoint); codePoint = this.snext()) {}
            final StringBuilder sb = new StringBuilder();
            int n;
            do {
                sb.appendCodePoint(codePoint);
            } while ((n = (codePoint = this.snext())) != 10 && n != 13 && n != -1);
            return sb.toString();
        }
        
        private boolean isSpaceChar(final int n) {
            final SpaceCharFilter filter = this.filter;
            return n == 32 || n == 10 || n == 13 || n == 9 || n == -1;
        }
        
        private static boolean isEndOfLine(final int n) {
            return n == 10 || n == 13 || n == -1;
        }
        
        public interface SpaceCharFilter
        {
            boolean isSpaceChar$134632();
        }
    }
}