public final class Main
{
    private static void main$3231c38a() throws Exception {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final PrintWriter printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        final char[] charArray = bufferedReader.readLine().toCharArray();
        int max = 0;
        int n = 0;
        for (int length = charArray.length, i = 0; i < length; ++i) {
            final char c;
            if ((c = charArray[i]) == 'S') {
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