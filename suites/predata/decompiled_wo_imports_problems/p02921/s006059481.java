public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final PrintStream out = System.out;
        final String next = scanner.next();
        final String next2 = scanner.next();
        int i = 0;
        for (int j = 0; j < next.length(); ++j) {
            if (next.charAt(j) == next2.charAt(j)) {
                ++i;
            }
        }
        out.println(String.valueOf(i));
    }
    
    private static String solve(final Scanner scanner) {
        final String next = scanner.next();
        final String next2 = scanner.next();
        int i = 0;
        for (int j = 0; j < next.length(); ++j) {
            if (next.charAt(j) == next2.charAt(j)) {
                ++i;
            }
        }
        return String.valueOf(i);
    }
}