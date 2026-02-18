public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner = new Scanner(System.in);
        final char[] array = new char[3];
        final char[] array2 = new char[3];
        final String nextLine = scanner.nextLine();
        final String nextLine2 = scanner.nextLine();
        int x = 0;
        scanner.close();
        tenki(nextLine, array);
        tenki(nextLine2, array2);
        for (int i = 0; i < 3; ++i) {
            if (array[i] == array2[i]) {
                ++x;
            }
        }
        System.out.println(x);
    }
    
    private static void tenki(final String s, final char[] array) {
        for (int i = 0; i < 3; ++i) {
            array[i] = s.charAt(i);
        }
    }
}