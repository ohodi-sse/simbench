class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        final Integer[] a = new Integer[nextInt2];
        for (int i = 0; i < nextInt2; ++i) {
            a[i] = scanner.nextInt();
        }
        int x = -100;
        if (nextInt2 == 0) {
            System.out.println(nextInt);
            return;
        }
        for (int j = nextInt - nextInt2; j < nextInt + nextInt2; ++j) {
            if (!Arrays.asList(a).contains(j)) {
                if (Math.abs(nextInt - x) > Math.abs(nextInt - j)) {
                    x = j;
                }
                else if (Math.abs(nextInt - x) < Math.abs(nextInt - j)) {
                    break;
                }
            }
        }
        System.out.println(x);
        scanner.close();
    }
}