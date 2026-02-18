public final class Main
{
    private static void main$3231c38a() throws IOException {
        final BufferedReader bufferedReader;
        final String[] split;
        final int intValue = Integer.valueOf((split = (bufferedReader = new BufferedReader(new InputStreamReader(System.in))).readLine().split(" "))[0]);
        final int intValue2 = Integer.valueOf(split[1]);
        final int[] array = new int[200];
        final String[] split2 = bufferedReader.readLine().split(" ");
        for (int i = 0; i < intValue2; ++i) {
            array[Integer.valueOf(split2[i])] = 1;
        }
        int n = 0;
        int x;
        while (true) {
            final int n2 = intValue - n;
            final int n3 = intValue + n;
            if (array[n2] == 0) {
                x = n2;
                break;
            }
            if (array[n3] == 0) {
                x = n3;
                break;
            }
            ++n;
        }
        System.out.println(x);
    }
}