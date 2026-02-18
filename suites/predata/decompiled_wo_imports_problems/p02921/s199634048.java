public final class Main
{
    private static void main$3231c38a() throws FileNotFoundException {
        final Scanner scanner;
        final String next = (scanner = new Scanner(System.in)).next();
        final String next2 = scanner.next();
        scanner.close();
        final char[] charArray = next.toCharArray();
        final char[] charArray2 = next2.toCharArray();
        int x = 0;
        for (int i = 0; i < charArray.length; ++i) {
            if (charArray[i] == charArray2[i]) {
                ++x;
            }
        }
        System.out.println(x);
    }
}