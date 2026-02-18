public final class Main
{
    private static void main$3231c38a() {
        final int nextInt = new Scanner(System.in).nextInt();
        int n = 0;
        int n2 = 0;
        for (int i = 1; i != nextInt + 1; ++i) {
            int n3 = 0;
            for (int n4 = i; n4 % 2 == 0; n4 /= 2) {
                ++n3;
            }
            if (n2 < n3) {
                n = i;
                n2 = n3;
            }
        }
        System.out.println((nextInt == 1) ? 1 : n);
    }
}