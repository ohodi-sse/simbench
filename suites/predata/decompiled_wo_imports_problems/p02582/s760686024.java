public final class Main
{
    private static void main$3231c38a() {
        final char[] charArray = new Scanner(System.in).next().toCharArray();
        int x = 0;
        int x2 = 0;
        for (int i = 0; i < charArray.length; ++i) {
            if (charArray[i] == 'R') {
                ++x;
            }
            else {
                if (x2 < x) {
                    x2 = x;
                }
                x = 0;
            }
        }
        if (x2 < x) {
            System.out.println(x);
            return;
        }
        System.out.println(x2);
    }
}