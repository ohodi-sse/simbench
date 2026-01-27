public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final String next = scanner.next();
        int n = 0;
        int max = 0;
        for (int i = 0; i < 3; ++i) {
            if (next.substring(i, i + 1).equals("R")) {
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