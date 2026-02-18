final class FastReader
{
    private BufferedReader br;
    private StringTokenizer st;
    
    public FastReader() {
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }
    
    final String next() {
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
    
    private int nextInt() {
        return Integer.parseInt(this.next());
    }
    
    private Long nextLong() {
        return Long.parseLong(this.next());
    }
    
    private double nextDouble() {
        return Double.parseDouble(this.next());
    }
    
    private String nextLine() {
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











public final class Main
{
    private static void main$3231c38a() throws IOException {
        final PrintWriter printWriter = new PrintWriter(System.out);
        final FastReader fastReader = new FastReader();
        new test();
        final FastReader fastReader2 = fastReader;
        final PrintWriter printWriter2 = printWriter;
        final FastReader fastReader3 = fastReader2;
        final int int1 = Integer.parseInt(fastReader2.next());
        final int int2 = Integer.parseInt(fastReader3.next());
        final ArrayList list = new ArrayList();
        for (int i = 0; i < int2; ++i) {
            list.add(Integer.parseInt(fastReader3.next()));
        }
        Collections.sort((List<Comparable>)list);
        Label_0192: {
            if (int2 == 0) {
                printWriter2.println(int1);
            }
            else {
                if (list.contains(int1)) {
                    while (true) {
                        int n;
                        int n2;
                        for (n = int1, n2 = 1; list.contains(n - n2); ++n2) {
                            if (!list.contains(n + n2)) {
                                final int x = n + n2;
                                printWriter2.println(x);
                                break Label_0192;
                            }
                        }
                        final int x = n - n2;
                        continue;
                    }
                }
                printWriter2.println(int1);
            }
        }
        printWriter.close();
    }
}









final class test
{
    private static void solve(final FastReader fastReader, final PrintWriter printWriter) {
        final int int1 = Integer.parseInt(fastReader.next());
        final int int2 = Integer.parseInt(fastReader.next());
        final ArrayList list = new ArrayList();
        for (int i = 0; i < int2; ++i) {
            list.add(Integer.parseInt(fastReader.next()));
        }
        Collections.sort((List<Comparable>)list);
        if (int2 == 0) {
            printWriter.println(int1);
            return;
        }
        if (!list.contains(int1)) {
            printWriter.println(int1);
            return;
        }
        while (true) {
            int n;
            int n2;
            for (n = int1, n2 = 1; list.contains(n - n2); ++n2) {
                if (!list.contains(n + n2)) {
                    final int x = n + n2;
                    printWriter.println(x);
                    return;
                }
            }
            final int x = n - n2;
            continue;
        }
    }
}