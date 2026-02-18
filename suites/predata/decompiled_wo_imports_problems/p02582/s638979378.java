public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final String next = (scanner = new Scanner(System.in)).next();
        int n = 0;
        int max = 0;
        for (int i = 0; i < 3; ++i) {
            final String s = next;
            final int beginIndex = i;
            if (s.substring(beginIndex, beginIndex + 1).equals("R")) {
                ++n;
            }
            else {
                max = Math.max(n, max);
                n = 0;
            }
        }
        System.out.println(Math.max(n, max));
        scanner.close();
    }
}