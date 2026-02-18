public final class Main
{
    private static void main$3231c38a() throws IOException {
        final Scanner scanner;
        final String next = (scanner = new Scanner(System.in)).next();
        scanner.close();
        int x = 0;
        int n = 0;
        for (int i = 0; i < next.length(); ++i) {
            if (next.charAt(i) == 'R') {
                ++n;
            }
            else if (x < n) {
                x = n;
                n = 0;
            }
        }
        if (x < n) {
            x = n;
        }
        System.out.println(x);
    }
}