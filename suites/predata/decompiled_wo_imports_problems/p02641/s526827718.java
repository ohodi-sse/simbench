public class Main
{
    public static void main(final String[] array) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final String[] split = bufferedReader.readLine().split(" ");
        final int int1 = Integer.parseInt(split[0]);
        final int int2 = Integer.parseInt(split[1]);
        int x = 0;
        int n = Integer.MAX_VALUE;
        final HashSet set = new HashSet();
        final String[] split2 = bufferedReader.readLine().split(" ");
        for (int i = 0; i < int2; ++i) {
            set.add(Integer.parseInt(split2[i]));
        }
        for (int j = 0; j <= 101; ++j) {
            if (!set.contains(j)) {
                final int abs = Math.abs(int1 - j);
                if (abs < n) {
                    n = abs;
                    x = j;
                }
            }
        }
        System.out.println(x);
    }
}