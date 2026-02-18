public final class Main
{
    private static void main$3231c38a() throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stringTokenizer;
        final int int1 = Integer.parseInt((stringTokenizer = new StringTokenizer(bufferedReader.readLine())).nextToken());
        final int int2 = Integer.parseInt(stringTokenizer.nextToken());
        final HashSet set = new HashSet();
        if (int2 == 0) {
            System.out.println(int1);
            return;
        }
        final StringTokenizer stringTokenizer2 = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < int2; ++i) {
            set.add(Integer.parseInt(stringTokenizer2.nextToken()));
        }
        for (int j = 0; j < int2 + 1; ++j) {
            final int n = int1 + j;
            final int n2 = int1 - j;
            if (!set.contains(n2)) {
                System.out.println(n2);
                return;
            }
            if (!set.contains(n)) {
                System.out.println(n);
                return;
            }
        }
    }
}