public final class Main
{
    private static void main$3231c38a() {
        final char[] charArray = new Scanner(System.in).next().toCharArray();
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            if (charArray[i] == 'R') {
                ++x;
            }
        }
        if (charArray[1] != 'R' && x == 2) {
            System.out.println(1);
            return;
        }
        System.out.println(x);
    }
}