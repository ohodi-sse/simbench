public final class Main
{
    private static long MOD = 998244353L;
    
    private static void main$3231c38a() {
        new PrintWriter(System.out);
        final InputReader inputReader;
        final char[] charArray;
        System.out.println((inputReader = new InputReader(System.in)).nextLong() * (Integer.parseInt(String.valueOf((charArray = inputReader.next().toCharArray())[0])) * 100 + Integer.parseInt(String.valueOf(charArray[2])) * 10 + Integer.parseInt(String.valueOf(charArray[3]))) / 100L);
    }
    
    static final class InputReader
    {
        private InputStream in;
        private byte[] buffer;
        private int curbuf;
        private int lenbuf;
        
        public InputReader(final InputStream in) {
            this.buffer = new byte[1024];
            this.in = in;
            final int n = 0;
            this.lenbuf = n;
            this.curbuf = n;
        }
        
        private boolean hasNextByte() {
            if (this.curbuf >= this.lenbuf) {
                this.curbuf = 0;
                try {
                    this.lenbuf = this.in.read(this.buffer);
                }
                catch (final IOException ex) {
                    throw new InputMismatchException();
                }
                if (this.lenbuf <= 0) {
                    return false;
                }
            }
            return true;
        }
        
        private int readByte() {
            if (this.hasNextByte()) {
                return this.buffer[this.curbuf++];
            }
            return -1;
        }
        
        private static boolean isSpaceChar(final int n) {
            return n < 33 || n > 126;
        }
        
        private void skip() {
            while (this.hasNextByte() && isSpaceChar(this.buffer[this.curbuf])) {
                ++this.curbuf;
            }
        }
        
        private boolean hasNext() {
            while (this.hasNextByte() && isSpaceChar(this.buffer[this.curbuf])) {
                ++this.curbuf;
            }
            return this.hasNextByte();
        }
        
        public final String next() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            final StringBuilder sb = new StringBuilder();
            for (int codePoint = this.readByte(); !isSpaceChar(codePoint); codePoint = this.readByte()) {
                sb.appendCodePoint(codePoint);
            }
            return sb.toString();
        }
        
        private int nextInt() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            int n;
            while (isSpaceChar(n = this.readByte())) {}
            boolean b = false;
            if (n == 45) {
                b = true;
                n = this.readByte();
            }
            int n2 = 0;
            while (n >= 48 && n <= 57) {
                n2 = n2 * 10 + n - 48;
                if (isSpaceChar(n = this.readByte())) {
                    if (b) {
                        return -n2;
                    }
                    return n2;
                }
            }
            throw new InputMismatchException();
        }
        
        public final long nextLong() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            int n;
            while (isSpaceChar(n = this.readByte())) {}
            boolean b = false;
            if (n == 45) {
                b = true;
                n = this.readByte();
            }
            long n2 = 0L;
            while (n >= 48 && n <= 57) {
                n2 = n2 * 10L + n - 48L;
                if (isSpaceChar(n = this.readByte())) {
                    if (b) {
                        return -n2;
                    }
                    return n2;
                }
            }
            throw new InputMismatchException();
        }
        
        private double nextDouble() {
            return Double.parseDouble(this.next());
        }
        
        private int[] nextIntArray(final int n) {
            final int[] array = new int[n];
            int i = 0;
        Label_0006:
            while (i < n) {
                final int[] array2 = array;
                final int n2 = i;
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                int n3;
                while (isSpaceChar(n3 = this.readByte())) {}
                boolean b = false;
                if (n3 == 45) {
                    b = true;
                    n3 = this.readByte();
                }
                int n4 = 0;
                while (n3 >= 48 && n3 <= 57) {
                    n4 = n4 * 10 + n3 - 48;
                    if (isSpaceChar(n3 = this.readByte())) {
                        array2[n2] = (b ? (-n4) : n4);
                        ++i;
                        continue Label_0006;
                    }
                }
                throw new InputMismatchException();
            }
            return array;
        }
        
        private long[] nextLongArray(final int n) {
            final long[] array = new long[n];
            for (int i = 0; i < n; ++i) {
                array[i] = this.nextLong();
            }
            return array;
        }
        
        private char[][] nextCharMap(final int n, final int n2) {
            final char[][] array = new char[n][n2];
            for (int i = 0; i < n; ++i) {
                array[i] = this.next().toCharArray();
            }
            return array;
        }
    }
}