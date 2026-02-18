public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final String next = (scanner = new Scanner(System.in)).next();
        final String next2 = scanner.next();
        int x = 0;
        for (int i = 0; i < next.length(); ++i) {
            x += ((next.charAt(i) == next2.charAt(i)) ? 1 : 0);
        }
        System.out.println(x);
    }
}