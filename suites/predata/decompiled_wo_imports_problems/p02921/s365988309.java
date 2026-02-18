public final class Main
{
    private static void main$3231c38a() throws IOException {
        final Scanner scanner = new Scanner();
        final PrintWriter printWriter = new PrintWriter(System.out);
        final char[] charArray = scanner.next().toCharArray();
        final char[] charArray2 = scanner.next().toCharArray();
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            if (charArray[i] == charArray2[i]) {
                ++x;
            }
        }
        printWriter.println(x);
        printWriter.flush();
        printWriter.close();
    }
    
    static final class Scanner
    {
        private BufferedReader br;
        private StringTokenizer st;
        
        Scanner() {
            this.br = new BufferedReader(new InputStreamReader(System.in));
        }
        
        final String next() throws IOException {
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
        
        private Integer[] nextIntegerArray(final int n) throws IOException {
            final Integer[] array = new Integer[n];
            for (int i = 0; i < n; ++i) {
                array[i] = Integer.parseInt(this.next());
            }
            return array;
        }
        
        private double nextDouble() throws IOException {
            return Double.parseDouble(this.next());
        }
        
        private int[] nextIntArray(final int n) throws IOException {
            final int[] array = new int[n];
            for (int i = 0; i < n; ++i) {
                array[i] = Integer.parseInt(this.next()) - 1;
            }
            return array;
        }
    }
}