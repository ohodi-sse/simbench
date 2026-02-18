public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        int x = 1;
        int n = 0;
        int n2 = 0;
        for (int i = nextInt; i > 0; --i) {
            final int n3 = i;
            while (i % 2 == 0) {
                ++n2;
                i /= 2;
            }
            i = n3;
            if (n2 > n) {
                x = n3;
                n = n2;
            }
            n2 = 0;
        }
        System.out.println(x);
        scanner.close();
    }
}