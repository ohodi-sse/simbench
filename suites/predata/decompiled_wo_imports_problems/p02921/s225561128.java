public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final char[] charArray = (scanner = new Scanner(System.in)).nextLine().toCharArray();
        final char[] charArray2 = scanner.nextLine().toCharArray();
        int x = 0;
        for (int i = 0; i < charArray.length; ++i) {
            if (charArray[i] == charArray2[i]) {
                ++x;
            }
        }
        System.out.println(x);
    }
}