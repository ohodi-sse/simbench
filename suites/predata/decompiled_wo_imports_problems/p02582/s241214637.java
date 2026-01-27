public class Main
{
    public static void main(final String[] array) {
        try (final Scanner scanner = new Scanner(System.in)) {
            final String next = scanner.next();
            final char char1 = next.charAt(0);
            final char char2 = next.charAt(1);
            final char char3 = next.charAt(2);
            int x = 0;
            if (char1 == 'R') {
                ++x;
                if (char2 == 'R') {
                    ++x;
                    if (char3 == 'R') {
                        ++x;
                    }
                }
                else if (char3 == 'R') {}
            }
            else if (char2 == 'R') {
                ++x;
                if (char3 == 'R') {
                    ++x;
                }
            }
            else if (char3 == 'R') {
                ++x;
            }
            System.out.println(x);
        }
    }
}