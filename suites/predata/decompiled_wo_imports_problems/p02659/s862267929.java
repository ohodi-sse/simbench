public final class Main
{
    private static final int MOD = 1000000007;
    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final double eps = 1.0E-4;
    
    private static void main$3231c38a() {
        final Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.nextLong() * (int)(scanner.nextDouble() * 100.0 + 1.0E-4) / 100L);
    }
    
    private static String solve(final long val, final double val2) {
        return BigDecimal.valueOf(val).multiply(BigDecimal.valueOf(val2)).setScale(0, RoundingMode.DOWN).toString();
    }
    
    private static long solve2(final long n, final double n2) {
        return n * (int)(n2 * 100.0 + 1.0E-4) / 100L;
    }
}