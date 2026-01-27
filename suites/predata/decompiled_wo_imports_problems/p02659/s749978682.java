public class Main
{
    public static void main(final String[] array) throws IOException {
        final String[] split = new BufferedReader(new InputStreamReader(System.in)).readLine().split(" ");
        final long long1 = Long.parseLong(split[0]);
        final char[] charArray = split[1].toCharArray();
        String s = "";
        for (int i = 0; i < charArray.length; ++i) {
            if (charArray[i] != '.') {
                s += charArray[i];
            }
        }
        System.out.println(Long.parseLong(s) * long1 / 100L);
    }
}