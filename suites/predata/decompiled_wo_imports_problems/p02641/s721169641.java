public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2 = scanner.nextInt();
        final ArrayList list = new ArrayList();
        int abs = Integer.MAX_VALUE;
        int x = 0;
        for (int i = 0; i < nextInt2; ++i) {
            list.add(scanner.nextInt());
        }
        for (int j = 0; j <= 110; ++j) {
            if (!list.contains(j) && abs > Math.abs(j - nextInt)) {
                abs = Math.abs(j - nextInt);
                x = j;
            }
        }
        System.out.println(x);
        scanner.close();
    }
}