public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final String next = (scanner = new Scanner(System.in)).next();
        final String next2 = scanner.next();
        int x = 0;
        for (int length = next.length(), i = 0; i < length; ++i) {
            final String s = next;
            final int beginIndex = i;
            final String substring = s.substring(beginIndex, beginIndex + 1);
            final String s2 = next2;
            final int beginIndex2 = i;
            if (substring.equals(s2.substring(beginIndex2, beginIndex2 + 1))) {
                ++x;
            }
        }
        System.out.println(x);
    }
}