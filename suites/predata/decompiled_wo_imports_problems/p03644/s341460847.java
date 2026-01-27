public class Main
{
    public static void main(final String[] array) {
        final int nextInt = new Scanner(System.in).nextInt();
        int n = 0;
        int x = 0;
        for (int i = 1; i <= nextInt; ++i) {
            int n2 = 0;
            int j = 1;
            int n3 = i;
            while (j != 0) {
                if (n3 % 2 == 0) {
                    ++n2;
                    n3 /= 2;
                }
                else {
                    if (n3 % 2 != 1) {
                        continue;
                    }
                    if (n <= n2) {
                        n = n2;
                        x = i;
                    }
                    j = 0;
                }
            }
        }
        System.out.println(x);
    }
}