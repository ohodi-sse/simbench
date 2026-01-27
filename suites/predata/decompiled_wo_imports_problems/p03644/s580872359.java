class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        int x = 1;
        int n = 0;
        for (int nextInt = scanner.nextInt(), i = 1; i <= nextInt; ++i) {
            if (i % 2 == 0) {
                final int countHalf = countHalf(i);
                if (n < countHalf) {
                    n = countHalf;
                    x = i;
                }
            }
        }
        System.out.println(x);
        scanner.close();
    }
    
    public static int countHalf(int n) {
        int n2 = 0;
        int i = 1;
        while (i != 0) {
            if (n % 2 == 0) {
                n /= 2;
                ++n2;
            }
            else {
                i = 0;
            }
        }
        return n2;
    }
}