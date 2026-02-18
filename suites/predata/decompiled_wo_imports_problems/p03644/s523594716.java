public final class Main
{
    private static void main$3231c38a() {
        final int nextInt = new Scanner(System.in).nextInt();
        for (int i = 0; i <= 8; ++i) {
            if (Math.pow(2.0, i) <= nextInt && nextInt < Math.pow(2.0, i + 1)) {
                System.out.println((int)Math.pow(2.0, i));
                return;
            }
        }
    }
}