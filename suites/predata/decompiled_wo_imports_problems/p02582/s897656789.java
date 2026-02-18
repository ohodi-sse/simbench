public final class Main
{
    private static void main$3231c38a() {
        final String next = new Scanner(System.in).next();
        int x = 0;
        final String anObject = "RSR";
        for (int i = 0; i < 3; ++i) {
            if (next.equals(anObject)) {
                x = 1;
                break;
            }
            if (next.charAt(i) == 'R') {
                ++x;
            }
        }
        System.out.println(x);
    }
}