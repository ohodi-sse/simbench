public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner = new Scanner(System.in);
        int x = 0;
        new String();
        new String();
        final String nextLine = scanner.nextLine();
        final String nextLine2 = scanner.nextLine();
        final char[] charArray = nextLine.toCharArray();
        final char[] charArray2 = nextLine2.toCharArray();
        for (int i = 0; i < charArray.length; ++i) {
            if (charArray[i] == charArray2[i]) {
                ++x;
            }
        }
        System.out.println(x);
    }
}