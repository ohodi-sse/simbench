public final class Main
{
    private static void main$3231c38a() {
        final int i = new Scanner(System.in).nextInt();
        int n = 1;
        int x = 1;
        while (i >= n) {
            x = n;
            n <<= 1;
        }
        System.out.println(x);
    }
}