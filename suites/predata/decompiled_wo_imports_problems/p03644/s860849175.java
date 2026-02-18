public final class Main
{
    private static void main$3231c38a() {
        final int nextInt = new Scanner(System.in).nextInt();
        int x = 0;
        for (int n = 0; n <= nextInt && Math.pow(2.0, n) <= nextInt; ++n) {
            x = (int)Math.pow(2.0, n);
        }
        System.out.println(x);
    }
}