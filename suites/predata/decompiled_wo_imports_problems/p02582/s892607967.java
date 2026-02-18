final class Main
{
    private static void main$3231c38a() throws IOException {
        final char[] charArray;
        int x;
        if ((charArray = new Scanner(System.in).next().toCharArray())[0] == 'R' && charArray[1] == 'R' && charArray[2] == 'R') {
            x = 3;
        }
        else if ((charArray[0] == 'R' && charArray[1] == 'R') || (charArray[1] == 'R' && charArray[2] == 'R')) {
            x = 2;
        }
        else if (charArray[0] == 'R' || charArray[1] == 'R' || charArray[2] == 'R') {
            x = 1;
        }
        else {
            x = 0;
        }
        System.out.println(x);
    }
    
    static final class Scanner
    {
        private StringTokenizer st;
        private BufferedReader br;
        
        public Scanner(final InputStream in) {
            this.br = new BufferedReader(new InputStreamReader(in));
        }
        
        private Scanner(final FileReader in) throws FileNotFoundException {
            this.br = new BufferedReader(in);
        }
        
        public final String next() throws IOException {
            while (this.st == null || !this.st.hasMoreTokens()) {
                this.st = new StringTokenizer(this.br.readLine());
            }
            return this.st.nextToken();
        }
        
        private int nextInt() throws IOException {
            return Integer.parseInt(this.next());
        }
        
        private long nextLong() throws IOException {
            return Long.parseLong(this.next());
        }
        
        private String nextLine() throws IOException {
            return this.br.readLine();
        }
        
        private double nextDouble() throws IOException {
            return Double.parseDouble(this.next());
        }
        
        private boolean ready() throws IOException {
            return this.br.ready();
        }
    }
}