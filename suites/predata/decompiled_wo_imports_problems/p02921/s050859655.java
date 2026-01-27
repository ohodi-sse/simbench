public class Main
{
    public static void main(final String[] array) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(checkTenki(convertArr(bufferedReader.readLine()), convertArr(bufferedReader.readLine())));
    }
    
    private static String[] convertArr(final String s) {
        final String[] array = new String[s.length()];
        for (int i = 0; i < s.length(); ++i) {
            array[i] = s.substring(i, i + 1);
        }
        return array;
    }
    
    private static int checkTenki(final String[] array, final String[] array2) {
        int n = 0;
        for (int i = 0; i < array.length; ++i) {
            if (array[i].equals(array2[i])) {
                ++n;
            }
        }
        return n;
    }
}