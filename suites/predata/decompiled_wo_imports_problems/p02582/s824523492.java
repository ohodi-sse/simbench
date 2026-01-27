public class Main
{
    public static void main(final String[] array) {
        final String nextLine = new Scanner(System.in).nextLine();
        int max = 0;
        int b = 0;
        final char[] charArray = nextLine.toCharArray();
        for (int length = charArray.length, i = 0; i < length; ++i) {
            if (charArray[i] == 'R') {
                ++b;
            }
            else {
                b = 0;
            }
            max = Math.max(max, b);
        }
        System.out.println(max);
    }
}