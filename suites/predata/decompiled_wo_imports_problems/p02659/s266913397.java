public class Main
{
    public static void main(final String[] array) throws Exception {
        try (final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            final String[] split = bufferedReader.readLine().split(" ");
            bufferedReader.close();
            System.out.println(new BigDecimal(split[0]).multiply(new BigDecimal(split[1])).toBigInteger());
        }
    }
}