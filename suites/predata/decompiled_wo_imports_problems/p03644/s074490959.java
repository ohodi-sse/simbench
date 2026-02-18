public final class Main
{
    private static void main$3231c38a() throws Exception {
        int n = 0;
        int x = 1;
        Scanner scanner;
        for (int nextInt = (scanner = new Scanner(System.in)).nextInt(), i = 1; i <= nextInt; ++i) {
            int n2 = 0;
            for (int n3 = i; n3 % 2 == 0; n3 /= 2, ++n2) {}
            if (n2 > n) {
                n = n2;
                x = i;
            }
        }
        System.out.println(x);
        scanner.close();
    }
}