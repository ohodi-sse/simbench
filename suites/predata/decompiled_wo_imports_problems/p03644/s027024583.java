public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        int n = 0;
        int x = 0;
        for (int i = 1; i <= nextInt; ++i) {
            int n2 = 0;
            int n3 = i;
            while (n3 % 2 == 0) {
                n3 /= 2;
                if (++n2 > n) {
                    n = n2;
                    x = i;
                }
            }
        }
        if (nextInt == 1) {
            System.out.println(1);
        }
        else {
            System.out.println(x);
        }
        scanner.close();
    }
}