static class FastReader
{
    BufferedReader br;
    StringTokenizer st;
    
    public FastReader(final InputStream in) {
        this.br = new BufferedReader(new InputStreamReader(in));
    }
    
    public String next() {
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
    
    public int nextInt() {
        return Integer.parseInt(this.next());
    }
}public class Main
{
    public static void main(final String[] array) {
        final InputStream in = System.in;
        final PrintStream out = System.out;
        final FastReader fastReader = new FastReader(in);
        final PrintWriter printWriter = new PrintWriter(out);
        new TaskB().solve(1, fastReader, printWriter);
        printWriter.close();
    }
    
    static class TaskB
    {
        public void solve(final int n, final FastReader fastReader, final PrintWriter printWriter) {
            final int nextInt = fastReader.nextInt();
            if (nextInt < 2) {
                printWriter.println(1);
            }
            else if (nextInt < 4) {
                printWriter.println(2);
            }
            else if (nextInt < 8) {
                printWriter.println(4);
            }
            else if (nextInt < 16) {
                printWriter.println(8);
            }
            else if (nextInt < 32) {
                printWriter.println(16);
            }
            else if (nextInt < 64) {
                printWriter.println(32);
            }
            else {
                printWriter.println(64);
            }
        }
    }
    
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;
        
        public FastReader(final InputStream in) {
            this.br = new BufferedReader(new InputStreamReader(in));
        }
        
        public String next() {
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
        
        public int nextInt() {
            return Integer.parseInt(this.next());
        }
    }
}static class TaskB
{
    public void solve(final int n, final FastReader fastReader, final PrintWriter printWriter) {
        final int nextInt = fastReader.nextInt();
        if (nextInt < 2) {
            printWriter.println(1);
        }
        else if (nextInt < 4) {
            printWriter.println(2);
        }
        else if (nextInt < 8) {
            printWriter.println(4);
        }
        else if (nextInt < 16) {
            printWriter.println(8);
        }
        else if (nextInt < 32) {
            printWriter.println(16);
        }
        else if (nextInt < 64) {
            printWriter.println(32);
        }
        else {
            printWriter.println(64);
        }
    }
}