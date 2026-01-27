public class Main
{
    public static void main(final String[] array) throws IOException {
        final Scanner scanner = new Scanner(System.in);
        final PrintWriter printWriter = new PrintWriter(System.out);
        final String next = scanner.next();
        if (next.contains("RRR")) {
            printWriter.println(3);
        }
        else if (next.contains("RR")) {
            printWriter.println(2);
        }
        else if (next.contains("R")) {
            printWriter.println(1);
        }
        else {
            printWriter.println(0);
        }
        printWriter.close();
    }
    
    static class Scanner
    {
        StringTokenizer st;
        BufferedReader br;
        
        public Scanner(final InputStream in) {
            this.br = new BufferedReader(new InputStreamReader(in));
        }
        
        public String next() throws IOException {
            while (this.st == null || !this.st.hasMoreTokens()) {
                this.st = new StringTokenizer(this.br.readLine());
            }
            return this.st.nextToken();
        }
        
        public int nextInt() throws IOException {
            return Integer.parseInt(this.next());
        }
        
        public long nextLong() throws IOException {
            return Long.parseLong(this.next());
        }
        
        public String nextLine() throws IOException {
            return this.br.readLine();
        }
        
        public double nextDouble() throws IOException {
            final String next = this.next();
            StringBuilder sb = new StringBuilder("0");
            double n = 0.0;
            double n2 = 1.0;
            boolean b = false;
            boolean b2 = false;
            int n3 = 0;
            if (next.charAt(0) == '-') {
                b2 = true;
                ++n3;
            }
            for (int i = n3; i < next.length(); ++i) {
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
            }
            return (n + Long.parseLong(sb.toString()) / n2) * (b2 ? -1 : 1);
        }
        
        public boolean ready() throws IOException {
            return this.br.ready();
        }
    }
}static class Scanner
{
    StringTokenizer st;
    BufferedReader br;
    
    public Scanner(final InputStream in) {
        this.br = new BufferedReader(new InputStreamReader(in));
    }
    
    public String next() throws IOException {
        while (this.st == null || !this.st.hasMoreTokens()) {
            this.st = new StringTokenizer(this.br.readLine());
        }
        return this.st.nextToken();
    }
    
    public int nextInt() throws IOException {
        return Integer.parseInt(this.next());
    }
    
    public long nextLong() throws IOException {
        return Long.parseLong(this.next());
    }
    
    public String nextLine() throws IOException {
        return this.br.readLine();
    }
    
    public double nextDouble() throws IOException {
        final String next = this.next();
        StringBuilder sb = new StringBuilder("0");
        double n = 0.0;
        double n2 = 1.0;
        boolean b = false;
        boolean b2 = false;
        int n3 = 0;
        if (next.charAt(0) == '-') {
            b2 = true;
            ++n3;
        }
        for (int i = n3; i < next.length(); ++i) {
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
        }
        return (n + Long.parseLong(sb.toString()) / n2) * (b2 ? -1 : 1);
    }
    
    public boolean ready() throws IOException {
        return this.br.ready();
    }
}