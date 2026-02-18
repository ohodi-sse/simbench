public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final char[] charArray = (scanner = new Scanner(System.in)).next().toCharArray();
        int a = 0;
        int max = 0;
        for (int length = charArray.length, i = 0; i < length; ++i) {
            if (charArray[i] == 'R') {
                ++a;
            }
            else {
                a = 0;
            }
            max = Math.max(a, max);
        }
        System.out.println(max);
        scanner.close();
    }
}