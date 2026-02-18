public final class Main
{
    private static int countPower(int n) {
        int n2 = 0;
        while (n % 2 == 0) {
            ++n2;
            n /= 2;
        }
        return n2;
    }
    
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        int x = 1;
        int n = 0;
        for (int i = 1; i <= nextInt; ++i) {
            int n2 = i;
            int n3 = 0;
            while (n2 % 2 == 0) {
                ++n3;
                n2 /= 2;
            }
            final int n4 = n3;
            if (n < n4) {
                n = n4;
                x = i;
            }
        }
        System.out.println(x);
        scanner.close();
    }
}