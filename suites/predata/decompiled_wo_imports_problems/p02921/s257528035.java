public final class Main
{
    private static void main$3231c38a() {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            final String line = bufferedReader.readLine();
            final String line2 = bufferedReader.readLine();
            int x = 0;
            for (int i = 0; i < 3; ++i) {
                if (line.charAt(i) == line2.charAt(i)) {
                    ++x;
                }
            }
            System.out.println(x);
        }
        catch (final IOException ex) {
            ex.printStackTrace();
        }
    }
}