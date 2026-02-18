public final class Main
{
    private static void main$3231c38a() {
        int nextInt;
        while ((nextInt = new Scanner(System.in).nextInt()) > 100) {}
        int n;
        for (n = 0; (int)Math.pow(2.0, n) <= nextInt; ++n) {}
        --n;
        System.out.println((int)Math.pow(2.0, n));
    }
}