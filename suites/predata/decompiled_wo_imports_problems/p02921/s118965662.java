public final class Main
{
    private static void main$3231c38a() throws Exception {
        final Scanner scanner;
        final char[] charArray = (scanner = new Scanner(System.in)).next().toCharArray();
        final char[] charArray2 = scanner.next().toCharArray();
        int x = 0;
        for (int length = charArray.length, i = 0; i < length; ++i) {
            if (charArray[i] == charArray2[i]) {
                ++x;
            }
        }
        System.out.println(x);
    }
}