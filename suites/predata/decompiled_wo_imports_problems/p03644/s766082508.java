public final class Main
{
    private static void main$3231c38a() {
        int nextInt;
        int n;
        for (nextInt = new Scanner(System.in).nextInt(), n = 0; Math.pow(2.0, n + 1) <= nextInt; ++n) {}
        System.out.println(Math.round(Math.pow(2.0, n)));
    }
}