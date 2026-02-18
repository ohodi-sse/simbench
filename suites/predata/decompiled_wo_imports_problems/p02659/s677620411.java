public final class Main
{
    private static void main$3231c38a() throws IOException {
        final StringTokenizer stringTokenizer = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
        System.out.println(new BigDecimal(stringTokenizer.nextToken()).multiply(new BigDecimal(stringTokenizer.nextToken())).toBigInteger().longValueExact());
    }
}