public final class Main
{
    private static void main$3231c38a() {
        int x = 0;
        final Scanner scanner;
        final String nextLine = (scanner = new Scanner(System.in)).nextLine();
        final String nextLine2 = scanner.nextLine();
        for (int i = 0; i < 3; ++i) {
            final String s = nextLine;
            final int beginIndex = i;
            final String substring = s.substring(beginIndex, beginIndex + 1);
            final String s2 = nextLine2;
            final int beginIndex2 = i;
            if (substring.equals(s2.substring(beginIndex2, beginIndex2 + 1))) {
                ++x;
            }
        }
        System.out.println(x);
    }
}