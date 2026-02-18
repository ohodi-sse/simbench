public final class Main
{
    private static void main$3231c38a() throws IOException {
        final BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stringTokenizer;
        final int int1 = Integer.parseInt((stringTokenizer = new StringTokenizer(bufferedReader.readLine())).nextToken());
        final int int2 = Integer.parseInt(stringTokenizer.nextToken());
        final boolean[] array = new boolean[101];
        if (int2 > 0) {
            final StringTokenizer stringTokenizer2 = new StringTokenizer(bufferedReader.readLine());
            while (stringTokenizer2.hasMoreTokens()) {
                array[Integer.parseInt(stringTokenizer2.nextToken())] = true;
            }
        }
        int n = int1;
        int n2 = int1;
        while (n > 0 && array[n]) {
            --n;
        }
        while (n2 < 101 && array[n2]) {
            ++n2;
        }
        bufferedWriter.write("" + ((int1 - n <= n2 - int1) ? n : n2));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}