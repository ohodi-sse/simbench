public final class Main
{
    private static void main$3231c38a() {
        final int nextInt;
        if ((nextInt = new Scanner(System.in).nextInt()) == 1) {
            System.out.println(1);
            return;
        }
        int x = 0;
        for (int i = 2; i <= nextInt; i <<= 1) {
            x = i;
        }
        System.out.println(x);
    }
}