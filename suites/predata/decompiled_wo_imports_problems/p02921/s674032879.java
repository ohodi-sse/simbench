public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final char[] charArray = (scanner = new Scanner(System.in)).next().toCharArray();
        final char[] charArray2 = scanner.next().toCharArray();
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
        scanner.close();
    }
}