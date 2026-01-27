public class Main
{
    public static void main(final String[] array) throws IOException {
        final StringTokenizer stringTokenizer = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
        final long long1 = Long.parseLong(stringTokenizer.nextToken());
        final String nextToken = stringTokenizer.nextToken();
        System.out.println(long1 * (Integer.parseInt(nextToken.substring(0, 1)) * 100 + Integer.parseInt(nextToken.substring(2))) / 100L);
    }
}