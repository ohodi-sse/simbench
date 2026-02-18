final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final String next = (scanner = new Scanner(System.in)).next();
        final String next2 = scanner.next();
        Integer x = 0;
        for (Integer n = 0; n < next.length(); ++n) {
            if (next.charAt(n) == next2.charAt(n)) {
                ++x;
            }
        }
        System.out.println(x);
    }
}