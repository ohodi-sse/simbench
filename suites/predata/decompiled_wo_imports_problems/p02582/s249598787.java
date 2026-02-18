public final class Main
{
    private static void main$3231c38a() {
        try (final Scanner scanner = new Scanner(System.in)) {
            final String next = scanner.next();
            int n = 0;
            int x = 0;
            for (int i = 0; i < next.length(); ++i) {
                if (next.charAt(i) == 'R') {
                    if (n != 0) {
                        ++x;
                    }
                    else {
                        x = 1;
                    }
                    n = 1;
                }
                else {
                    n = 0;
                }
            }
            System.out.println(x);
        }
    }
}