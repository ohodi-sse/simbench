public final class Main
{
    private static void main$3231c38a() throws Exception {
        final int nextInt;
        if ((nextInt = new Scanner(System.in).nextInt()) == 1) {
            System.out.println(1);
            return;
        }
        if (nextInt <= 3) {
            System.out.println(2);
            return;
        }
        if (nextInt > 3 && nextInt < 8) {
            System.out.println(4);
            return;
        }
        if (nextInt >= 8 && nextInt < 16) {
            System.out.println(8);
            return;
        }
        if (nextInt >= 16 && nextInt < 31) {
            System.out.println(16);
            return;
        }
        if (nextInt >= 32 && nextInt < 64) {
            System.out.println(32);
            return;
        }
        System.out.println(64);
    }
}