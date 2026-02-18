public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final String next = (scanner = new Scanner(System.in)).next();
        final String next2 = scanner.next();
        final String substring = next.substring(0, 1);
        final String substring2 = next.substring(1, 2);
        final String substring3 = next.substring(2, 3);
        final String substring4 = next2.substring(0, 1);
        final String substring5 = next2.substring(1, 2);
        final String substring6 = next2.substring(2, 3);
        int x = 0;
        if (substring.equals(substring4)) {
            ++x;
        }
        if (substring2.equals(substring5)) {
            ++x;
        }
        if (substring3.equals(substring6)) {
            ++x;
        }
        System.out.println(x);
    }
}