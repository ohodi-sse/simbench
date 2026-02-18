public final class Main
{
    private static PrintWriter out;
    private static int MAX = 100000;
    private static List<Integer>[] edge;
    private static int N;
    
    private static void main$3231c38a() {
        final FastReader fastReader;
        final char[] charArray = (fastReader = new FastReader()).next().toCharArray();
        final char[] charArray2 = fastReader.next().toCharArray();
        int i = 0;
        for (int j = 0; j < 3; ++j) {
            if (charArray[j] == charArray2[j]) {
                ++i;
            }
        }
        Main.out.print(i);
        Main.out.close();
    }
    
    static {
        Main.out = new PrintWriter(new BufferedOutputStream(System.out));
    }
    
    public static final class FastReader
    {
        private BufferedReader br;
        private StringTokenizer st;
        
        public FastReader() {
            this.br = new BufferedReader(new InputStreamReader(System.in));
        }
        
        final String next() {
            while (true) {
                if (this.st != null) {
                    if (this.st.hasMoreTokens()) {
                        break;
                    }
                }
                try {
                    this.st = new StringTokenizer(this.br.readLine());
                }
                catch (final Exception ex) {
                    ex.printStackTrace();
                }
            }
            return this.st.nextToken();
        }
        
        private int nextInt() {
            return Integer.parseInt(this.next());
        }
        
        private double nextDouble() {
            return Double.parseDouble(this.next());
        }
        
        private long nextLong() {
            return Long.parseLong(this.next());
        }
        
        private String nextLine() {
            String line = "";
            try {
                line = this.br.readLine();
            }
            catch (final Exception ex) {
                ex.printStackTrace();
            }
            return line;
        }
    }
}