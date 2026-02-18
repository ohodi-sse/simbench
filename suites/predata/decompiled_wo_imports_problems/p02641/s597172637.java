public final class Main
{
    private static void main$3231c38a() {
        final FastReader fastReader;
        final int int1 = Integer.parseInt((fastReader = new FastReader()).next());
        final int int2;
        if ((int2 = Integer.parseInt(fastReader.next())) == 0) {
            System.out.println(int1);
            return;
        }
        final HashSet set = new HashSet();
        for (int i = 0; i < int2; ++i) {
            set.add(Integer.parseInt(fastReader.next()));
        }
        if (!set.contains(int1)) {
            System.out.println(int1);
            return;
        }
        int j;
        for (j = int1 + 1; set.contains(j); ++j) {}
        int n;
        for (n = int1 - 1; set.contains(n); --n) {}
        final int n2 = j - int1;
        int n3;
        if (n < 0) {
            n3 = int1 + Math.abs(n);
        }
        else {
            n3 = int1 - n;
        }
        if (n2 < n3) {
            System.out.println(int1 + n2);
            return;
        }
        System.out.println(int1 - n3);
    }
    
    static final class FastReader
    {
        private BufferedReader br;
        private StringTokenizer st;
        
        public FastReader() {
            this.br = new BufferedReader(new InputStreamReader(System.in));
        }
        
        final String next() {
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
        
        private int nextInt() {
            return Integer.parseInt(this.next());
        }
        
        private long nextLong() {
            return Long.parseLong(this.next());
        }
        
        private double nextDouble() {
            return Double.parseDouble(this.next());
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
    }
}