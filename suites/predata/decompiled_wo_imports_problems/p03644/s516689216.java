public final class Main
{
    private int _intMax = Integer.MAX_VALUE;
    private int _intMin = Integer.MIN_VALUE;
    private long _longMax = Long.MAX_VALUE;
    private long _longMin = Long.MIN_VALUE;
    private static boolean bElapsed;
    private static BufferedReader _in;
    private static PrintWriter _out;
    
    private static void solve() {
        int int1;
        int i;
        for (int1 = Integer.parseInt(readLine()), i = 1; i <= int1; i <<= 1) {}
        if (i > int1) {
            i /= 2;
        }
        Main._out.println((long)i);
    }
    
    private static int abs(final int n) {
        if (n >= 0) {
            return n;
        }
        return -n;
    }
    
    private static long abs(final long n) {
        if (n >= 0L) {
            return n;
        }
        return -n;
    }
    
    private static int max(final int n, final int n2) {
        if (n > n2) {
            return n;
        }
        return n2;
    }
    
    private static long max(final long n, final long n2) {
        if (n > n2) {
            return n;
        }
        return n2;
    }
    
    private static int min(final int n, final int n2) {
        if (n < n2) {
            return n;
        }
        return n2;
    }
    
    private static long min(final long n, final long n2) {
        if (n < n2) {
            return n;
        }
        return n2;
    }
    
    private static int pint(final String s) {
        return Integer.parseInt(s);
    }
    
    private static long plong(final String s) {
        return Long.parseLong(s);
    }
    
    private static String readLine() {
        try {
            return Main._in.readLine();
        }
        catch (final IOException cause) {
            throw new RuntimeException(cause);
        }
    }
    
    private static int readNum() {
        return Integer.parseInt(readLine());
    }
    
    private static long readLong() {
        return Long.parseLong(readLine());
    }
    
    private static String[] readFlds() {
        return readLine().split(" ");
    }
    
    private static int[] readNums() {
        final String[] flds;
        final int[] array = new int[(flds = readFlds()).length];
        for (int i = 0; i < flds.length; ++i) {
            array[i] = Integer.parseInt(flds[i]);
        }
        return array;
    }
    
    private static long[] readLongs() {
        final String[] flds;
        final long[] array = new long[(flds = readFlds()).length];
        for (int i = 0; i < flds.length; ++i) {
            array[i] = Integer.parseInt(flds[i]);
        }
        return array;
    }
    
    private static void p(final char c) {
        Main._out.print(c);
    }
    
    private static void pln(final char x) {
        Main._out.println(x);
    }
    
    private static void p(final double d) {
        Main._out.print(d);
    }
    
    private static void pln(final double x) {
        Main._out.println(x);
    }
    
    private static void p(final long l) {
        Main._out.print(l);
    }
    
    private static void pln(final long x) {
        Main._out.println(x);
    }
    
    private static void p(final String s) {
        Main._out.print(s);
    }
    
    private static void pln(final String x) {
        Main._out.println(x);
    }
    
    private static void main$3231c38a() {
        Main._in = new BufferedReader(new InputStreamReader(System.in));
        Main._out = new PrintWriter(System.out);
        new Main();
        int int1;
        int i;
        for (int1 = Integer.parseInt(readLine()), i = 1; i <= int1; i <<= 1) {}
        if (i > int1) {
            i /= 2;
        }
        Main._out.println((long)i);
        Main._out.flush();
    }
}