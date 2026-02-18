public final class Main
{
    private static void main$3231c38a() {
        final int nextInt = new Scanner(System.in).nextInt();
        int max = 0;
        int x = 0;
        for (int i = nextInt; i > 0; --i) {
            int b = 0;
            for (int n = i; n % 2 == 0; n /= 2, ++b) {}
            if ((max = Math.max(max, b)) == b) {
                x = i;
            }
        }
        System.out.println(x);
    }
}