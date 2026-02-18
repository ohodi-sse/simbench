public final class Main
{
    private static void main$3231c38a() {
        final String[] split = new Scanner(System.in).nextLine().split(" ", 0);
        System.out.println(new BigDecimal(split[0]).multiply(new BigDecimal(split[1]).multiply(BigDecimal.valueOf(100L))).divide(BigDecimal.valueOf(100L)).setScale(0, RoundingMode.DOWN));
    }
}