public final class Main
{
    private static BigDecimal A;
    private static BigDecimal B;
    
    private static void main$3231c38a() throws NumberFormatException, IOException {
        final BufferedReader bufferedReader;
        final String[] split;
        Main.A = BigDecimal.valueOf(Double.valueOf((split = (bufferedReader = new BufferedReader(new InputStreamReader(System.in))).readLine().split(" "))[0]));
        Main.B = BigDecimal.valueOf(Double.valueOf(split[1]));
        Main.A = Main.A.multiply(Main.B);
        System.out.println(Main.A.longValue());
        bufferedReader.close();
    }
    
    private static void read() throws IOException {
        final BufferedReader bufferedReader;
        final String[] split;
        Main.A = BigDecimal.valueOf(Double.valueOf((split = (bufferedReader = new BufferedReader(new InputStreamReader(System.in))).readLine().split(" "))[0]));
        Main.B = BigDecimal.valueOf(Double.valueOf(split[1]));
        Main.A = Main.A.multiply(Main.B);
        System.out.println(Main.A.longValue());
        bufferedReader.close();
    }
}