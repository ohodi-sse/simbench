public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final String next = scanner.next();
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            if (next.charAt(i) == 'R') {
                ++x;
            }
        }
        if (x == 2 && next.charAt(1) == 'S') {
            --x;
        }
        System.out.println(x);
        scanner.close();
    }
}