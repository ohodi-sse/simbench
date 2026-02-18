public final class Main
{
    private static void main$3231c38a() throws IOException {
        int n = 0;
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            final char c;
            if ((c = (char)System.in.read()) == 'R') {
                ++n;
            }
            if (c == 'S') {
                n = 0;
            }
            if (n > x) {
                x = n;
            }
        }
        System.out.println(x);
    }
}