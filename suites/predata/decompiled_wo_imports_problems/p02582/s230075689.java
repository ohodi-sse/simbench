public final class Main
{
    private static void main$3231c38a() {
        final String next = new Scanner(System.in).next();
        int x = 0;
        int n = 0;
        final char[] array = new char[3];
        for (int i = 0; i < 3; ++i) {
            array[i] = next.charAt(i);
        }
        for (int j = 0; j < 3; ++j) {
            if (array[j] == 'R') {
                ++n;
                if (x < n) {
                    x = n;
                }
            }
            else {
                if (x < n) {
                    x = n;
                }
                n = 0;
            }
        }
        System.out.println(x);
    }
}