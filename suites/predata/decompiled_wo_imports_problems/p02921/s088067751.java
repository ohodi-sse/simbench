public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final String nextLine = (scanner = new Scanner(System.in)).nextLine();
        final String nextLine2 = scanner.nextLine();
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            if (nextLine.charAt(i) == nextLine2.charAt(i)) {
                ++x;
            }
        }
        System.out.println(x);
        scanner.close();
    }
}