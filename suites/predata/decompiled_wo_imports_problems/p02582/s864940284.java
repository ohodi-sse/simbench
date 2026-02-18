public final class Main
{
    private static PrintWriter out;
    
    private static void main$3231c38a() throws Exception {
        final FastReader fastReader = new FastReader(System.in);
        int n = 1;
        while (n-- > 0) {
            FastReader fastReader2;
            int i;
            for (i = (fastReader2 = fastReader).scan(); i <= 32; i = fastReader2.scan()) {}
            final StringBuilder sb = new StringBuilder();
            while (i > 32) {
                sb.append((char)i);
                i = fastReader2.scan();
            }
            final String string = sb.toString();
            final HashMap hashMap;
            (hashMap = new HashMap()).put("SSS", 0);
            hashMap.put("SSR", 1);
            hashMap.put("SRS", 1);
            hashMap.put("SRR", 2);
            hashMap.put("RSS", 1);
            hashMap.put("RSR", 1);
            hashMap.put("RRS", 2);
            hashMap.put("RRR", 3);
            Main.out.println(hashMap.get(string));
        }
        Main.out.flush();
        Main.out.close();
    }
    
    static {
        Main.out = new PrintWriter(new OutputStreamWriter(System.out));
    }
    
    static final class FastReader
    {
        private byte[] buf;
        private int index;
        private int total;
        private InputStream in;
        
        FastReader(final InputStream in) {
            this.buf = new byte[2048];
            this.in = in;
        }
        
        final int scan() throws IOException {
            if (this.index >= this.total) {
                this.index = 0;
                this.total = this.in.read(this.buf);
                if (this.total <= 0) {
                    return -1;
                }
            }
            return this.buf[this.index++];
        }
        
        private String next() throws IOException {
            int i;
            for (i = this.scan(); i <= 32; i = this.scan()) {}
            final StringBuilder sb = new StringBuilder();
            while (i > 32) {
                sb.append((char)i);
                i = this.scan();
            }
            return sb.toString();
        }
        
        private int nextInt() throws IOException {
            int n = 0;
            int i;
            for (i = this.scan(); i <= 32; i = this.scan()) {}
            final boolean b = i == 45;
            while (true) {
                Label_0050: {
                    if (i != 45 && i != 43) {
                        break Label_0050;
                    }
                    i = this.scan();
                }
                if (i >= 48 && i <= 57) {
                    n = (n << 3) + (n << 1) + (i & 0xF);
                    continue;
                }
                break;
            }
            if (b) {
                return -n;
            }
            return n;
        }
        
        private long nextLong() throws IOException {
            long n = 0L;
            int i;
            for (i = this.scan(); i <= 32; i = this.scan()) {}
            final boolean b = i == 45;
            while (true) {
                Label_0051: {
                    if (i != 45 && i != 43) {
                        break Label_0051;
                    }
                    i = this.scan();
                }
                if (i >= 48 && i <= 57) {
                    n = (n << 3) + (n << 1) + (i & 0xF);
                    continue;
                }
                break;
            }
            if (b) {
                return -n;
            }
            return n;
        }
    }
}