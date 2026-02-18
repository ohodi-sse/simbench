public final class Main
{
    private static void main$3231c38a() {
        final String next = new Scanner(System.in).next();
        int n = 0;
        int x = 0;
        for (int i = 0; i < next.length(); ++i) {
            if (next.charAt(i) == 'R') {
                ++n;
            }
            else {
                n = 0;
            }
            if (n >= x) {
                x = n;
            }
        }
        System.out.println(x);
    }
}