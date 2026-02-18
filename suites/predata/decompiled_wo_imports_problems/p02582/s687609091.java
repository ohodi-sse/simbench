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
        if (x == 2 && charArray[1] == 'S') {
            x = 1;
        }
        System.out.println(x);
    }
}