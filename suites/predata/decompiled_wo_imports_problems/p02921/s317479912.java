public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final String nextLine = scanner.nextLine();
        final String nextLine2 = scanner.nextLine();
        int x = 0;
        if (nextLine.charAt(0) == nextLine2.charAt(0)) {
            ++x;
        }
        if (nextLine.charAt(1) == nextLine2.charAt(1)) {
            ++x;
        }
        if (nextLine.charAt(2) == nextLine2.charAt(2)) {
            ++x;
        }
        System.out.println(x);
    }
}