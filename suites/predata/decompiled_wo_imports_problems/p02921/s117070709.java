public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner = new Scanner(System.in);
        int i = 0;
        final String next = scanner.next();
        final String next2 = scanner.next();
        for (int j = 0; j < 3; ++j) {
            if (next.charAt(j) == next2.charAt(j)) {
                ++i;
            }
        }
        System.out.print(i);
    }
}