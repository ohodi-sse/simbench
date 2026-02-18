public final class Main
{
    private static long MOD = 1000000007L;
    private static String[] Ws;
    private static int wsIndx;
    private static BufferedReader in;
    
    private static void main$3231c38a() throws Exception {
        final char[] charArray = nextString().toCharArray();
        final char[] charArray2 = nextString().toCharArray();
        long x = 0L;
        for (int i = 0; i < charArray.length; ++i) {
            if (charArray[i] == charArray2[i]) {
                ++x;
            }
        }
        System.out.println(x);
        if (Main.in != null) {
            Main.in.close();
        }
    }
    
    private static void solution$3231c38a() throws Exception {
        final char[] charArray = nextString().toCharArray();
        final char[] charArray2 = nextString().toCharArray();
        long x = 0L;
        for (int i = 0; i < charArray.length; ++i) {
            if (charArray[i] == charArray2[i]) {
                ++x;
            }
        }
        System.out.println(x);
    }
    
    private static String[] toStringArray(final String s) {
        final String[] array = new String[s.length()];
        final char[] charArray = s.toCharArray();
        for (int i = 0; i < array.length; ++i) {
            array[i] = String.valueOf(charArray[i]);
        }
        return array;
    }
    
    private static void check() throws Exception {
        if (Main.in == null) {
            Main.in = new BufferedReader(new InputStreamReader(System.in));
        }
        if (Main.Ws == null || Main.Ws.length <= Main.wsIndx) {
            Main.Ws = Main.in.readLine().split(" ");
            Main.wsIndx = 0;
        }
    }
    
    private static int nextInt() throws Exception {
        check();
        return Integer.parseInt(Main.Ws[Main.wsIndx++]);
    }
    
    private static long nextLong() throws Exception {
        check();
        return Long.parseLong(Main.Ws[Main.wsIndx++]);
    }
    
    private static String nextString() throws Exception {
        check();
        return Main.Ws[Main.wsIndx++];
    }
    
    private static int[] nextInts() throws Exception {
        check();
        final int[] array = new int[Main.Ws.length];
        for (int i = 0; i < array.length; ++i) {
            array[i] = Integer.parseInt(Main.Ws[i]);
        }
        Main.wsIndx = Main.Ws.length;
        return array;
    }
    
    private static long[] nextLongs() throws Exception {
        check();
        final long[] array = new long[Main.Ws.length];
        for (int i = 0; i < array.length; ++i) {
            array[i] = Long.parseLong(Main.Ws[i]);
        }
        Main.wsIndx = Main.Ws.length;
        return array;
    }
    
    private static String[] nextStrings() throws Exception {
        check();
        Main.wsIndx = Main.Ws.length;
        return Main.Ws;
    }
    
    static {
        Main.Ws = null;
        Main.wsIndx = 0;
        Main.in = null;
    }
}