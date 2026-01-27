public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final String next = scanner.next();
        final String next2 = scanner.next();
        scanner.close();
        int i = 0;
        for (int j = 0; j < 3; ++j) {
            if (next.substring(j, j + 1).contentEquals(next2.substring(j, j + 1))) {
                ++i;
            }
        }
        System.out.print(i);
    }
}