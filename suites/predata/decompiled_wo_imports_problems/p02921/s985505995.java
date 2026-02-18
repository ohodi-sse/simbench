final class Main
{
    private static void main$3231c38a() throws Exception {
        try {
            final BufferedReader bufferedReader;
            final List<String> list = Arrays.asList((bufferedReader = new BufferedReader(new InputStreamReader(System.in))).readLine().split(""));
            final List<String> list2 = Arrays.asList(bufferedReader.readLine().split(""));
            int x = 0;
            for (int i = 0; i < 3; ++i) {
                if (list.get(i).equals(list2.get(i))) {
                    ++x;
                }
            }
            System.out.println(x);
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