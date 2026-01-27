public class Main
{
    public static void main(final String[] array) throws IOException {
        final StringTokenizer stringTokenizer = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
        System.out.println(Long.parseLong(stringTokenizer.nextToken()) * (long)(Double.parseDouble(stringTokenizer.nextToken()) * 100.0 + 0.5) / 100L);
    }
}