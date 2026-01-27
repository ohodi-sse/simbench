public class Main
{
    public static void main(final String[] array) {
        final String next = new Scanner(System.in).next();
        int max = 0;
        for (int i = 0; i < 3; ++i) {
            int index = i;
            int b = 0;
            while (index < 3 && next.charAt(index) == 'R') {
                ++b;
                ++index;
            }
            max = Math.max(max, b);
        }
        System.out.println(max);
    }
}