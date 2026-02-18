public final class Main
{
    private static void main$3231c38a() {
        final int int1 = Integer.parseInt(new Scanner(System.in).next());
        for (int i = 0; i < 10; ++i) {
            if (Math.pow(2.0, i) > int1) {
                System.out.println((int)Math.pow(2.0, i - 1));
                return;
            }
        }
    }
}