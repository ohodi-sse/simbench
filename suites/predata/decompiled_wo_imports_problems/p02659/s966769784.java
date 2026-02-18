public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner = new Scanner(System.in);
        final BigDecimal multiply = scanner.nextBigDecimal().multiply(scanner.nextBigDecimal().multiply(new BigDecimal(100.0)));
        String substring;
        if (new BigDecimal(100.0).compareTo(multiply) <= 0) {
            String s;
            final int index;
            if ((index = (s = multiply.toString()).indexOf(".")) >= 0) {
                s = s.substring(0, index);
            }
            substring = s.substring(0, s.length() - 2);
        }
        else {
            substring = "0";
        }
        System.out.println(substring);
    }
}