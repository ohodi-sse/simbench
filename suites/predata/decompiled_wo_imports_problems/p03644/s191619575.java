final class Main
{
    private static void main$3231c38a() throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int int1;
            int n;
            for (int1 = Integer.parseInt(bufferedReader.readLine()), n = 0; int1 != 1 && int1 != 0; int1 /= 2, ++n) {}
            System.out.println((int)Math.pow(2.0, n));
        }
        catch (final Exception ex) {
            System.exit(0);
        }
    }
}