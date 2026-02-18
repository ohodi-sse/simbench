public final class Main
{
    private static void main$3231c38a() throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final PrintWriter printWriter = new PrintWriter(System.out);
        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        printWriter.println(new BigDecimal(stringTokenizer.nextToken()).multiply(new BigDecimal(stringTokenizer.nextToken())).setScale(0, RoundingMode.DOWN).toPlainString());
        bufferedReader.close();
        printWriter.close();
    }
}