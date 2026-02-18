public final class Main
{
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static byte[] buffer;
    private static int index;
    private static InputStream input_stream;
    private static int total;
    private static boolean[] al;
    
    private static String ns() throws IOException {
        final StringBuilder sb = new StringBuilder();
        int n;
        for (n = read(); isWhiteSpace(n); n = read()) {}
        while (!isWhiteSpace(n)) {
            sb.append((char)n);
            n = read();
        }
        return sb.toString();
    }
    
    private static int read() throws IOException {
        if (Main.total < 0) {
            throw new InputMismatchException();
        }
        if (Main.index >= Main.total) {
            Main.index = 0;
            if ((Main.total = Main.input_stream.read(Main.buffer)) <= 0) {
                return -1;
            }
        }
        return Main.buffer[Main.index++];
    }
    
    private static int ni() throws IOException {
        int n = 0;
        int n2;
        for (n2 = read(); isWhiteSpace(n2); n2 = read()) {}
        int n3 = 1;
        if (n2 == 45) {
            n3 = -1;
            n2 = read();
        }
        while (!isWhiteSpace(n2)) {
            if (n2 < 48 || n2 > 57) {
                throw new InputMismatchException();
            }
            n = n * 10 + (n2 - 48);
            n2 = read();
        }
        return n3 * n;
    }
    
    private static long nl() throws IOException {
        long n = 0L;
        int n2;
        for (n2 = read(); isWhiteSpace(n2); n2 = read()) {}
        long n3 = 1L;
        if (n2 == 45) {
            n3 = -1L;
            n2 = read();
        }
        while (!isWhiteSpace(n2)) {
            if (n2 < 48 || n2 > 57) {
                throw new InputMismatchException();
            }
            n = n * 10L + (n2 - 48);
            n2 = read();
        }
        return n3 * n;
    }
    
    private static double nd() throws IOException {
        double n = 0.0;
        int n2;
        for (n2 = read(); isWhiteSpace(n2); n2 = read()) {}
        int n3 = 1;
        if (n2 == 45) {
            n3 = -1;
            n2 = read();
        }
        while (!isWhiteSpace(n2) && n2 != 46) {
            if (n2 < 48 || n2 > 57) {
                throw new InputMismatchException();
            }
            n = n * 10.0 + (n2 - 48);
            n2 = read();
        }
        if (n2 == 46) {
            int n4 = read();
            double n5 = 1.0;
            while (!isWhiteSpace(n4)) {
                if (n4 < 48 || n4 > 57) {
                    throw new InputMismatchException();
                }
                n5 /= 10.0;
                n += (n4 - 48) * n5;
                n4 = read();
            }
        }
        return n * n3;
    }
    
    private static String nsl() throws IOException {
        String line = "";
        try {
            line = Main.br.readLine();
        }
        catch (final IOException ex) {
            ex.printStackTrace();
        }
        return line;
    }
    
    private static boolean isWhiteSpace(final int n) {
        return n == 32 || n == 10 || n == 13 || n == 9 || n == -1;
    }
    
    private static void p(final String csq) throws IOException {
        Main.bw.append((CharSequence)csq);
    }
    
    private static void pn(final String csq) throws IOException {
        Main.bw.append((CharSequence)csq);
        Main.bw.append((CharSequence)"\n");
    }
    
    private static void close() throws IOException {
        Main.bw.close();
    }
    
    private static void flush() throws IOException {
        Main.bw.flush();
    }
    
    private static void prime() {
        int n = 2;
        while (true) {
            final int n2 = n;
            if (n2 * n2 > 1000000) {
                break;
            }
            if (!Main.al[n]) {
                for (int i = n << 1; i <= 1000000; i += n) {
                    Main.al[i] = true;
                }
            }
            ++n;
        }
    }
    
    private static void main$3231c38a() throws IOException {
        final StringBuilder sb = new StringBuilder();
        int n;
        for (n = read(); isWhiteSpace(n); n = read()) {}
        while (!isWhiteSpace(n)) {
            sb.append((char)n);
            n = read();
        }
        final String string;
        if ((string = sb.toString()).charAt(0) == 'R') {
            if (string.charAt(1) == 'R') {
                if (string.charAt(2) == 'R') {
                    pn("3");
                }
                else if (string.charAt(2) == 'S') {
                    pn("2");
                }
            }
            if (string.charAt(1) == 'S') {
                if (string.charAt(2) == 'R') {
                    pn("1");
                }
                else if (string.charAt(2) == 'S') {
                    pn("1");
                }
            }
        }
        if (string.charAt(0) == 'S') {
            if (string.charAt(1) == 'R') {
                if (string.charAt(2) == 'R') {
                    pn("2");
                }
                else if (string.charAt(2) == 'S') {
                    pn("1");
                }
            }
            if (string.charAt(1) == 'S') {
                if (string.charAt(2) == 'R') {
                    pn("1");
                }
                else if (string.charAt(2) == 'S') {
                    pn("0");
                }
            }
        }
        Main.bw.flush();
    }
    
    static {
        Main.br = new BufferedReader(new InputStreamReader(System.in));
        Main.bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Main.buffer = new byte[10240];
        Main.input_stream = System.in;
        Main.al = new boolean[1100000];
    }
    
    static final class Node
    {
        private int h;
        private int w;
        
        private Node(final int h, final int w) {
            this.h = h;
            this.w = w;
        }
    }
}