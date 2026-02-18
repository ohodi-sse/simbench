public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int int1 = Integer.parseInt((scanner = new Scanner(System.in)).next());
        scanner.close();
        int n = -1;
        int x = 0;
        for (int i = 1; i <= int1; ++i) {
            int n2 = 0;
            for (int n3 = i; n3 % 2 != 1; n3 /= 2, ++n2) {}
            if (n2 > n) {
                n = n2;
                x = i;
            }
        }
        System.out.println(x);
    }
}