public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final String next = (scanner = new Scanner(System.in)).next();
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            if (next.charAt(i) == 'R') {
                ++x;
            }
        }
        if (x == 2 && next.charAt(1) == 'S') {
            --x;
        }
        System.out.println(x);
        scanner.close();
    }
}