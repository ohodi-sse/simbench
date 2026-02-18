public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final String next = (scanner = new Scanner(System.in)).next();
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