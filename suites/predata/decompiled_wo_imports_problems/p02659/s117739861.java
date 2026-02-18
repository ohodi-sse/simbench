public final class Main
{
    private static void main$3231c38a() {
        final InputStream in = System.in;
        final PrintStream out = System.out;
        final MyScanner myScanner = new MyScanner(in);
        final PrintWriter printWriter = new PrintWriter(out);
        new C();
        final MyScanner myScanner2 = myScanner;
        printWriter.println(BigInteger.valueOf(Long.parseLong(myScanner2.next())).multiply(BigInteger.valueOf(Math.round(Double.parseDouble(myScanner2.next()) * 100.0))).divide(BigInteger.valueOf(100L)).toString());
        printWriter.close();
    }
    
    static final class C
    {
        private static void solve$32c5fcf9(final MyScanner myScanner, final PrintWriter printWriter) {
            printWriter.println(BigInteger.valueOf(Long.parseLong(myScanner.next())).multiply(BigInteger.valueOf(Math.round(Double.parseDouble(myScanner.next()) * 100.0))).divide(BigInteger.valueOf(100L)).toString());
        }
    }
    
    static final class MyScanner
    {
        private BufferedReader in;
        private StringTokenizer st;
        
        public MyScanner(final InputStream in) {
            this.in = new BufferedReader(new InputStreamReader(in));
        }
        
        public final String next() {
            while (true) {
                if (this.st != null) {
                    if (this.st.hasMoreTokens()) {
                        break;
                    }
                }
                try {
                    final String line;
                    if ((line = this.in.readLine()) == null) {
                        return null;
                    }
                    this.st = new StringTokenizer(line);
                    continue;
                }
                catch (final IOException ex) {
                    return null;
                }
                break;
            }
            return this.st.nextToken();
        }
        
        private long Long() {
            return Long.parseLong(this.next());
        }
        
        private double Double() {
            return Double.parseDouble(this.next());
        }
    }
}