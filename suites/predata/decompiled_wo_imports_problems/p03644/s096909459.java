public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        int i = (scanner = new Scanner(System.in)).nextInt();
        scanner.close();
        int x = 1;
        int n = 1;
        while (i > 1) {
            final int calc = calc(i);
            if (n <= calc) {
                x = i;
                n = calc;
            }
            --i;
        }
        System.out.println(x);
    }
    
    private static int calc(final int n) {
        if (n % 2 == 0) {
            return 1 + calc(n / 2);
        }
        return 0;
    }
}