static class FastReader
{
    BufferedReader br;
    BufferedReader br1;
    StringTokenizer st;
    
    public FastReader() {
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }
    
    public FastReader(final String fileName) throws FileNotFoundException {
        this.br = new BufferedReader(new FileReader(fileName));
    }
    
    String next() {
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
    
    int nextInt() {
        return Integer.parseInt(this.next());
    }
    
    long nextLong() {
        return Long.parseLong(this.next());
    }
    
    double nextDouble() {
        return Double.parseDouble(this.next());
    }
    
    char[][] readCharArray(final int n, final int n2) {
        final char[][] array = new char[n][n2];
        for (int i = 0; i < n; ++i) {
            final String nextLine = this.nextLine();
            for (int j = 0; j < n; ++j) {
                array[i][j] = nextLine.charAt(j);
            }
        }
        return array;
    }
    
    char[][] readCharArray(final int n) {
        return this.readCharArray(n, n);
    }
    
    int[] readArray(final int n) {
        final int[] array = new int[n];
        for (int i = 0; i < n; ++i) {
            array[i] = this.nextInt();
        }
        return array;
    }
    
    long[] readLongArray(final int n) {
        final long[] array = new long[n];
        for (int i = 0; i < n; ++i) {
            array[i] = this.nextLong();
        }
        return array;
    }
    
    String nextLine() {
        String line = "";
        try {
            line = this.br.readLine();
        }
        catch (final IOException ex) {
            ex.printStackTrace();
        }
        return line;
    }
}public class Main
{
    public static void main(final String[] array) throws NumberFormatException, IOException {
        final FastReader fastReader = new FastReader();
        final PrintWriter printWriter = new PrintWriter(System.out);
        final int nextInt = fastReader.nextInt();
        int x = 0;
        int n = -1;
        for (int i = 1; i <= nextInt; ++i) {
            int n2;
            int n3;
            for (n2 = i, n3 = 0; n2 % 2 == 0; n2 /= 2, ++n3) {}
            if (n3 >= n) {
                n = n3;
                x = i;
            }
        }
        printWriter.println(x);
        printWriter.close();
    }
    
    static class FastReader
    {
        BufferedReader br;
        BufferedReader br1;
        StringTokenizer st;
        
        public FastReader() {
            this.br = new BufferedReader(new InputStreamReader(System.in));
        }
        
        public FastReader(final String fileName) throws FileNotFoundException {
            this.br = new BufferedReader(new FileReader(fileName));
        }
        
        String next() {
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
        
        int nextInt() {
            return Integer.parseInt(this.next());
        }
        
        long nextLong() {
            return Long.parseLong(this.next());
        }
        
        double nextDouble() {
            return Double.parseDouble(this.next());
        }
        
        char[][] readCharArray(final int n, final int n2) {
            final char[][] array = new char[n][n2];
            for (int i = 0; i < n; ++i) {
                final String nextLine = this.nextLine();
                for (int j = 0; j < n; ++j) {
                    array[i][j] = nextLine.charAt(j);
                }
            }
            return array;
        }
        
        char[][] readCharArray(final int n) {
            return this.readCharArray(n, n);
        }
        
        int[] readArray(final int n) {
            final int[] array = new int[n];
            for (int i = 0; i < n; ++i) {
                array[i] = this.nextInt();
            }
            return array;
        }
        
        long[] readLongArray(final int n) {
            final long[] array = new long[n];
            for (int i = 0; i < n; ++i) {
                array[i] = this.nextLong();
            }
            return array;
        }
        
        String nextLine() {
            String line = "";
            try {
                line = this.br.readLine();
            }
            catch (final IOException ex) {
                ex.printStackTrace();
            }
            return line;
        }
    }
}