public final class Main
{
    private static void main$3231c38a() throws Exception {
        final int nextInt = new Scanner(System.in).nextInt();
        int n = 0;
        int x = 0;
        for (int i = 1; i <= nextInt; ++i) {
            int n2 = 0;
            int j = i;
            while (j > 0) {
                if (j == 1) {
                    ++n2;
                    j = 0;
                }
                else if (j % 2 == 0) {
                    ++n2;
                    j /= 2;
                }
                else {
                    if (j % 2 != 1) {
                        continue;
                    }
                    j /= 2;
                }
            }
            if (n < n2) {
                n = n2;
                x = i;
            }
        }
        System.out.println(x);
    }
}