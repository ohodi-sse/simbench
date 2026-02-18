final class Main
{
    private static int breakNumber(int i) {
        if (i % 2 == 0) {
            int n;
            for (n = 0; i > 0; i /= 2, ++n) {
                if (i / 2 == 1) {
                    ++n;
                    break;
                }
            }
            return n;
        }
        return 0;
    }
    
    private static void main$3231c38a() {
        final int nextInt = new Scanner(System.in).nextInt();
        int max = 0;
        for (int i = 2; i <= nextInt; ++i) {
            final int a = max;
            int j;
            int b;
            if ((j = i) % 2 == 0) {
                int n;
                for (n = 0; j > 0; j /= 2, ++n) {
                    if (j / 2 == 1) {
                        ++n;
                        break;
                    }
                }
                b = n;
            }
            else {
                b = 0;
            }
            max = Math.max(a, b);
        }
        System.out.println((int)Math.pow(2.0, max));
    }
}