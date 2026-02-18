public final class Main
{
    private static void main$3231c38a() throws Exception {
        final Scanner scanner;
        final char[] charArray = (scanner = new Scanner(System.in)).nextLine().toCharArray();
        final char[] charArray2 = scanner.nextLine().toCharArray();
        int i = 0;
        for (int j = 0; j < 3; ++j) {
            if (charArray[j] == charArray2[j]) {
                ++i;
            }
        }
        System.out.printf("%d\n", i);
    }
}