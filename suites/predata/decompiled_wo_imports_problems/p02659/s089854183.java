public final class Main
{
    private static void main$3231c38a() throws Exception {
        final String[] split;
        final long long1 = Long.parseLong((split = new BufferedReader(new InputStreamReader(System.in)).readLine().split(" "))[0]);
        final String s = split[1];
        long n = 0L;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                n = n * 10L + (s.charAt(i) - '0');
            }
        }
        System.out.println(long1 * n / 100L);
    }
    
    private static long convertToLong(final String s) {
        long n = 0L;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                n = n * 10L + (s.charAt(i) - '0');
            }
        }
        return n;
    }
}