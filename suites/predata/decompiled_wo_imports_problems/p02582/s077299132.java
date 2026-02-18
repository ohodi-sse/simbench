public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final String next = (scanner = new Scanner(System.in)).next();
        scanner.close();
        if ("SSS".equals(next)) {
            System.out.println(0);
            return;
        }
        if ("RRS".equals(next) || "SRR".equals(next)) {
            System.out.println(2);
            return;
        }
        if ("RRR".equals(next)) {
            System.out.println(3);
            return;
        }
        System.out.println(1);
    }
}