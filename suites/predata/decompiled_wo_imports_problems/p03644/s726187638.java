public final class Main
{
    private static void main$3231c38a() {
        final int nextInt = new Scanner(System.in).nextInt();
        int n = 0;
        int n2 = 0;
        for (int i = 1; i <= nextInt; ++i) {
            int n3 = i;
            int n4 = 0;
            while (n3 % 2 == 0) {
                ++n4;
                n3 /= 2;
            }
            if (n < n4) {
                n2 = i;
                n = n4;
            }
        }
        System.out.println((nextInt == 1) ? 1 : n2);
    }
}