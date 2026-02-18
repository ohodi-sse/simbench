public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final String next = (scanner = new Scanner(System.in)).next();
        final String next2 = scanner.next();
        final char[] charArray = next.toCharArray();
        final char[] charArray2 = next2.toCharArray();
        int x = 0;
        if (charArray[0] == charArray2[0]) {
            ++x;
        }
        if (charArray[1] == charArray2[1]) {
            ++x;
        }
        if (charArray[2] == charArray2[2]) {
            ++x;
        }
        System.out.println(x);
    }
}