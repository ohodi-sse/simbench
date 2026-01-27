public class Main
{
    public static void main(final String[] array) {
        try (final Scanner scanner = new Scanner(System.in)) {
            final String next = scanner.next();
            int max = 0;
            int b = 0;
            for (int i = 0; i < 3; ++i) {
                if (next.charAt(i) == 'R') {
                    ++b;
                }
                max = Math.max(max, b);
                if (next.charAt(i) == 'S') {
                    b = 0;
                }
            }
            System.out.print(max);
        }
    }
}