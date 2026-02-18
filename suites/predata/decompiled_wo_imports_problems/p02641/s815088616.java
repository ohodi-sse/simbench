final class FastScanner
{
    private BufferedReader br;
    private StringTokenizer st;
    
    FastScanner(final InputStream in) {
        try {
            this.br = new BufferedReader(new InputStreamReader(in));
        }
        catch (final Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private FastScanner(final File file) {
        try {
            this.br = new BufferedReader(new FileReader(file));
        }
        catch (final Exception ex) {
            ex.printStackTrace();
        }
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
}




public final class Main
{
    private static void main$3231c38a() {
        final FastScanner fastScanner;
        final int int1 = Integer.parseInt((fastScanner = new FastScanner(System.in)).next());
        final int int2 = Integer.parseInt(fastScanner.next());
        int abs = Integer.MAX_VALUE;
        int x = 0;
        final boolean[] array = new boolean[102];
        for (int i = 0; i < int2; ++i) {
            array[Integer.parseInt(fastScanner.next())] = true;
        }
        for (int j = 0; j < array.length; ++j) {
            if (!array[j] && Math.abs(int1 - j) < abs) {
                abs = Math.abs(int1 - j);
                x = j;
            }
        }
        System.out.println(x);
    }
}