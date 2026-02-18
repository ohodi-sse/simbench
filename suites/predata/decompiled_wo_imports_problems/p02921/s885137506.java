public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final String next = (scanner = new Scanner(System.in)).next();
        final String next2 = scanner.next();
        scanner.close();
        final String[] array = new String[3];
        final String[] array2 = new String[3];
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            final String[] array3 = array;
            final int n = i;
            final String s = next;
            final int beginIndex = i;
            array3[n] = s.substring(beginIndex, beginIndex + 1);
            final String[] array4 = array2;
            final int n2 = i;
            final String s2 = next2;
            final int beginIndex2 = i;
            array4[n2] = s2.substring(beginIndex2, beginIndex2 + 1);
            if (array[i].equals(array2[i])) {
                ++x;
            }
        }
        System.out.println(x);
    }
}