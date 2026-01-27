public class Main
{
    public static void main(final String[] array) {
        final FastScanner fastScanner = new FastScanner(System.in);
        final int nextInt = fastScanner.nextInt();
        final int nextInt2 = fastScanner.nextInt();
        if (nextInt2 == 0) {
            System.out.println(nextInt);
        }
        else {
            final int[] array2 = new int[nextInt2];
            for (int i = 0; i < nextInt2; ++i) {
                array2[i] = fastScanner.nextInt();
            }
            int n = -1;
            for (int j = nextInt; j >= 0; --j) {
                boolean b = false;
                for (int k = 0; k < nextInt2; ++k) {
                    if (array2[k] == j) {
                        b = true;
                        break;
                    }
                }
                if (!b) {
                    n = j;
                    break;
                }
            }
            int n2 = -1;
            for (int l = nextInt + 1; l <= 101; ++l) {
                boolean b2 = false;
                for (int n3 = 0; n3 < nextInt2; ++n3) {
                    if (array2[n3] == l) {
                        b2 = true;
                        break;
                    }
                }
                if (!b2) {
                    n2 = l;
                    break;
                }
            }
            if (n2 == -1 && n != -1) {
                System.out.println(n);
            }
            else if (n == -1 && n2 != -1) {
                System.out.println(n2);
            }
            else if (nextInt - n <= n2 - nextInt) {
                System.out.println(n);
            }
            else {
                System.out.println(n2);
            }
        }
    }
    
    private static class FastScanner
    {
        private BufferedReader reader;
        private StringTokenizer tokenizer;
        
        public FastScanner(final InputStream in) {
            this.reader = null;
            this.tokenizer = null;
            this.reader = new BufferedReader(new InputStreamReader(in));
            this.tokenizer = null;
        }
        
        public String next() {
            if (this.tokenizer != null) {
                if (this.tokenizer.hasMoreTokens()) {
                    return this.tokenizer.nextToken();
                }
            }
            try {
                this.tokenizer = new StringTokenizer(this.reader.readLine());
            }
            catch (final IOException cause) {
                throw new RuntimeException(cause);
            }
            return this.tokenizer.nextToken();
        }
        
        public int nextInt() {
            return Integer.parseInt(this.next());
        }
    }
}private static class FastScanner
{
    private BufferedReader reader;
    private StringTokenizer tokenizer;
    
    public FastScanner(final InputStream in) {
        this.reader = null;
        this.tokenizer = null;
        this.reader = new BufferedReader(new InputStreamReader(in));
        this.tokenizer = null;
    }
    
    public String next() {
        if (this.tokenizer != null) {
            if (this.tokenizer.hasMoreTokens()) {
                return this.tokenizer.nextToken();
            }
        }
        try {
            this.tokenizer = new StringTokenizer(this.reader.readLine());
        }
        catch (final IOException cause) {
            throw new RuntimeException(cause);
        }
        return this.tokenizer.nextToken();
    }
    
    public int nextInt() {
        return Integer.parseInt(this.next());
    }
}