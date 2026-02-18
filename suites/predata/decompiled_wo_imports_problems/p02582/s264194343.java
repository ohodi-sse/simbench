public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final String next = (scanner = new Scanner(System.in)).next();
        int x = 0;
        scanner.close();
        for (int i = 0; i < 3; ++i) {
            if (next.charAt(i) == 'R') {
                ++x;
            }
        }
        if (next.equals("RSR")) {
            x = 1;
        }
        System.out.println(x);
    }
}