public class Main
{
    public static void main(final String[] array) {
        final String next = new Scanner(System.in).next();
        int x = 0;
        for (int i = 0; i < next.length(); ++i) {
            if (x == 0 && 'R' == next.charAt(i)) {
                ++x;
            }
            if (i > 0 && next.charAt(i - 1) == next.charAt(i) && 'R' == next.charAt(i)) {
                ++x;
            }
        }
        System.out.println(x);
    }
}