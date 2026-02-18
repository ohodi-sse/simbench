public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final long nextLong = (scanner = new Scanner(System.in)).nextLong();
        final double nextDouble = scanner.nextDouble();
        scanner.close();
        final char[] charArray = BigDecimal.valueOf(nextDouble).multiply(BigDecimal.valueOf(nextLong)).toPlainString().toCharArray();
        final StringBuilder sb = new StringBuilder();
        for (int n = 0; n < charArray.length && charArray[n] != '.'; ++n) {
            sb.append(charArray[n]);
        }
        System.out.println(sb.toString());
    }
}