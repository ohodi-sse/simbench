public final class Main
{
    private static void main$3231c38a() throws IOException, Exception {
        final BufferedReader bufferedReader;
        final String[] split = (bufferedReader = new BufferedReader(new InputStreamReader(System.in))).readLine().split("");
        final String[] split2 = bufferedReader.readLine().split("");
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            if (split[i].equals(split2[i])) {
                ++x;
            }
        }
        System.out.println(x);
    }
    
    private static String getStr(final BufferedReader bufferedReader) throws Exception, IOException {
        return bufferedReader.readLine();
    }
    
    private static void anser(final int x) {
        System.out.println(x);
    }
}