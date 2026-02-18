public final class Main
{
    private static void main$3231c38a() {
        final String next;
        final int length = (next = new Scanner(System.in).next()).length();
        int n = 0;
        int x = 0;
        final char[] charArray = next.toCharArray();
        for (int i = 0; i < length; ++i) {
            if (charArray[i] == 'R') {
                ++n;
                if (x < n) {
                    x = n;
                }
            }
            else {
                n = 0;
            }
        }
        System.out.println(x);
    }
}