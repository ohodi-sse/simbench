public final class Main
{
    private static void main$3231c38a() throws IOException {
        new Main(new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8)));
    }
    
    private Main(final BufferedReader bufferedReader) throws IOException {
        final String[] split = bufferedReader.readLine().split(" ");
        System.out.println(new BigDecimal(split[0]).multiply(new BigDecimal(split[1])).toBigInteger());
    }
    
    private static void calc() {
    }
    
    private static void showResult() {
    }
}