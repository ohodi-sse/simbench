public final class Main
{
    private static void main$3231c38a() throws IOException {
        final Scanner scanner;
        final int int1 = Integer.parseInt((scanner = new Scanner(System.in)).next());
        final int int2;
        final int[] array = new int[int2 = Integer.parseInt(scanner.next())];
        final int[] array2 = new int[102];
        for (int i = 0; i < int2; ++i) {
            array[i] = Integer.parseInt(scanner.next());
            final int[] array3 = array2;
            final int n = array[i];
            ++array3[n];
        }
        int x = 0;
        int abs = Integer.MAX_VALUE;
        for (int j = 0; j <= 101; ++j) {
            if (array2[j] == 0 && Math.abs(int1 - j) < abs) {
                abs = Math.abs(int1 - j);
                x = j;
            }
        }
        System.out.println(x);
    }
}











final class Scanner
{
    private StringTokenizer st;
    private BufferedReader br;
    
    public Scanner(final InputStream in) {
        this.br = new BufferedReader(new InputStreamReader(in));
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
        final String next = this.next();
        StringBuilder sb = new StringBuilder("0");
        double n = 0.0;
        double n2 = 1.0;
        boolean b = false;
        boolean b2 = false;
        int i = 0;
        if (next.charAt(0) == '-') {
            b2 = true;
            ++i;
        }
        while (i < next.length()) {
            if (next.charAt(i) == '.') {
                n = (double)Long.parseLong(sb.toString());
                sb = new StringBuilder("0");
                b = true;
            }
            else {
                sb.append(next.charAt(i));
                if (b) {
                    n2 *= 10.0;
                }
            }
            ++i;
        }
        return (n + Long.parseLong(sb.toString()) / n2) * (b2 ? -1 : 1);
    }
    
    private boolean ready() throws IOException {
        return this.br.ready();
    }
}