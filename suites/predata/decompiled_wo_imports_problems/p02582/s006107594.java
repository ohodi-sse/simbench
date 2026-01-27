public class Main
{
    public static void main(final String[] array) {
        final String next = new Scanner(System.in).next();
        final char c = 'R';
        int x = 0;
        for (int i = 0; i < next.length(); ++i) {
            if (x == 0 && next.charAt(i) == c) {
                x = 1;
            }
            if (next.charAt(i) == c && i > 0 && next.charAt(i - 1) == c) {
                ++x;
            }
        }
        System.out.println(x);
    }
}