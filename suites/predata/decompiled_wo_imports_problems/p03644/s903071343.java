public final class Main
{
    private static void main$3231c38a() {
        final int nextInt = new Scanner(System.in).nextInt();
        double pow = 1.0;
        if (nextInt == 1) {
            pow = 2.0;
        }
        else {
            for (int n = 0; n < nextInt && (pow = Math.pow(2.0, n)) <= nextInt; ++n) {}
        }
        System.out.println((int)(pow / 2.0));
    }
}