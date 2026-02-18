public final class Main
{
    private static void main$3231c38a() {
        final String nextLine = new Scanner(System.in).nextLine();
        int n = 0;
        int x = 0;
        if (nextLine.charAt(0) == 'R') {
            ++n;
            x = Math.max(0, 1);
        }
        for (int i = 1; i < nextLine.length(); ++i) {
            if (nextLine.charAt(i - 1) == nextLine.charAt(i) && nextLine.charAt(i) == 'R') {
                x = Math.max(++n, x);
            }
            else if (nextLine.charAt(i) == 'R') {
                n = 1;
                x = Math.max(1, x);
            }
            else {
                n = 0;
            }
        }
        System.out.println(x);
    }
    
    private static int getConcRainy(final String s) {
        int n = 0;
        int n2 = 0;
        if (s.charAt(0) == 'R') {
            ++n;
            n2 = Math.max(0, 1);
        }
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i - 1) == s.charAt(i) && s.charAt(i) == 'R') {
                n2 = Math.max(++n, n2);
            }
            else if (s.charAt(i) == 'R') {
                n = 1;
                n2 = Math.max(1, n2);
            }
            else {
                n = 0;
            }
        }
        return n2;
    }
}