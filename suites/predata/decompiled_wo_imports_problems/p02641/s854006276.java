public final class Main
{
    private static final String NO = "NO";
    private static final String YES = "YES";
    private InputStream is;
    private PrintWriter out;
    private String INPUT;
    private static final long MOD = 1000000007L;
    private static final long inf = 100000000000L;
    private Set<Integer>[] g;
    private byte[] inbuf;
    private int lenbuf;
    private int ptrbuf;
    private boolean[] vis;
    
    public Main() {
        this.INPUT = "";
        this.inbuf = new byte[1024];
        this.lenbuf = 0;
        this.ptrbuf = 0;
    }
    
    private void solve() {
        for (int i = 0; i <= 0; ++i) {
            final int ni = this.ni();
            final int ni2 = this.ni();
            final int[] array = new int[102];
            for (int j = 0; j < ni2; ++j) {
                final int[] array2 = array;
                final int ni3 = this.ni();
                ++array2[ni3];
            }
            int x = ni;
            int n = Integer.MAX_VALUE;
            for (int k = 0; k <= 101; ++k) {
                final int abs;
                if (array[k] == 0 && (abs = Math.abs(k - ni)) < n) {
                    n = abs;
                    x = k;
                }
            }
            this.out.println(x);
        }
    }
    
    private void solve$13462e() {
        final int ni = this.ni();
        final int ni2 = this.ni();
        final int[] array = new int[102];
        for (int i = 0; i < ni2; ++i) {
            final int[] array2 = array;
            final int ni3 = this.ni();
            ++array2[ni3];
        }
        int x = ni;
        int n = Integer.MAX_VALUE;
        for (int j = 0; j <= 101; ++j) {
            final int abs;
            if (array[j] == 0 && (abs = Math.abs(j - ni)) < n) {
                n = abs;
                x = j;
            }
        }
        this.out.println(x);
    }
    
    private static long power(final long n, long n2) {
        long n3 = 1L;
        long n4 = n;
        while (n2 > 0L) {
            if (n2 % 2L != 0L) {
                n3 = n3 * n4 % 1000000007L;
            }
            final long n5 = n4;
            n4 = n5 * n5 % 1000000007L;
            n2 /= 2L;
        }
        return n3 % 1000000007L;
    }
    
    private static long gcd(long n, long n2) {
        while (n != 0L) {
            final long n3 = n2 % n;
            n2 = n;
            n = n3;
        }
        return n2;
    }
    
    private void run() throws Exception {
        this.is = (this.INPUT.isEmpty() ? System.in : new ByteArrayInputStream(this.INPUT.getBytes()));
        this.out = new PrintWriter(System.out);
        final long currentTimeMillis = System.currentTimeMillis();
        for (int i = 0; i <= 0; ++i) {
            final int ni = this.ni();
            final int ni2 = this.ni();
            final int[] array = new int[102];
            for (int j = 0; j < ni2; ++j) {
                final int[] array2 = array;
                final int ni3 = this.ni();
                ++array2[ni3];
            }
            int x = ni;
            int n = Integer.MAX_VALUE;
            for (int k = 0; k <= 101; ++k) {
                final int abs;
                if (array[k] == 0 && (abs = Math.abs(k - ni)) < n) {
                    n = abs;
                    x = k;
                }
            }
            this.out.println(x);
        }
        this.out.flush();
        if (!this.INPUT.isEmpty()) {
            System.out.println(Arrays.deepToString(new Object[] { System.currentTimeMillis() - currentTimeMillis + "ms" }));
        }
    }
    
    private static void main$3231c38a() throws Exception {
        final Main main2;
        final Main main = main2 = new Main();
        main.is = (main.INPUT.isEmpty() ? System.in : new ByteArrayInputStream(main2.INPUT.getBytes()));
        main2.out = new PrintWriter(System.out);
        final long currentTimeMillis = System.currentTimeMillis();
        final Main main3 = main2;
        for (int i = 0; i <= 0; ++i) {
            final Main main4;
            final int ni = (main4 = main3).ni();
            final int ni2 = main4.ni();
            final int[] array = new int[102];
            for (int j = 0; j < ni2; ++j) {
                final int[] array2 = array;
                final int ni3 = main4.ni();
                ++array2[ni3];
            }
            int x = ni;
            int n = Integer.MAX_VALUE;
            for (int k = 0; k <= 101; ++k) {
                final int abs;
                if (array[k] == 0 && (abs = Math.abs(k - ni)) < n) {
                    n = abs;
                    x = k;
                }
            }
            main4.out.println(x);
        }
        main2.out.flush();
        if (!main2.INPUT.isEmpty()) {
            System.out.println(Arrays.deepToString(new Object[] { System.currentTimeMillis() - currentTimeMillis + "ms" }));
        }
    }
    
    private int readByte() {
        if (this.lenbuf == -1) {
            throw new InputMismatchException();
        }
        if (this.ptrbuf >= this.lenbuf) {
            this.ptrbuf = 0;
            try {
                this.lenbuf = this.is.read(this.inbuf);
            }
            catch (final IOException ex) {
                throw new InputMismatchException();
            }
            if (this.lenbuf <= 0) {
                return -1;
            }
        }
        return this.inbuf[this.ptrbuf++];
    }
    
    private static boolean isSpaceChar(final int n) {
        return n < 33 || n > 126;
    }
    
    private int skip() {
        int byte1;
        while ((byte1 = this.readByte()) != -1 && isSpaceChar(byte1)) {}
        return byte1;
    }
    
    private double nd() {
        int codePoint = this.skip();
        final StringBuilder sb = new StringBuilder();
        while (!isSpaceChar(codePoint)) {
            sb.appendCodePoint(codePoint);
            codePoint = this.readByte();
        }
        return Double.parseDouble(sb.toString());
    }
    
    private char nc() {
        return (char)this.skip();
    }
    
    private String ns() {
        int codePoint = this.skip();
        final StringBuilder sb = new StringBuilder();
        while (!isSpaceChar(codePoint)) {
            sb.appendCodePoint(codePoint);
            codePoint = this.readByte();
        }
        return sb.toString();
    }
    
    private char[] ns(final int n) {
        final char[] original = new char[n];
        int n2 = this.skip();
        int i = 0;
        while (i < n) {
            if (!isSpaceChar(n2)) {
                original[i++] = (char)n2;
            }
            n2 = this.readByte();
        }
        if (n == i) {
            return original;
        }
        return Arrays.copyOf(original, i);
    }
    
    private char[][] nm(final int n, final int n2) {
        final char[][] array = new char[n][];
        for (int i = 0; i < n; ++i) {
            final char[][] array2 = array;
            final int n3 = i;
            final char[] original = new char[n2];
            int n4 = this.skip();
            int j = 0;
            while (j < n2) {
                if (!isSpaceChar(n4)) {
                    original[j++] = (char)n4;
                }
                n4 = this.readByte();
            }
            array2[n3] = ((n2 == j) ? original : Arrays.copyOf(original, j));
        }
        return array;
    }
    
    private int[] na(final int n) {
        final int[] array = new int[n];
        for (int i = 0; i < n; ++i) {
            array[i] = this.ni();
        }
        return array;
    }
    
    private List<Integer> na2(final int n) {
        final ArrayList list = new ArrayList();
        for (int i = 0; i < n; ++i) {
            list.add(this.ni());
        }
        return list;
    }
    
    private int[][] na(final int n, final int n2) {
        final int[][] array = new int[n][];
        for (int i = 0; i < n; ++i) {
            final int[][] array2 = array;
            final int n3 = i;
            final int[] array3 = new int[n2];
            for (int j = 0; j < n2; ++j) {
                array3[j] = this.ni();
            }
            array2[n3] = array3;
        }
        return array;
    }
    
    private int ni() {
        int n = 0;
        boolean b = false;
        int n2;
        while ((n2 = this.readByte()) != -1 && (n2 < 48 || n2 > 57) && n2 != 45) {}
        if (n2 == 45) {
            b = true;
            n2 = this.readByte();
        }
        while (n2 >= 48 && n2 <= 57) {
            n = n * 10 + (n2 - 48);
            n2 = this.readByte();
        }
        if (b) {
            return -n;
        }
        return n;
    }
    
    private long[] nl(final int n) {
        final long[] array = new long[n];
        for (int i = 0; i < n; ++i) {
            final long[] array2 = array;
            final int n2 = i;
            long n3 = 0L;
            boolean b = false;
            int n4;
            while ((n4 = this.readByte()) != -1 && (n4 < 48 || n4 > 57) && n4 != 45) {}
            if (n4 == 45) {
                b = true;
                n4 = this.readByte();
            }
            while (n4 >= 48 && n4 <= 57) {
                n3 = n3 * 10L + (n4 - 48);
                n4 = this.readByte();
            }
            array2[n2] = (b ? (-n3) : n3);
        }
        return array;
    }
    
    private long[][] nl(final int n, final int n2) {
        final long[][] array = new long[n][];
        for (int i = 0; i < n; ++i) {
            final long[][] array2 = array;
            final int n3 = i;
            final long[] array3 = new long[n2];
            for (int j = 0; j < n2; ++j) {
                final long[] array4 = array3;
                final int n4 = j;
                long n5 = 0L;
                boolean b = false;
                int n6;
                while ((n6 = this.readByte()) != -1 && (n6 < 48 || n6 > 57) && n6 != 45) {}
                if (n6 == 45) {
                    b = true;
                    n6 = this.readByte();
                }
                while (n6 >= 48 && n6 <= 57) {
                    n5 = n5 * 10L + (n6 - 48);
                    n6 = this.readByte();
                }
                array4[n4] = (b ? (-n5) : n5);
            }
            array2[n3] = array3;
        }
        return array;
    }
    
    private long nl() {
        long n = 0L;
        boolean b = false;
        int n2;
        while ((n2 = this.readByte()) != -1 && (n2 < 48 || n2 > 57) && n2 != 45) {}
        if (n2 == 45) {
            b = true;
            n2 = this.readByte();
        }
        while (n2 >= 48 && n2 <= 57) {
            n = n * 10L + (n2 - 48);
            n2 = this.readByte();
        }
        if (b) {
            return -n;
        }
        return n;
    }
    
    private static void tr(final Object... a) {
        System.out.println(Arrays.deepToString(a));
    }
    
    public final class Pair<K, V>
    {
        private K key;
        private V value;
        
        private K getKey() {
            return this.key;
        }
        
        private V getValue() {
            return this.value;
        }
        
        private Pair(final Main obj, final K key, final V value) {
            Objects.requireNonNull(obj);
            this.key = key;
            this.value = value;
        }
        
        @Override
        public final String toString() {
            return String.valueOf(this.key) + "=" + String.valueOf(this.value);
        }
        
        @Override
        public final int hashCode() {
            return this.key.hashCode() * 13 + ((this.value == null) ? 0 : this.value.hashCode());
        }
        
        @Override
        public final boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (o instanceof final Pair pair) {
                Label_0052: {
                    if (this.key != null) {
                        if (this.key.equals(pair.key)) {
                            break Label_0052;
                        }
                    }
                    else if (pair.key == null) {
                        break Label_0052;
                    }
                    return false;
                }
                if (this.value != null) {
                    if (this.value.equals(pair.value)) {
                        return true;
                    }
                }
                else if (pair.value == null) {
                    return true;
                }
                return false;
            }
            return false;
        }
    }
}