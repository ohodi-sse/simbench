public class Main
{
    public static void main(final String[] array) throws Exception {
        solve(System.in, System.out);
    }
    
    static void solve(final InputStream source, final PrintStream printStream) {
        final String next = new Scanner(source).next();
        int n = 0;
        int max = 0;
        int b = 0;
        for (int i = 0; i < 3; ++i) {
            int n2 = 0;
            if (next.charAt(i) == 'R') {
                n2 = 1;
                if (n != 0) {
                    ++b;
                }
                else {
                    b = 1;
                }
            }
            else {
                b = 0;
            }
            n = n2;
            max = Math.max(max, b);
        }
        printStream.println(max);
    }
}