public final class Main
{
    private static void main$3231c38a() {
        final String next = new Scanner(System.in).next();
        final String[] array;
        (array = new String[3])[0] = next.substring(0, 1);
        array[1] = next.substring(1, 2);
        array[2] = next.substring(2, 3);
        int x = 0;
        int n = 0;
        for (int i = 0; i < 3; ++i) {
            if ("R".equals(array[i])) {
                ++n;
            }
            else if (n > x) {
                x = n;
                n = 0;
            }
        }
        if (n > x) {
            x = n;
        }
        System.out.println(x);
    }
}