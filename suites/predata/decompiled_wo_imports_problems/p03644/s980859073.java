public final class Main
{
    private static void main$3231c38a() {
        final int nextInt = new Scanner(System.in).nextInt();
        int x = 1;
        for (int i = 0; i < nextInt; ++i) {
            if ((x <<= 1) > nextInt) {
                x /= 2;
                break;
            }
        }
        System.out.println(x);
    }
}