public final class Main
{
    private static void main$3231c38a() throws IOException {
        final FastScanner fastScanner;
        final int int1 = Integer.parseInt((fastScanner = new Main().new FastScanner()).next());
        final int int2;
        if ((int2 = Integer.parseInt(fastScanner.next())) == 0) {
            System.out.println(int1);
            return;
        }
        final FastScanner fastScanner2 = fastScanner;
        final int n = int2;
        final FastScanner fastScanner3 = fastScanner2;
        final int[] a = new int[n];
        for (int i = 0; i < n; ++i) {
            a[i] = Integer.parseInt(fastScanner3.next());
        }
        Arrays.sort(a);
        int abs = 1000000;
        int x = -1;
        int j = 0;
    Label_0096:
        while (j < 1000) {
            final int[] array = a;
            final int n2 = j;
            final int[] array2 = array;
            while (true) {
                for (int length = array.length, k = 0; k < length; ++k) {
                    if (array2[k] == n2) {
                        final boolean b = true;
                        if (!b && Math.abs(j - int1) < abs) {
                            abs = Math.abs(j - int1);
                            x = j;
                        }
                        ++j;
                        continue Label_0096;
                    }
                }
                final boolean b = false;
                continue;
            }
        }
        System.out.println(x);
    }
    
    private void solve() throws IOException {
        final FastScanner fastScanner;
        final int int1 = Integer.parseInt((fastScanner = new FastScanner()).next());
        final int int2;
        if ((int2 = Integer.parseInt(fastScanner.next())) == 0) {
            System.out.println(int1);
            return;
        }
        final FastScanner fastScanner2 = fastScanner;
        final int n = int2;
        final FastScanner fastScanner3 = fastScanner2;
        final int[] array = new int[n];
        for (int i = 0; i < n; ++i) {
            array[i] = Integer.parseInt(fastScanner3.next());
        }
        final int[] array2;
        Arrays.sort(array2 = array);
        int abs = 1000000;
        int x = -1;
        int j = 0;
    Label_0094:
        while (j < 1000) {
            final int[] array3 = array2;
            final int n2 = j;
            final int[] array4 = array3;
            while (true) {
                for (int length = array3.length, k = 0; k < length; ++k) {
                    if (array4[k] == n2) {
                        final boolean b = true;
                        if (!b && Math.abs(j - int1) < abs) {
                            abs = Math.abs(j - int1);
                            x = j;
                        }
                        ++j;
                        continue Label_0094;
                    }
                }
                final boolean b = false;
                continue;
            }
        }
        System.out.println(x);
    }
    
    private static boolean exist(final int[] array, final int n) {
        for (int length = array.length, i = 0; i < length; ++i) {
            if (array[i] == n) {
                return true;
            }
        }
        return false;
    }
    
    public final class FastScanner
    {
        private BufferedReader reader;
        private StringTokenizer st;
        
        public FastScanner(final Main obj) {
            Objects.requireNonNull(obj);
            this.st = null;
            this.reader = new BufferedReader(new InputStreamReader(System.in));
        }
        
        public final String next() throws IOException {
            if (this.st == null || !this.st.hasMoreElements()) {
                this.st = new StringTokenizer(this.reader.readLine());
            }
            return this.st.nextToken();
        }
        
        private String nextLine() throws IOException {
            this.st = null;
            return this.reader.readLine();
        }
        
        private int nextInt() throws NumberFormatException, IOException {
            return Integer.parseInt(this.next());
        }
        
        private long nextLong() throws NumberFormatException, IOException {
            return Long.parseLong(this.next());
        }
        
        private int[] nextIntArr(final int n) throws NumberFormatException, IOException {
            final int[] array = new int[n];
            for (int i = 0; i < n; ++i) {
                array[i] = Integer.parseInt(this.next());
            }
            return array;
        }
        
        private long[] nextLongArr(final int n) throws NumberFormatException, IOException {
            final long[] array = new long[n];
            for (int i = 0; i < n; ++i) {
                array[i] = Long.parseLong(this.next());
            }
            return array;
        }
        
        private void close() throws IOException {
            this.reader.close();
        }
    }
}