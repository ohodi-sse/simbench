public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final char[] charArray = (scanner = new Scanner(System.in)).nextLine().toCharArray();
        scanner.close();
        int x = 0;
        char[] array;
        for (int length = (array = charArray).length, i = 0; i < length; ++i) {
            if (array[i] == 'R') {
                ++x;
            }
        }
        if (x == 2 && charArray[1] == 'S') {
            x = 1;
        }
        System.out.println(x);
    }
}