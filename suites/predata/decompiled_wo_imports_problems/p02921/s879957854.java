public final class Main
{
    private static void main$3231c38a() throws IOException {
        final BufferedReader bufferedReader;
        final String[] split = (bufferedReader = new BufferedReader(new InputStreamReader(System.in))).readLine().split("");
        final String[] split2 = bufferedReader.readLine().split("");
        final int[] array = new int[split.length];
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            if (split[i].equals(split2[i])) {
                ++x;
            }
        }
        System.out.println(x);
    }
}