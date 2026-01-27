public class Main
{
    public static void main(final String[] array) throws Exception {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final PrintWriter printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        final char[] charArray = bufferedReader.readLine().toCharArray();
        int max = 0;
        int n = 0;
        for (final char c : charArray) {
            if (c == 'S') {
                max = Math.max(max, n);
                n = 0;
            }
            else if (c == 'R') {
                ++n;
            }
        }
        printWriter.println(Math.max(n, max));
        printWriter.close();
    }
}