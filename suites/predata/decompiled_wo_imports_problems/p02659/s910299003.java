public class Main
{
    public static void main(final String[] array) throws IOException {
        final Main main = new Main(new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8)));
        main.calc();
        main.showResult();
    }
    
    Main(final BufferedReader bufferedReader) throws IOException {
        final String[] split = bufferedReader.readLine().split(" ");
        System.out.println(new BigDecimal(split[0]).multiply(new BigDecimal(split[1])).toBigInteger());
    }
    
    void calc() {
    }
    
    void showResult() {
    }
}