public final class Main
{
    private static void main$3231c38a() {
        int n = 0;
        int n2 = 0;
        int i = 1;
        Scanner scanner;
        for (int nextInt = (scanner = new Scanner(System.in)).nextInt(), j = 0; j <= nextInt; ++j) {
            for (int n3 = j; n3 % 2 == 0 && n3 != 0; n3 /= 2, ++n) {}
            if (n > n2) {
                n2 = n;
                i = j;
            }
            n = 0;
        }
        System.out.print(i);
        scanner.close();
    }
}