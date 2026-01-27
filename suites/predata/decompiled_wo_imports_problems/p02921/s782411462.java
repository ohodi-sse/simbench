public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final String next = scanner.next();
        final String next2 = scanner.next();
        int i = 0;
        if (next.substring(0, 1).equals(next2.substring(0, 1))) {
            ++i;
        }
        if (next.substring(1, 2).equals(next2.substring(1, 2))) {
            ++i;
        }
        if (next.substring(2, 3).equals(next2.substring(2, 3))) {
            ++i;
        }
        System.out.print(i);
    }
}