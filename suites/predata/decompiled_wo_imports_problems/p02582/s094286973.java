public class Main
{
    public static void main(final String[] array) throws Exception {
        final Scanner scanner = new Scanner(System.in);
        final String next = scanner.next();
        scanner.close();
        int n = 0;
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            if (next.charAt(i) == 'R') {
                ++n;
                if (x < n) {
                    x = n;
                }
            }
            else {
                if (x < n) {
                    x = n;
                }
                n = 0;
            }
        }
        System.out.println(x);
    }
}