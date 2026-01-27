public class Main
{
    private static final int MOD = 1000000007;
    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final double eps = 1.0E-4;
    
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println(solve2(scanner.nextLong(), scanner.nextDouble()));
    }
    
    private static String solve(final long val, final double val2) {
        return BigDecimal.valueOf(val).multiply(BigDecimal.valueOf(val2)).setScale(0, RoundingMode.DOWN).toString();
    }
    
    private static long solve2(final long n, final double n2) {
        return n * (int)(n2 * 100.0 + 1.0E-4) / 100L;
    }
}