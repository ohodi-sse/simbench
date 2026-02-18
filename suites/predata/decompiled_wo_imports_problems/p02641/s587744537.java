final class InputReader
{
    private BufferedReader br;
    private StringTokenizer st;
    
    public InputReader(final InputStream in) {
        this.br = new BufferedReader(new InputStreamReader(in));
        this.st = null;
    }
    
    public final String next() {
        while (true) {
            if (this.st != null) {
                if (this.st.hasMoreTokens()) {
                    break;
                }
            }
            try {
                this.st = new StringTokenizer(this.br.readLine());
                continue;
            }
            catch (final IOException cause) {
                throw new RuntimeException(cause);
            }
            break;
        }
        return this.st.nextToken();
    }
    
    private int nextInt() {
        return Integer.parseInt(this.next());
    }
    
    private long nextLong() {
        return Long.parseLong(this.next());
    }
    
    private double nextDouble() {
        return Double.parseDouble(this.next());
    }
}











public final class Main
{
    private static void main$3231c38a() {
        final InputReader inputReader = new InputReader(System.in);
        final PrintWriter printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)), true);
        new TaskB();
        final InputReader inputReader2 = inputReader;
        final PrintWriter printWriter2 = printWriter;
        final InputReader inputReader3 = inputReader2;
        final int int1 = Integer.parseInt(inputReader2.next());
        final int int2 = Integer.parseInt(inputReader3.next());
        final boolean[] array;
        Arrays.fill(array = new boolean[102], true);
        final int[] array2 = new int[int2];
        for (int i = 0; i < int2; ++i) {
            array[array2[i] = Integer.parseInt(inputReader3.next())] = false;
        }
        int n = Integer.MAX_VALUE;
        int x = -1;
        for (int j = 0; j <= int1; ++j) {
            final int abs;
            if (array[j] && (abs = Math.abs(int1 - j)) < n) {
                x = j;
                n = abs;
            }
        }
        for (int k = int1 + 1; k <= 101; ++k) {
            final int abs2;
            if (array[k] && (abs2 = Math.abs(int1 - k)) < n) {
                x = k;
                n = abs2;
            }
        }
        printWriter2.println(x);
        printWriter.flush();
        printWriter.close();
    }
}




final class Pair
{
    private int first;
    private int second;
    
    private Pair(final int first, final int second) {
        this.first = first;
        this.second = second;
    }
}







final class TaskB
{
    private static void solve$ddb01a9(final InputReader inputReader, final PrintWriter printWriter) {
        final int int1 = Integer.parseInt(inputReader.next());
        final int int2 = Integer.parseInt(inputReader.next());
        final boolean[] array;
        Arrays.fill(array = new boolean[102], true);
        final int[] array2 = new int[int2];
        for (int i = 0; i < int2; ++i) {
            array[array2[i] = Integer.parseInt(inputReader.next())] = false;
        }
        int n = Integer.MAX_VALUE;
        int x = -1;
        for (int j = 0; j <= int1; ++j) {
            final int abs;
            if (array[j] && (abs = Math.abs(int1 - j)) < n) {
                x = j;
                n = abs;
            }
        }
        for (int k = int1 + 1; k <= 101; ++k) {
            final int abs2;
            if (array[k] && (abs2 = Math.abs(int1 - k)) < n) {
                x = k;
                n = abs2;
            }
        }
        printWriter.println(x);
    }
    
    private static long __gcd(long n, long n2) {
        while (n2 != 0L) {
            final long n3 = n2;
            n2 = n % n2;
            n = n3;
        }
        return n;
    }
    
    private static int getInt(final int n) {
        int n2 = -1;
        switch (n) {
            case 0: {
                n2 = 6;
                break;
            }
            case 1: {
                n2 = 2;
                break;
            }
            case 2: {
                n2 = 5;
                break;
            }
            case 3: {
                n2 = 5;
                break;
            }
            case 4: {
                n2 = 4;
                break;
            }
            case 5: {
                n2 = 5;
                break;
            }
            case 6: {
                n2 = 6;
                break;
            }
            case 7: {
                n2 = 3;
                break;
            }
            case 8: {
                n2 = 7;
                break;
            }
            case 9: {
                n2 = 6;
                break;
            }
        }
        return n2;
    }
    
    private static int isPow(long n) {
        int n2;
        for (n2 = 0; n > 0L; n /= 2L, ++n2) {}
        return n2;
    }
}