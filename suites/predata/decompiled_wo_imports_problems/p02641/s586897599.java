public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2;
        final String[] array = new String[nextInt2 = scanner.nextInt()];
        for (int i = 0; i < nextInt2; ++i) {
            array[i] = scanner.next();
        }
        scanner.close();
        int n;
        for (n = 0; Arrays.asList(array).contains(String.valueOf(nextInt - n)); ++n) {
            if (!Arrays.asList(array).contains(String.valueOf(nextInt + n))) {
                System.out.println(nextInt + n);
                return;
            }
        }
        System.out.println(nextInt - n);
    }
}