public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2;
        final int[] array = new int[nextInt2 = scanner.nextInt()];
        final HashSet set = new HashSet();
        for (int i = 0; i < nextInt2; ++i) {
            array[i] = scanner.nextInt();
            set.add(array[i]);
        }
        int abs = Integer.MAX_VALUE;
        int x = 0;
        for (int j = nextInt; j >= -1000; --j) {
            if (!set.contains(j) && Integer.MAX_VALUE > Math.abs(nextInt - j)) {
                abs = Math.abs(nextInt - j);
                x = j;
                break;
            }
        }
        for (int k = nextInt; k <= 1000; ++k) {
            if (!set.contains(k) && abs > Math.abs(nextInt - k)) {
                x = k;
                break;
            }
        }
        System.out.println(x);
    }
}