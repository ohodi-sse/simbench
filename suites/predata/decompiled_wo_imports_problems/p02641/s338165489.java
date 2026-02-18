final class Main
{
    private static boolean[] visited;
    private static long[][][] dp;
    private static long MOD;
    private static Hashtable<String, Long> hash;
    
    private static void main$3231c38a() throws Exception {
        final BufferedReader bufferedReader;
        final String[] split = (bufferedReader = new BufferedReader(new InputStreamReader(System.in))).readLine().split(" ");
        String[] split2 = new String[0];
        if (Integer.parseInt(split[1]) != 0) {
            split2 = bufferedReader.readLine().split(" ");
        }
        final HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < split2.length; ++i) {
            set.add(Integer.parseInt(split2[i]));
        }
        int int1;
        int n;
        for (n = (int1 = Integer.parseInt(split[0])); set.contains(int1); ++int1) {}
        int x = int1;
        int j;
        for (j = n - 1; set.contains(j); --j) {}
        if (n - j <= x - n) {
            x = j;
        }
        System.out.println(x);
    }
    
    private static long get$5622c30f(final long n, final String s, final int n2) {
        if (n2 != s.length()) {
            throw new NullPointerException();
        }
        if (n == 0L) {
            return 1L;
        }
        return 2L;
    }
    
    static {
        new Hashtable();
    }
}




final class Pair
{
    private long a;
    private long b;
    
    private Pair(final long a, final long b) {
        this.a = a;
        this.b = b;
    }
}