public final class Main
{
    private static void main$3231c38a() {
        final String nextLine = new Scanner(System.in).nextLine();
        int n = 0;
        int x = 0;
        for (int i = 0; i < nextLine.length(); ++i) {
            final String s = nextLine;
            final int beginIndex = i;
            if (s.substring(beginIndex, beginIndex + 1).equals("R")) {
                if (++n > x) {
                    x = n;
                }
            }
            else {
                final String s2 = nextLine;
                final int beginIndex2 = i;
                if (s2.substring(beginIndex2, beginIndex2 + 1).equals("S")) {
                    n = 0;
                }
            }
        }
        System.out.println(x);
    }
}