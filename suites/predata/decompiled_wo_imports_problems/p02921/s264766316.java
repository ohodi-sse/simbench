public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final char[] charArray = (scanner = new Scanner(System.in)).next().toCharArray();
        final char[] charArray2 = scanner.next().toCharArray();
        int x = 0;
        for (int i = 0; i < charArray.length; ++i) {
            x += ((charArray[i] == charArray2[i]) ? 1 : 0);
        }
        System.out.println(x);
    }
}