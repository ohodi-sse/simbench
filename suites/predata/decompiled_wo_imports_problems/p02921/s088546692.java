public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final String next = (scanner = new Scanner(System.in)).next();
        final String next2 = scanner.next();
        scanner.close();
        int i = 0;
        for (int j = 0; j < 3; ++j) {
            final String s = next;
            final int beginIndex = j;
            final String substring = s.substring(beginIndex, beginIndex + 1);
            final String s2 = next2;
            final int beginIndex2 = j;
            if (substring.contentEquals(s2.substring(beginIndex2, beginIndex2 + 1))) {
                ++i;
            }
        }
        System.out.print(i);
    }
}