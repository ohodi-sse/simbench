public class Main
{
    public static void main(final String[] array) throws Exception {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final String line = bufferedReader.readLine();
        final String line2 = bufferedReader.readLine();
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            if (line.charAt(i) == line2.charAt(i)) {
                ++x;
            }
        }
        System.out.println(x);
    }
}