public final class Main
{
    private static void main$3231c38a() throws IOException {
        final BufferedReader bufferedReader;
        final char[] charArray = (bufferedReader = new BufferedReader(new InputStreamReader(System.in))).readLine().toCharArray();
        final char[] charArray2 = bufferedReader.readLine().toCharArray();
        int x = 0;
        for (int i = 0; i < charArray.length; ++i) {
            if (charArray[i] == charArray2[i]) {
                ++x;
            }
        }
        System.out.println(x);
    }
}