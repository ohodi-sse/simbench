public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2;
        final Integer[] a = new Integer[nextInt2 = scanner.nextInt()];
        int abs = 100;
        int x = nextInt;
        for (int i = 0; i < nextInt2; ++i) {
            a[i] = scanner.nextInt();
        }
        for (int j = 0; j <= 200; ++j) {
            if (Math.abs(nextInt - j) < abs && !Arrays.asList(a).contains(j)) {
                abs = Math.abs(nextInt - j);
                x = j;
            }
        }
        System.out.println(x);
    }
}