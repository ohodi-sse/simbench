public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final String next = (scanner = new Scanner(System.in)).next();
        final String next2 = scanner.next();
        final char[] array = new char[3];
        final char[] array2 = new char[3];
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            array[i] = next.charAt(i);
        }
        for (int j = 0; j < 3; ++j) {
            array2[j] = next2.charAt(j);
        }
        for (int k = 0; k < 3; ++k) {
            if (array[k] == array2[k]) {
                ++x;
            }
        }
        System.out.println(x);
    }
}