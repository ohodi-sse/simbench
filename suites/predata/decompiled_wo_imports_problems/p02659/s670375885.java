final class FastReader
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








public final class Main
{
    private static void main$3231c38a() throws IOException {
        final FastReader fastReader = new FastReader();
        new PrintWriter(System.out);
        System.out.println((long)(Double.parseDouble(fastReader.next()) * 100.0 + 0.05) * Long.parseLong(fastReader.next()) / 100L);
    }
}