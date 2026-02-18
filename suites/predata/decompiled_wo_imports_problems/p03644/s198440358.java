public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        int n = 0;
        int x = 1;
        scanner.close();
        for (int i = 1; i <= nextInt; ++i) {
            int n2 = 0;
            for (int n3 = i; n3 % 2 == 0; n3 /= 2) {
                ++n2;
            }
            if (n2 > n) {
                n = n2;
                x = i;
            }
        }
        System.out.println(x);
    }
}