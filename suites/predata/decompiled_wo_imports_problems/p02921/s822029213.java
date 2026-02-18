public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final String nextLine = (scanner = new Scanner(System.in)).nextLine();
        final String nextLine2 = scanner.nextLine();
        int x = 0;
        if (nextLine.substring(0, 1).equals(nextLine2.substring(0, 1))) {
            ++x;
        }
        if (nextLine.substring(1, 2).equals(nextLine2.substring(1, 2))) {
            ++x;
        }
        if (nextLine.substring(2, 3).equals(nextLine2.substring(2, 3))) {
            ++x;
        }
        System.out.println(x);
    }
}