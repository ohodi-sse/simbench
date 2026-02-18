public final class Main
{
    private static final BigDecimal BD1000000007;
    private static BufferedReader brStdin;
    private static String[] readBuf;
    private static int readPtr;
    
    private static String getString() throws IOException {
        while (Main.readBuf == null || Main.readPtr >= Main.readBuf.length) {
            Main.readBuf = Main.brStdin.readLine().split(" ");
            Main.readPtr = 0;
        }
        return Main.readBuf[Main.readPtr++];
    }
    
    private static int getInt() throws IOException {
        return Integer.parseInt(getString());
    }
    
    private static long getLong() throws IOException {
        return Long.parseLong(getString());
    }
    
    private static BigDecimal getBD() throws IOException {
        return new BigDecimal(getString());
    }
    
    private static String[] getStringArray(final int n) throws IOException {
        final String[] array = new String[n];
        for (int i = 0; i < array.length; ++i) {
            array[i] = getString();
        }
        return array;
    }
    
    private static int[] getIntArray(final int n) throws IOException {
        final int[] array = new int[n];
        for (int i = 0; i < array.length; ++i) {
            array[i] = Integer.parseInt(getString());
        }
        return array;
    }
    
    private static long[] getLongArray(final int n) throws IOException {
        final long[] array = new long[n];
        for (int i = 0; i < array.length; ++i) {
            array[i] = Long.parseLong(getString());
        }
        return array;
    }
    
    private static BigDecimal[] getBDArray(final int n) throws IOException {
        final BigDecimal[] array = new BigDecimal[n];
        for (int i = 0; i < array.length; ++i) {
            array[i] = new BigDecimal(getString());
        }
        return array;
    }
    
    private static BigDecimal mod1000000007(final BigDecimal bigDecimal) {
        return bigDecimal.subtract(Main.BD1000000007.multiply(bigDecimal.divide(Main.BD1000000007, 1)));
    }
    
    private static BigDecimal mod1000000007(final int val) {
        return mod1000000007(new BigDecimal(val));
    }
    
    private static BigDecimal mod1000000007(final long val) {
        return mod1000000007(new BigDecimal(val));
    }
    
    private static void main$3231c38a() throws IOException {
        final char[] charArray = getString().toCharArray();
        final char[] charArray2 = getString().toCharArray();
        System.out.println(((charArray[0] == charArray2[0]) + (charArray[1] == charArray2[1]) + (charArray[2] == charArray2[2])) ? 1 : 0);
    }
    
    static {
        BD1000000007 = new BigDecimal(1000000007);
        Main.brStdin = new BufferedReader(new InputStreamReader(System.in));
        Main.readBuf = null;
        Main.readPtr = 0;
    }
}