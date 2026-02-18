public final class Main
{
    private static void main$3231c38a() {
        final String next = new Scanner(System.in).next();
        int max = 0;
        int n = 0;
        for (int i = 0; i < 3; ++i) {
            if (next.charAt(i) == 'R') {
                ++n;
            }
            else {
                max = Math.max(max, n);
                n = 0;
            }
        }
        System.out.println(Math.max(max, n));
    }
}