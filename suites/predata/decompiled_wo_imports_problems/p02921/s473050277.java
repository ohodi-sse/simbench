private class MyScanner
{
    String[] s;
    int i;
    BufferedReader br;
    String reg;
    
    MyScanner(final Main obj) {
        Objects.requireNonNull(obj);
        this.reg = " ";
        this.s = new String[0];
        this.i = 0;
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }
    
    public String next() {
        try {
            if (this.i < this.s.length) {
                return this.s[this.i++];
            }
            String s;
            for (s = this.br.readLine(); s.equals(""); s = this.br.readLine()) {}
            this.s = s.split(this.reg, 0);
            this.i = 0;
            return this.s[this.i++];
        }
        catch (final Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public int nextInt() {
        try {
            return Integer.parseInt(this.next());
        }
        catch (final Exception ex) {
            ex.printStackTrace();
            return -1;
        }
    }
    
    public double nextDouble() {
        try {
            return Double.parseDouble(this.next());
        }
        catch (final Exception ex) {
            ex.printStackTrace();
            return -1.0;
        }
    }
    
    public long nextLong() {
        try {
            return Long.parseLong(this.next());
        }
        catch (final Exception ex) {
            ex.printStackTrace();
            return -1L;
        }
    }
}public class Main
{
    public static void main(final String[] array) {
        new Main().solve(array);
    }
    
    public void solve(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final char[] charArray = scanner.next().toCharArray();
        final char[] charArray2 = scanner.next().toCharArray();
        int x = 0;
        for (int i = 0; i < charArray.length; ++i) {
            if (charArray[i] == charArray2[i]) {
                ++x;
            }
        }
        System.out.println(x);
    }
    
    private class MyScanner
    {
        String[] s;
        int i;
        BufferedReader br;
        String reg;
        
        MyScanner(final Main obj) {
            Objects.requireNonNull(obj);
            this.reg = " ";
            this.s = new String[0];
            this.i = 0;
            this.br = new BufferedReader(new InputStreamReader(System.in));
        }
        
        public String next() {
            try {
                if (this.i < this.s.length) {
                    return this.s[this.i++];
                }
                String s;
                for (s = this.br.readLine(); s.equals(""); s = this.br.readLine()) {}
                this.s = s.split(this.reg, 0);
                this.i = 0;
                return this.s[this.i++];
            }
            catch (final Exception ex) {
                ex.printStackTrace();
                return null;
            }
        }
        
        public int nextInt() {
            try {
                return Integer.parseInt(this.next());
            }
            catch (final Exception ex) {
                ex.printStackTrace();
                return -1;
            }
        }
        
        public double nextDouble() {
            try {
                return Double.parseDouble(this.next());
            }
            catch (final Exception ex) {
                ex.printStackTrace();
                return -1.0;
            }
        }
        
        public long nextLong() {
            try {
                return Long.parseLong(this.next());
            }
            catch (final Exception ex) {
                ex.printStackTrace();
                return -1L;
            }
        }
    }
}