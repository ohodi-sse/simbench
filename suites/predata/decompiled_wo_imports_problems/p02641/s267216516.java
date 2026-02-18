public final class Main
{
    private static void main$3231c38a() throws IOException {
        final BufferedReader bufferedReader;
        final String[] split;
        final int int1 = Integer.parseInt((split = (bufferedReader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8))).readLine().split(" "))[0]);
        final int int2;
        if ((int2 = Integer.parseInt(split[1])) == 0) {
            System.out.println(int1);
            return;
        }
        final String[] split2 = bufferedReader.readLine().split(" ");
        final ArrayList list = new ArrayList();
        for (int i = 0; i < int2; ++i) {
            list.add(Integer.parseInt(split2[i]));
        }
        if (!list.contains(int1)) {
            System.out.println(int1);
            return;
        }
        for (int j = 1; j < int2 + 1; ++j) {
            if (!list.contains(int1 - j)) {
                System.out.println(int1 - j);
                return;
            }
            if (!list.contains(int1 + j)) {
                System.out.println(int1 + j);
                return;
            }
        }
    }
}