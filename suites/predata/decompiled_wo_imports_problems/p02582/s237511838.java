public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final String next = (scanner = new Scanner(System.in)).next();
        scanner.close();
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            if (next.charAt(i) == 'R') {
                if (i == 2 && next.charAt(1) == 'S') {
                    x = 0;
                }
                ++x;
            }
        }
        System.out.println(x);
    }
}