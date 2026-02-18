public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner = new Scanner(System.in);
        int x = 0;
        final String nextLine = scanner.nextLine();
        for (int i = 0; i < nextLine.length(); ++i) {
            if (nextLine.charAt(i) == 'R') {
                ++x;
            }
            if (nextLine.charAt(1) == 'S' && nextLine.charAt(0) == 'R') {
                x = 1;
            }
        }
        System.out.println(x);
        scanner.close();
    }
}