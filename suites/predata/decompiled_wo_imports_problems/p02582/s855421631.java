public final class Main
{
    private static void main$3231c38a() {
        try (final Scanner scanner = new Scanner(System.in)) {
            final String next = scanner.next();
            int b = 0;
            int max = 0;
            for (int i = 0; i < 3; ++i) {
                if (next.charAt(i) == 'R') {
                    ++b;
                }
                else {
                    b = 0;
                }
                max = Math.max(max, b);
            }
            System.out.println(max);
        }
        catch (final Exception ex) {
            ex.printStackTrace();
        }
    }
}