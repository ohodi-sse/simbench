public final class Main
{
    private static BufferedReader br;
    private static StringTokenizer tokenizer;
    
    private static void solve() {
        final long long1 = Long.parseLong(next());
        final char[] charArray = next().toCharArray();
        long n = 0L;
        int n2 = 2;
        for (int length = charArray.length, i = 0; i < length; ++i) {
            final char ch;
            if ((ch = charArray[i]) != '.') {
                n += Character.getNumericValue(ch) * (long)Math.pow(10.0, n2);
                --n2;
            }
        }
        System.out.println(long1 * n / 100L);
    }
    
    private static void main$3231c38a() {
        Main.br = new BufferedReader(new InputStreamReader(System.in));
        final String getenv;
        if ((getenv = System.getenv("DD_PATH")) != null) {
            try {
                Main.br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(getenv))));
            }
            catch (final Exception cause) {
                throw new RuntimeException(cause);
            }
        }
        int i = 1;
        while (i != 0) {
            final long long1 = Long.parseLong(next());
            final char[] charArray = next().toCharArray();
            long n = 0L;
            int n2 = 2;
            for (int length = charArray.length, j = 0; j < length; ++j) {
                final char ch;
                if ((ch = charArray[j]) != '.') {
                    n += Character.getNumericValue(ch) * (long)Math.pow(10.0, n2);
                    --n2;
                }
            }
            System.out.println(long1 * n / 100L);
            try {
                Main.br.mark(1);
                if (Main.br.read() > 0) {
                    Main.br.reset();
                    System.out.println("---");
                    continue;
                }
                i = 0;
                continue;
            }
            catch (final Exception cause2) {
                throw new RuntimeException(cause2);
            }
            break;
        }
    }
    
    private static String next() {
        while (true) {
            if (Main.tokenizer != null) {
                if (Main.tokenizer.hasMoreTokens()) {
                    break;
                }
            }
            try {
                Main.tokenizer = new StringTokenizer(Main.br.readLine());
                continue;
            }
            catch (final Exception cause) {
                throw new RuntimeException(cause);
            }
            break;
        }
        return Main.tokenizer.nextToken();
    }
    
    private static int ni() {
        return Integer.parseInt(next());
    }
    
    private static long nl() {
        return Long.parseLong(next());
    }
    
    private static double nd() {
        return Double.parseDouble(next());
    }
    
    private static int[] na(final int n) {
        final int[] array = new int[n];
        for (int i = 0; i < n; ++i) {
            array[i] = Integer.parseInt(next());
        }
        return array;
    }
    
    private static char[] ns() {
        return next().toCharArray();
    }
    
    private static long[] nal(final int n) {
        final long[] array = new long[n];
        for (int i = 0; i < n; ++i) {
            array[i] = Long.parseLong(next());
        }
        return array;
    }
    
    static {
        Main.tokenizer = null;
    }
}