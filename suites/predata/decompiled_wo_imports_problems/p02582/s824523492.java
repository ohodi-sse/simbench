public final class Main
{
    private static void main$3231c38a() {
        final String nextLine = new Scanner(System.in).nextLine();
        int max = 0;
        int b = 0;
        char[] charArray;
        for (int length = (charArray = nextLine.toCharArray()).length, i = 0; i < length; ++i) {
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