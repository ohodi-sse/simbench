public final class Main
{
    private static void main$3231c38a() {
        final int nextInt;
        if ((nextInt = new Scanner(System.in).nextInt()) == 1) {
            System.out.println(1);
        }
        if (nextInt > 1 && nextInt < 4) {
            System.out.println(2);
        }
        if (nextInt > 3 && nextInt < 8) {
            System.out.println(4);
        }
        if (nextInt > 7 && nextInt < 16) {
            System.out.println(8);
        }
        if (nextInt > 15 && nextInt < 32) {
            System.out.println(16);
        }
        if (nextInt > 31 && nextInt < 64) {
            System.out.println(32);
        }
        if (nextInt > 63) {
            System.out.println(64);
        }
    }
}