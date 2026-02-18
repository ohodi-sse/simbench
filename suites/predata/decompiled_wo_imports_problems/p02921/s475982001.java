public final class Main
{
    private PrintWriter out;
    private BufferedReader in;
    private StringTokenizer tok;
    
    public Main() {
        this.out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        this.in = new BufferedReader(new InputStreamReader(System.in));
    }
    
    private void go() throws IOException {
        this.ntok();
        final String nextToken = this.tok.nextToken();
        this.ntok();
        final String nextToken2 = this.tok.nextToken();
        int x = 0;
        for (int i = 0; i < nextToken.length(); ++i) {
            if (nextToken.charAt(i) == nextToken2.charAt(i)) {
                ++x;
            }
        }
        this.out.println(x);
        this.out.flush();
        this.in.close();
    }
    
    private void ntok() throws IOException {
        this.tok = new StringTokenizer(this.in.readLine());
    }
    
    private int ipar() {
        return Integer.parseInt(this.tok.nextToken());
    }
    
    private long lpar() {
        return Long.parseLong(this.tok.nextToken());
    }
    
    private double dpar() {
        return Double.parseDouble(this.tok.nextToken());
    }
    
    private String spar() {
        return this.tok.nextToken();
    }
    
    private static void main$3231c38a() throws IOException {
        final Main main;
        (main = new Main()).ntok();
        final String nextToken = main.tok.nextToken();
        main.ntok();
        final String nextToken2 = main.tok.nextToken();
        int x = 0;
        for (int i = 0; i < nextToken.length(); ++i) {
            if (nextToken.charAt(i) == nextToken2.charAt(i)) {
                ++x;
            }
        }
        main.out.println(x);
        main.out.flush();
        main.in.close();
    }
}