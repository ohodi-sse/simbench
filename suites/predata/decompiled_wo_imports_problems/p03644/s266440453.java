public final class Main
{
    private static void main$3231c38a() {
        final int nextInt = new Scanner(System.in).nextInt();
        int x = 1;
        for (int n = 0; n < 10 && 2 * x <= nextInt; x <<= 1, ++n) {}
        System.out.println(x);
    }
}