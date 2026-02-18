public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        scanner.close();
        for (int i = 0; i < 8; ++i) {
            if (nextInt < Math.pow(2.0, i)) {
                System.out.println((int)Math.pow(2.0, i - 1));
                return;
            }
        }
    }
}