public final class Main
{
    private static void main$3231c38a() throws Exception {
        final int nextInt = new Scanner(System.in).nextInt();
        int x = 0;
        int n = 0;
        for (int i = 1; i <= nextInt; ++i) {
            int n2;
            int n3;
            for (n2 = i, n3 = 0; n2 % 2 == 0; n2 /= 2, ++n3) {}
            if (n <= n3) {
                x = i;
                n = n3;
            }
        }
        System.out.println(x);
    }
}