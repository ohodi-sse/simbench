public class Main
{
    public static void main(final String[] array) {
        System.out.println(getConcRainy(new Scanner(System.in).nextLine()));
    }
    
    public static int getConcRainy(final String s) {
        int n = 0;
        int b = 0;
        if (s.charAt(0) == 'R') {
            ++n;
            b = Math.max(b, n);
        }
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i - 1) == s.charAt(i) && s.charAt(i) == 'R') {
                b = Math.max(++n, b);
            }
            else if (s.charAt(i) == 'R') {
                n = 1;
                b = Math.max(n, b);
            }
            else {
                n = 0;
            }
        }
        return b;
    }
}