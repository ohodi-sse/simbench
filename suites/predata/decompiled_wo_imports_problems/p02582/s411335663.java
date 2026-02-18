public final class Main
{
    private static FastIO io;
    
    private static void main$3231c38a() throws Exception {
        final String next;
        if ((next = FastIO.next()).indexOf(82) < 0) {
            FastIO.println(0);
        }
        else if (next.equals("RRR")) {
            FastIO.println(3);
        }
        else if (next.equals("RRS") || next.equals("SRR")) {
            FastIO.println(2);
        }
        else {
            FastIO.println(1);
        }
        FastIO.flush();
    }
    
    static {
        new FastIO("in.txt");
    }
    
    static final class FastIO
    {
        private static StringBuilder sb;
        private static BufferedReader br;
        private static StringTokenizer st;
        private static PrintStream ps;
        
        public FastIO(final String s) {
            try {
                if (new File(s).exists()) {
                    System.setIn(new FileInputStream(s));
                }
            }
            catch (final Exception ex) {
                ex.printStackTrace();
            }
            FastIO.br = new BufferedReader(new InputStreamReader(System.in));
        }
        
        static String next() {
            while (true) {
                if (FastIO.st != null) {
                    if (FastIO.st.hasMoreElements()) {
                        break;
                    }
                }
                try {
                    FastIO.st = new StringTokenizer(FastIO.br.readLine());
                }
                catch (final IOException ex) {
                    ex.printStackTrace();
                }
            }
            return FastIO.st.nextToken();
        }
        
        private static int nextInt() {
            return Integer.parseInt(next());
        }
        
        private static long nextLong() {
            return Long.parseLong(next());
        }
        
        private static double nextDouble() {
            return Double.parseDouble(next());
        }
        
        static void flush() {
            System.out.print(FastIO.sb.toString());
            FastIO.sb.setLength();
        }
        
        private static void print(final Object obj) {
            FastIO.sb.append(obj);
        }
        
        static void println(final Object obj) {
            FastIO.sb.append(obj);
            FastIO.sb.append('\n');
        }
        
        private static String nextLine() {
            String line = "";
            try {
                line = FastIO.br.readLine();
            }
            catch (final IOException ex) {
                ex.printStackTrace();
            }
            return line;
        }
        
        static {
            FastIO.sb = new StringBuilder();
            new PrintStream(System.out);
        }
    }
}