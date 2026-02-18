public final class Main
{
    private static void main$3231c38a() {
        final String next = new Scanner(System.in).next();
        int n = 0;
        int n2 = 0;
        if (next.charAt(0) == 'R') {
            ++n;
            n2 = Math.max(0, 1);
        }
        for (int i = 1; i < next.length(); ++i) {
            if (next.charAt(i) == next.charAt(i - 1) && next.charAt(i) == 'R') {
                ++n;
                n2 = Math.max(n2, n);
            }
            else if (next.charAt(i) == 'R') {
                n = 0;
                ++n;
            }
        }
        System.out.println(Math.max(n2, n));
    }
}