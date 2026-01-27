public class Main
{
    public static void main(final String[] array) throws Exception {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(System.out));
        final String line = bufferedReader.readLine();
        final String line2 = bufferedReader.readLine();
        int x = 0;
        if (line.charAt(0) == line2.charAt(0)) {
            ++x;
        }
        if (line.charAt(1) == line2.charAt(1)) {
            ++x;
        }
        if (line.charAt(2) == line2.charAt(2)) {
            ++x;
        }
        printWriter.println(x);
        printWriter.close();
    }
}