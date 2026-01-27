public class Main
{
    public static void main(final String[] array) {
        final int nextInt = new Scanner(System.in).nextInt();
        int n = 0;
        int x = 1;
        for (int i = 1; i <= nextInt; ++i) {
            int n2;
            int n3;
            for (n2 = i, n3 = 0; n2 % 2 == 0; n2 /= 2, ++n3) {}
            if (n3 > n) {
                n = n3;
                x = i;
            }
        }
        System.out.println(x);
    }
}