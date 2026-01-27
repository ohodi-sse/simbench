public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final String next = scanner.next();
        final String next2 = scanner.next();
        int i = 0;
        for (int j = 0; j < next.length(); ++j) {
            if (next.charAt(j) == next2.charAt(j)) {
                ++i;
            }
        }
        System.out.print(i);
    }
}