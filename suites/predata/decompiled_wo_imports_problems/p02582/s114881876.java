public final class Main
{
    private static void main$3231c38a() {
        final String next = new Scanner(System.in).next();
        int a = 0;
        int max = 0;
        for (int i = 0; i < 3; ++i) {
            if (next.charAt(i) == 'R') {
                ++a;
            }
            else {
                a = 0;
            }
            max = Math.max(a, max);
        }
        System.out.println(max);
    }
}