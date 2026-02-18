public final class Main
{
    private static void main$3231c38a() throws Exception {
        new BufferedReader(new InputStreamReader(System.in));
        final String[] split = new Scanner(System.in).nextLine().split(" ");
        System.out.println(new BigDecimal(split[0]).multiply(new BigDecimal(split[1])).longValue());
    }
}