public class Main
{
    public static void main(final String[] array) {
        final int nextInt = new Scanner(System.in).nextInt();
        int max = 0;
        int x = 0;
        for (int i = nextInt; i > 0; --i) {
            int b = 0;
            for (int n = i; n % 2 == 0; n /= 2, ++b) {}
            max = Math.max(max, b);
            if (max == b) {
                x = i;
            }
        }
        System.out.println(x);
    }
}