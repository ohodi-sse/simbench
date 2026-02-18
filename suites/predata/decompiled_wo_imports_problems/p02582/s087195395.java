public final class Main
{
    private static void main$3231c38a() {
        final String next = new Scanner(System.in).next();
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            if (x > 0) {
                if (next.charAt(i) == 'R' && next.charAt(i - 1) == 'R') {
                    ++x;
                }
            }
            else if (next.charAt(i) == 'R') {
                ++x;
            }
        }
        System.out.println(x);
    }
}