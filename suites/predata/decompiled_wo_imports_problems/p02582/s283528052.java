public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final String nextLine = (scanner = new Scanner(System.in)).nextLine();
        int n = 0;
        int max = 0;
        for (int i = 0; i < nextLine.length(); ++i) {
            if (nextLine.charAt(i) == 'R') {
                ++n;
            }
            else {
                max = Math.max(n, max);
                n = 0;
            }
        }
        System.out.println(Math.max(n, max));
        scanner.close();
    }
}