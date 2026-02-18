public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner = new Scanner(System.in);
        int x = 0;
        final String next = scanner.next();
        final String next2 = scanner.next();
        final char[] charArray = next.toCharArray();
        final char[] charArray2 = next2.toCharArray();
        for (int i = 0; i < 3; ++i) {
            if (charArray[i] == charArray2[i]) {
                ++x;
            }
        }
        System.out.println(x);
    }
}