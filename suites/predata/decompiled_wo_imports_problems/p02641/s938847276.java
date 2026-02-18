public final class Main
{
    private BufferedReader br;
    private PrintWriter out;
    private StringTokenizer st;
    private boolean eof;
    private long MOD = 1000000007L;
    private static final int[] dx;
    private static final int[] dy;
    
    private void solve() throws IOException {
        final int int1 = Integer.parseInt(this.nextToken());
        final int int2 = Integer.parseInt(this.nextToken());
        final int[] array = new int[int2];
        for (int i = 0; i < int2; ++i) {
            array[i] = Integer.parseInt(this.nextToken());
        }
        final int[] array2 = array;
        final HashSet set = new HashSet();
        for (int length = array2.length, j = 0; j < length; ++j) {
            set.add(array2[j]);
        }
        int n = Integer.MAX_VALUE;
        int k = -1;
        for (int l = -1; l < 1000; ++l) {
            final int abs;
            if (!set.contains(l) && (abs = Math.abs(l - int1)) < n) {
                n = abs;
                k = l;
            }
        }
        this.out.println((Object)k);
    }
    
    private static void shuffle(final int[] array) {
        for (int length = array.length, i = 0; i < length; ++i) {
            final int n = i + (int)(Math.random() * (length - i));
            final int n2 = array[i];
            array[i] = array[n];
            array[n] = n2;
        }
    }
    
    private void outln(final Object x) {
        this.out.println(x);
    }
    
    private void out(final Object obj) {
        this.out.print(obj);
    }
    
    public Main() throws IOException {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        this.out = new PrintWriter(System.out);
        final int int1 = Integer.parseInt(this.nextToken());
        final int int2 = Integer.parseInt(this.nextToken());
        final int[] array = new int[int2];
        for (int i = 0; i < int2; ++i) {
            array[i] = Integer.parseInt(this.nextToken());
        }
        final int[] array2 = array;
        final HashSet set = new HashSet();
        for (int length = array2.length, j = 0; j < length; ++j) {
            set.add(array2[j]);
        }
        int n = Integer.MAX_VALUE;
        int k = -1;
        for (int l = -1; l < 1000; ++l) {
            final int abs;
            if (!set.contains(l) && (abs = Math.abs(l - int1)) < n) {
                n = abs;
                k = l;
            }
        }
        this.out.println((Object)k);
        this.out.close();
    }
    
    private static void main$3231c38a() throws IOException {
        new Main();
    }
    
    private long[] nextLongArr(final int n) throws IOException {
        final long[] array = new long[n];
        for (int i = 0; i < n; ++i) {
            array[i] = Long.parseLong(this.nextToken());
        }
        return array;
    }
    
    private int[] nextIntArr(final int n) throws IOException {
        final int[] array = new int[n];
        for (int i = 0; i < n; ++i) {
            array[i] = Integer.parseInt(this.nextToken());
        }
        return array;
    }
    
    private String nextToken() {
        while (true) {
            if (this.st != null) {
                if (this.st.hasMoreTokens()) {
                    break;
                }
            }
            try {
                this.st = new StringTokenizer(this.br.readLine());
                continue;
            }
            catch (final Exception ex) {
                this.eof = true;
                return null;
            }
            break;
        }
        return this.st.nextToken();
    }
    
    private String nextString() {
        try {
            return this.br.readLine();
        }
        catch (final IOException ex) {
            this.eof = true;
            return null;
        }
    }
    
    private int nextInt() throws IOException {
        return Integer.parseInt(this.nextToken());
    }
    
    private long nextLong() throws IOException {
        return Long.parseLong(this.nextToken());
    }
    
    private double nextDouble() throws IOException {
        return Double.parseDouble(this.nextToken());
    }
}