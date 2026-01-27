class Main
{
    static int breakNumber(final int n) {
        if (n % 2 == 0) {
            int i;
            int n2;
            for (i = n, n2 = 0; i > 0; i /= 2, ++n2) {
                if (i / 2 == 1) {
                    ++n2;
                    break;
                }
            }
            return n2;
        }
        return 0;
    }
    
    public static void main(final String[] array) {
        final int nextInt = new Scanner(System.in).nextInt();
        int max = 0;
        for (int i = 2; i <= nextInt; ++i) {
            max = Math.max(max, breakNumber(i));
        }
        System.out.println((int)Math.pow(2.0, max));
    }
}