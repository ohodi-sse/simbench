public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final String next = (scanner = new Scanner(System.in)).next();
        int max = 0;
        for (int i = 0; i < next.length(); ++i) {
            int b = 0;
            for (int index = i; index < next.length() && next.charAt(index) == 'R'; ++index) {
                ++b;
            }
            max = Math.max(max, b);
        }
        System.out.println(max);
        scanner.close();
    }
}