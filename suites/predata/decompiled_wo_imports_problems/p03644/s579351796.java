class Main
{
    static int answer(final int n) {
        int n2 = 1;
        for (int i = 0; i < 7; ++i) {
            if (n2 <= n && n < n2 * 2) {
                return n2;
            }
            n2 *= 2;
        }
        return 0;
    }
    
    public static void main(final String[] array) {
        System.out.println(answer(new Scanner(System.in).nextInt()));
    }
}