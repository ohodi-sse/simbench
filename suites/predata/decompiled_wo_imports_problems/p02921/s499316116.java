public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final String nextLine = scanner.nextLine();
        final String nextLine2 = scanner.nextLine();
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            x += ((nextLine.charAt(i) == nextLine2.charAt(i)) ? 1 : 0);
        }
        scanner.close();
        System.out.println(x);
    }
}