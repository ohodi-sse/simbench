public final class Main
{
    private static void main$3231c38a() {
        final int nextInt = new Scanner(System.in).nextInt();
        int n = 1;
        for (int i = 0; i >= 0; ++i) {
            if ((n <<= 1) > nextInt) {
                System.out.println(n / 2);
                return;
            }
        }
    }
}