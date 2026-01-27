public class Main
{
    public static void main(final String[] array) throws IOException {
        int n = 0;
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            final char c = (char)System.in.read();
            if (c == 'R') {
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