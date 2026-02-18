final class Main
{
    private static void main$3231c38a() throws Exception {
        try (final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int int1;
            int i;
            for (int1 = Integer.parseInt(bufferedReader.readLine()), i = 1; i < int1; i <<= 1) {}
            if (i > int1) {
                i /= 2;
            }
            System.out.println(i);
        }
        catch (final IOException | NumberFormatException ex) {
            ((Throwable)ex).printStackTrace();
            System.exit(0);
        }
        catch (final Exception ex2) {
            ex2.printStackTrace();
            System.exit(0);
        }
    }
}