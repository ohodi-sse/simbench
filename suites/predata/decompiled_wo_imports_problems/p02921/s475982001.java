public class Main
{
    PrintWriter out;
    BufferedReader in;
    StringTokenizer tok;
    
    public Main() {
        this.out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        this.in = new BufferedReader(new InputStreamReader(System.in));
    }
    
    public void go() throws IOException {
        this.ntok();
        final String spar = this.spar();
        this.ntok();
        final String spar2 = this.spar();
        int x = 0;
        for (int i = 0; i < spar.length(); ++i) {
            if (spar.charAt(i) == spar2.charAt(i)) {
                ++x;
            }
        }
        this.out.println(x);
        this.out.flush();
        this.in.close();
    }
    
    public void ntok() throws IOException {
        this.tok = new StringTokenizer(this.in.readLine());
    }
    
    public int ipar() {
        return Integer.parseInt(this.tok.nextToken());
    }
    
    public long lpar() {
        return Long.parseLong(this.tok.nextToken());
    }
    
    public double dpar() {
        return Double.parseDouble(this.tok.nextToken());
    }
    
    public String spar() {
        return this.tok.nextToken();
    }
    
    public static void main(final String[] array) throws IOException {
        new Main().go();
    }
}