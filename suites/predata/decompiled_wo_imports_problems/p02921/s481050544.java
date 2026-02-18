public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final String next = (scanner = new Scanner(System.in)).next();
        final String next2 = scanner.next();
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            final String s = next;
            final int beginIndex = i;
            final char char1 = s.substring(beginIndex, beginIndex + 1).charAt(0);
            final String s2 = next2;
            final int beginIndex2 = i;
            if (char1 == s2.substring(beginIndex2, beginIndex2 + 1).charAt(0)) {
                ++x;
            }
        }
        System.out.println(x);
    }
}