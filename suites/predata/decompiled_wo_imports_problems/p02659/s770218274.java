final class Main
{
    private static void main$3231c38a() throws IOException {
        try (final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            final String[] split = bufferedReader.readLine().split(" ");
            System.out.println(Long.parseLong(split[0]) * new BigDecimal(split[1]).multiply(new BigDecimal("100")).intValue() / 100L);
        }
    }
}