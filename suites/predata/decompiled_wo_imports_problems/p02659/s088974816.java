public final class Main
{
    private static void main(final Scanner scanner) {
        final String string;
        if ((string = new Long(scanner.nextLong() * new Long(scanner.next().replace(".", ""))).toString()).length() >= 3) {
            System.out.println(string.substring(0, string.length() - 2));
            return;
        }
        System.out.println(0);
    }
    
    private static void main$3231c38a() {
        final Scanner scanner = new Scanner(System.in);
        new Main();
        final String string;
        if ((string = new Long(scanner.nextLong() * new Long(scanner.next().replace(".", ""))).toString()).length() >= 3) {
            System.out.println(string.substring(0, string.length() - 2));
            return;
        }
        System.out.println(0);
    }
}