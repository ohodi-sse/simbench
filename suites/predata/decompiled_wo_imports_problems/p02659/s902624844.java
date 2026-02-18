public final class Main
{
    private static final int MOD = 1000000007;
    private static final String YES = "Yes";
    private static final String NO = "No";
    
    private static void main$3231c38a() {
        final Scanner scanner = new Scanner(System.in);
        System.out.println(BigDecimal.valueOf(scanner.nextLong()).multiply(BigDecimal.valueOf(scanner.nextDouble())).setScale(0, RoundingMode.DOWN).toString());
    }
    
    private static String solve(final long val, final double val2) {
        return BigDecimal.valueOf(val).multiply(BigDecimal.valueOf(val2)).setScale(0, RoundingMode.DOWN).toString();
    }
}