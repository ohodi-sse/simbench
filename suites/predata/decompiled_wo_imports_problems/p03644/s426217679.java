public final class Main
{
    private static void main$3231c38a() {
        final int int1 = Integer.parseInt(new Scanner(System.in).next());
        int n = 0;
        int i = 1;
        for (int j = 1; j < int1 + 1; ++j) {
            int n2 = j;
            int n3 = 0;
            while (n2 % 2 == 0) {
                n2 /= 2;
                ++n3;
                if (n2 == 0) {
                    break;
                }
            }
            if (n < n3) {
                n = n3;
                i = j;
            }
        }
        System.out.print(i);
    }
}