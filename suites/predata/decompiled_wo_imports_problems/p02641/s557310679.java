public class Main
{
    public static void main(final String[] array) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final String[] split = bufferedReader.readLine().split(" ");
        final int intValue = Integer.valueOf(split[0]);
        final int intValue2 = Integer.valueOf(split[1]);
        final int[] array2 = new int[200];
        final String[] split2 = bufferedReader.readLine().split(" ");
        for (int i = 0; i < intValue2; ++i) {
            array2[Integer.valueOf(split2[i])] = 1;
        }
        int n = 0;
        int x;
        while (true) {
            final int n2 = intValue - n;
            final int n3 = intValue + n;
            if (array2[n2] == 0) {
                x = n2;
                break;
            }
            if (array2[n3] == 0) {
                x = n3;
                break;
            }
            ++n;
        }
        System.out.println(x);
    }
}