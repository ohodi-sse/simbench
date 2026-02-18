public final class Main
{
    private static void main$3231c38a() {
        final String next = new Scanner(System.in).next();
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            if (next.charAt(i) == 'R') {
                x = 1;
            }
        }
        for (int j = 0; j < 2; ++j) {
            final char char1 = next.charAt(j);
            if (char1 == next.charAt(j + 1) && char1 == 'R') {
                ++x;
            }
        }
        System.out.println(x);
    }
}